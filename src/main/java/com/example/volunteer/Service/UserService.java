package com.example.volunteer.Service;


import com.example.volunteer.DTO.UserDTO;
import com.example.volunteer.Entity.User;
import com.example.volunteer.Response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 注册1
     */
    Response<Boolean> signUp(User user, String verifyCode);

    /**
     * 登录
     */
    UserDTO signIn(String userName,String password);

    /**
     * 更新密码
     */
    Response<Boolean> updatePassword(String tel, String oldPassword, String newPassword, String verifyCode);

    /**
     * 忘记密码
     */
    Response<Boolean> forgetPassword(String tel, String newPassword, String verifyCode);

    /**
     * 验证登录短信验证码
     */
    Response<Boolean> getVerifyMsgCode(String tel);

    /**
     * 删除用户信息
     */
    Response<Boolean> deleteUserByUserId(long userId);
}
