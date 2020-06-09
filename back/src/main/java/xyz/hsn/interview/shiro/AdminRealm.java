package xyz.hsn.interview.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.hsn.interview.entity.Manager;
import xyz.hsn.interview.service.IManagerService;
import xyz.hsn.interview.util.PasswordUtil;



@Component("adminRealm")
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    IManagerService managerService;
    /**
     * 鉴权
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return simpleAuthorizationInfo;
    }

    /**
     * 验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        Manager manager = managerService.getByUsername(upToken.getUsername());
        if (manager == null){
            throw new UnknownAccountException();
        }
        String md5Password = PasswordUtil.getMD5Password(new String(upToken.getPassword()));
        if (!md5Password.equals(manager.getPassword())){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(manager,upToken.getPassword(),manager.getUsername());
    }
}
