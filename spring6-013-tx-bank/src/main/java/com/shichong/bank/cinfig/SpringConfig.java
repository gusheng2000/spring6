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
public class SpringConfig {


/**
     * 配置数据源
     * @return
     * @throws SQLException
     */

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    @Bean
    public DataSource dataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(Driver.class.getName());
        source.setUrl("jdbc:mysql://localhost:3306/spring6?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        source.setUsername("root");
        source.setPassword("root");
        return source;
    }


    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean
    public TransactionTemplate transactionTemplate( DataSourceTransactionManager dataSourceTransactionManager){
       return new TransactionTemplate(dataSourceTransactionManager);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}

