package yx.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("employee")
public class Employee {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String empName;
    private String loginName;

    @TableField(select = false)
    private String loginPassword;

    private Integer age;
    private String gender;
    private String addr;
    private String deptName;
    private Integer status;

    @TableLogic                // 声明逻辑删除字段
    private Integer deleted = 0;   // 默认未删除
}