package com.example.school.model;

/**
 * Student with personal fields and Scores.
 */
public class Student {
    private String name;
    private String gender;
    private Integer age;
    private Scores scores;

    public Student() {
    }

    public Student(String name, String gender, Integer age, Scores scores) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    /**
     * Compute average of the three subjects as a double (two decimal places).
     */
    public double getAverage() {
        if (scores == null) {
            return 0.0;
        }
        int sum = 0;
        int count = 0;
        if (scores.getChinese() != null) {
            sum += scores.getChinese();
            count++;
        }
        if (scores.getMath() != null) {
            sum += scores.getMath();
            count++;
        }
        if (scores.getEnglish() != null) {
            sum += scores.getEnglish();
            count++;
        }
        if (count == 0) {
            return 0.0;
        }
        double avg = (double) sum / count;
        return Math.round(avg * 100.0) / 100.0;
    }
}