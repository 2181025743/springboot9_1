package yx.model;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String gender;
    private Integer age;
    private Score score;
}