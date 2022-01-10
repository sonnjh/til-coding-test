package Java.Programmers.Level_1.정수_내림차순으로_배치하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA(118372)); // 873211
    }

    static long solutionA(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());

        return Long.parseLong(String.join("", arr));
    }

    static long solutionB(long n) {
        StringBuilder result = new StringBuilder();
        ArrayList<Long> list = new ArrayList<>();

        while (n != 0) {
            long share = n / 10;
            long rest  = n % 10;
            n = share;
            list.add(rest);
        }

        list.sort(Collections.reverseOrder());

        for (long num : list) {
            result.append(num);
        }

        return Long.parseLong(result.toString());
    }
}