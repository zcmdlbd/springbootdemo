package com.zcm.springboot.service.impl;

import com.zcm.springboot.entity.SysUser;
import com.zcm.springboot.mapper.SysUserMapper;
import com.zcm.springboot.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcm
 * @since 2019-08-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private  SysUserMapper userMapper;
    @Override
    public SysUser findByUsername(String name) {
        return userMapper.findByUsername(name);
    }
}
