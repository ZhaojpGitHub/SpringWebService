# SpringWebService
Spring项目中的WebService简单程序,大致步骤:
1. 首先构建在resource目录下的student.xsd文件

2. 使用jaxb2生成`com.springwstest.xml.school`包下的代码

   > #### jaxb2构件配置
   >
   > ```xml
   > <build>
   >     <plugins>            
   >         <plugin>
   >             <groupId>org.codehaus.mojo</groupId>
   >             <artifactId>jaxb2-maven-plugin</artifactId>
   >             <version>1.6</version>
   >             <configuration>
   >                 <!--xsd文件存放目录-->
   >                 <schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
   >                 <!--代码生成目录-->
   >                 <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
   >                 <clearOutputDir>false</clearOutputDir>
   >             </configuration>
   >         </plugin>
   >     </plugins>
   > </build>
   > ```

3. 编写EndPoint类

   ```java
   @Endpoint
   public class StudentEndpoint {
       //此处的地址应于xsd中的地址相同
       private static final String NAMESPACE_URI = "http://www.springwsTest.com/xml/school";
   	//localPart属性的值应于xsd中请求Request的名称相同
       @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentByNameRequest")
       @ResponsePayload
       public GetStudentByNameResponse GetStudentByName(@RequestPayload GetStudentByNameRequest request) {
           //......
       }
   }
   ```

4. 配置Config文件

   ```java
   @EnableWs
   @Configuration
   public class Config extends WsConfigurerAdapter {
       //配置拦截器
       @Bean
       public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
       {
           MessageDispatcherServlet servlet = new MessageDispatcherServlet();
           servlet.setApplicationContext(applicationContext);
           servlet.setTransformWsdlLocations(true);
           return new ServletRegistrationBean(servlet, "/webService/*");
       }
       @Bean(name = "StudentWsdl")//name属性为自动生成的wsdl文件的名称
       public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema)
       {
           DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
           wsdl11Definition.setPortTypeName("StudentPort");//??不知道有啥用
           wsdl11Definition.setLocationUri("/webService/studentInfo");//网络请求用?
           wsdl11Definition.setTargetNamespace("http://www.springwsTest.com/xml/school");//与xsd文件相同
           wsdl11Definition.setSchema(countriesSchema);
           return wsdl11Definition;
       }
   
       @Bean
       public XsdSchema countriesSchema()
       {
           return new SimpleXsdSchema(new ClassPathResource("student.xsd"));//xsd文件位置
       }
   }
   ```

5. 配置完成后访问:http://localhost:+端口+拦截器地址+DefaultWsdl11Definition类的名字，即可或得wsdl文件

6. 使用axis生成客户端来访问webservice服务

   > #### Pom配置
   >
   > #### 1.jar包
   >
   > ```xml
   > <dependency>
   >     <groupId>org.apache.axis2</groupId>
   >     <artifactId>axis2-wsdl2code-maven-plugin</artifactId>
   >     <version>1.7.9</version>
   > </dependency>
   > <dependency>
   >     <groupId>org.apache.axis2</groupId>
   >     <artifactId>axis2-jaxbri</artifactId>
   >     <version>1.7.9</version>
   > </dependency>
   > <dependency>
   >     <groupId>org.apache.axis2</groupId>
   >     <artifactId>axis2-jaxws</artifactId>
   >     <version>1.7.9</version>
   > </dependency>
   > ```
   >
   > #### 2.Build
   >
   > ```xml
   > <plugin>
   >     <groupId>org.apache.axis2</groupId>
   >     <artifactId>axis2-wsdl2code-maven-plugin</artifactId>
   >     <version>1.7.9</version>
   >     <configuration>
   >        <!-- wsdl默认位置为resources文件夹,默认名称为service.wsdl -->
   >         <overWrite>true</overWrite><!--生成时覆盖文件-->
   >         <packageName>com.clienttest.test</packageName><!--包名-->
   >         <outputDirectory>${project.basedir}/src/main/java</outputDirectory><!--路径-->
   >     </configuration>
   > </plugin>
   > ```
   >
   > 更多属性查看[官方介绍]([axis2-wsdl2code-maven-plugin – axis2-wsdl2code:wsdl2code (apache.org)](http://axis.apache.org/axis2/java/core/tools/maven-plugins/axis2-wsdl2code-maven-plugin/wsdl2code-mojo.html))
   >
   > #### 生成文件测试
   >
   > #### 1.调用get方法,然后返回Response
   >
   > ```java
   > try{
   >     StudentPortServiceStub stub =new StudentPortServiceStub();
   >     log.info("Start!");
   >     log.info(stub.getStudents(new StudentPortServiceStub.GetStudentsRequest()).getJsonString());
   >     log.info("End!");
   > }catch(Exception error){
   >     log.error("获取Students信息出错了",error);
   > }
   > ```
   >
   > #### 2.传入CallBackHandler
   >
   > 可能是使用的方式不正确,没有反应
   >
   > ```java
   > try{
   >     StudentPortServiceStub stub =new StudentPortServiceStub();
   >     stub.startgetStudents(new StudentPortServiceStub.GetStudentsRequest(), new StudentPortServiceCallbackHandler() {
   >         @Override
   >         public void receiveResultgetStudents(StudentPortServiceStub.GetStudentsResponse result) {
   >             log.info(result.getJsonString());
   >         }
   >     });
   > }catch(Exception error){
   >     log.error("获取Students信息出错了",error);
   > }
   > ```