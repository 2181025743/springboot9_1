package com.yx.generator.service.impl;

import com.yx.generator.entity.Employee;
import com.yx.generator.mapper.EmployeeMapper;
import com.yx.generator.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author yx
 * @since 2025-09-05
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
