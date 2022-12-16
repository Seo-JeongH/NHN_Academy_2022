package com.nhnacademy.springmvc.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;

    private String name;

    private String email;


    private int score;

    private String comment;

    public Student(String name, String email, int score, String comment) {

        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }

    public static Student create(String name, String email, int score, String comment) {
        return new Student(name, email, score, comment);
    }
}
