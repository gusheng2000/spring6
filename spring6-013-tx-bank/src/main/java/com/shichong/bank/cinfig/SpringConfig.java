package com.shichong.bank.cinfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * @Author sc
 * @ClassName springConfig
 * @Description class function:
 * @Date 2023/12/21 20:56:31
 **/

@Configuration
@ComponentScan(basePackages = "com.shichong.bank")
@EnableTransactionManagement //事务注解驱动器开启 告诉spring使用注解的方式管理事务   <tx:annotation-driven transaction-manager="txManager"/>
public class SpringConfig {


/**
     * jdbcTemplate spring提供的jdbc操作类
     * @return
     * @throws SQLException
     */

    //Spring框架，看到这个@Bean注解后，会调用这个被标注的方法，这个方法的，返回值是一个java对象，这个java对象会自动纳入IoC容器管理。
    //返回的对象就是Spring容器当中的一个Bean了。
    //并且这bean的名字是方法名：jdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){    //dataSource参数会根据参数类型自动从ioc容器注入
        //return new JdbcTemplate(dataSource());
        return new JdbcTemplate(dataSource);
    }

    //德鲁伊数据源
    @Bean
    public DataSource dataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(Driver.class.getName());
        source.setUrl("jdbc:mysql://localhost:3306/spring6?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        source.setUsername("root");
        source.setPassword("root");
        return source;
    }

    //事务管理器 需要一个数据源
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    //编程式事务需要的Bean
/*    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    //编程式事务需要的Bean
    @Bean
    public TransactionTemplate transactionTemplate( DataSourceTransactionManager dataSourceTransactionManager){
        return new TransactionTemplate(dataSourceTransactionManager);
    }*/
}

