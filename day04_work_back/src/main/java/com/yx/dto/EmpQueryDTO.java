package com.yx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("员工查询条件")
public class EmpQueryDTO {
    @ApiModelProperty("姓名（模糊查询）")
    private String name;

    @ApiModelProperty("部门")
    private String dept;

    @ApiModelProperty("最小年龄")
    private Integer minAge;

    @ApiModelProperty("最大年龄")
    private Integer maxAge;

    @ApiModelProperty("页码")
    private Integer pageNum = 1;

    @ApiModelProperty("每页大小")
    private Integer pageSize = 10;
}