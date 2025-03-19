export function parseTableConfig(config) {
    const filterValue = {};
    const tableFieldValue = {};
    const _columnWidth = {};
    let filterType = [];

    for (const key in config) {
        if (key === "__filterType") {
            filterType = config[key];
        } else {
            const item = config[key];
            if(item != null){
              if (item.name !== undefined) tableFieldValue[key] = item.name;
              if (item.width !== undefined) _columnWidth[key] = item.width;
              if (item.filter !== undefined) filterValue[key] = item.filter;
            }
        }
    }

    return { filterValue, tableFieldValue, _columnWidth, filterType };
}

export function convertApiToItems(api, config,callback=()=>{}) {
  const aObj = api.FieldsInfo; // 字段详细配置
  const cObj = api.FieldsName; // 字段中文映射
  const items = [];
  // 读取 config 中的 nameMap 配置，默认为空对象
  const nameMap = config.nameMap || {};

  for (const key in aObj) {
    const field = aObj[key];
    const item = {};

    // 1. required：当 isNullable 为 false 时必填
    item.required = field.isNullable === false;

    // 2. initialValue：若 defaultValue 不为 undefined
    //    如果字段类型为 date/timestamp/time 且 defaultValue 为 "CURRENT_TIMESTAMP"，则设置当前时间
    const columnType = field.type && field.type.columnType;
    if (field.defaultValue !== undefined) {
      if (["date", "timestamp", "time"].includes(columnType) && field.defaultValue === "CURRENT_TIMESTAMP") {
        item.initialValue = new Date();
      } else {
        item.initialValue = field.defaultValue;
      }
    }

    // 3. 字段名称：使用 nameMap（不区分大小写匹配）来覆盖默认 key
    const matchedKey = Object.keys(nameMap).find(mapKey => mapKey.toLowerCase() === key.toLowerCase());
    item.name = matchedKey ? nameMap[matchedKey] : key;

    // 4. label 和 placeholder：根据 cObj 映射生成
    const labelText = cObj[key] || "";
    item.label = labelText;
    item.props = { placeholder: "请输入" + labelText };

    // 5. 组件类型处理
    const columnDefinition = field.type && field.type.columnDefinition;

    if (columnType === 'enum' && columnDefinition) {
      // 枚举类型：解析枚举项
      const match = columnDefinition.match(/\(([^)]+)\)/);
      if (match) {
        const inner = match[1].trim();
        const itemsArr = inner.split(',').map(s => s.trim().replace(/^['"]|['"]$/g, ""));
        const options = itemsArr.map(s => ({ label: s, value: s }));
        item.props.mode = "static";
        item.props.options = options;
        // 使用 config.type['enum'] 得到组件名称（例如 'Radio'）
        const handler = config.type['enum'];
        item.component = typeof handler === 'function' ? handler() : 'Select';
      } else {
        item.component = "";
      }
    } else if (columnType === 'date') {
      item.props.type = "date";
      item.props.clearable = true;
      const handler = config.type['date'];
      item.component = typeof handler === 'function' ? handler() : "";
    } else if (columnType === 'timestamp' || columnType === 'time') {
      item.props.type = "datetime";
      item.props.clearable = true;
      const handler = config.type[columnType] || config.type['timestamp'];
      item.component = typeof handler === 'function' ? handler() : "";
    } else {
      // 非枚举、非日期类型：尝试从 columnDefinition 中提取参数
      let param;
      if (columnDefinition && columnDefinition.includes('(')) {
        const match = columnDefinition.match(/\((.+?)\)/);
        if (match) {
          const inner = match[1].trim();
          if (inner.startsWith("'") || inner.startsWith('"')) {
            param = inner.split(',').map(s => s.trim().replace(/^['"]|['"]$/g, ""));
          } else {
            param = Number(inner);
          }
        }
      }
      const handler = config.type[columnType];
      if (typeof handler === 'function') {
        item.component = (param !== undefined) ? handler(param) : handler();
      } else {
        item.component = "";
      }
    }

    // 6. 如果 config.fliterField 中存在当前字段 key（不区分大小写），则添加 "hidden": true
    if (config.fliterField && config.fliterField.some(f => f.toLowerCase() === key.toLowerCase())) {
      item.hidden = true;
    }

    // 7. 如果 config.Field 中存在当前字段 key（不区分大小写），则直接覆盖 component 值
    if (config.Field) {
      const fieldKey = Object.keys(config.Field).find(mapKey => mapKey.toLowerCase() === key.toLowerCase());
      if (fieldKey) {
        item.component = config.Field[fieldKey];
      }
    }

    // 8. 处理 AddAttr（不区分大小写），最后覆盖
    if (config.AddAttr) {
      const addAttrKey = Object.keys(config.AddAttr).find(mapKey => mapKey.toLowerCase() === key.toLowerCase());
      if (addAttrKey) {
        Object.assign(item, config.AddAttr[addAttrKey]);
      }
    }
    const r = callback({items,item,key})
    if(!r?.notAdd)
      items.push(item);
    if(r?.item){
      items.push(r?.item);
    }
  }

  return items;
}



export const arrToObj = (item)=>{
  return item.reduce((obj, item) => {obj[item.name] = item;return obj;},{});
}

export const objToArr = ()=>{
  return Object.entries(obj).map(([key, value]) => ({ key, ...value }));
}


/**
 * 根据 a 对象中的 fields 信息，利用字段的 type 属性匹配 b 对象中对应模块的指定字段映射，
 * 构造返回新的结果对象。支持任意层级的嵌套处理。顶层 key 默认保持原样，
 * 只有内部嵌套的 fields 会根据 type 进行模块匹配（第一层不做模块匹配），
 * 可选参数 matchTopLevel 控制是否对顶层进行模块匹配。
 *
 * @param {Object} a - 待处理对象
 * @param {Object} b - 各模块 API 对象集合，每个模块中应包含 FieldsInfo 和 FieldsName 属性
 * @param {string} mappingKey - b 对象中用于匹配的字段（"FieldsInfo" 或 "FieldsName"）
 * @param {boolean} [matchTopLevel=false] - 是否对顶层进行模块匹配
 * @returns {Object} 处理后的结果对象
 */
function buildResult(a, b, mappingKey, matchTopLevel = false) {
  /**
   * 递归处理节点
   * @param {*} node - 当前节点（可以为对象或其他类型）
   * @param {boolean} useModuleMatching - 是否对当前节点进行模块匹配
   * @returns {*} 处理后的节点
   */
  function processNode(node, useModuleMatching) {
    // 非对象直接返回
    if (node === null || typeof node !== "object") {
      return node;
    }
    // 如果节点含有 "fields" 属性，则认为需要处理
    if ("fields" in node && typeof node.fields === "object") {
      const resultFields = {};
      // 若需要模块匹配且 node 有 type 属性，则尝试根据 type 匹配对应模块
      if (useModuleMatching && node.type) {
        // 使用原始的 node.type 作为 moduleName
        const moduleName = node.type;
        let targetModuleKey = null;
        // 遍历 b 中的每个 key，检查是否 moduleName 包含该 key（忽略大小写）
        for (const bKey in b) {
          if (moduleName.toLowerCase().includes(bKey.toLowerCase())) {
            targetModuleKey = bKey;
            break;
          }
        }
        // 若找到对应模块且该模块存在指定映射属性，则使用映射处理 fields 内每个键
        if (targetModuleKey && b[targetModuleKey][mappingKey]) {
          const fieldsMapping = b[targetModuleKey][mappingKey];
          for (const fieldKey in node.fields) {
            const fieldVal = node.fields[fieldKey];
            // 如果值是对象且包含 fields，则递归处理（开启模块匹配）
            if (fieldVal && typeof fieldVal === "object" && "fields" in fieldVal) {
              resultFields[fieldKey] = processNode(fieldVal, true);
            } else {
              // 否则在映射中查找与 fieldKey 不区分大小写匹配的键
              let matched = false;
              for (const mapKey in fieldsMapping) {
                if (mapKey.toLowerCase() === fieldKey.toLowerCase()) {
                  resultFields[fieldKey] = fieldsMapping[mapKey];
                  matched = true;
                  break;
                }
              }
              // 未匹配到则原样复制
              if (!matched) {
                resultFields[fieldKey] = fieldVal;
              }
            }
          }
          return resultFields;
        }
      }
      // 非模块匹配场景或匹配不到时，对内部 fields 递归处理，
      // 如果子节点带有 type，则在递归时开启模块匹配（否则保持 false）
      for (const fieldKey in node.fields) {
        const fieldVal = node.fields[fieldKey];
        if (fieldVal && typeof fieldVal === "object" && "fields" in fieldVal) {
          resultFields[fieldKey] = processNode(fieldVal, !!fieldVal.type);
        } else {
          resultFields[fieldKey] = fieldVal;
        }
      }
      return resultFields;
    } else {
      // 对于普通对象或数组，递归处理其所有属性
      const resultObj = Array.isArray(node) ? [] : {};
      for (const key in node) {
        resultObj[key] = processNode(node[key], useModuleMatching);
      }
      return resultObj;
    }
  }

  // 根据 matchTopLevel 参数决定顶层是否进行模块匹配
  const result = {};
  for (const key in a) {
    result[key] = processNode(a[key], matchTopLevel);
  }
  return result;
}


/**
 * 考虑顶层构造两个返回结果：
 *  - fieldsInfo：根据 b 模块中 FieldsInfo 匹配字段信息
 *  - fieldsName：根据 b 模块中 FieldsName 匹配字段名称
 *
 * @param {Object} a - 待处理对象
 * @param {Object} b - 各模块 API 对象集合，每个模块中应包含 FieldsInfo 和 FieldsName 属性
 * @returns {Object} { fieldsInfo, fieldsName }
 */
export function buildFieldsInfoAndNameConsiderTop(a, b) {
  return {
    FieldsInfo: buildResult(a, b, "FieldsInfo"),
    FieldsName: buildResult(a, b, "FieldsName")
  };
}

/**
 * 不考虑顶层构造两个返回结果：
 *  - fieldsInfo：根据 b 模块中 FieldsInfo 匹配字段信息
 *  - fieldsName：根据 b 模块中 FieldsName 匹配字段名称
 *
 * @param {Object} a - 待处理对象
 * @param {Object} b - 各模块 API 对象集合，每个模块中应包含 FieldsInfo 和 FieldsName 属性
 * @returns {Object} { fieldsInfo, fieldsName }
 */
export function buildFieldsInfoAndNameIgnoreTop(a, b) {
  return {
    FieldsInfo: buildResult(a, b, "FieldsInfo",true),
    FieldsName: buildResult(a, b, "FieldsName",true)
  };
}

/*

// ===== 示例数据 ===== 
let data = {
  a: 1,
  b: {
    c: 2,
    d: {
      e: 3,
      f: 4
    }
  },
  g: 5,
  h: 1  // 与 a 重复
};

// ===== 示例 1：ignoreFilter 模式 ===== 
// 全部打平（不考虑 filter）
let resultIgnore = flattenObjectWithIndex(data, [], { ignoreFilter: true });
console.log("【ignoreFilter:true】");
console.log("flatArray:", resultIgnore.flatArray);
// 预期 flatArray：[1, 2, 3, 4, 5, 1]
// flatMap 预期：{ a: 1, c: 2, e: 3, f: 4, g: 5, h: 1 }
console.log("flatMap:", resultIgnore.flatMap);
// pathSwapMap 预期：{ "1": ["a", "h"], "2": "b.c", "3": "b.d.e", "4": "b.d.f", "5": "g" }
console.log("pathSwapMap:", resultIgnore.pathSwapMap);

// ===== 示例 2：严格匹配模式 ===== 
let filterStrict = [
  {
    c: 2,
    d: {
      e: 3,
      f: 4
    }
  }
];
let resultStrict = flattenObjectWithIndex(data, filterStrict); // 默认 ignoreFilter:false, fuzzy:false
console.log("\n【严格匹配模式】");
console.log("flatArray:", resultStrict.flatArray);
// 预期 flatArray：[1, { c:2, d:{ e:3, f:4 } }, 5, 1]
console.log("flatMap:", resultStrict.flatMap);
// 预期 flatMap：{ a: 1, b: { c:2, d:{ e:3, f:4 } }, g: 5, h: 1 }
console.log("pathSwapMap:", resultStrict.pathSwapMap);
// 预期 pathSwapMap：{ "1": ["a", "h"], "b": "b", "5": "g" }

// ===== 示例 3：模糊匹配模式 ===== 
let filterFuzzy = [
  {
    c: 2 // 仅指定部分结构
  }
];
let resultFuzzy = flattenObjectWithIndex(data, filterFuzzy, { fuzzy: true });
console.log("\n【模糊匹配模式】");
console.log("flatArray:", resultFuzzy.flatArray);
// 预期 flatArray 与严格模式相同：[1, { c:2, d:{ e:3, f:4 } }, 5, 1]
console.log("flatMap:", resultFuzzy.flatMap);
// 预期 flatMap：{ a: 1, b: { c:2, d:{ e:3, f:4 } }, g: 5, h: 1 }
console.log("pathSwapMap:", resultFuzzy.pathSwapMap);
// 预期 pathSwapMap：{ "1": ["a", "h"], "b": "b", "5": "g" }
*/
export function flattenObjectWithIndex(obj, filter = [], options = {}) {
  let flatArray = [];
  let indexMap = {};
  const { ignoreFilter = false, fuzzy = false } = options;
  
  // 如果不忽略 filter，则预先计算 filter 数组中各对象的结构
  const filterStructures = ignoreFilter ? [] : filter.map(getStructure);

  // 主递归函数，处理扁平化与索引映射
  function helper(curr, path) {
    if (typeof curr === 'object' && curr !== null) {
      const currStructure = getStructure(curr);
      let matchedFilter = false;
      if (!ignoreFilter) {
        matchedFilter = filterStructures.some(fs =>
          fuzzy ? isSubsetStructure(fs, currStructure) : isSameStructure(fs, currStructure)
        );
      }
      // 如果匹配，则将整个对象视为叶子节点（不再递归）
      if (matchedFilter) {
        const idx = flatArray.length;
        flatArray.push(curr);
        indexMap[path.join('.')] = idx;
        return;
      }
      const startIdx = flatArray.length;
      for (let key in curr) {
        helper(curr[key], path.concat(key));
      }
      const endIdx = flatArray.length;
      indexMap[path.join('.')] = [startIdx, endIdx - 1];
    } else {
      const idx = flatArray.length;
      flatArray.push(curr);
      indexMap[path.join('.')] = idx;
    }
  }

  for (let key in obj) {
    helper(obj[key], [key]);
  }

  // 生成 flatMap：对对象进行完整扁平化（遵循 filter 规则），将所有叶子节点以最后一级键名为 key 保存
  function flattenToMapFiltered(o, currentPath = "") {
    let result = {};
    if (typeof o === "object" && o !== null) {
      // 当 currentPath 不为空且当前对象匹配 filter（不忽略时）则停止递归
      if (
        currentPath !== "" &&
        !ignoreFilter &&
        filterStructures.some(fs =>
          fuzzy ? isSubsetStructure(fs, getStructure(o)) : isSameStructure(fs, getStructure(o))
        )
      ) {
        let segments = currentPath.split(".");
        let lastKey = segments[segments.length - 1];
        result[lastKey] = o;
        return result;
      }
      for (let key in o) {
        let newPath = currentPath === "" ? key : currentPath + "." + key;
        let subResult = flattenToMapFiltered(o[key], newPath);
        for (let subKey in subResult) {
          result[subKey] = subResult[subKey];
        }
      }
      return result;
    } else {
      let segments = currentPath.split(".");
      let lastKey = segments[segments.length - 1];
      result[lastKey] = o;
      return result;
    }
  }

  let flatMap = flattenToMapFiltered(obj);

  // 新增 pathSwapMap：记录每个叶子值对应的完整路径（以点号连接）
  // 如果同一叶子值出现多次，则以数组形式保存路径
  function generatePathSwapMap(o, currentPath = "") {
    let mapping = {};
    if (typeof o === "object" && o !== null) {
      // 当 currentPath 非空且当前对象匹配 filter，则停止递归，
      // 对于对象，使用当前路径的最后一部分作为 key
      if (
        currentPath !== "" &&
        !ignoreFilter &&
        filterStructures.some(fs =>
          fuzzy ? isSubsetStructure(fs, getStructure(o)) : isSameStructure(fs, getStructure(o))
        )
      ) {
        let segments = currentPath.split(".");
        let lastKey = segments[segments.length - 1];
        addMapping(mapping, lastKey, currentPath);
        return mapping;
      }
      for (let key in o) {
        let newPath = currentPath === "" ? key : currentPath + "." + key;
        let subMapping = generatePathSwapMap(o[key], newPath);
        for (let k in subMapping) {
          addMapping(mapping, k, subMapping[k]);
        }
      }
      return mapping;
    } else {
      // 对于叶子（非对象），用 String(o) 作为 key
      addMapping(mapping, String(o), currentPath);
      return mapping;
    }
  }

  // 辅助函数：如果同一 key 已存在，则合并为数组，否则直接赋值
  function addMapping(mapping, key, pathStr) {
    if (mapping.hasOwnProperty(key)) {
      if (Array.isArray(mapping[key])) {
        mapping[key].push(pathStr);
      } else {
        mapping[key] = [mapping[key], pathStr];
      }
    } else {
      mapping[key] = pathStr;
    }
  }

  let pathSwapMap = generatePathSwapMap(obj);

  return { flatArray, indexMap, flatMap, pathSwapMap };

  // 辅助函数：提取对象结构（递归所有键名）
  function getStructure(o) {
    if (typeof o !== 'object' || o === null) return null;
    let structure = {};
    for (let k in o) {
      if (typeof o[k] === 'object' && o[k] !== null) {
        structure[k] = getStructure(o[k]);
      } else {
        structure[k] = true;
      }
    }
    return structure;
  }

  // 辅助函数：严格比较两个结构是否完全一致
  function isSameStructure(s1, s2) {
    if (s1 === null || s2 === null) return s1 === s2;
    const keys1 = Object.keys(s1).sort();
    const keys2 = Object.keys(s2).sort();
    if (keys1.length !== keys2.length) return false;
    for (let i = 0; i < keys1.length; i++) {
      if (keys1[i] !== keys2[i]) return false;
      const val1 = s1[keys1[i]];
      const val2 = s2[keys2[i]];
      if (typeof val1 === 'object' && typeof val2 === 'object') {
        if (!isSameStructure(val1, val2)) return false;
      } else {
        if (val1 !== val2) return false;
      }
    }
    return true;
  }

  // 辅助函数：模糊比较——判断 s1 是否为 s2 的子集
  function isSubsetStructure(sub, full) {
    if (sub === null) return true;
    const keys = Object.keys(sub);
    for (let key of keys) {
      if (!(key in full)) return false;
      const valSub = sub[key];
      const valFull = full[key];
      if (typeof valSub === 'object' && typeof valFull === 'object') {
        if (!isSubsetStructure(valSub, valFull)) return false;
      }
    }
    return true;
  }
}

/**
 * 扁平化对象，将嵌套的属性展开为“路径.属性”的形式
 * @param {Object} obj - 需要扁平化的对象
 * @param {string} [prefix=''] - 前缀（递归内部使用）
 * @returns {Array} 返回一个 [路径, 值] 对的数组
 */
function flattenObject(obj, prefix = '') {
  let result = [];
  for (let key in obj) {
    if (!obj.hasOwnProperty(key)) continue;
    // 新的键：如果有前缀则用点连接
    let newKey = prefix ? `${prefix}.${key}` : key;
    let value = obj[key];
    // 如果值是对象且非 null 且不是数组，则递归展开
    if (typeof value === 'object' && value !== null && !Array.isArray(value)) {
      result = result.concat(flattenObject(value, newKey));
    } else {
      result.push([newKey, value]);
    }
  }
  return result;
}

/**
 * 交换对象的键值：
 * 1. 首先扁平化对象
 * 2. 将值转成字符串作为新对象的键，如果重复则收集成数组
 * @param {Object} obj - 输入对象
 * @returns {Object} 交换后的对象
 */
/* 示例
// 示例数据
const obj = {
  a: 1,
  b: 2,
  c: 1,
  d: {
    x: 3,
    y: 4,
  },
  e: {
    m: 3,
    n: 5,
  },
  f: {
    x: 3,
    y: 4,
  },
};

const swapped = swapKeyValueFlattened(obj);
console.log(swapped);

  运行结果：
  {
    "1": ["a", "c"],
    "2": "b",
    "3": ["d.x", "e.m", "f.x"],
    "4": ["d.y", "f.y"],
    "5": "e.n"
  }
*/
export function swapKeyValueFlattened(obj) {
  const pairs = flattenObject(obj);
  const res = {};
  pairs.forEach(([flatKey, val]) => {
    // 将值转为字符串
    const strVal = String(val);
    if (res.hasOwnProperty(strVal)) {
      // 如果已有，先转换为数组（如果不是数组）
      if (!Array.isArray(res[strVal])) {
        res[strVal] = [res[strVal]];
      }
      res[strVal].push(flatKey);
    } else {
      res[strVal] = flatKey;
    }
  });
  return res;
}

/**
示例：
// 使用示例
const data = {
  rugconsumptionMixParam: {
    TransactionID: 12345,
    items: [
      { id: 1, name: 'item1' },
      { id: 2, name: 'item2' }
    ]
  }
};
console.log(getNestedValue(data, 'rugconsumptionMixParam.TransactionID')); // 输出：12345
console.log(getNestedValue(data, 'rugconsumptionMixParam.items[1].name'));    // 输出："item2"
console.log(getNestedValue(data, 'rugconsumptionMixParam.notExist'));         // 输出：undefined
 * 根据字符串路径安全获取嵌套对象的值
 * @param {Object} obj - 目标对象
 * @param {string} path - 属性路径，例如 "a.b.c" 或 "a[0].b"
 * @returns {*} - 如果路径存在则返回对应的值，否则返回 undefined
 */
export function getNestedValue(obj, path) {
  if (obj == null || typeof path !== 'string') return undefined;

  // 将数组访问的 [key] 形式转换为 .key 形式
  path = path.replace(/\[(\w+)\]/g, '.$1').replace(/^\./, '');
  const keys = path.split('.');

  let result = obj;
  for (const key of keys) {
    // 如果当前层级为 null 或 undefined，则返回 undefined
    if (result == null || typeof result !== 'object') return undefined;
    result = result[key];
    if (result === undefined) return undefined;
  }
  return result;
}


/**
 * 判断值是否为空对象或空数组
 * @param {*} value 
 * @returns {boolean}
 */
function isEmptyValue(value) {
  if (value === null || value === undefined){
    return true;
  }
  if (Array.isArray(value)){ 
    return value.length === 0;
  }
  if (typeof value === 'object'){
    if(value instanceof Date) return false;
    return Object.keys(value).length === 0;
  } 
  return false;
}
/**
示例:
// 示例数据
const inputData = {
  "drugconsumptionParam": {
    "DrugID": "1",
    "PatientID": "1",
    "QuantityUsed": "1",
    "Count": "1"
  },
  "financialrecordsParam": {},
  "TransactionID": "1",
  "someArray": [],
  "nested": {
    "a": {},
    "b": [],
    "c": {
      "d": []
    },
    "e": {
      "f": "value"
    }
  },
  "arrayNested": [
    {},
    [],
    {"g": []},
    {"h": "test"}
  ]
};
const result = removeEmptyValues(inputData);
console.log(result);
 * 递归删除对象中值为空对象或空数组的键（包括嵌套对象和数组）
 * @param {Object|Array} data - 要处理的数据
 * @returns {Object|Array} 处理后的数据
 */

export function removeEmptyValues(data) {
  if (Array.isArray(data)) {
    // 处理数组中的每个元素，并过滤掉空对象或空数组
    return data
      .map(item => removeEmptyValues(item))
      .filter(item => !isEmptyValue(item));
  } else if (typeof data === 'object' && data !== null) {
    // 遍历对象每个键，递归处理嵌套对象或数组
    Object.keys(data).forEach(key => {
      data[key] = removeEmptyValues(data[key]);
      if (isEmptyValue(data[key])) {
        delete data[key];
      }
    });
    return data;
  }
  // 非对象和非数组直接返回原始值
  return data;
}

/**
 * 处理 contractor 数据，并返回扁平化后的 FieldsInfo 与 FieldsName 对象
 *
 * @param {Object} params - 参数对象
 * @param {Object} params.api - 包含 contractorParam 与 FieldsInfo 的 API 对象
 * @param {Object} params.apiAll - 其它 API 全局信息
 * @param {Object} params.fapi - 包含财务相关数据的 API 对象（例如 transactionID）
 * @param {string} params.createKey - contractorParam 中使用的 key（例如 "create"）
 * @returns {Object} 返回 { FieldsInfoFlatten, FieldsNameFlatten, firstFloorKey }
 */
export function processFinancialrecordsData({ api, apiAll, fapi, createKey}) {
  // 从 contractorParam 中获取第一个 key 对应的值
  const contractorParam = Object.values(api.contractorParam)[0];

  // 使用指定的 createKey 构建字段信息对象
  const ParamObj = buildFieldsInfoAndNameConsiderTop(contractorParam[createKey], apiAll);

  // 获取 ParamObj.FieldsInfo 中的第一个 key
  const firstFloorKey = Object.keys(ParamObj.FieldsInfo)[0];

  // 将财务相关的 TransactionID 信息添加到 ParamObj 对应位置
  if(fapi){
    ParamObj.FieldsInfo[firstFloorKey].TransactionID = fapi.FieldsInfo.transactionID;
    ParamObj.FieldsName[firstFloorKey].TransactionID = fapi.FieldsName.transactionID;
  }
  
  // 扁平化 FieldsInfo 与 FieldsName 对象
  const FieldsInfoFlatten = flattenObjectWithIndex(
    ParamObj.FieldsInfo,
    [Object.values(api.FieldsInfo)[0]]
  );
  const FieldsNameFlatten = flattenObjectWithIndex(ParamObj.FieldsName);

  return { FieldsInfoFlatten, FieldsNameFlatten,firstFloorKey};
}


/**
 * 处理 contractor 数据，并返回扁平化后的 FieldsInfo 与 FieldsName 对象
 *
 * @param {Object} params - 参数对象
 * @param {Object} params.api - 包含 contractorParam 与 FieldsInfo 的 API 对象
 * @param {Object} params.apiAll - 其它 API 全局信息
 * @param {string} params.createKey - contractorParam 中使用的 key（例如 "create"）
 * @returns {Object} 返回 { FieldsInfoFlatten, FieldsNameFlatten, firstFloorKey }
 */
export function processGeneralData({ api, apiAll, createKey}) {
  // 从 contractorParam 中获取第一个 key 对应的值
  const contractorParam = Object.values(api.contractorParam)[0];
  
  // 使用指定的 createKey 构建字段信息对象
  const ParamObj = buildFieldsInfoAndNameIgnoreTop(contractorParam[createKey], apiAll);
  const firstFloorKey = Object.keys(ParamObj.FieldsInfo)[0];
  // 扁平化 FieldsInfo 与 FieldsName 对象
  const FieldsInfoFlatten = flattenObjectWithIndex(
    ParamObj.FieldsInfo,
    [Object.values(api.FieldsInfo)[0]]
  );
  const FieldsNameFlatten = flattenObjectWithIndex(ParamObj.FieldsName);

  return { FieldsInfoFlatten, FieldsNameFlatten,firstFloorKey};
}

/*
示例：
// 测试
const Obj = {
  "count": 1,
  "drugID": 1,
  "consumptionID": 70,
  "patientID": 1,
  "lastUpdated": "2025-03-04T10:31:59.000+00:00",
  "quantityUsed": 1
};
const MapObj = {
  "DrugID": "drugconsumptionMixParam.drugconsumptionParam.DrugID",
  "PatientID": "drugconsumptionMixParam.drugconsumptionParam.PatientID",
  "QuantityUsed": "drugconsumptionMixParam.drugconsumptionParam.QuantityUsed",
  "Count": "drugconsumptionMixParam.drugconsumptionParam.Count",
  "TransactionID": "drugconsumptionMixParam.TransactionID",
  "Integer": "id"
};
console.log(JSON.stringify(mapObject(Obj, MapObj), null, 2));

*/
export function mapObject(obj, mapObj) {
  // 构建一个以小写 key 为索引的映射，方便不区分大小写的比较
  const lowerCaseObjKeys = Object.keys(obj).reduce((acc, key) => {
    acc[key.toLowerCase()] = key; // 存储原始键名
    return acc;
  }, {});

  let result = {};

  // 遍历 mapObj 中的每个映射项（右连接：保留 mapObj 的所有键）
  for (let [targetKey, path] of Object.entries(mapObj)) {
    let sourceKey = lowerCaseObjKeys[targetKey.toLowerCase()];
    // 如果源对象中存在对应属性，则使用其值；否则赋为 null
    let value = (sourceKey && obj.hasOwnProperty(sourceKey)) ? obj[sourceKey] : null;
    
    // 判断 path 是否为字符串，不是则跳过当前映射
    if (typeof path !== 'string') {
      console.error(`Invalid mapping for key ${targetKey}: path is not a string`);
      continue;
    }
    setNestedProperty(result, path, value);
  }

  return result;

  // 辅助函数：根据给定路径创建嵌套结构并赋值
  function setNestedProperty(obj, path, value) {
    // path 已经确保为字符串，再进行 split 操作
    const keys = path.split('.');
    let current = obj;
    for (let i = 0; i < keys.length - 1; i++) {
      const key = keys[i];
      if (!(key in current)) {
        current[key] = {};
      }
      current = current[key];
    }
    current[keys[keys.length - 1]] = value;
  }
}



/**
 * 深度比较两个对象，返回差异对象（保留嵌套结构）
 * @param {Object} obj1 第一个对象（旧值）
 * @param {Object} obj2 第二个对象（新值）
 * @param {Object} options 可选参数： { mode: "both" | "old" | "new" }
 *                - "both": 返回 { old: ..., new: ... } （默认）
 *                - "old": 只返回旧值
 *                - "new": 只返回新值
 * @returns {Object} 差异对象
 */
export function diffObjects(obj1, obj2, options = { mode: "both" }) {
  const diff = {};
  // 获取两个对象的所有键的并集
  const keys = new Set([...Object.keys(obj1), ...Object.keys(obj2)]);
  
  keys.forEach(key => {
    const val1 = obj1[key];
    const val2 = obj2[key];
    
    // 如果两个值都是对象（非数组），递归比较
    if (isObject(val1) && isObject(val2)) {
      const subDiff = diffObjects(val1, val2, options);
      if (Object.keys(subDiff).length > 0) {
        diff[key] = subDiff;
      }
    }
    // 如果两个值都是数组，进行逐项比较
    else if (Array.isArray(val1) && Array.isArray(val2)) {
      if (!arraysEqual(val1, val2)) {
        if (options.mode === "old") {
          diff[key] = val1;
        } else if (options.mode === "new") {
          diff[key] = val2;
        } else {
          diff[key] = { old: val1, new: val2 };
        }
      }
    }
    // 原始类型或类型不一致的情况
    else {
      if (val1 !== val2) {
        if (options.mode === "old") {
          diff[key] = val1;
        } else if (options.mode === "new") {
          diff[key] = val2;
        } else {
          diff[key] = { old: val1, new: val2 };
        }
      }
    }
  });
  
  return diff;

  // 辅助函数：判断是否是普通对象（排除数组）
  function isObject(item) {
    return item && typeof item === 'object' && !Array.isArray(item);
  }

  // 辅助函数：比较两个数组是否相等（支持对象递归比较）
  function arraysEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) return false;
    for (let i = 0; i < arr1.length; i++) {
      const a = arr1[i], b = arr2[i];
      if (isObject(a) && isObject(b)) {
        if (Object.keys(diffObjects(a, b, { mode: "both" })).length > 0) return false;
      } else if (Array.isArray(a) && Array.isArray(b)) {
        if (!arraysEqual(a, b)) return false;
      } else if (a !== b) {
        return false;
      }
    }
    return true;
  }
}

export function getValueIgnoreCase(obj, key) {
  if (!obj || typeof obj !== "object") return undefined;

  const lowerKey = key.toLowerCase();
  for (const k in obj) {
    if (k.toLowerCase() === lowerKey) {
      return obj[k];
    }
  }

  return undefined;
}


export default {
  getValueIgnoreCase,
  //Table
  parseTableConfig,
  //Form
  convertApiToItems,
  arrToObj,
  objToArr,
  flattenObjectWithIndex,
  buildFieldsInfoAndNameConsiderTop,
  buildFieldsInfoAndNameIgnoreTop,
  swapKeyValueFlattened,
  getNestedValue,
  removeEmptyValues,
  processFinancialrecordsData,
  mapObject,
  diffObjects,
  processGeneralData,
}