package com.zhangdxchn.controller.test;

import com.zhangdxchn.controller.base.BaseRestController;
import com.zhangdxchn.dao.NewsDaoImpl;
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
    private NewsDaoImpl newsDaoImpl;


    @RequestMapping(value = "/news", produces = "application/json;charset=UTF-8")
    public String weather(
            ModelMap model,
            HttpServletRequest request,
            HttpServletResponse response
//            ,
//            @RequestHeader HttpHeaders headers,
//            @RequestHeader(value = "X-Api-Version") String apiVersion
    ) {


        //test 全局异常
//        List<Integer> a = null;
//        a.add(1);

        return resultEntitySuccess(newsDaoImpl.fetchAll());
    }
}
