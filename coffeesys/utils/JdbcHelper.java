/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.utils;

import java.sql.*;


public class JdbcHelper {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=CoffeeSys";
    private static String user = "sa";
    private static String pass = "123";
    // nạp driver
    static {
        try {
            Class.forName(driver);   
        } catch (Exception e) {
            System.out.println("Loi: " + e);
        }
    }
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException{
        //  kết nối database
        Connection con  = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = con.prepareCall(sql);
        } else {
            pstmt = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    // có thể thêm sửa xóa , các thủ tục
    public static int update(String sql, Object... args){
        try {
            PreparedStatement sttm = getStmt(sql, args);
            try {
              return  sttm.executeUpdate();
            }finally{
                sttm.getConnection().close();
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
    // truy vấn
    public static ResultSet query(String sql, Object... args){
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
    public static Object value(String sql, Object... args){
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
