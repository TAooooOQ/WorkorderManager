package com.ash.workorder.dao;

/**
 * @Created by Ash on 2019/6/9 11:28
 */

import com.ash.workorder.dao.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao{

    UserPo selectByEmail(String username);

}