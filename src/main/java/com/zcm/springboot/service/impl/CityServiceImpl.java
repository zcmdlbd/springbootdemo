package com.zcm.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcm.springboot.entity.City;
import com.zcm.springboot.mapper.CityMapper;
import com.zcm.springboot.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcm
 * @since 2019-07-11
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Page<City> findAll(Page<City> page) {
        return page.setRecords(cityMapper.findAll(page));
    }

    @Override
    public void deleteById(Integer id) {
        cityMapper.deleteById(id);
    }
}
