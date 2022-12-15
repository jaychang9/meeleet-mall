package com.meeleet.mall.admin.controller;

import com.meeleet.cloud.common.result.R;
import com.meeleet.cloud.common.security.util.SysUserUtils;
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

    @Operation(description = "指定ID的系统用户信息")
    @GetMapping("/{id:\\d+}")
    public R<SysUserDTO> info(@PathVariable("id") Long id) {
        return R.success(sysUserRpcService.findById(id));
    }


    @Operation(description = "当前登录者的系统用户信息")
    @GetMapping("/me")
    public R<SysUserDTO> me() {
        Long userId = SysUserUtils.getUserId();
        return R.success(sysUserRpcService.findById(userId));
    }

    @Operation(description = "系统用户列表")
    @GetMapping("/list")
    public R<List<SysUserDTO>> list() {
        return R.success(sysUserRpcService.list());
    }
}
