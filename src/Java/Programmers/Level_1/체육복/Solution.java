package Java.Programmers.Level_1.체육복;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(9, new int[]{5, 6, 8, 1, 2}, new int[]{2, 3, 1, 4, 8, 9}));  // 7 [1, 2, 3, 4, 7, 8, 9]
        System.out.println(solution(12, new int[]{1, 2, 3, 4, 8, 9, 10, 11}, new int[]{9, 10})); // 6 [5, 6, 7, 9, 10, 12]
        System.out.println(solution(5, new int[]{1, 2, 3}, new int[]{2, 3, 4})); // 4 [2, 3, 4, 5]
        System.out.println(solution(5, new int[]{2, 3, 4}, new int[]{1, 2, 3})); // 4 [1, 2, 3, 5]
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));    // 5 [1, 2, 3, 4, 5]
        System.out.println(solution(5, new int[]{2, 3}, new int[]{1, 3, 4}));    // 5 [1, 2, 3, 4, 5]
        System.out.println(solution(5, new int[]{2, 4}, new int[]{5, 3}));       // 5 [1, 2, 3, 4, 5]
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));          // 4 [1, 2, 3, 5]
        System.out.println(solution(3, new int[]{1, 2}, new int[]{2, 3}));       // 2 [2, 3]
        System.out.println(solution(3, new int[]{3}, new int[]{1}));             // 2 [1, 2]
    }

    static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;

        // 1) lost 배열과 reserve 배열에 있는 동일한 원소를 소거한다.
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i]    = -1;
                    reserve[j] = -1;
                    // 체육복을 도난 당한 학생이면서 여벌의 체육복을 가진 학생은 1벌의 체육복을 가진 것과 같다.
                    answer++;
                    break;
                }
            }
        }
//        System.out.println("1) lost:    " + Arrays.toString(lost));
//        System.out.println("1) reserve: " + Arrays.toString(reserve));

        // 2) lost 배열과 reserve 배열의 원소를 비교한다.
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            int borrower = -1;
//            int lender   = -1;
//            // lost 배열과 reserve 배열의 첫 번째 원소를 가져온다.
//            if (lost.length > 0) borrower  = lost[0];
//            if (reserve.length > 0) lender = reserve[0];
//
//            // -1 또는 +1이면 여벌의 체육복을 빌려줄 수 있다.
//            if (borrower - 1 == lender || borrower + 1 == lender) {
//                lost    = Arrays.copyOfRange(lost, 1, lost.length);
//                reserve = Arrays.copyOfRange(reserve, 1, reserve.length);
//                answer++;
//            }
//            System.out.println("2) lost:    " + Arrays.toString(lost));
//            System.out.println("2) reserve: " + Arrays.toString(reserve));
//        }

        return answer;
    }
}