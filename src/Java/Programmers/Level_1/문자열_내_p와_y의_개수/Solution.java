package Java.Programmers.Level_1.문자열_내_p와_y의_개수;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY")); // true
        System.out.println(solution("Pyy"));     // false
    }

    static boolean solution(String s) {
        int pCount = 0, yCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') pCount++;
            if (c == 'y' || c == 'Y') yCount++;
        }

        return pCount == yCount;
    }
}