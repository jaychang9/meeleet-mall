package com.meeleet.cloud.sys.rpc.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.SysDictItemDTO;
import com.meeleet.cloud.sys.pojo.query.SysDictItemPageQuery;
import com.meeleet.cloud.sys.rpc.ISysDictItemRpcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SysDictItemRpcServiceImplTest {

    @Autowired
    private ISysDictItemRpcService sysDictItemRpcService;

    @Test
    void page() {
        SysDictItemPageQuery pageQuery = new SysDictItemPageQuery();
        pageQuery.setNameLike("服务");
        IPage<SysDictItemDTO> page = sysDictItemRpcService.page(pageQuery);
        Assert.notEmpty(page.getRecords());
        System.out.println(JSONUtil.toJsonStr(page));
    }
}