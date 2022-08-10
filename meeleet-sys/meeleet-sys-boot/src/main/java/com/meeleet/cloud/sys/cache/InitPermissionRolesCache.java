package com.meeleet.cloud.sys.cache;

import com.meeleet.cloud.sys.rpc.ISysPermissionRpcService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 容器启动完成时加载角色权限规则至Redis缓存
 *
 * @author jaychang
 */
@Component
@RequiredArgsConstructor
public class InitPermissionRolesCache implements CommandLineRunner {

    private final ISysPermissionRpcService sysPermissionRpcService;

    @Override
    public void run(String... args) {
        sysPermissionRpcService.refreshPermRolesRules();
    }
}
