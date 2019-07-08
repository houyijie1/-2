package com.hand.test;

import com.hand.cn.Company;
import com.hand.servlet.Servlets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class test2 {

    public static void main(String[] args) {
        Company company = null;
        ArrayList<Company> companies = new ArrayList<Company>();
        Servlets sss = new Servlets();
        boolean isStop = false;
        Document doc = null;
        int j = 1;
        for (int k = 1; k <= 95; k++) {
            String url = "http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?sr_p=-1&order=code%7C1&p=" + k;
            try {
                doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36").timeout(3000).post();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements trs = doc.getElementsByTag("tr");//找到所有a标签
            int i = 1;
            for (Element tr : trs) {
                Elements tds = tr.getElementsByTag("span");
                for (Element td : tds) {
                    if (i % 3 == 1) {
//                       if(j%2==1){
//                           company = new Company();
//                       }
                        company = new Company();
                        String id = td.id();
                        String substring = id.substring(5);
                        System.out.println(td);
                        String text = td.text();
                        company.setId(substring);
                        company.setName(text);
                        sss.insert(company);
                        // System.out.println(company.getId());
                        //  System.out.println(company.getName());
                        companies.add(company);
                        j++;
                    }
                    i++;
                }
            }
        }
        System.out.println(j);
    }
}
