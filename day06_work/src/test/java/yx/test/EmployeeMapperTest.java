package yx.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yx.entity.Employee;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    private yx.mapper.EmployeeMapper employeeMapper;

    @Test
    void testSelect() {
        employeeMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void Query1() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(Employee::getAge, 22, 30);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }
    
    /**
     * 测试查询年龄在22-30之间且性别为男性的员工
     */
    @Test
    void testQueryAgeRange() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 22, 30)
                .eq("gender", "男")
                .eq("deleted", 0);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        employees.forEach(System.out::println);
    }
    
    /**
     * 测试查询市场部或销售部的女性员工
     */
    @Test
    void testQueryDeptGender() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "女")
                .in("dept_name", Arrays.asList("市场部", "销售部"))
                .eq("deleted", 0);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        employees.forEach(System.out::println);
    }
    
    /**
     * 测试查询长春地址且状态为休息的员工
     */
    @Test
    void testQueryAddrStatus() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("addr", "长春")
                .eq("status", 1)
                .eq("deleted", 0);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        employees.forEach(System.out::println);
    }
    
    /**
     * 测试查询登录名包含admin，同时（性别=男 或 部门=人事部）的员工
     */
    @Test
    void testQueryLoginCondition() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("login_name", "admin")
                .and(w -> w.eq("gender", "男").or().eq("dept_name", "人事部"))
                .eq("deleted", 0);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        employees.forEach(System.out::println);
    }
    
    /**
     * 测试按年龄降序排列的查询
     */
    @Test
    void testQueryOrderByAge() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted", 0)
                .orderByDesc("age");
        List<Employee> employees = employeeMapper.selectList(wrapper);
        employees.forEach(System.out::println);
    }
}
