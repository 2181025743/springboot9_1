package yx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yx.entity.Emp;
import yx.mapper.EmpMapper;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int addEmp(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int deleteEmpById(Integer id) {
        return empMapper.deleteById(id);
    }

    @Override
    public int deleteEmpByCondition(Emp emp) {
        return empMapper.deleteByCondition(emp);
    }

    @Override
    public int updateEmpById(Emp emp) {
        return empMapper.updateById(emp);
    }

    @Override
    public List<Emp> getAllEmps() {
        return empMapper.selectAll();
    }

    @Override
    public PageInfo<Emp> getAllEmpsByPage(int pageNum, int pageSize) {
        // 1. 开启分页
        PageHelper.startPage(pageNum, pageSize);
        // 2. 执行查询 (紧跟在startPage后的第一个MyBatis查询会被分页)
        List<Emp> emps = empMapper.selectAll();
        // 3. 封装到PageInfo对象中
        return new PageInfo<>(emps);
    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public PageInfo<Emp> getEmpsByCondition(int pageNum, int pageSize, Emp emp) {
        // 1. 开启分页
        PageHelper.startPage(pageNum, pageSize);
        // 2. 执行条件查询
        List<Emp> emps = empMapper.selectByPaginationConditions(emp);
        // 3. 封装到PageInfo对象中
        return new PageInfo<>(emps);
    }
}