package com.meeleet.cloud.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.sys.pojo.entity.SysDict;

/**
 * 字典业务接口
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 修改字典
     *
     * @param dict
     * @return
     */
    boolean updateDictById( Long id,SysDict dict);

    /**
     *
     * @param ids
     * @return
     */
    boolean deleteDictByIds(String ids);
}
