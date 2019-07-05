package com.hand.cn;

import com.hand.servlet.Servlets;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
       Servlets sss=new Servlets();
      //  Company dd=new Company();
      //  dd.setId("ttt");
      //  dd.setName("rrrr");


       // sss.insert(dd);
        ArrayList<Company> aaa=new ArrayList<Company>();
        try {
            aaa = sss.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(aaa.size());


    }

}
