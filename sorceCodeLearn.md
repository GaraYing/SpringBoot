## **Redis源码学习路径**

1. `@SpringBootApplication`

2. `@EnableAutoConfiguration`

3. `@Import(AutoConfigurationImportSelector.class)`

4. 找到`spring-boot-autoconfig-XXXX.jar`

5. `spring.factories`

6. `RedisAutoConfiguration`

7. `@Import(XXX.class)`

8.  初始化`JedisConnectionConfiguration(RedisProperties ...)`

9. `JedisConnectionFactory`

10. 初始化`RedisConnectionFactory`

## jConsole for Java Application
application PID for JMS

## selfDefine Annotation 自定义注解
### 派生性
    `Repository` 
        `FirstLevelRepository` 
            `SecondLevelRepository`
### 层次性

## 自定义条件装配

### 注解实现
    1. `@Profile` 示例见`ProfileBootStrap`
    2. `org.springframework.context.annotation@Conditional` `org.springframework.context.annotation@Condition`

### 编程实现
    类似`ConditionalOnProperty` 
    
## 自动装配
 参考`META_INF/spring.factories`
 
####实现方法
1. 激活自动装配`@EnableAutoConfiguration`
2. 实现自动装配`XXAutoConfiguration`
3. 配置自动装配实现`META_INF/spring.factories`
