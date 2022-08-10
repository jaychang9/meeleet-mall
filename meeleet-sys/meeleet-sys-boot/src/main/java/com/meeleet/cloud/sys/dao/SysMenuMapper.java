package com.meeleet.cloud.sys.dao;

/**
 * @author jaychang
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meeleet.cloud.sys.pojo.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 *
 * @author jaychang
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> listRoutes();

}
