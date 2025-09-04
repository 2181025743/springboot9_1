package com.example.school.config;

import com.example.school.model.Student;
import com.example.school.model.Teacher;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Binds properties under prefix "school" from YAML files.
 */
@Component
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private Teacher teacher;
    private List<Student> students;
    private String communityProgram;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getCommunityProgram() {
        return communityProgram;
    }

    public void setCommunityProgram(String communityProgram) {
        this.communityProgram = communityProgram;
    }
}