package com.tongdou.datasource;

import com.tongdou.beans.properties.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.sql.SQLException;

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
        dataSource.setMaxWait(10000);   // 设置获取超时等待时间
        printDbInfo(dataSource);
        for (int i = 0; i < 9; i++) {
            jdbcTemplate.getDataSource().getConnection();
            printDbInfo(dataSource);
        }
    }

    /**
     * 打印数据库信息
     */
    private void printDbInfo(BasicDataSource dataSource) {
        logger.info("InitialSize:{}, maxActive:{},NumActive:{}, NumIdle:{}", dataSource.getInitialSize(), dataSource.getMaxActive(), dataSource.getNumActive(), dataSource.getNumIdle());
    }


}
