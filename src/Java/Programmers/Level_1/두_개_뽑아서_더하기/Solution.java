package Java.Programmers.Level_1.두_개_뽑아서_더하기;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{2, 1, 3, 4, 1}
        ))); // [2, 3, 4, 5, 6, 7]
        System.out.println(Arrays.toString(solution(
                new int[]{5, 0, 2, 7}
        ))); // [2, 5, 7, 9, 12]
        System.out.println(Arrays.toString(solution(
                new int[]{0, 100, 1000, 10}
        ))); // [10, 100, 110, 1000, 1010, 1100]
    }

    static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        // TC1: [1, 1, 2, 3, 4]
        // TC2: [0, 2, 5, 7]
        // TC3: [1010, 100, 1000, 10, 1100, 110]
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // int index = 0;
        // int[] answer = new int[set.size()];
        // for (Integer i : set) {
        //     answer[index] = i;
        //     index++;
        // }
        // Arrays.sort(answer);

        // return answer;

        return set.stream().mapToInt(Number::intValue).sorted().toArray();
    }
}