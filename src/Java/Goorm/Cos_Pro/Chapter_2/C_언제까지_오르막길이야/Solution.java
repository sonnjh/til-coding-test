package Java.Goorm.Cos_Pro.Chapter_2.C_언제까지_오르막길이야;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 4, 5, 1, 2, 2, 3, 4})); // 4
        System.out.println(solution(new int[]{1, 1, 2, 4, 3, 1, 2, 3, 4, 5})); // 5
    }

    public static int solution(int[] arr) {
        int[] lengths = new int[arr.length];
        lengths[0] = 1; // 길이 배열의 모든 원소는 1에서 시작한다.

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {           // 이전 원소와 현재 원소의 크기를 비교한다.
                lengths[i] = lengths[i - 1] + 1; // 현재 원소가 더 크다면 길이 배열의 i번째 값을 조정한다.
            } else {                             // 이전 원소가 현재 원소보다 크거나 같은 경우
                lengths[i] = 1;                  // 길이 배열의 i번째 값을 1로 지정한다.
            }
        }

        System.out.println(Arrays.toString(lengths));

        return Arrays.stream(lengths).max().orElse(1);
    }
}