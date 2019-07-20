## **Redis源码**

1. 找到spring-boot-autoconfig jar

2. `spring.factories`

3. `RedisAutoConfiguration`

4. `@Import()`

5.  初始化`JedisConnectionConfiguration(RedisProperties ...)`

6. `JedisConnectionFactory`

7. 初始化`RedisConnectionFactory`