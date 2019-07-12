package com.zcm.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcm.springboot.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcm
 * @since 2019-07-11
 */
public interface CityService extends IService<City> {

    Page<City> findAll (Page<City> page);
}
