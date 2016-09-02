package com.zhangdxchn.dao.base;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;

/**
 * Created by zhangdx on 16/8/7.
 */
@Repository
public class BaseDaoImpl implements IBaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private static String INSERT_SQL_TEMPLATE = "insert into %s (%s) values(%s)";
    private static String UPDATE_SQL_TEMPLATE = "update %s set %s where `id`=:id";
    private static String DELETE_SQL_TEMPLATE = "delete from %s where `id`=:id";


    public static String buildInsertSql(Object object) {
        String tableName = buildTableName(object);
        StringBuffer attrs = new StringBuffer();
        StringBuffer values = new StringBuffer();

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            attrs.append("`" + fieldName + "`");
            values.append(":" + fieldName);

            if (i != fields.length - 1) {
                attrs.append(",");
                values.append(",");
            }
        }
        return String.format(INSERT_SQL_TEMPLATE, tableName, attrs.toString(), values.toString());
    }

    public static String buildUpdateSql(Object object) {
        String tableName = buildTableName(object);
        StringBuffer sets = new StringBuffer();

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            if (fieldName.equals("id")) {
                continue;
            }

            sets.append("`" + fieldName + "`= :" + fieldName);

            if (i != fields.length - 1) {
                sets.append(",");
            }
        }
        return String.format(UPDATE_SQL_TEMPLATE, tableName, sets.toString());
    }

    public static String buildDeleteSql(Object object) {
        String tableName = buildTableName(object);
        return String.format(DELETE_SQL_TEMPLATE, tableName);
    }

    public static String buildTableName(Object object) {
        return "tb_" + object.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public int add(Object object) {
        String sql = buildInsertSql(object);
        return this.namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }

    @Override
    public int update(Object object) {
        String sql = buildUpdateSql(object);
        return this.namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }

    @Override
    public int delete(Object object) {
        String sql = buildDeleteSql(object);
        return this.namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }
}
