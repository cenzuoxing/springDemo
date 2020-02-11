package com.cen.jdbc;

import java.sql.*;

/**
 * @author:cen
 * @date:2020/2/11
 * @Description:com.cen.jdbc
 * @version:1.0
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        注册驱动
//       / DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");

//        获取连接
        String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String pwd = "123456";
        Connection con = DriverManager.getConnection(url,username,pwd);

//        为数据库获取预处理对象
        String sql = "select *from account";
        PreparedStatement preparedStatement = con.prepareStatement(sql);


//        获取结果集
       ResultSet rs = preparedStatement.executeQuery();

       while (rs.next()){
           String name = rs.getString("name");
           System.out.println(name);
       }


    }
}
