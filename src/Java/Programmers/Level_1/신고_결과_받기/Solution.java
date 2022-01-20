package Java.Programmers.Level_1.신고_결과_받기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"a", "b", "c", "d"},
                new String[]{"a b", "c b", "b d", "a d", "c a"}, 2)
        )); // "[2, 1, 1, 0]"
        System.out.println(Arrays.toString(solution(
                new String[]{"a", "b"},
                new String[]{"b a", "b a", "b a", "b a"}, 3)
        )); // "[0, 0]"
    }

    // 신고자는 동일한 유저를 반복 신고하지 못한다. (1회)
    // 신고자가 신고한 유저가 이용 정지되면 결과 메일을 받는다.

    static int[] solution(String[] users, String[] reports, int k) {
        HashMap<String, Integer> mailMap = new HashMap<>();           // 각 유저가 받을 메일 개수
        HashMap<String, HashSet<String>> reportMap = new HashMap<>(); // 각 유저의 신고 데이터

        // [a=0, b=0, c=0, d=0] (a가 받는 메일의 개수는 0개인 상태)
        for (String user : users) {
            mailMap.put(user, 0);
            reportMap.put(user, new HashSet<>());
        }

        // [a=[c], b=[a, c], c=[], d=[a, b]] (a는 c에게 신고 당한 상태)
        for (String report : reports) {
            // temp[0]: 신고자, temp[1]: 신고 대상자
            String[] temp = report.split(" ");
            reportMap.get(temp[1]).add(temp[0]);
        }

        // [a=2, b=1, c=1, d=0] (a가 받는 메일의 개수는 2개인 상태)
        for (String key : reportMap.keySet()) {
            HashSet<String> reporters = reportMap.get(key);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailMap.put(reporter, mailMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        int[] answer = new int[users.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = mailMap.get(users[i]);
        }

        return answer;
    }
}