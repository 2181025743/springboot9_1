package com.yx.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author yx
 * @since 2025-09-05
 */
@Getter
@Setter
@ApiModel(value = "Employee对象", description = "员工表")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工姓名")
    private String empName;

    @ApiModelProperty("登录账号")
    private String loginName;

    @ApiModelProperty("登录密码")
    private String loginPassword;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("地址")
    private String addr;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("状态：0工作 1休息 2离职")
    private Integer status;

    @ApiModelProperty("是否删除：0未删除 1已删除")
    private Boolean deleted;


}
