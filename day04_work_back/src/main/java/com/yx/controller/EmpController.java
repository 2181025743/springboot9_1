package com.yx.controller;

import com.yx.dto.EmpQueryDTO;
import com.yx.entity.Emp;
import com.yx.service.EmpService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Api(tags = "员工管理接口")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/add")
    @ApiOperation("1. 添加员工")
    public String add(@RequestBody Emp emp) {
        return empService.add(emp) ? "添加成功" : "添加失败";
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("2. 根据ID删除员工")
    public String deleteById(@PathVariable @ApiParam("员工ID") Integer id) {
        return empService.deleteById(id) ? "删除成功" : "删除失败";
    }

    @DeleteMapping("/deleteByCondition")
    @ApiOperation("3. 根据条件删除员工")
    public String deleteByCondition(@RequestBody EmpQueryDTO condition) {
        return empService.deleteByCondition(condition) ? "删除成功" : "删除失败";
    }

    @PutMapping("/update")
    @ApiOperation("4. 根据ID修改员工信息")
    public String updateById(@RequestBody Emp emp) {
        return empService.updateById(emp) ? "修改成功" : "修改失败";
    }

    @GetMapping("/list")
    @ApiOperation("5. 查询所有员工")
    public List<Emp> findAll() {
        return empService.findAll();
    }

    @GetMapping("/page")
    @ApiOperation("6. 分页查询所有员工")
    public PageInfo<Emp> findAllByPage(
            @RequestParam(defaultValue = "1") @ApiParam("页码") Integer pageNum,
            @RequestParam(defaultValue = "5") @ApiParam("每页大小") Integer pageSize) {
        return empService.findAllByPage(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    @ApiOperation("7. 根据ID查询员工")
    public Emp findById(@PathVariable @ApiParam("员工ID") Integer id) {
        return empService.findById(id);
    }

    @PostMapping("/search")
    @ApiOperation("8. 条件分页查询员工")
    public PageInfo<Emp> findByCondition(@RequestBody EmpQueryDTO condition) {
        return empService.findByCondition(condition);
    }
}