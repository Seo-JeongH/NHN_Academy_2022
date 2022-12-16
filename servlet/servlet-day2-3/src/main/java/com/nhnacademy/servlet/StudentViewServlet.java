package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        StudentRepository studentRepository
            = (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = req.getParameter("id");

        Student student = studentRepository.get(id);
        if (Objects.isNull(student)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            req.setAttribute("student", student);

            RequestDispatcher rd = req.getRequestDispatcher("/studentView.jsp");
            rd.forward(req, resp);
        }
    }

}
