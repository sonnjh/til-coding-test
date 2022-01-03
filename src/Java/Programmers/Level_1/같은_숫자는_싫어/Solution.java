package Java.Programmers.Level_1.같은_숫자는_싫어;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solutionA(new int[]{1, 1, 3, 3, 0, 1, 1}))); // [1, 3, 0, 1]
        System.out.println(Arrays.toString(solutionA(new int[]{4, 4, 4, 3, 3})));       // [4, 3]
    }

    /**
     * 채점 결과
     * 정확성: 71.9
     * 효율성: 28.1
     * 합계: 100.0 / 100.0
     */
    static int[] solutionA(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>(){{
            add(arr[0]);
        }};
        int prev = arr[0];

        // 이전 원소와 현재 원소가 같을 경우 중복 값이므로 다음 반복으로 넘긴다.
        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                continue;
            }
            list.add(arr[i]);
            prev = arr[i];
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    /**
     * 채점 결과
     * 정확성: 71.9
     * 효율성: 0.0
     * 합계: 71.9 / 100.0
     */
    static int[] solutionB(int[] arr) {
        int[] answer = {arr[0]};
        int prev = arr[0];

        // 이전 원소와 현재 원소가 같을 경우 중복 값이므로 다음 반복으로 넘긴다.
        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                continue;
            }
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = arr[i];
            prev = arr[i];
        }

        return answer;
    }
}