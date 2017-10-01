package com.tongdou.datasource;

import com.tongdou.beans.properties.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

/**
 * datasource info
 * Created by shenyuzhu on 2017/9/28.
 */
@ContextConfiguration(locations = {"classpath:com/tongdou/dao/applicationContext.xml"})
public class DatasourceTest extends AbstractTestNGSpringContextTests {
    Logger logger = LoggerFactory.getLogger(DataSource.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void showDbCollection() throws SQLException {
        BasicDataSource dataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        logger.info("userName:{}, password:{}, maxWait:{}", dataSource.getUsername(), dataSource.getPassword(), dataSource.getMaxWait());
        dataSource.setMaxWait(3000);   // 设置获取超时等待时间
        printDbInfo(dataSource);


        List<Connection> list = new ArrayList<>();

        try {
            for (int i = 0; i < 10; i++) {
                list.add(jdbcTemplate.getDataSource().getConnection());
                printDbInfo(dataSource);
            }
        } catch (Exception e) {
            logger.error("jdbcTemplate.getDataSource().getConnection", e);
        } finally {
            for (Connection con : list) {
                con.close();
            }
        }


    }

    /**
     * 打印数据库信息
     */
    private void printDbInfo(BasicDataSource dataSource) {
        logger.info("InitialSize:{}, maxActive:{},NumActive:{}, NumIdle:{}", dataSource.getInitialSize(), dataSource.getMaxActive(), dataSource.getNumActive(), dataSource.getNumIdle());
    }


}
