package Java.Goorm.Cos_Pro.Chapter_3.C_중복_문자열_이어붙이기;

//public class Solution {
//    public static void main(String[] args) {
//        System.out.println(solution("abcdab", "ababc")); // 8
//    }
//
//    // abcdab
//    // ababc
//
//    public static int solution(String s1, String s2) {
//        int idx    = 0;
//        int answer = 0;
//        // 중복 문자열을 찾기 위한 반복 횟수는 짧은 문자열을 기준으로 한다. (abcdab(6번)보다 ababc(5번)이 효율적이다.)
//        int length = Math.min(s1.length(), s2.length());
//
//        for (int i = 0; i < length; i++) {
//            // 긴 문자열을 짧은 문자열의 왼쪽, 오른쪽 방향에서 비교한다.
//        }
//
//        return answer;
//    }
//}