package com.nhnacademy.servlet;

import com.nhnacademy.*;
import com.nhnacademy.Exceptions.AmountException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CartServlet extends HttpServlet {
    private FoodStand foodStand;
    private Cart cart;
    private int count_onion;
    private int count_egg;
    private int count_Gonion;
    private int count_apple;
    private int addPrice;

    private int defaultcount[] = {2, 5, 10, 20};
    String html[];

    @Override// 장바구니 화면
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        addPrice = (count_onion *1000 + count_egg * 2000 + count_apple * 2000
                + count_Gonion * 500);



        try (PrintWriter out = resp.getWriter()) {
            out.println("장바구니입니다.");
            out.println();
            out.println("현재 카트에 있는 수 ");
            out.println("양파 : " + count_onion);
            out.println("계란 : " + count_egg);
            out.println("파 : " + count_Gonion);
            out.println("사과 : " + count_apple);
            out.println("총합 가격 : " + addPrice + "원 입니다.");
//            out.println(("<form method = \"post\" action = \"/cart\">");
            out.println("<li><a href="+"/pay"+">Go Pay</a> </li>");
//            out.println("</form>");
            out.println();
        }

        Counter counter = new Counter(count_onion, count_egg, count_Gonion, count_apple);
        getServletContext().setAttribute("counter", counter);//저장

    }

    @Override //장바구니에 담기
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Food onion = new Food("양파", 1000);
        Food egg = new Food("계란", 2000);
        Food Gonion = new Food("파", 500);
        Food apple = new Food("사과", 2000);

        cart = (Cart) getServletContext().getAttribute("cart");
        count_onion = Integer.parseInt(req.getParameter("onion"));
        count_egg = Integer.parseInt(req.getParameter("egg"));
        count_Gonion = Integer.parseInt(req.getParameter("Gonion"));
        count_apple = Integer.parseInt(req.getParameter("apple"));

        FoodStand foodStand = new FoodStand();
        for (int i = 0; i < count_onion; i++) {
            foodStand.add(onion);
        }
        for (int i = 0; i < count_egg; i++) {
            foodStand.add(egg);
        }
        for (int i = 0; i < count_Gonion; i++) {
            foodStand.add(Gonion);
        }
        for (int i = 0; i < count_apple; i++) {
            foodStand.add(apple);
        }
        if (defaultcount[0] < count_onion) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("마트의 재고보다 많이 고르셨습니다.");
                out.println("장바구니입니다.");
                out.println();
                out.println("현재 카트에 있는 수 ");
                count_onion = defaultcount[0];
                out.println("양파 : " + count_onion + "개");
                out.println("계란 : " + count_egg+ "개");
                out.println("파 : " + count_Gonion+ "개");
                out.println("사과 : " + count_apple+ "개");
                out.println();
                out.println("<li><a href="+"/cart"+">Go MyCart</a> </li>");
                throw new AmountException("양파의 재고가 부족합니다.");
            } catch (AmountException e) {
                e.printStackTrace();
            }
        } else if (defaultcount[1] < count_egg) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("마트의 재고보다 많이 고르셨습니다.");
                out.println("장바구니입니다.");
                out.println();
                out.println("현재 카트에 있는 수 ");
                out.println("양파 : " + count_onion+ "개");
                count_egg = defaultcount[1];
                out.println("계란 : " + count_egg+ "개");
                out.println("파 : " + count_Gonion+ "개");
                out.println("사과 : " + count_apple+ "개");
                out.println();
                out.println("<li><a href="+"/cart"+">Go MyCart</a> </li>");
                throw new AmountException("계란의 재고가 부족합니다.");
            } catch (AmountException e) {
                e.printStackTrace();
            }
        } else if (defaultcount[2] < count_Gonion) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("마트의 재고보다 많이 고르셨습니다.");
                out.println("장바구니입니다.");
                out.println();
                out.println("현재 카트에 있는 수 ");
                out.println("양파 : " + count_onion+ "개");
                out.println("계란 : " + count_egg+ "개");
                count_Gonion = defaultcount[2];
                out.println("파 : " + defaultcount[2]+ "개");
                out.println("사과 : " + count_apple+ "개");
                out.println();
                out.println("<li><a href="+"/cart"+">Go MyCart</a> </li>");
                throw new AmountException("파의 재고가 부족합니다.");
            } catch (AmountException e) {
                e.printStackTrace();
            }
        } else if (defaultcount[3] < count_apple) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("마트의 재고보다 많이 고르셨습니다.");
                out.println("장바구니입니다.");
                out.println();
                out.println("현재 카트에 있는 수 ");
                out.println("양파 : " + count_onion+ "개");
                out.println("계란 : " + count_egg+ "개");
                out.println("파 : " + count_Gonion+ "개");
                count_apple = defaultcount[3];
                out.println("사과 : " + count_apple+ "개");
                out.println();
                out.println("<li><a href="+"/cart"+">Go MyCart</a> </li>");
                //매대정리
                throw new AmountException("사과의 재고가 부족합니다.");
            } catch (AmountException e) {
                e.printStackTrace();
            }
        } else {
            try (PrintWriter out = resp.getWriter()) {
                out.println("장바구니입니다.");
                out.println();
                out.println("현재 카트에 있는 수 ");
                out.println("양파 : " + count_onion+ "개");
                out.println("계란 : " + count_egg+ "개");
                out.println("파 : " + count_Gonion+ "개");
                out.println("사과 : " + count_apple+ "개");
                out.println();
                out.println("<li><a href="+"/cart"+">Go MyCart</a> </li>");
            }
        }
    }
}
