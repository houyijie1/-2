package com.hand.cn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class test {
    private static String url = "http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?sr_p=-1&order=code%7C1&p=1";

    public static void main(String[] args) {
        boolean isStop = false;
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0 " +
                    "(Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                    " Chrome/66.0.3359.181 Safari/537.36").timeout(3000).post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements trs = doc.getElementsByTag("tr");//找到所有a标签
//        System.out.print(elements);

        ArrayList<ArrayList> all = new ArrayList<ArrayList>();

        for (Element tr:trs){
            Elements tds= tr.getElementsByTag("td");
            ArrayList<Object> one = new ArrayList<Object>();
            for(Element td:tds){

                Element as = td.after("a");
                System.out.println(as);
                String text = as.text();
//                System.out.println(text);
                one.add(text);
            }
            all.add(one);

//            System.out.print("**********************************************");
        }
    //   System.out.println(all);
    }
}
