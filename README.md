# 医院信息管理系统

本项目是一个基于**Spring Boot**和**Vue**的医院信息管理系统，包含**管理端**和**客户端**两部分，旨在为医院提供高效的信息管理和便捷的客户端服务。
## 相关地址
http://mf-graduationdesign-hospital-management.asia (重定向为swagger API 文档) <br>
http://mf-graduationdesign-hospital-management.asia/admin (管理端) <br>
http://mf-graduationdesign-hospital-management.asia/customer (用户端)<br>
### 详细的nginx配置
server {
    listen       80;
    server_name  mf-graduationdesign-hospital-management.asia; #修改域名
    # 根路径重定向到完整 URL
    location = / {
        return 301 http://mf-graduationdesign-hospital-management.asia:8080/swagger-ui/index.html;
    }
    location /admin {
        alias  /usr/share/nginx/html/admin; #代理到admin文件夹中
        index  index.html index.htm;
    }
    location /customer  {
        alias  /usr/share/nginx/html/customer ; #代理到customer文件夹中
        index  index.html index.htm;
    }
    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }
}

|        | 账号 | 密码|支付密码|
| ------ | ------ | ------ |------ |
| 测试登录      | admin1 |123456|
| 沙箱支付| newmhg9105@sandbox.com|111111|111111|

沙箱支付的二维码页面在控制台有打印对应支付url
## 目录结构
```
├── hospital      # 后端服务 (Spring Boot)
├── customer      # 客户端前端(uniapp)
├── management    # 管理端前端 (Vue + Element Plus)
├── deployment    # 服务器部署相关文件
└── resources     # hospital后端服务的配置文件
```

---

## 技术栈

### 后端技术
- **Spring Boot**：后端框架
- **MyBatis / MyBatis-Plus**：持久层框架
- **MySQL**：关系型数据库
- **Redis**：缓存
- **Elasticsearch**：搜索引擎
- **Swagger**：接口文档
- **Spring Security**：安全认证
- **Velocity**：模板引擎

### 前端技术

#### 管理端 (management)
- **Vue 3**：前端框架
- **Element Plus**：UI 组件库
- **Axios**：HTTP 请求库
- **Vuex**：状态管理
- **Vue Router**：路由管理
- **Vue Form Craft**：表单构建

#### 客户端(customer)
- **Uni-app**：跨平台前端框架
---

## 后端文件结构 (`hospital`)
```
hospital
├── admin                # 管理端业务模块
├── common               # 公共模块，封装通用工具类和配置
├── externalservice      # 外部服务对接模块，如支付、存储等
├── mbg                  # MyBatis Generator 生成的基础代码
├── restful              # RESTful API 实现模块
├── restful_generate     # 使用 MyBatis-Plus 和 Velocity 生成 RESTful API
├── search               # Elasticsearch 搜索功能模块
└── security             # 安全模块，包含认证和权限管理
```

#### 说明
- **admin**：负责管理端业务逻辑，包括后台管理和权限控制。  
- **common**：包含公共配置、工具类和通用模块封装，便于多模块复用。  
- **externalservice**：对接外部服务模块，如阿里云OSS、支付宝沙箱支付等。  
- **mbg**：使用MyBatis Generator生成的基础代码，减少开发工作量。  
- **restful**：RESTful API接口实现，提供对外服务能力。  
- **restful_generate**：基于**MyBatis-Plus**和**Velocity**自动生成的RESTful API模块和前端js接口文件，减少手动代码量。  
- **search**：集成**Elasticsearch**，提供全文检索和数据查询能力。 ***(因服务器内存过小暂停服务)***
- **security**：使用**Spring Security**实现身份认证和权限管理，确保系统安全性。  

---

## 管理端文件结构 (`management/src`)
```
src
├── api            # 统一管理接口请求
├── assets         # 静态资源，如图片和样式
├── components     # 全局可复用组件
├── config         # 全局配置和环境变量
├── icons          # （空文件夹，遗留无用）
├── router         # 路由管理
├── store          # 状态管理 (Vuex)
├── utils          # 工具函数和封装
├── views          # 页面级组件和视图
├── App.vue        # 应用入口组件
├── main.js        # 应用主入口文件
└── swagger.js     # Swagger 接口请求封装
```

