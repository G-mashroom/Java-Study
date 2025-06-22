package study_list.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class L_comparator {
    public  void main1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("acdadasd");
        list.add("bsdwaewaea");
        list.add("cdsagasdfwa");
        list.add("dsfsdfsdf");
        list.add("fsdfsdfsdf");
        list.forEach(item -> System.out.println(item));
//        list.sort((o1, o2) -> o1.length() - o2.length());
        //匿名内部类方法
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        list.forEach(item -> System.out.println(item));
    }
}
