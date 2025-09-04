package yx.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yx.entity.Emp;
import yx.service.EmpService;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Tag(name = "员工管理 API", description = "提供对员工信息的增删改查操作")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Operation(summary = "1. 新增员工信息")
    @PostMapping("/add")
    public ResponseEntity<String> addEmp(@RequestBody Emp emp) {
        int result = empService.addEmp(emp);
        if (result > 0) {
            return ResponseEntity.ok("新增员工成功, ID: " + emp.getId());
        }
        return ResponseEntity.badRequest().body("新增员工失败");
    }

    @Operation(summary = "2. 根据ID删除员工")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpById(
            @Parameter(description = "员工ID", required = true, example = "1")
            @PathVariable Integer id) {
        int result = empService.deleteEmpById(id);
        if (result > 0) {
            return ResponseEntity.ok("删除成功");
        }
        return ResponseEntity.badRequest().body("删除失败，可能员工不存在");
    }

    @Operation(summary = "3. (思考)根据条件删除员工")
    @DeleteMapping("/deleteByCondition")
    public ResponseEntity<String> deleteEmpByCondition(@RequestBody Emp emp) {
        int result = empService.deleteEmpByCondition(emp);
        if (result > 0) {
            return ResponseEntity.ok("成功删除 " + result + " 条记录");
        }
        return ResponseEntity.badRequest().body("删除失败，没有匹配的记录");
    }

    @Operation(summary = "4. 根据ID修改员工信息")
    @PutMapping("/update")
    public ResponseEntity<String> updateEmp(@RequestBody Emp emp) {
        if (emp.getId() == null) {
            return ResponseEntity.badRequest().body("更新时必须提供员工ID");
        }
        int result = empService.updateEmpById(emp);
        if (result > 0) {
            return ResponseEntity.ok("更新成功");
        }
        return ResponseEntity.badRequest().body("更新失败，可能员工不存在");
    }

    @Operation(summary = "5. 查询所有员工信息")
    @GetMapping("/all")
    public ResponseEntity<List<Emp>> getAllEmps() {
        return ResponseEntity.ok(empService.getAllEmps());
    }

    @Operation(summary = "6. 分页查询所有员工信息")
    @GetMapping("/all/page")
    public ResponseEntity<PageInfo<Emp>> getAllEmpsByPage(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") int pageNum,
            @Parameter(description = "每页数量", example = "3") @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(empService.getAllEmpsByPage(pageNum, pageSize));
    }

    @Operation(summary = "7. 根据ID查询员工信息")
    @GetMapping("/{id}")
    public ResponseEntity<Emp> getEmpById(
            @Parameter(description = "员工ID", required = true, example = "1")
            @PathVariable Integer id) {
        Emp emp = empService.getEmpById(id);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "8. (思考)根据条件分页查询员工")
    @GetMapping("/search")
    public ResponseEntity<PageInfo<Emp>> getEmpsByCondition(
            @Parameter(description = "页码", example = "1") @RequestParam(defaultValue = "1") int pageNum,
            @Parameter(description = "每页数量", example = "3") @RequestParam(defaultValue = "10") int pageSize,
            @Parameter(description = "查询条件(可组合)") Emp emp) {
        return ResponseEntity.ok(empService.getEmpsByCondition(pageNum, pageSize, emp));
    }
}