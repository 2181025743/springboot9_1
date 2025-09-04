package com.yx.service;

import com.yx.dto.EmpQueryDTO;
import com.yx.entity.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmpService {
    boolean add(Emp emp);
    boolean deleteById(Integer id);
    boolean deleteByCondition(EmpQueryDTO condition);
    boolean updateById(Emp emp);
    List<Emp> findAll();
    PageInfo<Emp> findAllByPage(Integer pageNum, Integer pageSize);
    Emp findById(Integer id);
    PageInfo<Emp> findByCondition(EmpQueryDTO condition);
}