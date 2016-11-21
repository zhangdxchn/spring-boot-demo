package com.zhangdxchn.web.api;

import com.zhangdxchn.dao.UserDaoImpl;
import com.zhangdxchn.web.test.TestController;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;

/**
 * Created by zhangdx on 2016/11/20.
 */
public class TestControllerTestWithoutAnnotations {
    private UserDaoImpl userDaoImpl;
    private TestController testController;

    @Before
    public void setUp() throws Exception
    {
        userDaoImpl = Mockito.mock(UserDaoImpl.class);
        testController = new TestController();

        ReflectionTestUtils.setField(testController, "userDaoImpl", userDaoImpl);
    }

    @Test
    public void weather() throws Exception {

        Map<String, Object> newsMap = new HashedMap();
        newsMap.put("name", "张大");

        Mockito.when(userDaoImpl.fetch(1)).thenReturn(newsMap);

        //assertEquals(userDaoImpl.fetch(39), newsMap);

        //add request and response
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        MockHttpSession mockHttpSession = new MockHttpSession();
//        mockHttpSession.setAttribute("username", "user");
        mockHttpServletRequest.setSession(mockHttpSession);

        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();

        testController.testUser(mockHttpServletRequest, mockHttpServletResponse);
    }

}