package www.mylzs.cn.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import www.mylzs.cn.entity.User;
import www.mylzs.cn.service.UserService;

/**
 * Created by Administrator on 17/11/24.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService   userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       String uname= (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo  simpleAuthorizationInfo=new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles(userService.getRoles(uname));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String uname= (String) token.getPrincipal();
        User user=userService.selectByName(uname);
        if (user !=null)
        {
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUname(),user.getUpwd(),"xx");
            return authenticationInfo;
        }
        return null;
    }
}
