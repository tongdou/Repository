package com.tongdou.beans.properties;


import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * inject from property file
 * Created by shenyuzhu on 2017/7/30.
 */
public class TestProperties {

    private static final Log log = LogFactory.getLog(TestProperties.class);

    /**
     * 测试加载资源文件，初始化DataSource
     */
    @Test
    public void testDatasource() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:properties/dataSource.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        BasicDataSource dataSourceXml = (BasicDataSource) context.getBean("dataSourceXml");

        log.info(String.format("dataSource.getUrl %s,%s,%s,%s", dataSource.getUrl(), dataSource.getPassword(), dataSource.getUsername(), dataSource.getDriverClassName()));
        log.info(String.format("dataSourceXml.getUrl %s,%s,%s,%s", dataSourceXml.getUrl(), dataSourceXml.getPassword(), dataSourceXml.getUsername(), dataSourceXml.getDriverClassName()));
    }

    /**
     * 初始化数据库，为模拟Diamond做准备
     */
    @Test
    public void initDatabase() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:properties/dataSource.xml");
        BasicDataSource dataSourceXml = (BasicDataSource) context.getBean("dataSourceXml");

        // get connection
        Connection connection = null;
        try {
            connection = dataSourceXml.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // create table
        String createTableSql = "CREATE TABLE `properties` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  `value` varchar(255) DEFAULT NULL,\n" +
                "  `insert_date` datetime DEFAULT NOW(),\n" +
                "  `modified_date` datetime DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ");";
        try {
            PreparedStatement createState = connection.prepareStatement(createTableSql);
            createState.execute();
        } catch (SQLException e) {
//            e.printStackTrace();
        }

        // init table
        String[] initTable = {"delete FROM properties where NAME in('rocket.topic','rocket.tags');",
                "insert INTO properties( name ,VALUE) values('rocket.topic','ORDER');",
                "insert INTO properties( name ,VALUE) values('rocket.tags','SMI');"};
        try {
            Statement insertState = connection.createStatement();
            for (int i = 0; i < initTable.length; i++) {
                insertState.addBatch(initTable[i]);
            }
            insertState.executeBatch();
        } catch (SQLException e) {
//            e.printStackTrace();
        }

    }


    /**
     * 模拟实现一个Diamond功能，与真实Diamond功能不同的是，我们的配置信息存储在数据库中，而非Diamond服务器上
     * 1、创建表
     * 2、定制PropertyPlaceholderConfigurer类
     */
    @Test
    public void testDiamond() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:properties/dataSource.xml");
        OrderConsumer consumer = context.getBean(OrderConsumer.class);
        log.info(String.format("OrderConsumer info %s,%s", consumer.getTopic(), consumer.getTags()));


    }


}
