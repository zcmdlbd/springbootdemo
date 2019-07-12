package com.zcm.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zcm
 * @since 2019-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class City extends Model<City> {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省份编号
     */
    private Integer provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
