package yx.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "teacher")
public class Teacher {
    private String name;
    private String gender;
    private Integer age;
    private List<Student> students;

    public Double getChineseAverage() {
        if (students == null || students.isEmpty()) {
            return 0.0;
        }
        return students.stream()
                .mapToInt(s -> s.getScore().getChinese())
                .average()
                .orElse(0.0);
    }

    public Double getMathAverage() {
        if (students == null || students.isEmpty()) {
            return 0.0;
        }
        return students.stream()
                .mapToInt(s -> s.getScore().getMath())
                .average()
                .orElse(0.0);
    }

    public Double getEnglishAverage() {
        if (students == null || students.isEmpty()) {
            return 0.0;
        }
        return students.stream()
                .mapToInt(s -> s.getScore().getEnglish())
                .average()
                .orElse(0.0);
    }
}