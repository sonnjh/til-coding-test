package Java.Goorm.Cos_Pro.Chapter_6.C_큰수와_작은수의_차이;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 11, 9, 6, 4, 19}, 4)); // 5
        System.out.println(solution(new int[]{3, 4, 5, 9, 9, 10}, 4)); // 5
    }

    // [4, 6, 9, 9, 11, 19]
    // [4, 6, 9, 9] 4개 -> 9 - 4 = 5
    // [6, 9, 9, 11] 4개 -> 11 - 6 = 5

    // [3, 4, 5, 9, 9, 10]
    // [3, 4, 5, 9] 4개 -> 9 - 3 = 6
    // [5, 9, 9, 10] 4개 -> 10 - 5 = 5

    // 큰 수, 작은 수를 1개씩 선택하고 차이가 가장 작은 경우를 구한다.

    public static int solution(int[] arr, int K) {
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        // int answer = arr[arr.length - 1]; // 임의의 가장 큰 숫자

        // i = 0, 1, 2
        // curr = arr[0, 1, 2]
        // last = arr[3, 4, 5]
        for (int i = 0; i <= arr.length - K; i++) {
            int small = arr[i];           // 작은 수 중, 선택한 숫자; 4(i=0)
            int large = arr[i + (K - 1)]; // 큰 수 중, 선택한 숫자; 9(i=3)
            if (answer > large - small) {
                answer = large - small;
            }
        }

        return answer;
    }
}