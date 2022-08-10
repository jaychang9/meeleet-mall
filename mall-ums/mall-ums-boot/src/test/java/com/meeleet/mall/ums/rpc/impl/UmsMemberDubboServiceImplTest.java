package com.meeleet.mall.ums.rpc.impl;

import cn.hutool.core.lang.Assert;
import com.meeleet.mall.ums.rpc.IMemberRpcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UmsMemberDubboServiceImplTest {

    @Autowired
    private IMemberRpcService memberRpcService;

    @Test
    void addMember() {
    }

    @Test
    void findMemberOpenId() {
        String memberOpenId = memberRpcService.findMemberOpenId(3L);
        Assert.notBlank(memberOpenId);
        System.out.println(memberOpenId);
    }

    @Test
    void loadUserByOpenid() {
    }

    @Test
    void loadUserByMobile() {
    }
}