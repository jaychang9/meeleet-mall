package com.meeleet.cloud.sys.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户导入表单对象
 *
 * @author jaychang
 */
@Data
public class UserImportDTO {

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 角色ID
     */
    private String roleIds;


    private MultipartFile file;

    /**
     * 导入的用户列表
     */
    private List<UserItem> userList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserItem {

        @ExcelProperty(value = "用户名")
        private String username;

        @ExcelProperty(value = "用户昵称")
        private String nickname;

        @ExcelProperty(value = "性别")
        private String gender;

        @ExcelProperty(value = "手机号码")
        private String mobile;

        @ExcelProperty(value = "邮箱")
        private String email;
    }

}
