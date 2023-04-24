package javajungsuk.collectionsFramework;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    static class Desc implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1;  // return c2.compareTo(c1); 도 가능하다.
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));  // [Dog, cat, lion, tiger]

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);  // 대소문자를 구분하지 않는다. [cat, Dog, lion, tiger]
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, new Desc());
        System.out.println(Arrays.toString(strArr));  // 역순 정렬.  [tiger, lion, cat, Dog]

    }
}