package com.example.school.controller;

import com.example.school.config.SchoolProperties;
import com.example.school.model.Student;
import com.example.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Controller exposing endpoints:
 *  - GET /teacher : 显示教师类的相关信息
 *  - GET /students/averages : 显示每个学生的三科平均成绩
 *  - GET /students/chinese-average : 显示语文平均成绩（所有学生）
 *  - GET /community-program : 显示当前环境下的社区团购程序名称
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SchoolController {

    private final SchoolProperties schoolProperties;

    @Autowired
    public SchoolController(SchoolProperties schoolProperties) {
        this.schoolProperties = schoolProperties;
    }

    /**
     * 显示教师类的相关信息
     */
    @GetMapping("/teacher")
    public Teacher getTeacher() {
        Teacher t = schoolProperties.getTeacher();
        if (t == null) {
            // return empty placeholder instead of null to keep API stable
            Teacher placeholder = new Teacher();
            placeholder.setName("");
            placeholder.setGender("");
            placeholder.setAge(0);
            return placeholder;
        }
        return t;
    }

    /**
     * 显示每个学生的三科平均成绩
     * 返回格式示例：
     * [
     *   { "name": "王小明", "average": 84.33 },
     *   { "name": "张丽丽", "average": 85.67 }
     * ]
     */
    @GetMapping("/students/averages")
    public List<Map<String, Object>> getStudentAverages() {
        List<Student> students = Optional.ofNullable(schoolProperties.getStudents()).orElse(Collections.emptyList());
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student s : students) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("name", s.getName() == null ? "" : s.getName());
            entry.put("gender", s.getGender());
            entry.put("age", s.getAge());
            entry.put("average", s.getAverage());
            result.add(entry);
        }
        return result;
    }

    /**
     * 显示语文平均成绩（所有学生）
     * 返回一个简单对象： { "chineseAverage": 85.5 }
     */
    @GetMapping("/students/chinese-average")
    public Map<String, Object> getChineseAverage() {
        List<Student> students = Optional.ofNullable(schoolProperties.getStudents()).orElse(Collections.emptyList());
        double sum = 0.0;
        int count = 0;
        for (Student s : students) {
            if (s.getScores() != null && s.getScores().getChinese() != null) {
                sum += s.getScores().getChinese();
                count++;
            }
        }
        double avg = count == 0 ? 0.0 : Math.round((sum / count) * 100.0) / 100.0;
        Map<String, Object> resp = new HashMap<>();
        resp.put("chineseAverage", avg);
        resp.put("studentCount", count);
        return resp;
    }

    /**
     * 显示当前激活环境的社区团购程序名称
     */
    @GetMapping("/community-program")
    public Map<String, Object> getCommunityProgram() {
        String program = schoolProperties.getCommunityProgram();
        Map<String, Object> resp = new HashMap<>();
        resp.put("communityProgram", program == null ? "" : program);
        return resp;
    }
}