package com.nhnacademy.servlet;

import com.nhnacademy.Cart;
import com.nhnacademy.Customer;
import com.nhnacademy.Food;
import com.nhnacademy.FoodStand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InitServlet extends HttpServlet {

    Customer customer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Food onion = new Food("양파", 1000);
        Food egg = new Food("계란", 2000);
        Food Gonion = new Food("파", 500);
        Food apple = new Food("사과", 2000);

        FoodStand foodStand = new FoodStand();
        for (int i = 0; i < 2; i++) { //재고 2개
            foodStand.add(onion);
        }
        for (int i = 0; i < 5; i++) { //재고 5개
            foodStand.add(egg);
        }
        for (int i = 0; i < 10; i++) {//재고 10개
            foodStand.add(Gonion);
        }
        for (int i = 0; i < 20; i++) {//재고 20개
            foodStand.add(apple);
        }

        getServletContext().setAttribute("foodStand", foodStand);//저장

        show(req, resp);
    }

    //  /Foods로 가는 링크 생성
    private void show(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Init_Start</title></head>");
        out.println("<body>");

        out.println("로그인을 우선 진행해주세요!");
        out.println(("<form method = \"post\" action = \"/login\">"+
                        "ID : <input type = \"text\" name = \"id\">"+
                        "  PWD : <input type = \"text\" name = \"pwd\">"+
                "<input type = \"submit\" value =\"로그인\" />"+
                "</form>"));

        out.println("<li><a href=\"/foods\">Go Foods</a> </li>");

        out.println("</body>");
        out.println("</html>");
    }
}
