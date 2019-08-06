package com.zcm.springboot.mapper;

import com.zcm.springboot.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcm
 * @since 2019-08-02
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(String name);
}
