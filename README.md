# SSM Example

## 目录介绍

src/main/java

	com.pojo 数据模型(映射实体)
	
	com.pojo.request(请求DTO)
	
	com.pojo.response(响应DTO)
	
	com.dao(数据访问层接口，主要sql写在这块)
	
	com.service(业务逻辑层接口)
	
	com.service.impl(业务逻辑层实现)
	
	com.controller(路由层，可返回视图或JSON数据)


src/main/resouces

	sql(简单的sql脚本)
	
	application-config.xml(相当于spring-mybatis整合后的配置文件)
	
	application-mvc.xml(spingmvc配置文件)
	
	log4j.properties(log4j配置文件)
	
	mybatis-config.xml(mybaits配置文件)
	
src/test/java

	com.junit.test(主要写单元测试的地方)
	

	
webapp

	WEB-INF
		view(jsp视图放置处)
		web.xml(初始化配置信息)