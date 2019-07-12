package com.zcm.springboot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcm.springboot.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.scene.control.Pagination;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcm
 * @since 2019-07-11
 */
@Repository
public interface CityMapper extends BaseMapper<City> {

    /**
     * @author zcm
     * 查询所有
     * @date 2019/7/11 16:05
     * @Param
     * @return
     * @throws
     * @param page
    */
    List<City> findAll(Page<City> page);
}
