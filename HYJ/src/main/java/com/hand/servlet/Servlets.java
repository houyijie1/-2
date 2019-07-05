package com.hand.servlet;

import com.hand.cn.Company;
import com.hand.dao.ConnMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Servlets  {
    public Servlets() {
        super();
    }

    public int insert(Company u) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int row = 0;
        String sql = "insert into data(id,name) values(?,?)";
        try {
            conn = ConnMysql.getDBconnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getId());
            pstmt.setString(2, u.getName());
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                ConnMysql.free(conn, pstmt, rs);
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return row;

    }

    public ArrayList<Company> select() throws Exception {
       ArrayList<Company> result=new ArrayList<Company>();
       int i=0;
        Connection conn=null;
        try {
            conn=ConnMysql.getDBconnection();
            String sql="select * from data";
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Company u=new Company();
                u.setId(rs.getString("id"));
                u.setName(rs.getString("name"));
               ((ArrayList) result).add(u);
               i++;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
        }
        //System.out.println(i);
        return result;
    }
    }

