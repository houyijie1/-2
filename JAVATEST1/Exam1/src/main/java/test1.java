import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        // 生成50个0~100内的随机数，存放到一个ArrayList中
            for (int i = 0; i < 50; i++) {

                int ii = (int) ((Math.random()) * 101);

                list.add(ii);

            }


          Map  ss=new LinkedHashMap();

        for(int t=0;t<50;t++)
        {  int m;
            m=list.get(t)/10;
            ss.put(m,list.get(t));

        }


        System.out.println(ss);






    }
}