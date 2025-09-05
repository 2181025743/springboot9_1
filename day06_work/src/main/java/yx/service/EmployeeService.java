package yx.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import yx.entity.Employee;

public interface EmployeeService extends IService<Employee> {

    // 自定义查询封装（对应上面 5 条查询）
    IPage<Employee> findByConditions(QueryWrapper<Employee> wrapper, Page<Employee> page);
}