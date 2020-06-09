package xyz.hsn.interview.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.hsn.interview.bean.BaseResult;
import xyz.hsn.interview.bean.DataResult;
import xyz.hsn.interview.entity.Manager;
import xyz.hsn.interview.request.UserLoginRequest;
import xyz.hsn.interview.service.IManagerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminManagerController {
    @Autowired
    IManagerService managerService;
    @PostMapping("login")
    public BaseResult login(@Valid @RequestBody UserLoginRequest request){
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordToken(request.getUsername(), request.getPassword()));
        } catch (UnknownAccountException uae) {
            return BaseResult.fail("用户帐号或密码不正确");
        } catch (LockedAccountException lae) {
            return BaseResult.fail("用户帐号已锁定不可用");

        } catch (AuthenticationException ae) {
            return BaseResult.fail("认证失败");
        }
        Manager manager = managerService.getUserInfo(request.getUsername());
        return DataResult.ok(manager);
    }

    @GetMapping("logout")
    public BaseResult logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return BaseResult.ok("退出成功");
    }
}
