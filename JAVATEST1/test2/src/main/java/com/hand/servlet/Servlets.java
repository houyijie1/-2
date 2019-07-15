package com.hand.servlet;

import com.hand.cn.City;
import com.hand.cn.Country;
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

//    public int insert(Country u) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        int row = 0;
//        String sql = "insert into data(id,name) values(?,?)";
//        try {
//            conn = ConnMysql.getDBconnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, u.getId());
//            pstmt.setString(2, u.getName());
//            row = pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            try {
//                ConnMysql.free(conn, pstmt, rs);
//            } catch (SQLException e) {
//
//                e.printStackTrace();
//            }
//        }
//        return row;
//
//    }

    public ArrayList<Country> select() throws Exception {
        ArrayList<Country> result=new ArrayList<Country>();
        int i=0;
        Connection conn=null;
        try {
            conn=ConnMysql.getDBconnection();
            String sql="select * from country";
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                //Company u=new Company();
                Country  u=new Country();
                u.setCountry_id(rs.getInt("country_id"));
                u.setCountry(rs.getString("country"));
                u.setUpdate(rs.getString("last_update"));
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
    public ArrayList<City> select1() throws Exception {
        ArrayList<City> result=new ArrayList<City>();
        int i=0;
        Connection conn=null;
        try {
            conn=ConnMysql.getDBconnection();
            String sql="select * from city ";
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                //Company u=new Company();
                City u=new City();
                u.setCountry_id(rs.getInt("country_id"));
                u.setCity_id(rs.getInt("city_id"));
                u.setName(rs.getString("city"));
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

