package com.Service;

import com.Dao.UserDao;
import com.PoJo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public String login(String id, String password) {
        User user= userDao.get(id);
        if (user==null){
            return "用户不存在";
        }else {
            if (user.password.equals(password)){
                return "登陆成功";
            }else {
                return "密码错误";
            }
        }


    }
}
