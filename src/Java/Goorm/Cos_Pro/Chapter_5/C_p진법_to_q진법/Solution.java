package Java.Goorm.Cos_Pro.Chapter_5.C_p진법_to_q진법;

public class Solution {
    public static void main(String[] args) {
        // 3진법 두 수의 합을 8진법으로 변환한다.
        System.out.println(solution("112001", "12010", 3, 8)); // 1005
    }

    public static String solution(String s1, String s2, int p, int q) {
        // Integer.parseInt(str, x) -> 문자열을 x진법 숫자로 변환한다.
        // Integer.toString(int, x) -> 숫자를 x진법 문자로 변환한다.
        int sum = Integer.parseInt(s1, p) + Integer.parseInt(s2, p);

        return Integer.toString(sum, q);
    }
}