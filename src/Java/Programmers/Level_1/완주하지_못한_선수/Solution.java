package Java.Programmers.Level_1.완주하지_못한_선수;

import java.util.HashMap;

/**
 * 채점 결과
 * 정확성: 50.0
 * 효율성: 50.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}
        )); // "leo"
        System.out.println(solution(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}
        )); // "vinko"
        System.out.println(solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}
        )); // "mislav"
    }

    static String solution(String[] participants, String[] completions) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";

        // 이름별로 참가한 선수 인원을 지정한다.
        // leo = 1, kiki = 1, eden = 1
        for (String player : participants) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        // 이름별로 완주한 선수 인원을 뺀다.
        // leo = 1, kiki = 0, eden = 0
        for (String player : completions) {
            map.put(player, map.get(player) - 1);
        }

        // 해시맵에서 0 값을 갖지 않는 키를 찾는다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}