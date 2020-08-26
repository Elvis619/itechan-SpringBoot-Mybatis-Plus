package com.peixin.shiro;

import com.peixin.entity.Admin;
import com.peixin.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token =  (UsernamePasswordToken) authenticationToken;
        Admin admin = adminService.findByUsername(token.getUsername());
        if(admin != null){
            return new SimpleAuthenticationInfo(admin,admin.getUsername(),getName());
        }
        return null;
    }
}
