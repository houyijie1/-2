package com.hand.dao;

import java.sql.*;

public class ConnMysql {
    private static	 String  driverName="com.mysql.jdbc.Driver";
    private static	 String userName="root";
    private static	 String userPwd="123456";
    private static	 String dbName="gupiaodata";
    public static Connection getDBconnection() throws ClassNotFoundException, SQLException
    {
        String url1="jdbc:MySQL://localhost:3306/"+dbName;
        String url2="?user="+userName+"&password="+userPwd;
        String url3="&useUnicode=true&characterEncoding=UTF-8";
        String url=url1+url2+url3;
        Class.forName(driverName);
        Connection conn=DriverManager.getConnection(url);
        return conn;


    }
    public static void free(Connection conn,PreparedStatement pstm,ResultSet rs) throws SQLException
    {

        if(rs!=null) rs.close();
        if(pstm!=null) pstm.close();
        if(conn!=null) conn.close();


    }
}


