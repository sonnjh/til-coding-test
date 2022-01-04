package Java.Programmers.Level_1.서울에서_김서방_찾기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"})); // "김서방은 1에 있다"
    }

    static String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) answer = "김서방은 " + i + "에 있다";
        }

        return answer;
    }
}