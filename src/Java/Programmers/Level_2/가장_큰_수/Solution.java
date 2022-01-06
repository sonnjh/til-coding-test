package Java.Programmers.Level_2.가장_큰_수;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));        // 6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9})); // 9534330
        System.out.println(solution(new int[]{0, 0, 0}));         // 0
    }

    // "6" + "10"
    // "10" + "6"
    // -> "610" < "106"

    static String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // System.out.printf("%s : %s\n", o2 + o1, o1 + o2);
                // (o2 + o1) > (o1 + o2) -> 1
                // (o2 + o1) = (o1 + o2) -> 0
                // (o2 + o1) < (o1 + o2) -> -1
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        answer = String.join("", nums);
        // [0, 0, 0]일 때 "000" 대신 "0"으로 리턴한다.
        if (answer.equals(String.format("%0" + answer.length() + "d", 0))) return "0";

        return answer;
    }
}