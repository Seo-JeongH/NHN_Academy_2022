package com.nhnacademy.springmvc.validator;

import com.nhnacademy.springmvc.domain.StudentModifyRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class StudentModifyRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentModifyRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "name is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "email is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "", "score is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "", "comment is empty");

        StudentModifyRequest request = (StudentModifyRequest) target;
        int score = request.getScore();
        if (score > 100 || score < 0) {
            errors.rejectValue("score", "", "score max is 100 and min is 0");
        }

        String comment = request.getComment();
        if (comment.length() > 200) {
            errors.rejectValue("comment", "", "comment max length is 200");
        }

    }
}
