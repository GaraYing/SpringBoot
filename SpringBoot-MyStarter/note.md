需求： 实现任意字符加上前缀与后缀

实现：springboot 自定义实现自己的starter

思路：   
    1： 创建一个empty springboot project  
    2. 加入依赖  
    ```
    <!-- 此文件主要给IDE使用，用于提示使用 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>
    ```spring.factories
    3. 定义属性文件ExampleProperties  
    4. 定义服务类 ExampleService  
    4. 定义自动装配类 ExampleAutoConfigure **重点**  
    5. mvn clean install 打包starter到local repository  
    5. 测试工程引入mystarter,编写测试类  