package Java.Goorm.Cos_Pro.Chapter_3.C_전광판_문구_출력;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("happy-birthday", 3));
        System.out.println(solution("happy-birthday", 14));
        System.out.println(solution("happy-birthday", 16));
        System.out.println(solution("happy-birthday", 20));
        System.out.println(solution("happy-birthday", 28));
        System.out.println(solution("happy-birthday", 29));
    }

    // ______________ (0s, 28s)
    // _____________h (1s, 29s)
    // ____________ha (2s)
    // ___________hap (3s)
    // happy-birthday (14s)
    // ppy-birthday__ (16s)
    // birthday______ (20s)

    public static String solution(String phrases, int second) {
        // ______________ + happy-birthday
        StringBuilder answer = new StringBuilder("_".repeat(phrases.length()) + phrases);

        // 1글자씩 맨 앞의 글자를 맨 뒤로 옮긴다.
        for (int i = 1; i <= second; i++) {
            answer.append(answer.charAt(0));
            answer = new StringBuilder(answer.substring(1));
        }

        // 화면에 출력할 글자 수만큼 리턴한다.
        return answer.substring(0, phrases.length());
    }
}