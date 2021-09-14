package Java.Programmers.Level_1.숫자_문자열과_영단어;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        // 1478
        System.out.println(solution("one4seveneight"));
        // 234567
        System.out.println(solution("23four5six7"));
        // 234567
        System.out.println(solution("2three45sixseven"));
        // 123
        System.out.println(solution("123"));
    }

    static int solution(String s) {
        String[] strNums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strNums.length; i++) {
            s = s.replaceAll(strNums[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}