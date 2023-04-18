package javajungsuk.collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList arr1 = new ArrayList(10);
        arr1.add(new Integer(5));
        arr1.add(new Integer(4));
        arr1.add(new Integer(3));
        arr1.add(new Integer(2));

        ArrayList arr2 = new ArrayList(arr1.subList(1,3));  // index=1과 index=2에 있는 값만 출력.
        print(arr1, arr2);

        Collections.sort(arr1);
        System.out.println(arr1);

        System.out.println("arr1이 arr2의 모든 내용을 포함한다 : " + arr1.containsAll(arr2));

        System.out.println("arr2 초기 값 : " + arr2);   // [4, 3]
        arr2.add(1, "A");   // [4, A, 3]
        System.out.println("add 후 : " + arr2);

        arr2.set(1, "B");    // [4, B, 3]
        System.out.println("set 후 : " + arr2);

        System.out.println();
        /* retain */
        System.out.println("처음 arr1 : " + arr1);
        System.out.println("arr1에서 arr2와 겹치는 부분만 남기고 나머지 삭제 : " + arr1.retainAll(arr2));
        System.out.println(arr1);


        System.out.println("arr2에서 arr1에 포함된 객체 삭제");
        print(arr1, arr2);
        /* 이렇게 삭제하면 안된다. arr 특성 상 빈 공간을 채우기 위해 나머지 요소들이 자리이동 하기 때문. */
//        for (int i = 0; i < arr2.size()-1; i++) {
//            if (arr1.contains(arr2.get(i))) {
//                arr2.remove(i);
//            }
//        }
        /* 뒤에서부터 idx 접근을 해야 함. */
        for (int i = arr2.size() - 1; i >= 0; i--) {
            if (arr1.contains(arr2.get(i))) {
                arr2.remove(i);
            }
        }
        print(arr1, arr2);

    }
    static void print(ArrayList arr1, ArrayList arr2) {
        System.out.println("arr1 : " + arr1);
        System.out.println("arr2 : " + arr2);
        System.out.println();
    }

}
