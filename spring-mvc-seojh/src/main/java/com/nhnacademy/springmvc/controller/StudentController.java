package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentModifyRequest;
import com.nhnacademy.springmvc.domain.StudentRegisterRequest;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.validator.StudentModifyRequestValidator;
import com.nhnacademy.springmvc.validator.StudentRegisterRequestValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentModifyRequestValidator studentModifyRequestValidator;

    public StudentController(StudentRepository studentRepository, StudentModifyRequestValidator studentModifyRequestValidator) {
        this.studentRepository = studentRepository;
        this.studentModifyRequestValidator = studentModifyRequestValidator;
    }

    @GetMapping("/{studentId}") // param 써서 점수 평가 항목 출력x.
    public String viewStudent(@PathVariable("studentId") long id,
                              ModelMap modelMap) {
        Student student = studentRepository.getStudent(id);
        if(Objects.isNull(student)) {
            modelMap.put("error", new StudentNotFoundException());
            return "error";
        }

        modelMap.put("student", student);
        return "studentView";
    }

    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@ModelAttribute("student") Student student,
                                    Model model) {
        if (Objects.isNull(student)) {
            model.addAttribute("error", new StudentNotFoundException());
            return "error";
        }

        model.addAttribute("student", student);

        return "studentModify";
    }

    @PostMapping("/{studentId}/modify")
    public String modifyUser(@Valid @ModelAttribute StudentModifyRequest userRequest,
                             @PathVariable("studentId") long id,
                             Model model) {
        Student student = studentRepository.getStudent(id);
        if (Objects.isNull(student)) {
            model.addAttribute("error", new StudentNotFoundException());
            return "error";
        }

        student.setName(userRequest.getName());
        student.setEmail(userRequest.getEmail());
        student.setScore(userRequest.getScore());
        student.setComment(userRequest.getComment());

        model.addAttribute("student", student);
        return "studentView";
    }

    @InitBinder("studentModifyRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(studentModifyRequestValidator);
    }

}
