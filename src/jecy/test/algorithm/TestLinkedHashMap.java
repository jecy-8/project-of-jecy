package jecy.test.algorithm;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        /*String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();
        System.out.println("str1==str2 " + (str1 == str2));
        System.out.println("str2==str3 " + (str2 == str3));
        System.out.println("str1==str3 " + (str1 == str3));*/

        /*String text = "abbc";
        String regex = "ab{1,3}+bc";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }*/

        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("c");
//        removeByIterator(list);//删除指定的“b”元素
        removeByOldFor(list);
//        removeByNewFor(list);
        for(int i=0; i<list.size(); i++)
        {
            System.out.println("element : " + list.get(i));
        }
    }

    private static void removeByIterator(ArrayList<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("b")) {
                it.remove();
            }
        }
    }


    private static void removeByOldFor(ArrayList<String> list) {
        for (int i =0; i < list.size(); i ++) {
            if (list.get(i).equals("b")) {
                list.remove(list.get(i));
//                i --;
            }
        }
    }

    private static void removeByNewFor(ArrayList<String> list) {
        for (String s : list) {
            if (s.equals("b")) {
                list.remove(s);
            }
        }
    }
}
