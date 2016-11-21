package com.zhangdxchn.web.weixin;

import com.zhangdxchn.service.weixin.IWxService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by zhangdx on 16/8/13.
 */
@RestController
@RequestMapping("/api/")
public class ValidateController {
    private static final Logger logger = Logger.getLogger(ValidateController.class);

    @Value("${weixin.token}")
    private String WEIXIN_TOKEN;

    @Autowired
    private IWxService wxService;


    @RequestMapping(value = "/validate", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void token(
            @RequestParam(value = "signature") String signature,
            @RequestParam(value = "timestamp") String timestamp,
            @RequestParam(value = "nonce") String nonce,
            @RequestParam(value = "echostr") String echostr,
            ModelMap model,
            HttpServletRequest request,
            HttpServletResponse response) {

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (checkSignature(WEIXIN_TOKEN, signature, timestamp, nonce)) {
                out.print(echostr);
            } else {
                out.print("error parameter!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            out = null;
        } finally {
            out.close();
            out = null;
        }
    }

    /**
     * 校验签名
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
        if (signature == null || timestamp == null || nonce == null) {
            return false;
        }
        // 对token、timestamp和nonce按字典排序
        String[] paramArr = new String[]{token, timestamp, nonce};
        Arrays.sort(paramArr);

        // 将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String ciphertext = DigestUtils.sha1Hex(content.toString());

        // 将sha1加密后的字符串与signature进行对比
        return ciphertext != null ? ciphertext.equals(signature) : false;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void sendMsg(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            String respMessage = wxService.processRequest(request);
            out = response.getWriter();
            out.print(respMessage);
            logger.debug(respMessage);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            out.close();
        }
    }

    @RequestMapping(value = "/getToken", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void getToken(HttpServletResponse response) {
        try {
            response.getWriter().print(wxService.getToken().getAccessToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
