package com.hospital.restful_generate.generator;

import cn.hutool.setting.dialect.Props;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import com.hospital.restful.domain.FieldsInfo;


import com.hospital.restful_generate.config.MyBatisPlusConfig;
import com.hospital.restful_generate.mapper.TablesFieldsMapper;
import com.hospital.restful_generate.utils.AnnotationFieldExtractor;
import com.hospital.restful_generate.utils.PropsUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hospital.restful_generate.generator.MyBatisPlusGenerator.loadConfigByAttrPath;
import static com.hospital.restful_generate.generator.MyBatisPlusGenerator.readListFromYaml;

import static com.hospital.restful_generate.utils.ControllerParameterExtractor.getControllerParametersJson;
import static com.hospital.restful_generate.utils.ControllerParameterExtractor.parseRootJsonToMap;


public class FrontendApiGenerator {
    public static void main(String[] args) {
        generator("generator.properties","generator.yml");
    }
    private static void generator(String propsName,String propsList){
        List tables = readListFromYaml(propsList,"mysql.generatorList");
        Map<String, List<String>> excludeField = loadConfigByAttrPath(propsList,"mysql.contractor.generatorDtoExcludeField");
        String controllerParametersJson = getControllerParametersJson( "com.hospital.restful.modules.contractor.controller", "com.hospital");
        Props props = PropsUtils.getProps(propsName);
        Map esTables = getESSearchField(props,propsList);
        FastAutoGenerator.create(props.getStr("dataSource.url"), props.getStr("dataSource.username"), props.getStr("dataSource.password"))
                .globalConfig(builder -> {
                    builder.author("MF") // 设置作者
                            .disableOpenDir() // 禁用生成后打开目录
                            .outputDir(System.getProperty("user.dir") + "/RESTful/src/main/java"); // 设置输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(props.getStr("package.base.api")) // 设置父包名
                            .moduleName("api") // 设置模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    System.getProperty("user.dir") + "/src/main/resources/mapper")); // 设置Mapper XML生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables);// 设置需要生成的表名
                })
                .templateConfig(builder -> {
                    builder.disable(TemplateType.ENTITY, TemplateType.CONTROLLER, TemplateType.SERVICE,
                            TemplateType.SERVICE_IMPL, TemplateType.MAPPER, TemplateType.XML); // 禁用默认模板生成
                })
                .injectionConfig(builder -> {
                    builder.customFile(Collections.singletonMap("Api.js",
                            "/templates/Api.js.vm")); // 设置自定义模板
                    // 向模板传递自定义参数
                    Map<String, Object> customMap = new HashMap<>();
                    customMap.put("esTables", esTables); // 添加自定义参数
                    customMap.put("TableFieldInfo", getTableFieldInfo(props.getStr("mysql.schema"))); // 添加自定义参数
                    customMap.put("excludeField",excludeField);
                    customMap.put("CPJson", parseRootJsonToMap(controllerParametersJson));
                    builder.customMap(customMap);
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Velocity模板引擎
                .execute();
    }

    private static Map<String, Map<String, FieldsInfo>> getTableFieldInfo(String schema){
        Map<String, Map<String, FieldsInfo>> tablesFields = null;
        try {
            // 获取 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = MyBatisPlusConfig.getSqlSessionFactory();

            // 获取 SqlSession 并执行查询
            try (SqlSession session = sqlSessionFactory.openSession()) {
                TablesFieldsMapper mapper = session.getMapper(TablesFieldsMapper.class);
                tablesFields = mapper.getTableFieldsInfoToCombine(schema);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tablesFields;
    }
    //获得能模糊搜索字段
    private static Map getESSearchField(Props props,String propsList){
        List<Map<String, Object>> esTables =  readListFromYaml(propsList,"es.tables");
        String esPackage = props.getStr("es.basePackage");
        Map<String, List<String>> map = AnnotationFieldExtractor.getFieldName(esPackage);
        Map<String,List<String>> result = new HashMap();
        for (Object item:esTables){
            Map<String,String> tmp = (Map<String, String>) item;
            for(Map.Entry<String, String> vo : tmp.entrySet()){
                Object value = map.get(vo.getValue());
                result.put(vo.getKey(), (List<String>) value);
            }
        }
        return result;
    }
}

