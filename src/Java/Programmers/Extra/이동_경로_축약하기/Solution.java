//package Java.Programmers.Extra.이동_경로_축약하기;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class Solution {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(
//                new int[][]{{1, 2}, {2, 3}, {3, 4}, {8, 7}, {7, 6}}
//        ))); // [1, 4, 8, 6]
//    }
//
//    // 유니온 파인드 (Disjoint set)
//    // a, b, c가 있을 때 -> a의 부모는 a, b의 부모는 b, c의 부모는 c
//    // (a, b, c가 연결되지 않은 상태)
//    // a-b, c가 있을 때 -> a의 부모는 a, b의 부모는 a, c의 부모는 c
//    // (a와 b가 연결된 상태)
//    // a-b, b-c가 있을 때 -> a의 부모는 a, b의 부모는 a, c의 부모는 b
//    // (a와 b, b와 c가 연결된 상태)
//    // a-b, b-c는 a-b, a-c이 된다. -> a의 부모는 a, b의 부모는 a, c의 부모는 a
//
//    // [1, 2], [2, 3], [3, 4], [8, 7], [7, 6]
//    // [1, 2] -> 1의 부모는 1, 2의 부모는 1
//    // [2, 3] -> 2의 부모는 1, 3의 부모는 2 -> 2의 부모는 1이므로 3의 부모도 1이 된다.
//    // [3, 4] -> 3의 부모는 1, 4의 부모는 3 -> 4의 부모는 3이고 3의 부모는 1이므로 4의 부모도 1이 된다. -> [1, 4]
//    // [8, 7] -> 8의 부모는 8, 7의 부모는 8
//    // [7, 6] -> 7의 부모는 8, 6의 부모는 7 -> 7의 부모는 8이므로 6의 부모도 8이 된다. -> [8, 6]
//
//    // [1, 2], [2, 3], [3, 4], [8, 7], [7, 6]
//    // 이동 경로: 1 -> 2 -> 3 -> 4 = 1 -> 4
//    // 이동 경로: 8 -> 7 -> 6      = 8 -> 7
//
//    static int[] routes = {};
//    static int[] solution(int[][] array) {
//        for (int[] row : array) {
//            int length = routes.length;
//            routes = Arrays.copyOf(routes, length + 2);
//
//            routes[length]     = row[0]; // 인덱스 0, 2, 4, ...
//            routes[length + 1] = row[1]; // 인덱스 1, 3, 5, ...
//        }
//        System.out.println("before: " + Arrays.toString(routes));
//
//        int direction = 0; // +1(증가 방향), -1(감소 방향)
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            int a = array[i][0];
//            int b = array[i][1];
//            union(a, b);
//        }
//
//        System.out.println("after: " + Arrays.toString(routes));
//        return new int[]{};
//    }
//
//    // routes = [1, 2, 2, 3, 3, 4, 8, 7, 7, 6]
//    // union(1, 2)
//    // - find(1)
//    // - find(2)
//
//    static void union(int a, int b) {
//        int aPar = find(a); // a의 부모를 찾는다.
//        int bPar = find(b); // b의 부모를 찾는다.
//        if (aPar != bPar) {
//            routes[bPar] = aPar;
//        }
//    }
//
//    static int find(int a) {
//        if (a == routes[a]) {
//            return a;
//        } else {
//            return routes[a] = find(routes[a]);
//        }
//    }
//}