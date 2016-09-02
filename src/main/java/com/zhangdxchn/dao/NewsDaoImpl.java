package com.zhangdxchn.dao;

import com.zhangdxchn.dao.base.BaseDaoImpl;
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
        return this.jdbcTemplate.queryForList(sql);
    }

    //    @Override
//    public int add(News news) {
//        String sql = "insert into tb_news (id, title, time, author, content, imageUrl, `description`, readNumber)" +
//                " values(null, ?,?,?,?,?,?,?)";
//
//
//
//        return this.jdbcTemplate.update(sql,
//                news.getTitle(),
//                news.getTime(),
//                news.getAuthor(),
//                news.getContent(),
//                news.getImageUrl(),
//                news.getDescription(),
//                news.getReadNumber()
//        );
//    }
//
//    @Override
//    public int update(News news) {
//        String sql = "update tb_news set title=?, time=?, author=?, content=?, imageUrl=?, `description`=?, readNumber=? where id = ?";
//
//        return this.jdbcTemplate.update(sql,
//                news.getTitle(),
//                news.getTime(),
//                news.getAuthor(),
//                news.getContent(),
//                news.getImageUrl(),
//                news.getDescription(),
//                news.getReadNumber(),
//                news.getId()
//        );
//    }
//
//    @Override
//    public int delete(Integer newsId) {
//        String sql = "delete from tb_news where id = ?";
//
//        return this.jdbcTemplate.update(sql, newsId);
//    }

}
