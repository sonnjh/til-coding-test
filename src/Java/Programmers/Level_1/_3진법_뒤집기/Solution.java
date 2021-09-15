package Java.Programmers.Level_1._3진법_뒤집기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(45)); // 7
        System.out.println(solution(125)); // 229
    }

    static int solution(int n) {
        // 3진법 변환
        // Integer.toUnsignedString(45, 3) -> 10진수를 3진수로 변환한다.
        StringBuilder trinary = new StringBuilder(Integer.toUnsignedString(n, 3));

        // 3진법 변환 -> 3진법 뒤집기
        String reverse = trinary.reverse().toString();

        // 3진법 뒤집기 -> 10진법 변환
        // Integer.parseInt("21", 3) -> 3진수를 10진수로 변환한다.
        return Integer.parseInt(reverse, 3);
    }
}