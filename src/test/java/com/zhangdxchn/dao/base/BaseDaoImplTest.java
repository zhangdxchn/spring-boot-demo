package com.zhangdxchn.dao.base;

import com.zhangdxchn.dao.entity.News;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangdx on 16/8/31.
 */
public class BaseDaoImplTest {

    @Test
    public void buildInsertSql() throws Exception {
        String a = BaseDaoImpl.buildInsertSql(new News());

        System.out.println(a);
        Assert.assertNotNull(a);
    }

    @Test
    public void buildUpdateSql() throws Exception {
        String a = BaseDaoImpl.buildUpdateSql(new News());

        System.out.println(a);
        Assert.assertNotNull(a);
    }

}