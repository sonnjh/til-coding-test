package Java.Programmers.Extra.이동_경로_축약하기;

import java.util.Arrays;

/**
 * https://brenden.tistory.com/33
 * https://m.blog.naver.com/parkhj2416/221861837543
 */
public class UnionFind {
    public static int[] array = new int[10];
    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            array[i] = i;
        }
        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(8, 7);
        union(7, 6);
        System.out.println(Arrays.toString(array));

        System.out.println("1, 2 연결 여부: " + isSameParent(1, 2));
        System.out.println("2, 3 연결 여부: " + isSameParent(2, 3));
        System.out.println("3, 4 연결 여부: " + isSameParent(3, 4));
        System.out.println("8, 7 연결 여부: " + isSameParent(8, 7));
        System.out.println("7, 6 연결 여부: " + isSameParent(7, 6));

        System.out.println("1, 8 연결 여부: " + isSameParent(1, 8));
        System.out.println("2, 8 연결 여부: " + isSameParent(2, 8));
        System.out.println("3, 8 연결 여부: " + isSameParent(3, 8));
        System.out.println("4, 8 연결 여부: " + isSameParent(4, 8));
        System.out.println("1, 7 연결 여부: " + isSameParent(1, 7));
        System.out.println("2, 7 연결 여부: " + isSameParent(2, 7));
        System.out.println("3, 7 연결 여부: " + isSameParent(3, 7));
        System.out.println("4, 7 연결 여부: " + isSameParent(4, 7));
        System.out.println("1, 6 연결 여부: " + isSameParent(1, 6));
        System.out.println("2, 6 연결 여부: " + isSameParent(2, 6));
        System.out.println("3, 6 연결 여부: " + isSameParent(3, 6));
        System.out.println("4, 6 연결 여부: " + isSameParent(4, 6));
    }

    static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            // b > a
            array[b] = a;
        }
    }

    static int find(int a) {
        if (a == array[a]) {
            return a;
        } else {
            return array[a] = find(array[a]);
        }
    }
}