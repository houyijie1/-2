package com.hand.test;

import com.hand.cn.City;
import com.hand.cn.Country;
import com.hand.servlet.Servlets;

import java.util.ArrayList;
import java.util.Iterator;

public class test1 {
    public static void main(String[] args) {
//       Servlets sss=new Servlets();
//        ArrayList<Country> list=new ArrayList<Country>();
//        try {
//            list = sss.select();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Iterator<Country> it = list.iterator();
//        Country country =new Country();
//        while (it.hasNext()) {
//            country = (Country) it.next();
//            System.out.print(country.getCountry_id()+"    ");
//            System.out.println(country.getCountry()+"  ");
//            System.out.println(country.getUpdate()+"  ");
//        }
        Servlets sss=new Servlets();
        ArrayList<City> list=new ArrayList<City>();
        try {
            list = sss.select1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<City> it = list.iterator();
        City city =new City();
        while (it.hasNext()) {
            city = (City) it.next();
            System.out.print(city.getCountry_id()+"    ");
            System.out.println(city.getCity_id()+"  ");
            System.out.println(city.getName()+"  ");
        }




    }

}
