package com.meeleet.cloud.sys.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.meeleet.cloud.common.pojo.vo.BaseVO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户导出视图对象
 *
 * @author jaychang
 */

@Data
@ColumnWidth(20)
public class UserExportVO  extends BaseVO {

    private static final long serialVersionUID = -6557039897522434842L;

    @ExcelProperty(value = "用户名")
    private String username;

    @ExcelProperty(value = "用户昵称")
    private String nickname;

    @ExcelProperty(value = "部门")
    private String deptName;

    @ExcelProperty(value = "性别")
    private String gender;

    @ExcelProperty(value = "手机号码")
    private String mobile;

    @ExcelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "创建时间")
    @DateTimeFormat("yyyy/MM/dd HH:mm:ss")
    private LocalDateTime createTime;


}
