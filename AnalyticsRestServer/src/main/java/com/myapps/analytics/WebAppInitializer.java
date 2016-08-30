package com.myapps.analytics;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAutoConfiguration
@ComponentScan("com.myapps.analytics")

//@SpringBootApplication
@MapperScan("com.myapps.analytics.mapper")
@EnableTransactionManagement
public class WebAppInitializer{

    public static void main(String[] args) throws Exception{
    	
    	SpringApplication springApplication = new SpringApplication(new Object[] { WebAppInitializer.class });
    	System.getProperties().put( "server.port", 8090 );
        
        Map<String, Object> defaultProperties = new HashMap<String, Object>();
        defaultProperties.put("spring.datasource.url", "jdbc:mysql://localhost:3306/analytics");
        defaultProperties.put("spring.datasource.username", "root");
        //defaultProperties.put("spring.datasource.password", "Value Two");
        //defaultProperties.put("spring.datasource.driver-class-name", "com.mysql.jdbc.Driver");
        defaultProperties.put("spring.main.show-banner", true);

        springApplication.setDefaultProperties(defaultProperties);
        springApplication.run(args);
        
    }
}

