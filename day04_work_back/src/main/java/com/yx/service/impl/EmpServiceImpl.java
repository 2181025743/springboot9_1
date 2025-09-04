package com.yx.service.impl;

import com.yx.dto.EmpQueryDTO;
import com.yx.entity.Emp;
import com.yx.mapper.EmpMapper;
import com.yx.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public boolean add(Emp emp) {
        return empMapper.insert(emp) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return empMapper.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByCondition(EmpQueryDTO condition) {
        return empMapper.deleteByCondition(condition) > 0;
    }

    @Override
    public boolean updateById(Emp emp) {
        return empMapper.updateById(emp) > 0;
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.selectAll();
    }

    @Override
    public PageInfo<Emp> findAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> list = empMapper.selectAll();
        return new PageInfo<>(list);
    }

    @Override
    public Emp findById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public PageInfo<Emp> findByCondition(EmpQueryDTO condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<Emp> list = empMapper.selectByCondition(condition);
        return new PageInfo<>(list);
    }
}