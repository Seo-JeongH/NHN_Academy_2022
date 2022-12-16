package com.nhnacademy.servlet;

import com.nhnacademy.Customer;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class LoginServlet extends HttpServlet {

    Customer customer;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String initParamId = getServletConfig().getInitParameter("id");
        String initParamPwd = getServletConfig().getInitParameter("pwd");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");


        if (initParamId.equals(id) && initParamPwd.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/loginForm.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        customer = new Customer();

        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            resp.sendRedirect("/login.html");
        } else {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("로그인을 성공했습니다.  id=" + session.getAttribute("id") + "<br />");
                out.println();
                out.println("현재 보유 잔액 : " + customer.getMoney() + "원" + "<br />"); // 2만원 출력
                out.println("<a href='/logout'>로그아웃하기 (LogOut) </a>" + "<br />");
                out.println("<a href='/foods'>장보러 가기 (Go Foods). </a>");
            } catch (IOException ex) {
                log.error("", ex);
            }
        }

        getServletContext().setAttribute("customer", customer);//고객 저장
    }

}
