package com.wql.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wql.dao.LoginDao;
import com.wql.domain.LoginPojo;
import com.wql.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService
{
    @Autowired
    private LoginDao loginDao;
    @Override
    public LoginPojo getByid_Login(LoginPojo loginPojo) {
        LambdaQueryWrapper<LoginPojo> loginPojoLambdaQueryWrapper=new LambdaQueryWrapper<LoginPojo>();
        loginPojoLambdaQueryWrapper.eq(LoginPojo::getUser,loginPojo.getUser())
                                   .eq(LoginPojo::getPassword,loginPojo.getPassword());
        LoginPojo loginPojo1 = loginDao.selectOne(loginPojoLambdaQueryWrapper);
        return loginPojo1;
    }
}
