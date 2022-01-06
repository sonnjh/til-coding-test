package Java.Programmers.Level_1.K번째수;

import java.util.*;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})
        )); // [5, 6, 3]
    }

    // 1) [2, 5, 3]
    // 2 ~ 5번째 원소인 [5, 2, 6, 3]을 뽑고 정렬한 후, 3번째 원소(5)를 추출한다.

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int choose = commands[i][2] - 1; // 선택: 3번째 숫자 -> 2번째 인덱스
            int start = commands[i][0] - 1;  // 시작: 2번째 숫자 -> 1번째 인덱스
            int end = commands[i][1] - 1;    // 끝  : 5번째 숫자 -> 4번째 인덱스
            int size = (end - start) + 1;    // 시작 ~ 끝 범위에 해당하는 숫자 배열의 크기 -> 4

            int idx = 0;
            int[] temp = new int[size];
            for (int j = start; j <= end; j++) {
                temp[idx++] = array[j]; // idx: 0 ~ 3
            }
            Arrays.sort(temp);
            answer[i] = temp[choose];
        }

        return answer;
    }
}