package com.nhnacademy.servlet;

import com.nhnacademy.Cart;
import com.nhnacademy.Food;
import com.nhnacademy.FoodStand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FoodsServlet extends HttpServlet {

    private FoodStand foodStand;
    private Cart cart;
    private int count_onion = 0;
    private int count_egg = 0;
    private int count_Gonion = 0;
    private int count_apple = 0;
    private int getCount_onion;
    private int getCount_egg;
    private int getCount_Gonion;
    private int getCount_apple;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        foodStand = (FoodStand) getServletContext().getAttribute("foodStand");
        cart = new Cart();
//                (Cart) getServletContext().getAttribute("Cart")
        try (PrintWriter out = resp.getWriter()) {
            //진열대 전체출력문
//            for(Food food : foodStand.getFoods()) {
//                out.println(food);
//                out.println();
//            }

            for (int i = 0; i < foodStand.getFoods().size(); i++) {
                if (foodStand.getFoods().get(i).getName().equals("양파")) {
                    count_onion++;
                } else if (foodStand.getFoods().get(i).getName().equals("계란")) {
                    count_egg++;
                } else if (foodStand.getFoods().get(i).getName().equals("파")) {
                    count_Gonion++;
                } else if (foodStand.getFoods().get(i).getName().equals("사과")) {
                    count_apple++;
                }
            }

            out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
            out.println();
            out.println("<br/>" + "<br/>" + "현재 진열되어있는 개수 " + "<br/>");
            out.println("양파 : " + count_onion + "개"+"<br/>");
            out.println("계란 : " + count_egg + "판"+"<br/>");
            out.println("파 : " + count_Gonion + "개"+"<br/>");
            out.println("사과 : " + count_apple + "개"+"<br/>" + "<br/>");


            out.println(("<form method = \"post\" action = \"/cart\">" +
                    "양파 : <input type = \"text\" name = \"onion\">" +
                    "계란 : <input type = \"text\" name = \"egg\">" +
                    "파 : <input type = \"text\" name = \"Gonion\">" +
                    "사과 : <input type = \"text\" name = \"apple\">" +
                    "<input type = \"submit\" value =\"담기\" />" +
                    "</form>"));

            out.println("꼭 하나 이상씩 입력해주세요!");
            out.println();
            out.println("<li><a href="+"/cart"+">Go MyCart</a> </li>");


        }


    }
}