#### 说明
- **api**：封装所有接口请求，统一管理网络请求逻辑。  
- **assets**：存放项目静态资源，如图片和全局样式。  
- **components**：通用组件存放目录，便于在各页面复用。  
- **config**：应用配置，如环境变量和全局常量。  
- **router**：基于**Vue Router**管理路由跳转和页面导航。  
- **store**：基于**Vuex**进行状态集中管理，维护全局状态。  
- **utils**：封装常用工具方法，如数据格式化和防抖函数。  
- **views**：页面级组件，组织整个应用的视图展示和交互。  
- **swagger.js**：封装Swagger API请求，提供文档化接口访问能力。  

---

## 部署技术
- **Linux**：操作系统
- **Docker**：容器化部署
- **Nginx**：反向代理
- **阿里云OSS**：对象存储
- **轻量应用服务器**：后端服务托管
- **域名申请与备案**：网站访问
- **Alipay 沙箱支付**：支付功能测试

---

## 运行效果图
### 管理端
![image](https://github.com/user-attachments/assets/ac3584ac-40c2-427a-8432-34717f8f765b)
![image](https://github.com/user-attachments/assets/e1e8f899-8289-4103-abda-c32b002b4f2a)
![image](https://github.com/user-attachments/assets/407961d3-786d-42cc-b00c-656149915799)
![image](https://github.com/user-attachments/assets/54309a3f-970d-4c7b-975a-23d8ce6eb71e)

## 快速启动

### 后端启动
1. 克隆项目：
   ```bash
   git clone https://github.com/MFvmv/GraduationDesign.git
   cd hospital
   ```
2. 配置环境：
   - 修改 resources 中的数据库和Redis连接信息
   - 配置阿里云OSS和支付宝沙箱支付参数
3. 构建并运行：
   ```bash
   mvn clean package
   java -jar target/hospital.jar
   ```
   最好用idea去运行和构建

### 前端启动 (管理端)
1. 进入管理端文件夹：
   ```bash
   cd management
   ```
2. 安装依赖：
   ```bash
   npm install
   ```
3. 运行开发环境：
   ```bash
   npm run serve
   ```
4. 生产构建：
   ```bash
   npm run build
   ```

---

## Docker 部署
1. 构建镜像：
   ```bash
   docker build -t hospital-management-system .
   ```
2. 启动容器：
   ```bash
   docker run -d -p 8080:8080 --name hospital-management hospital-management-system
   ```
3. 配置Nginx代理服务，示例配置：
   ```
   server {
       listen 80;
       server_name yourdomain.com;

       location / {
           proxy_pass http://localhost:8080;
           proxy_set_header Host $host;
           proxy_set_header X-Real-IP $remote_addr;
           proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
           proxy_set_header X-Forwarded-Proto $scheme;
       }
   }
   ```

---

## 项目亮点
- **高并发支持**：Redis缓存和Elasticsearch搜索，提升系统性能。
- **安全认证**：Spring Security保障用户数据安全。
- **容器化部署**：使用Docker和Nginx简化部署和维护。
- **支付集成**：支持支付宝沙箱支付，便于测试支付流程。
- **静态资源**：OSS安全高效，弹性扩展，可靠存储。

---

## 未来规划
- [✔] 开发客户端 (Uni-app)
- [ ] 添加更多支付方式（需营业执照）
- [ ] 引入消息推送和实时通知
- [ ] 添加minio本地存储
- [ ] 添加MongoDB作为操作记录的数据库
---

## 贡献指南
欢迎对本项目提出建议和改进！请提交PR或Issue进行讨论。

---

## 联系方式
如有问题或建议，请联系邮箱：**2358672177@qq.com**

---

如果有任何修改或补充需求，请告诉我！
