package yx.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yx.entity.Employee;
import yx.mapper.EmployeeMapper;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class EmployeeMapperTest {   // ✅ 改名，避免冲突

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void testInsert() {
        List<Employee> employees = Arrays.asList(
                createEmployee("张三", "zhangsan", "123456", 35, "男", "北京市", "市场部"),
                createEmployee("李四", "lisi", "123456", 45, "女", "上海市", "市场部"),
                createEmployee("王五", "wangwu", "123456", 28, "男", "吉林市", "技术部"),
                createEmployee("赵六", "zhaoliu", "123456", 62, "男", "长春市", "市场部"),
                createEmployee("钱七", "qianqi", "123456", 55, "女", "吉林市", "人事部"),
                createEmployee("孙八", "sunba", "123456", 65, "男", "深圳市", "市场部")
        );
        employees.forEach(emp -> {
            int result = employeeMapper.insert(emp);
            System.out.println("插入结果：" + result);
        });
    }

    @Test
    void testSelectAll() {
        employeeMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void testUpdateDept() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Employee::getDeptName, "销售部")
                .eq(Employee::getDeptName, "市场部");
        int result = employeeMapper.update(null, wrapper);
        System.out.println("更新条数：" + result);
    }

    @Test
    void testComplexUpdate() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Employee::getStatus, 1)
                .in(Employee::getAddr, Arrays.asList("吉林市", "长春市"))
                .and(w -> w.lt(Employee::getAge, 30).or().gt(Employee::getAge, 50));
        int result = employeeMapper.update(null, wrapper);
        System.out.println("更新条数：" + result);
    }

    @Test
    void testDelete() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(Employee::getAge, 60).eq(Employee::getGender, "男");
        int result = employeeMapper.delete(wrapper);
        System.out.println("删除条数：" + result);
    }

    private Employee createEmployee(String name, String loginName, String password,
                                    int age, String gender, String addr, String deptName) {
        Employee emp = new Employee();
        emp.setEmpName(name);
        emp.setLoginName(loginName);
        emp.setLoginPassword(password);
        emp.setAge(age);
        emp.setGender(gender);
        emp.setAddr(addr);
        emp.setDeptName(deptName);
        emp.setStatus(0);
        return emp;
    }
}