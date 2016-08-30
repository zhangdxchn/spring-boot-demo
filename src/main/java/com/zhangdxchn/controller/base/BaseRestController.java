package com.zhangdxchn.controller.base;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.sql.SQLException;

/**
 * Created by zhangdx on 16/8/5.
 */
@RestController
public abstract class BaseRestController {
    private static final Logger logger = Logger.getLogger(BaseRestController.class);


    public String resultEntitySuccess(Object entity) {
        ResultEntity resultEntity = new ResultEntity(ResultEntity.CodeMsg.SUCCESS, entity);
        return JSON.toJSONString(resultEntity);
    }


    /**
     * api 接口全局异常处理
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public String resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Throwable e) {
        ResultEntity resultEntity = null;

        //get info
        String sessionId = httpServletRequest.getSession().getId();
        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        String url = httpServletRequest.getRequestURL().toString();

        logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        logger.error("session : " + sessionId);
        logger.error("ip      : " + ipAddress);
        logger.error("url     : " + url);
        logger.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (e instanceof UndeclaredThrowableException) {
            e = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }

        // 可以根据不同的异常类型设置不同的消息
        if (e instanceof NullPointerException) {
            logger.error("NullPointerException: ", e);
            e.printStackTrace();

            resultEntity = new ResultEntity(ResultEntity.CodeMsg.NULL_POINT, null);
        } else if (e instanceof IOException) {
            logger.error("IOException: ", e);
            e.printStackTrace();

            resultEntity = new ResultEntity(ResultEntity.CodeMsg.IO_ERROR, null);
        } else if (e instanceof SQLException) {
            logger.error("SQLException: ", e);
            e.printStackTrace();

            resultEntity = new ResultEntity(ResultEntity.CodeMsg.SQL_ERROR, null);
        } else {
            logger.error("UnknowException", e);
            e.printStackTrace();

            resultEntity = new ResultEntity(ResultEntity.CodeMsg.UNKONwN_ERROR, null);
        }

        return JSON.toJSONString(resultEntity);
    }
}
