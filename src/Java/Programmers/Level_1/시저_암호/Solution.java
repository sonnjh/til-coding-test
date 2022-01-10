package Java.Programmers.Level_1.시저_암호;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        // 'a' = 97, 'b' = 98, ... 'z' = 122 (26개)
        // 'A' = 65, 'B' = 66, ... 'Z' = 90  (26개)
        // System.out.println('b' - 'a'); // 1
        // System.out.println('b' - 97);  // 1
        // System.out.println(97 - '0');  // 49

        System.out.println(solution("z", 1)); // "a"
        System.out.println(solution("AB", 1)); // "BC"
        System.out.println(solution("a B z", 4)); // "e F d"
    }

    // 문장에서 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 치환한다.
    // AB -> 1 -> BC
    // AB -> 3 -> DE
    // z -> 1 -> a

    static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }
            answer.append(c);
        }

        return answer.toString();
    }
}