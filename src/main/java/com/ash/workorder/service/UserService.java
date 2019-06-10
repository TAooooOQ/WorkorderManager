package com.ash.workorder.service;

import com.ash.workorder.dao.po.UserPo;
import com.mchange.util.AlreadyExistsException;

/**
 * @Created by Ash on 2018/12/25 09:56
 */
public interface UserService {

    /**
     * 登录验证
     * @param user
     * @throws Exception
     */
    UserPo login(UserPo user) throws Exception;

    /**
     * 退出当前用户的登录
     * @throws Exception
     */
    void logout() throws Exception;

    /**
     * 注册账户
     * @param userPo
     * @return username
     */
    void signup(UserPo userPo) throws AlreadyExistsException;

    /**
     * 用户更改密码
     * @param userPo
     */
    void changePassword(UserPo userPo) throws Exception;

    /**
     * 用户名检索
     * @param username
     * @return
     */
    int usernameCheck(String username);

    /**
     * 激活账户
     * @param username
     * @return
     */
    int activateAccount(String username);
}
