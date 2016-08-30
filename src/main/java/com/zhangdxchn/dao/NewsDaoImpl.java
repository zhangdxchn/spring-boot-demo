package com.zhangdxchn.dao;

import com.zhangdxchn.dao.base.BaseDaoImpl;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdx on 16/8/7.
 */
@Repository
public class NewsDaoImpl extends BaseDaoImpl implements INewsDao {

    @Override
    public List<Map<String, Object>> fetchAll() {
        String sql = "select * from tb_news";
        return this.getJdbcTemplate().queryForList(sql);
    }

}
