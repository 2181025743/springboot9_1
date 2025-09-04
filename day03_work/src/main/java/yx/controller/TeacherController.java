package yx.controller;

import yx.model.Student;
import yx.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private Teacher teacher;

    @Value("${server.port}")
    private String port;

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("/info")
    public Map<String, Object> getTeacherInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("当前环境", profile);
        result.put("端口号", port);
        result.put("教师姓名", teacher.getName());
        result.put("教师性别", teacher.getGender());
        result.put("教师年龄", teacher.getAge());
        result.put("学生人数", teacher.getStudents().size());
        return result;
    }

    @GetMapping("/students/average")
    public Map<String, Object> getStudentsAverage() {
        Map<String, Object> result = new HashMap<>();
        result.put("当前环境", profile);

        for (int i = 0; i < teacher.getStudents().size(); i++) {
            Student student = teacher.getStudents().get(i);
            Map<String, Object> studentInfo = new HashMap<>();
            studentInfo.put("姓名", student.getName());
            studentInfo.put("性别", student.getGender());
            studentInfo.put("年龄", student.getAge());
            studentInfo.put("语文成绩", student.getScore().getChinese());
            studentInfo.put("数学成绩", student.getScore().getMath());
            studentInfo.put("英语成绩", student.getScore().getEnglish());
            studentInfo.put("平均成绩", String.format("%.2f", student.getScore().getAverage()));
            result.put("学生" + (i + 1), studentInfo);
        }
        return result;
    }

    @GetMapping("/chinese/average")
    public Map<String, Object> getChineseAverage() {
        Map<String, Object> result = new HashMap<>();
        result.put("当前环境", profile);
        result.put("语文平均成绩", String.format("%.2f", teacher.getChineseAverage()));
        result.put("数学平均成绩", String.format("%.2f", teacher.getMathAverage()));
        result.put("英语平均成绩", String.format("%.2f", teacher.getEnglishAverage()));
        return result;
    }
}