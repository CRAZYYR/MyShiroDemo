package com.mylzs.cn;

import com.mylzs.common.Util;
import org.apache.shiro.subject.Subject;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 17/11/22.
 */
public class RoleTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("用户登陆进来.....");

    }

    @Test
    public void testhasRole() throws Exception {
        Subject user =Util.login("classpath:shiro_role.ini","java1234","123456");

        System.out.println(user.hasRole("role3")?"有这个角色":"没有这个就角色");
    }

    @Test
    public void testhasRoles() throws Exception {
        Subject user =Util.login("classpath:shiro_role.ini","java1234","123456");
        List<String> list=new ArrayList<String>();
        list.add("role1");
        list.add("role2");
        list.add("role3");
        boolean[] rs=user.hasRoles(Arrays.asList("role1","role2","role3"));
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
//   user.checkRole("role3");
    }
    @Test
    public void testPermissions() throws Exception {
        Subject user =Util.login("classpath:shiro_permission.ini","shuaizi","shuaizi");
        System.out.println(user.isPermitted("user:select"));
    }



}
