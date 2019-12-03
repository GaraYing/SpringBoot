package com.gara.sbmybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.gara.sbmybatis.core.MyMapper;
import com.gara.sbmybatis.interceptor.CryptInterceptor;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
@MapperScan(basePackages = "com.gara.sbmybatis.mapper", sqlSessionTemplateRef = "orgSqlSessionTemplate")
public class MybatisConfigurer {

    private final Environment env;

    @Autowired
    public MybatisConfigurer(Environment env) {
        this.env = env;
    }

    private static final String prefix = "spring.datasource.druid.";

    @Bean(name = "orgSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage("com.gara.sbmybatis.entity");

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(pageHelper, new CryptInterceptor());

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory.getObject();
    }

    @Primary
    @Bean(name = "orgDataSource", initMethod = "init", destroyMethod = "close")
    public DataSource caDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("orgDataSource");
        dataSource.setUrl(env.getProperty(prefix + "url"));
        dataSource.setUsername(env.getProperty(prefix + "username"));
        dataSource.setPassword(env.getProperty(prefix + "password"));
        dataSource.setDriverClassName(env.getProperty(prefix + "driver-class-name", ""));
        dataSource.setInitialSize(env.getProperty(prefix + "initial-size", Integer.class));
        dataSource.setMaxActive(env.getProperty(prefix + "max-active", Integer.class));
        dataSource.setMinIdle(env.getProperty(prefix + "min-idle", Integer.class));
        dataSource.setMaxWait(env.getProperty(prefix + "max-wait", Integer.class));
        dataSource.setPoolPreparedStatements(env.getProperty(prefix + "pool-prepared-statements", Boolean.class));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(env.getProperty(prefix + "max-pool-prepared-statement-per-connection-size", Integer.class));
        dataSource.setValidationQuery(env.getProperty(prefix + "validation-query"));
        dataSource.setValidationQueryTimeout(env.getProperty(prefix + "validation-query-timeout", Integer.class));
        dataSource.setTestOnBorrow(env.getProperty(prefix + "test-on-borrow", Boolean.class));
        dataSource.setTestOnReturn(env.getProperty(prefix + "test-on-return", Boolean.class));
        dataSource.setTestWhileIdle(env.getProperty(prefix + "test-while-idle", Boolean.class));
        dataSource.setTimeBetweenEvictionRunsMillis(env.getProperty(prefix + "time-between-eviction-runs-millis", Integer.class));
        dataSource.setMinEvictableIdleTimeMillis(env.getProperty(prefix + "min-evictable-idle-time-millis", Integer.class));
        dataSource.setFilters(env.getProperty(prefix + "filters"));
        return dataSource;
    }

    @Bean(name = "orgTransactionManager")
    public DataSourceTransactionManager orgTransactionManager(@Qualifier("orgDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "orgSqlSessionTemplate")
    public SqlSessionTemplate orgSqlSessionTemplate(@Qualifier("orgSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

