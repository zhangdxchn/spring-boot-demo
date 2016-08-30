package com.zhangdxchn.dao;

import com.zhangdxchn.dao.base.IBaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdx on 16/8/7.
 */
public interface INewsDao extends IBaseDao{
    List<Map<String, Object>> fetchAll();
}
