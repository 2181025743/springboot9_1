package yx.service;

import com.github.pagehelper.PageInfo;
import yx.entity.Emp;

import java.util.List;

public interface EmpService {
    int addEmp(Emp emp);

    int deleteEmpById(Integer id);

    int deleteEmpByCondition(Emp emp);

    int updateEmpById(Emp emp);

    List<Emp> getAllEmps();

    PageInfo<Emp> getAllEmpsByPage(int pageNum, int pageSize);

    Emp getEmpById(Integer id);

    PageInfo<Emp> getEmpsByCondition(int pageNum, int pageSize, Emp emp);
}