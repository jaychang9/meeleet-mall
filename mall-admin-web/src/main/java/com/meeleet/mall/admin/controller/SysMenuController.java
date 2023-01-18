package com.meeleet.mall.admin.controller;

import com.meeleet.cloud.common.result.R;
import com.meeleet.cloud.sys.pojo.vo.RouteVO;
import com.meeleet.cloud.sys.rpc.ISysMenuRpcService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys_menu")
public class SysMenuController {

    @DubboReference
    private ISysMenuRpcService sysMenuRpcService;

    @Operation(description = "路由列表")
    @GetMapping("/routes")
    public R<List<RouteVO>> routes() {
        List<RouteVO> routes = sysMenuRpcService.listNextRoutes();
        return R.success(routes);
    }
}
