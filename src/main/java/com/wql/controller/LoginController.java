package com.wql.controller;

import com.wql.domain.LoginPojo;
import com.wql.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/logins")
public class LoginController
{
    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping
    public LoginResult getByid_Login(@RequestBody LoginPojo loginPojo, HttpServletRequest request, HttpServletResponse response)
    {
        LoginPojo byid_login = loginServiceImp.getByid_Login(loginPojo);
        String msg;
        String token=null;
        if(null!=byid_login)
        {
            token= UUID.randomUUID().toString();
            Cookie cookie=new Cookie("token",token);
            response.addCookie(cookie);
            msg="登录成功";
        }else {
            msg="登录失败";
        }
        return new LoginResult(null!=byid_login?Code.Get_Ok:Code.Get_ERR,msg,token);
    }
}
