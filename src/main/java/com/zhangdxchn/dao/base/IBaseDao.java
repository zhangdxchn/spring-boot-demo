package com.zhangdxchn.dao.base;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdx on 16/8/7.
 */
public interface IBaseDao {

    List<Map> fetchById(Object object);

    List<Map> fetchAnd(Object object);

    List<Map> fetchOr(Object object);

    int add(Object object);

    int update(Object object);

    int updateWithNoNull(Object object);

    int delete(Object object);

    int deleteWithLogic(Object object);
}

