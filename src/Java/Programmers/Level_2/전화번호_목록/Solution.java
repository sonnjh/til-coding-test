package Java.Programmers.Level_2.전화번호_목록;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 채점 결과
 * 정확성: 83.3
 * 효율성: 16.7
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA(new String[]{"119", "97674223", "1195524421"})); // false
        System.out.println(solutionA(new String[]{"12","123","1235","567","88"})); // false
        System.out.println(solutionA(new String[]{"123","456","789"})); // true
    }

    static boolean solutionA(String[] phoneBook) {
        boolean answer = true;
        HashMap<String, String> map = new HashMap<>();

        for (String phone : phoneBook) {
            map.put(phone, "");
        }

        for (String phone : phoneBook) {
            for (int i = 0; i < phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    /**
     * 채점 결과
     * 정확성: 83.3
     * 효율성: 16.7
     * 합계: 100.0 / 100.0
     */
    static boolean solutionB(String[] phoneBook) {
        boolean answer = true;
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    /**
     * 채점 결과
     * 정확성: 75.0
     * 효율성: 0.0
     * 합계: 75.0 / 100.0
     */
    static boolean solutionC(String[] phoneBook) {
        boolean answer = true;
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 1; j < phoneBook.length; j++) {
                if (i == j) continue;
                String prev = phoneBook[i];
                String curr = phoneBook[j];

                if (curr.startsWith(prev)) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}