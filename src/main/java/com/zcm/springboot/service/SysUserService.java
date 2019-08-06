package com.zcm.springboot.service;

import com.zcm.springboot.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcm
 * @since 2019-08-02
 */
public interface SysUserService extends IService<SysUser> {
    SysUser findByUsername(String name);
}
