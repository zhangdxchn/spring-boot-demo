package com.zhangdxchn.web.api;

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
 * Created by zhangdx on 16/11/21.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseRestController {
    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserDaoImpl userDaoImpl;


    @RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
    public String user(
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
