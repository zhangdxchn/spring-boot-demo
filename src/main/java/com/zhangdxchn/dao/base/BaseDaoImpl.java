package com.zhangdxchn.dao.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdx on 16/8/7.
 */
@Repository
public class BaseDaoImpl implements IBaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private static final String SELECT_ID_SQL_TEMPLATE = "search * from (%s) where `id`=:id";
    private static final String SELECT_AND_SQL_TEMPLATE = "search * from (%s) where %s";
    private static final String SELECT_OR_SQL_TEMPLATE = "search * from (%s) where %s";

    private static final String INSERT_SQL_TEMPLATE = "insert into %s (%s) values(%s)";
    private static final String UPDATE_SQL_TEMPLATE = "update %s set %s where `id`=:id";
    private static final String DELETE_SQL_TEMPLATE = "delete from %s where `id`=:id";
    private static final String DELETE_WITH_LOGIC_SQL_TEMPLATE = "update %s set isDelete = 1 where `id`=:id";


    private enum selectOperation {
        AND("and"), OR("or");

        private String value;

        selectOperation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String buildSelectSql(String template, Object object, selectOperation operation) {
        String tableName = buildTableName(object);
        StringBuffer whereOperations = new StringBuffer();

        boolean isAddCommoa = false;

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            //不存在值则跳过
            Object value = null;
            try {
                value = fields[i].get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                continue;
            }

            if (isAddCommoa) {
                whereOperations.append(" " + operation.getValue() + " ");
            }

            // TODO: 16/9/5

        }

        return String.format(template, tableName, null);
    }

    public static String buildInsertSql(Object object) {
        String tableName = buildTableName(object);
        StringBuffer attrs = new StringBuffer();
        StringBuffer values = new StringBuffer();

        boolean isAddCommoa = false;

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            //不存在值则跳过
            Object value = null;
            try {
                value = fields[i].get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                continue;
            }

            if (isAddCommoa) {
                attrs.append(",");
                values.append(",");
            }

            String fieldName = fields[i].getName();
            attrs.append("`" + fieldName + "`");
            values.append(":" + fieldName);

            isAddCommoa = true;
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

    public static String buildUpdateWithNoNullSql(Object object) {
        String tableName = buildTableName(object);
        StringBuffer sets = new StringBuffer();

        boolean isAddCommoa = false;

        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            //不存在值则跳过
            Object value = null;
            try {
                value = fields[i].get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                continue;
            }

            if (isAddCommoa) {
                sets.append(",");
            }

            String fieldName = fields[i].getName();
            if (fieldName.equals("id")) {
                continue;
            }

            sets.append("`" + fieldName + "`= :" + fieldName);

            isAddCommoa = true;
        }
        return String.format(UPDATE_SQL_TEMPLATE, tableName, sets.toString());
    }

    public static String buildDeleteSql(String template, Object object) {
        String tableName = buildTableName(object);
        return String.format(template, tableName);
    }

    public static String buildTableName(Object object) {
        return "tb_" + object.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public List<Map> fetchAnd(Object object) {
        String sql = buildDeleteSql(DELETE_WITH_LOGIC_SQL_TEMPLATE, object);
//        return this.namedParameterJdbcTemplate.queryForObject(sql, new BeanPropertySqlParameterSource(object), List.class);
//         TODO: 16/9/5
        return null;
    }

    @Override
    public List<Map> fetchOr(Object object) {
        return null;
    }

    @Override
    public List<Map> fetchById(Object object) {
        return null;
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
    public int updateWithNoNull(Object object) {
        String sql = buildUpdateWithNoNullSql(object);
        return this.namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }

    @Override
    public int delete(Object object) {
        String sql = buildDeleteSql(DELETE_SQL_TEMPLATE, object);
        return this.namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }

    @Override
    public int deleteWithLogic(Object object) {
        String sql = buildDeleteSql(DELETE_WITH_LOGIC_SQL_TEMPLATE, object);
        return this.namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(object));
    }
}
