package com.myshiro.cn;
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
public class HelloWord {
    public static void main(String[] args) {

        //读取配置文件、初始化工厂
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:MyshiroConfig.ini");
    //得到实例
        SecurityManager securityManager= factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
//        得到当前的用户
         Subject subject= SecurityUtils.getSubject();
         //创建令牌
        UsernamePasswordToken token= new UsernamePasswordToken("java1234","123456");
        token.setRememberMe(true);
        try {
            subject.login(token);
            System.out.println("身份认证成功!");
        }catch (AuthenticationException e){
            System.out.println("身份认证失败!");
        }
        subject.logout();
    }
}
