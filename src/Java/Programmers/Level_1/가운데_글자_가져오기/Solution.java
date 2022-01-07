package Java.Programmers.Level_1.가운데_글자_가져오기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("qwer")); // "we"
        System.out.println(solution("abcde")); // "c"
    }

    // qwer  -> 4 / 2 -> start = 1, end = 3
    // abcde -> 5 / 2 -> start = 2, end = 3

    static String solution(String s) {
        int length = s.length();
        int share  = length / 2;
        int rest   = length % 2;

        if (rest == 0) {
            return s.substring(share - 1, share + 1);
        } else {
            return s.substring(share, share + 1);
        }
    }
}