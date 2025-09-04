package com.yx.mapper;

import com.yx.dto.EmpQueryDTO;
import com.yx.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {
    // 1. 增加
    int insert(Emp emp);

    // 2. 根据ID删除
    int deleteById(@Param("id") Integer id);

    // 3. 根据条件删除
    int deleteByCondition(EmpQueryDTO condition);

    // 4. 根据ID修改
    int updateById(Emp emp);

    // 5. 查询全部
    List<Emp> selectAll();

    // 6. 根据ID查询
    Emp selectById(@Param("id") Integer id);

    // 7. 条件查询
    List<Emp> selectByCondition(EmpQueryDTO condition);
}