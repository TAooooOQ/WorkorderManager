package com.ash.workorder.shiro.token;

import com.ash.workorder.dao.UserDao;
import com.ash.workorder.dao.po.UserPo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Created by Ash on 2018/12/25 09:09
 * 该类未来可进行abstract化，供权限拓展使用
 */
public class AbstractRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(AbstractRealm.class);

    @Autowired
    UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        UserPo userPo = userDao.selectByUsername(token.getUsername());
        if (userPo == null) {
            logger.info("user: {} not exist.", token.getUsername());
            throw new AuthenticationException("该用户不存在");
        }
        else if(!userPo.isActivate())
            throw new AuthenticationException("账户未激活");
        return new SimpleAuthenticationInfo(userPo.getUsername(), userPo.getPassword(), getName());
    }
}
