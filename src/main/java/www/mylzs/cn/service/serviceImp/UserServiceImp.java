package www.mylzs.cn.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.mylzs.cn.dao.UserMapper;
import www.mylzs.cn.entity.User;
import www.mylzs.cn.service.UserService;

import java.util.Set;

/**
 * Created by Administrator on 17/11/23.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper  userMapper;

    @Override
    public User selectByPrimaryKey() {

        System.out.println("service进来了..");

        return  userMapper.selectByPrimaryKey(1);
    }


    @Override
    public User selectByName(String uname) {
        return userMapper.selectByName(uname);
    }
}
