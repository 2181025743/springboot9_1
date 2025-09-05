package yx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yx.entity.Employee;
import yx.service.EmployeeService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询：年龄 22 - 30，男性员工
     */
    @GetMapping("/age-range")
    public List<Employee> queryAgeRange() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 22, 30)
                .eq("gender", "男");
        return employeeService.list(wrapper);
    }

    /**
     * 查询市场部或销售部的女性员工
     */
    @GetMapping("/dept-gender")
    public List<Employee> queryDeptGender() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("gender", "女")
                .in("dept_name", Arrays.asList("市场部", "销售部"));
        return employeeService.list(wrapper);
    }

    /**
     * 查询长春地址+休息状态
     */
    @GetMapping("/addr-status")
    public List<Employee> queryAddrStatus() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("addr", "长春")
                .eq("status", 1);
        return employeeService.list(wrapper);
    }

    /**
     * 查询登录名包含 admin，同时（性别=男 或 部门=人事部）
     */
    @GetMapping("/admin-login")
    public List<Employee> queryLoginCondition() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("login_name", "admin")
                .and(w -> w.eq("gender", "男").or().eq("dept_name", "人事部"));
        return employeeService.list(wrapper);
    }

    /**
     * 年龄降序+分页，每页5条
     */
    @GetMapping("/page")
    public IPage<Employee> pagedList(@RequestParam(defaultValue = "1") int pageNum) {
        Page<Employee> page = new Page<>(pageNum, 5);  // 当前页，第几条
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        return employeeService.page(page, wrapper);
    }
}
