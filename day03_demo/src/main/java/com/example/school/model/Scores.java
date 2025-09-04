package com.example.school.model;

/**
 * Scores for three subjects.
 */
public class Scores {
    private Integer chinese;
    private Integer math;
    private Integer english;

    public Scores() {
    }

    public Scores(Integer chinese, Integer math, Integer english) {
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }
}