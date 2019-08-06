package com.zcm.springboot.controller;


import com.zcm.springboot.entity.SysUser;
import com.zcm.springboot.exception.UnauthorizedException;
import com.zcm.springboot.service.SysUserService;
import com.zcm.springboot.util.JWTUtil;
import com.zcm.springboot.util.ResponseBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcm
 * @since 2019-08-02
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController{
    @Autowired
    private SysUserService userService;


    @PostMapping("/login")
    public ResponseBean signUp(@RequestParam("username")String username,
                               @RequestParam("password")String password) {
        SysUser user = userService.findByUsername(username);
        if (user.getPassword().equals(password)){
            return new ResponseBean(200,"login success", JWTUtil.sign(username,password));
        }else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/article")
    public ResponseBean article(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            return new ResponseBean(200,"已经登录",null);
        }
        return new ResponseBean(200,"你是访客",null);
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }


}
