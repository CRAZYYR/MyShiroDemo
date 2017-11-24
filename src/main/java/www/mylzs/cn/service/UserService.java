package www.mylzs.cn.service;

import www.mylzs.cn.entity.User;

import java.util.Set;

/**
 * Created by Administrator on 17/11/23.
 */
public interface UserService {
     User selectByPrimaryKey();



    User selectByName(String uname);
}
