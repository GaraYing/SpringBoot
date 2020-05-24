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
