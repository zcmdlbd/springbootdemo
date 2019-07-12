package com.zcm.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcm.springboot.entity.City;
import com.zcm.springboot.service.CityService;
import com.zcm.springboot.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcm
 * @since 2019-07-11
 */
@Slf4j
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/find")
    public City findById(@RequestParam(value = "id")Integer id){
        City city = new City();
        city = cityService.getById(id);
        System.out.println(city.toString());
        return city;
    }

    /**
     * 获得用户列表
     *
     * @param page  页码
     * @param size  页大小
     * @param model model
     * @return JSON格式数据
     */
    @GetMapping
    public Response<Page<City>> citys(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "2") Integer size, Model model) {
        //用户列表
        Page pageable = new Page(page, size);
        Page<City> cityPage =cityService.findAll(pageable);
        return Response.yes(cityPage);
    }

    /**
     * @author zcm
     * @date 2019/7/11 17:28
     * @Param City
     * 增加城市
     * @return Response
     * @throws
    */
    @PostMapping
    public Response insertCity(@RequestBody City city){
        try {
            cityService.save(city);
        }catch (Exception e){
            e.printStackTrace();
            log.info("插入失败");
            return  Response.no();
        }
        return  Response.yes();
    }

    /**
     * @author zcm
     * @date 2019/7/12 10:31
     * @Param
     * @return
     * @throws
    */
    @PutMapping
    public  Response updateCity(@RequestBody City city){
        if (cityService.saveOrUpdate(city)) {
            return Response.yes();
        }
        return Response.no();
    }

    /**
     * @author zcm
     * @date 2019/7/12 10:57
     * @Param
     * @return
     * @throws
    */
    @DeleteMapping("/{id}")
    public Response deleteCity(@PathVariable Integer id){
        try {
            cityService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return  Response.no();
        }
        return  Response.yes();
    }






}
