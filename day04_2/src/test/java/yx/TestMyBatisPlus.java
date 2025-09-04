package yx;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import yx.entity.Teacher;
import yx.mapper.TeacherMapper;

import java.util.List;

@SpringBootTest
public class TestMyBatisPlus {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void testSelectAll() {
        List<Teacher> teachers = teacherMapper.selectList(null);
        teachers.forEach(System.out::println);
    }
}