package Java.Programmers.Level_1.자연수_뒤집어_배열로_만들기;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345))); // [5, 4, 3, 2, 1]
        System.out.println(Arrays.toString(solution(34562))); // [2, 6, 5, 4, 3]
    }

    static int[] solution(long n) {
        String[] arr = String.valueOf(n).split("");
        int[] answer = new int[arr.length];

        // ans = 0, 1, 2, 3, 4
        // arr = 4, 3, 2, 1, 0 (-> 합이 4가 되도록 맞춘다.)
        for (int i = 0; i < arr.length; i++) {
            // 0 - 4, 1 - 4, 2 - 4, 3 - 4, 4 - 4 (-> 4, 3, 2, 1, 0)
            answer[i] = Integer.parseInt(arr[Math.abs(i - (arr.length - 1))]);
        }

        return answer;
    }
}