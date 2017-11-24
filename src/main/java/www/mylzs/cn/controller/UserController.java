package www.mylzs.cn.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import www.mylzs.cn.entity.User;
import www.mylzs.cn.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 17/11/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    @ResponseBody
    public String view(User user, HttpServletRequest httpServletRequest){
     Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getUname(),user.getUpwd());

           subject.login(usernamePasswordToken);
           Session session=subject.getSession();
           session.setAttribute("info","登陆成功!");



        return "dengluchenggong!";
    }
    @RequestMapping("/unauthorized")
    @ResponseBody
    public String unauthorized(){
        return "shouquanshibai!";
    }
    @RequestMapping("/loginUrl")
    @ResponseBody
    public  String loginUrl(){
        return "shenfenrenzhengshibai!";
    }
}
