package Java.Programmers.Level_1.문자열_내_마음대로_정렬하기;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"sun", "bed", "car"}, 1)
        )); // ["car", "bed", "sun"]
        System.out.println(Arrays.toString(solution(
                new String[]{"abce", "abcd", "cdx"}, 2)
        )); // ["abcd", "abce", "cdx"]
    }

    // sun, bed, car    (u, e, a)
    // usun, ebed, acar (정렬하기 위해 n번째 글자를 앞에 붙인다.)
    // acar, ebed, usun (사전순으로 정렬한다.)
    // car, bed, sun    (앞에 붙인 n번째 글자를 뺀다.)

    static String[] solution(String[] strings, int n) {
        int idx = 0;
        String[] answer = {};
        for (String string : strings) {
            String word = string.charAt(n) + string;

            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[idx++] = word;
        }

        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++) {
            String word = answer[i].substring(1);
            answer[i] = word;
        }

        return answer;
    }
}