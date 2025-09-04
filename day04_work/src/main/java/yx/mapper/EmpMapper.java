package yx.mapper;

import org.apache.ibatis.annotations.Mapper;
import yx.entity.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {
    int insert(Emp emp);

    int deleteById(Integer id);

    int deleteByCondition(Emp emp);

    int updateById(Emp emp);

    List<Emp> selectAll();

    Emp selectById(Integer id);

    List<Emp> selectByPaginationConditions(Emp emp);
}
