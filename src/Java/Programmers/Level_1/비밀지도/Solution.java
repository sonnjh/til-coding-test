package Java.Programmers.Level_1.비밀지도;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5,
                new int[]{9, 20, 28, 18, 11},
                new int[]{30, 1, 21, 17, 28}
        ))); // ["#####","# # #", "### #", "# ##", "#####"]
        System.out.println(Arrays.toString(solution(6,
                new int[]{46, 33, 33, 22, 31, 50},
                new int[]{27 ,56, 19, 14, 14, 10}
        ))); // ["######", "### #", "## ##", " #### ", " #####", "### # "]
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];

        for (int i = 0; i < n; i++) {
            String sheet = Integer.toString((arr1[i] | arr2[i]), 2); // OR 비트 연산
            sheet = String.format("%" + n + "s", sheet).replace(" ", "0");
            map[i] = sheet
                    .replaceAll("1", "#")
                    .replaceAll("0", " ");
        }

        return map;
    }
}