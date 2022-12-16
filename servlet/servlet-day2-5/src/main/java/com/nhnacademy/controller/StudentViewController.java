package com.nhnacademy.controller;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();

        StudentRepository studentRepository
            = (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = request.getParameter("id");

        Student student = studentRepository.get(id);
        if (Objects.isNull(student)) {
            return "/404.jsp";
        } else {
            request.setAttribute("student", student);

            return "/studentView.jsp";
        }
    }

}
