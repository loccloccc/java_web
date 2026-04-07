package com.example.demo;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.utils.DataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // laays du lieu database
        try(Connection conn = DataBase.openConnection()) {
            String sql = "select *from person";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("ID : "+rs.getInt("id"));
                System.out.println("Name : " + rs.getString("full_name"));
                System.out.println("AGE : " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // phương thức điều hướng
        request.getRequestDispatcher("/views/students.jsp").forward(request,response);
    }

    public void destroy() {
    }
}