package com.meeleet.mall.admin.controller;

import com.meeleet.cloud.common.result.R;
import com.meeleet.cloud.sys.pojo.dto.SysUserDTO;
import com.meeleet.cloud.sys.rpc.ISysUserRpcService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/sys_user")
public class SysUserController {
    @DubboReference
    private ISysUserRpcService sysUserRpcService;

    @Operation(description = "系统用户信息")
    @GetMapping("/{id:\\d+}")
    public R<SysUserDTO> list(@PathVariable("id") Long id) {
        return R.success(sysUserRpcService.findById(id));
    }

    @Operation(description = "系统用户列表")
    @GetMapping("/list")
    public R<List<SysUserDTO>> list() {
        return R.success(sysUserRpcService.list());
    }
}
