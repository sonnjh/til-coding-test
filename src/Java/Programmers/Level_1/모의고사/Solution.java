package Java.Programmers.Level_1.모의고사;

import java.util.*;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 3, 2, 1, 5}))); // [3]
        System.out.println(Arrays.toString(solution(new int[]{5, 5, 4, 2, 3}))); // [1, 2, 3]
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}))); // [1]
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2}))); // [1, 2, 3]
    }

    // 정답 배열이 [1, 2, 3, 4, 5]일 때, 수포자들이 맞춘 개수는 [5, 0, 0]이다.
    // 1번 수포자가 가장 높은 점수이므로 [1]
    // 정답 배열이 [5, 5, 4, 2, 3]일 때, 수포자들이 맞춘 개수는 [0, 0, 0]이다.
    // 1, 2, 3번 수포자 모두 가장 높은 점수이므로 [1, 2, 3]

    static int[] solution(int[] answers) {
        // 수포자 3명의 찍기 패턴
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = {};
        int[] scores = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            // answers 배열의 크기에 맞춰 수포자들의 정답 패턴을 적용해야 한다. (나머지 연산 이용)
            // (0 % 5 = 0, 1 % 5 = 1, ... 5 % 5 = 0, 6 % 5 = 1, ...)
            if (answers[i] == arr1[i % arr1.length]) scores[0]++;
            if (answers[i] == arr2[i % arr2.length]) scores[1]++;
            if (answers[i] == arr3[i % arr3.length]) scores[2]++;
        }

        int size = 0;
        // scores 배열에서 가장 높은 점수를 찾는다.
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // scores 배열은 수포자 1, 2, 3번의 점수가 순서대로 들어있다.
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                // answer 배열의 크기를 늘린다.
                answer = Arrays.copyOf(answer, size + 1);
                // answer 배열에 수포자 번호를 추가한다.
                answer[size++] = i + 1;
            }
        }

        return answer;
    }
}