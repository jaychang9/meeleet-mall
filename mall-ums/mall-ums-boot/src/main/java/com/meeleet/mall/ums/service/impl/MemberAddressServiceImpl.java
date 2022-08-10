package com.meeleet.mall.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meeleet.mall.ums.dao.MemberAddressMapper;
import com.meeleet.mall.ums.pojo.entity.MemberAddress;
import com.meeleet.mall.ums.service.IMemberAddressService;
import org.springframework.stereotype.Service;

@Service
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressMapper, MemberAddress> implements IMemberAddressService {
}
