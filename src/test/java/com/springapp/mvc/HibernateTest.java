//package com.springapp.mvc;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Created by macbookpro on 4/29/15.
// */
//public class HibernateTest {
//
//    public static void main(String[] args) {
//            LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//            sfb.setDataSource(dataSource());
//            sfb.setPackagesToScan(new String[] { "domain" });
//            sfb.setHibernateProperties(hibernateProperties());
//
//
//            DriverManagerDataSource dataSource = new DriverManagerDataSource();
//            dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//            dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//            dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//            dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
//
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//
//    }
//
//}
