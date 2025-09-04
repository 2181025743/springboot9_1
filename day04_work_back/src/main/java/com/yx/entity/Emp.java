package com.yx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("员工实体")
public class Emp {
    @ApiModelProperty("员工ID")
    private Integer id;

    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("员工地址")
    private String addr;

    @ApiModelProperty("所属部门")
    private String dept;

    @ApiModelProperty("年龄")
    private Integer age;
}