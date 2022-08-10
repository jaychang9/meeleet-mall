package com.meeleet.cloud.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meeleet.cloud.sys.dao.SysOauthClientMapper;
import com.meeleet.cloud.sys.pojo.entity.SysOauthClient;
import com.meeleet.cloud.sys.service.ISysOauthClientService;
import org.springframework.stereotype.Service;


/**
 * OAuth2 客户端业务类
 *
 * @author jaychang
 */
@Service
public class SysOauthClientServiceImpl extends ServiceImpl<SysOauthClientMapper, SysOauthClient> implements ISysOauthClientService {
}
