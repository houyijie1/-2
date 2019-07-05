package com.hand.cn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PaCo {
    private static String url = "http://vip.stock.finance.sina.com.cn/q/go.php/vIR_CustomSearch/index.phtml?sr_p=-1&order=code%7C1&p=95";
    private static String blogName = "guoxiaolongonly";

    public static void main(String[] args) {
        getArticleListFromUrl(url + "/" + blogName);
    }

    public static void getArticleListFromUrl(final String listurl) {
        boolean isStop = false;
        Document doc = null;
        try {
            doc = Jsoup.connect(listurl).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36").timeout(3000).post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.getElementsByTag("tr");//找到所有a标签
        for (Element element : elements) {
            final String relHref = element.attr("href"); // == "/"这个是href的属性值，一般都是链接。这里放的是文章的连接
            //用if语句过滤掉不是文章链接的内容。因为文章的链接有两个，但评论的链接只有一个，反正指向相同的页面就拿评论的链接来用吧
            if (!relHref.startsWith("http://") && relHref.contains("details") && relHref.endsWith("comments")) {
                StringBuffer sb = new StringBuffer();
                sb.append(relHref);
                System.out.println(sb.substring(0, sb.length() - 9));//去掉最后的#comment输出
                getArticleFromUrl(sb.substring(0, sb.length() - 9));//可以通过这个url获取文章了
            }
            if (relHref.equals("https://mp.csdn.net//postlist")) {
                isStop = true;
            }
        }


        if (!isStop) {
            new Thread(new Runnable() {
                public void run() {
                    if (!listurl.contains("list")) {
                        getArticleListFromUrl(listurl + "/article/list/1");//获取下一页的列表
                    } else {
                        getArticleListFromUrl(listurl.substring(0, listurl.length() - 1) +
                                (Integer.valueOf(listurl.substring(listurl.length() - 1, listurl.length())) + 1));//获取下一页的列表
                    }
                }
            }).start();
        }
    }

    /**
     * 获取文章内容
     *
     * @param detailurl
     */
    public static void getArticleFromUrl(String detailurl) {
        try {
            Document document = Jsoup.connect(detailurl).userAgent("Mozilla/5.0").timeout(3000).post();
            Element elementTitle = document.getElementsByClass("link_title").first();//标题。 这边根据class的内容来过滤
            System.out.println(elementTitle.text());
            String filename = elementTitle.text().replaceAll("/", "或");
            Element elementContent = document.getElementsByClass("article_content").first();//内容。
            saveArticle(filename, elementContent.text(), blogName);
            // String Content =elementContent.te  xt().replaceAll(" ", "\t");
            // System.out.println(elementContent.text()+"\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 保存文章到本地
     *
     * @param titile
     * @param content
     * @param blogName
     */
    public static void saveArticle(String titile, String content, String blogName) {
        String lujing = "B:\\MyLoadArticle\\" + blogName + "\\" + titile + ".txt";//保存到本地的路径和文件名
        File file = new File(lujing);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



















    /*public static String url="http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/600000.phtml?year=2019&jidu=1";

    public static void main(String[] args) throws IOException {
        getDateFromUrl(url);
    }

    private static void getDateFromUrl(String url1) throws IOException {
        URL url = new URL(url1);
        //打开链接
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        //如果链接正常
        if(200==urlConnection.getResponseCode()){
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStream1 = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStream1);
            String str=null;
            if( (str=bufferedReader.readLine())!=null ){

            }



        }
    }*/
}
