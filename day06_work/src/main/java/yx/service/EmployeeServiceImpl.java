package yx.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yx.entity.Employee;
import yx.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Override
    public IPage<Employee> findByConditions(QueryWrapper<Employee> wrapper, Page<Employee> page) {
        // 使用内置 page 方法实现复杂条件分页查询
        return baseMapper.selectPage(page, wrapper);
    }
}
