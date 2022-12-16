package com.nhnacademy.servlet;

import com.nhnacademy.Counter;
import com.nhnacademy.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PayServlet extends HttpServlet {
    Customer customer;

    Counter counter;

    private int addPrice;

    private int result;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        customer = new Customer();
        counter = (Counter) getServletContext().getAttribute("counter");
        addPrice = (counter.getOnion() * 1000
                + counter.getEgg() * 2000
                + counter.getGonion() * 500
                + counter.getApple() * 2000);
        result = customer.getMoney()- addPrice;
        if (customer.getMoney() >= addPrice) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("장바구니입니다.");
                out.println();
                out.println("현재 카트에 있는 수 ");
                out.println("양파 : " + counter.getOnion() + "개" + "<br/>");
                out.println("계란 : " + counter.getEgg() + "개" + "<br/>");
                out.println("파 : " + counter.getGonion() + "개" + "<br/>");
                out.println("사과 : " + counter.getApple() + "개" + "<br/>");
                out.println("총합 가격 : " + addPrice + "원 입니다." + "<br/>");
                out.println("계산 후 남은 잔액은 : " + result + "입니다." + "<br/>");
//            out.println(("<form method = \"post\" action = \"/cart\">");
                out.println("<li><a href=" + "/cart" + ">Go Back</a> </li>");
//            out.println("</form>");
                out.println();
            }
        } else {
            try (PrintWriter out = resp.getWriter()) {
                out.println("현재 소지한 돈 :" + customer.getMoney() +
                        "보다");
                out.println("총합 가격 :" + addPrice + "이 더 많으므로 진열대로 가서 다시 " +
                        "담아주세요.");
                out.println("<li><a href=" + "/foods" + ">Go Foods" +
                        "</a> </li>");
            }
        }

    }
}
