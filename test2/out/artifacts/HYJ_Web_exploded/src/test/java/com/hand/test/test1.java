package com.hand.test;

import com.hand.cn.Company;
import com.hand.servlet.Servlets;

import java.util.ArrayList;
import java.util.Iterator;

public class test1 {
    public static void main(String[] args) {
       Servlets sss=new Servlets();

        ArrayList<Company> list=new ArrayList<Company>();
        try {
            list = sss.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        request.setAttribute("list",list);
        Iterator<Company> it = list.iterator();
        Company company=new Company();
        while (it.hasNext()) {
            company = (Company) it.next();
            System.out.print(company.getId()+"    ");
            System.out.println(company.getName());
        }




    }

}
