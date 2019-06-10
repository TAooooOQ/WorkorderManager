package com.ash.workorder.dao;

/**
 * @Created by Ash on 2019/6/9 11:28
 */

import com.ash.workorder.dao.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface UserDao{


    /**
     * 按用户名查找用户
     * @param username
     * @return UserPo
     */
    UserPo selectByUsername(String username);

    /**
     * 新增用户
     * @param UserPo
     * @return success ? 1:0
     */
    int insert(UserPo UserPo);

    /**
     * 删除用户
     * @param username
     * @return success ? 1:0
     */
    int delete(String username);

    /**
     * 更改密码
     * @param UserPo
     * @return success ? 1:0
     */
    int updatePassword(UserPo UserPo);

    /**
     * 查找用户名是否存在
     * @param username
     * @return username
     */
    UserPo searchUsername(String username);

    /**
     * 用户账户激活
     * @param username
     * @return
     */
    int activate(String username);

    void updateLoginTime(String username, Date currentTime);
}