package Java.Programmers.Level_1.핸드폰_번호_가리기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("027778888"));   // "*****8888"
        System.out.println(solution("01033334444")); // "*******4444"
    }

    static String solution(String phoneNumber) {
        String mask = "*".repeat(phoneNumber.length() - 4);

        return mask + phoneNumber.substring(mask.length());
    }
}