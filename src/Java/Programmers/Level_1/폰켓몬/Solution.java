package Java.Programmers.Level_1.폰켓몬;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3})); // 2
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4})); // 3
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2})); // 2
    }

    static int solution(int[] nums) {
        int choice = nums.length / 2;

        // 해시셋을 사용한 정렬, 중복 제거
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(choice, set.size());

        // 스트림을 사용한 정렬, 중복 제거
        // int[] temp = Arrays.stream(nums)
        //         .sorted().distinct()
        //         .toArray();

        // return Math.min(choice, temp.length);
    }
}