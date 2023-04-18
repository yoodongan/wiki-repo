package javajungsuk.collectionsFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {

    public static void main(String[] args) {
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";

        List list = new ArrayList();
        for (int i = 0; i < source.length(); i += LIMIT) {
            if (i + LIMIT < source.length()) {
                list.add(source.substring(i, i + LIMIT));
            } else list.add(source.substring(i));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
