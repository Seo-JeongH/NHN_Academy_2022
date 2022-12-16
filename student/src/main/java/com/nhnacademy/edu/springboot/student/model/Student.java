package com.nhnacademy.edu.springboot.student.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private Integer score;
}
