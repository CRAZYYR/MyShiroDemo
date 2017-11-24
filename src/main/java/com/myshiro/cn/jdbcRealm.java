package com.myshiro.cn;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.security.Security;

/**
 * Created by Administrator on 17/11/22.
 */
public class jdbcRealm  {
    public static void main(String[] args) {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini");

       SecurityManager securityManager=  factory.getInstance();

       SecurityUtils.setSecurityManager(securityManager);

              Subject subject =  SecurityUtils.getSubject();
        UsernamePasswordToken token= new UsernamePasswordToken("root","root");

        try {
            subject.login(token);
            System.out.println("身份认证成功!");
        }catch (AuthenticationException e){
            System.out.println("身份认证失败!");
        }
        subject.logout();


    }
}
