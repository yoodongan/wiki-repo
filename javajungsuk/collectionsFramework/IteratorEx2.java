package javajungsuk.collectionsFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEx2 {
    public static void main(String[] args) {
        List original = new ArrayList(10);
        List copy1 = new ArrayList(10);
        List copy2 = new ArrayList(10);

        for (int i = 0; i < 10; i++) {
            original.add(i);
        }
        Iterator it = original.iterator();
        while(it.hasNext()) {
            copy1.add(it.next());
        }
        System.out.println("=== Original -> copy1 으로 복사===");
        System.out.println("original : " + original);
        System.out.println("copy1 : " + copy1);

        it = original.iterator();   // 초기화 해주지 않으면, 이미 it.next()를 통해 컬렉션 조회를 마쳤기 때문에, it.next() 를 해도 아무것도 나오지 않는다.

        while (it.hasNext()) {
            copy2.add(it.next());
            it.remove();
        }
        System.out.println("=== Original -> copy2 으로 복사===");
        System.out.println("original : " + original);
        System.out.println("copy2 : " + copy2);
    }
}
