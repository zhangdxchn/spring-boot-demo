package com.zhangdxchn.dao;

import com.zhangdxchn.dao.entity.News;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by zhangdx on 16/8/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class INewsDaoTest {
    @Autowired
    private INewsDao newsDao;

    @Test
    public void fetch() throws Exception {

    }

    @Test
    public void fetchAll() throws Exception {

    }


    @Test
    public void add() throws Exception {

        News news = new News();
        news.setTitle("新闻标题");
        news.setTime(new Date());
        news.setAuthor("新闻作者");
        news.setContent("新闻内容。。。");
        news.setImageUrl("http://zpnews-open.oss-cn-hangzhou.aliyuncs.com/test/leo.png");
        news.setDescription("新闻描述");
        news.setReadNumber(100);

        int add = newsDao.add(news);

        Assert.assertNotNull(add);
    }

    @Test
    public void update() throws Exception {

        News news = new News();
        news.setId(4);
        news.setTitle("新闻标题1");
        news.setTime(new Date());
        news.setAuthor("新闻作者1");
        news.setContent("新闻内容1。。。");
        news.setImageUrl("http://zpnews-open.oss-cn-hangzhou.aliyuncs.com/test/leo.png");
        news.setDescription("新闻描述1");
        news.setReadNumber(101);

        int update = newsDao.update(news);

        Assert.assertNotNull(update);
    }

    @Test
    public void delete() throws Exception {

        int delete = newsDao.delete(3);

        Assert.assertNotNull(delete);

    }

}