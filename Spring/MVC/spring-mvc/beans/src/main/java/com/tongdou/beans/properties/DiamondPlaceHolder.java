package com.tongdou.beans.properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by shenyuzhu on 2017/7/30.
 */
public class DiamondPlaceHolder extends PropertyPlaceholderConfigurer {

    private static final Log log = LogFactory.getLog(DiamondPlaceHolder.class);
    private final String DIAMOND = "diamond()";


    @Override
    protected void convertProperties(Properties props) {
        super.convertProperties(props);

        Map<String, String> diamond = getProperties();
        for (Map.Entry entry : props.entrySet()) {
            if (DIAMOND.equals(entry.getValue())) {
                entry.setValue(diamond.get(entry.getKey()));
            }
        }


        log.info(props);


    }

    private Map<String, String> getProperties() {

        Map<String, String> result = new HashMap<String, String>();
        // get properties
        String createTableSql = "select name, value from properties;";
        Connection connection = null;
        PreparedStatement createState = null;
        ResultSet resultSet = null;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sampledb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        try {
            connection = dataSource.getConnection();
            createState = connection.prepareStatement(createTableSql);
            resultSet = createState.executeQuery();


            while (resultSet.next()) {
                result.put(resultSet.getString("name"), resultSet.getString("value"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // do close
        }

        return result;
    }

}
