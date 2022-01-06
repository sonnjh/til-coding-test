package Java.Programmers.Level_2.큰_수_만들기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2)); // 94
        System.out.println(solution("1231234", 3)); // 3234
        System.out.println(solution("4177252841", 4)); // 775841
    }

    // 1924, 2 -> 1, 2 삭제 -> 94
    // 1231234, 3 -> 1, 1, 2 삭제 -> 3234
    // 4177252841, 4 -> 4, 1, 2, 2 삭제 -> 775841

    static String solution(String number, int k) {
        int idx = 0;
        StringBuilder answer = new StringBuilder();

        if (number.charAt(0) == '0') return "0";
        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}