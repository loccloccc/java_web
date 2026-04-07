package com.example.demo.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// kết nối data base
public class DataBase {
    private static final String DRIVE = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "dbc:mysql://localhost:3306/HN_K24_CNTT4?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASS = "duongloc2505";

    // tạo kết nối
    public static Connection openConnection(){
        Connection conn;
        try {
            // khai báo DRIVE
            Class.forName(DRIVE);
            // mở kết nối database
            conn = DriverManager.getConnection(URL,USER,PASS);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
