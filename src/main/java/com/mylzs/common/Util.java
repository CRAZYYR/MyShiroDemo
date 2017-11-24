package com.mylzs.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by Administrator on 17/11/22.
 */
public class Util {

    /**
     * 登录
     * @param config
     * @param username
     * @param password
     * @return
     */
    public  static Subject login(String config,String username,String password){
        //读取配置文件、初始化工厂
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(config);
        //得到实例
        SecurityManager securityManager= factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
//        得到当前的用户
        Subject subject= SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken token= new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            System.out.println("身份认证成功!");
        }catch (AuthenticationException e){
            System.out.println("身份认证失败!");
        }
        return subject;
    }

}
