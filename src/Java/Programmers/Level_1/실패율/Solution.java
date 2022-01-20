package Java.Programmers.Level_1.실패율;

import java.util.*;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        // [3, 4, 2, 1, 5]
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        // [4, 1, 2, 3]
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    // N: 스테이지 개수 (N + 1은 N번째 스테이지를 클리어한 경우)
    // stages: 사용자별 실패한 스테이지 번호
    // int[]: 실패율의 내림차순으로 정렬한 스테이지 번호
    // 실패율: 실패 인원/도전 인원
    // 1번 스테이지의 실패율: 1/8 = 0.125
    // 2번 스테이지의 실패율: 3/7 = 0.428
    // 3번 스테이지의 실패율: 2/4 = 0.5
    // 4번 스테이지의 실패율: 1/2 = 0.5
    // 5번 스테이지의 실패율: 0/1 = 0.0

    static int[] solution(int N, int[] stages) {
        int total = stages.length;
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Double> rates = new HashMap<>();
        double[][] results = new double[N][2];
        int[] answer = new int[N];

        // 스테이지별 인원수를 센다.
        for (int stage : stages) {
            counts.put(stage, counts.getOrDefault(stage, 0) + 1);
        }

        // 스테이지별 실패율을 계산한다.
        for (int i = 1; i <= N; i++) {
            if (counts.containsKey(i)) {
                int count = counts.get(i);
                rates.put(i, ((double) count / total));
                total = total - count;
            }
        }

        // 스테이지별 실패율을 결과 배열에 세팅한다. (정렬하기 위함)
        for (int i = 1; i <= N; i++) {
            results[i - 1][0] = i;
            results[i - 1][1] = rates.getOrDefault(i, 0.0);
        }

        // 실패율 내림차순으로 정렬한다. (실패율이 같으면 번호 오름차순으로 정렬한다.)
        Arrays.sort(results, (o1, o2) -> {
            if (o1[1] == o2[1]) { // [0]: key, [1]: rate
                return Double.compare(o1[0], o2[0]);
            }
            return -Double.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < N; i++) {
            answer[i] = (int) results[i][0];
        }

        return answer;
    }
}