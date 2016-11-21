package com.zhangdxchn.web.test;

import com.zhangdxchn.dao.UserDaoImpl;
import com.zhangdxchn.web.base.BaseRestController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangdx on 16/8/4.
 */
@RestController
@RequestMapping("/api/test")
public class TestController extends BaseRestController {
    Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private UserDaoImpl userDaoImpl;


    @RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
    public String testUser(
            HttpServletRequest request,
            HttpServletResponse response
//            ModelMap model,
//            ,
//            @RequestHeader HttpHeaders headers,
//            @RequestHeader(value = "X-Api-Version") String apiVersion
    ) {

        return resultEntitySuccess(userDaoImpl.fetchAll());
    }

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String testLogin(
            ModelMap model,
            HttpServletRequest request,
            HttpServletResponse response
//            ,
//            @RequestHeader HttpHeaders headers,
//            @RequestHeader(value = "X-Api-Version") String apiVersion
    ) {

        return resultEntitySuccess(userDaoImpl.fetchAll());
    }
}
