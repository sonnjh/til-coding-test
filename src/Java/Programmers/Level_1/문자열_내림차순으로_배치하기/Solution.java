package Java.Programmers.Level_1.문자열_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Collections;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA("Zbacred")); // redcbaZ
        System.out.println(solutionB("Zbcdefg")); // gfedcbZ
    }

    // 내림차순 정렬        (z > a)
    // 소문자 > 대문자 정렬 (a > A)

    static String solutionA(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, Collections.reverseOrder());

        StringBuilder answer = new StringBuilder();
        for (Character c : chars) {
            answer.append(c);
        }

        return answer.toString();
    }

    static String solutionB(String s) {
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') lower.append(c);
            if ('A' <= c && c <= 'Z') upper.append(c);
        }

        String[] lowers = lower.toString().split("");
        String[] uppers = upper.toString().split("");
        Arrays.sort(lowers, Collections.reverseOrder());
        Arrays.sort(uppers, Collections.reverseOrder());

        return String.join("", lowers) + String.join("", uppers);
    }
}