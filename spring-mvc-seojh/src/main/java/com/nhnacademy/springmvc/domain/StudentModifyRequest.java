package com.nhnacademy.springmvc.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;


import javax.validation.constraints.*;

@Value
public class StudentModifyRequest {

    @NotBlank
    String name;

    @Email
    String email;

    @Max(100)
    @Min(0)
    int score;

    @NotBlank
    @Size(max = 200, min = 0)
    String comment;
}
