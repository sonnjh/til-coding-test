package Java.Programmers.Level_1.행렬의_덧셈;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{{1, 2}},
                new int[][]{{3, 4}}
        ))); // [[4], [6]]
        System.out.println(Arrays.deepToString(solution(
                new int[][]{{1, 2}, {2, 3}},
                new int[][]{{3, 4}, {5, 6}}
        ))); // [[4, 6], [7, 9]]
    }

    static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}