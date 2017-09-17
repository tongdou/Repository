package com.tongdou.datasource.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * 事务隔离级别
 * Created by shenyuzhu on 2017/9/17.
 */
@Service("transactionIsolation")
public class TransactionIsolation {
    @Resource(name = "dataSource")
    private DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 数据源的事务隔离级别
     */
    public void isolationInfo() {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
//            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            logger.info("default transation isolation:{}", connection.getTransactionIsolation());
        } catch (Exception e) {
            logger.error("transaction isolation ", e);
            if (connection != null)
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    logger.error("rollback", e1);
                }
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("connection.close", e);
                }
        }
    }
}
