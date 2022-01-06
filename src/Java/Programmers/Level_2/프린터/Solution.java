package Java.Programmers.Level_2.프린터;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 2, 1}, 0)); // 1
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
    }

    // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼낸다.
    // 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣는다.
    // 3. 그렇지 않으면 J를 인쇄한다.

    // A, B, C, D 문서의 중요도가 각각 2, 1, 3, 2일 때 인덱스 2번째 문서는 1번째로 인쇄된다. (C, D, A, B)

    // [A, B, C, D] -> [2, 1, 3, 2]
    // [B, C, D, A] -> [1, 3, 2, 2]
    // [C, D, A, B] -> [3, 2, 2, 1] -> C
    // [D, A, B] -> [2, 2, 1] -> D
    // [A, B] -> [2, 1] -> A
    // [D] -> [1] -> B
    // []

    // priorities = [3, 2, 2, 1], location = 0 (queue = [3, 2, 2, 1])
    // i = 0 -> if(3 == 3) -> if(0 == 0) -> answer++ -> return
    // priorities = [2, 1, 3, 2], location = 2 (queue = [3, 2, 2, 1])
    // i = 0 -> else
    // i = 1 -> else
    // i = 2 -> if(3 == 3) -> if(2 == 2) -> answer++ -> return

    static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : priorities) queue.add(i);

        int answer = 0;
        do {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        } while (!queue.isEmpty());
        return answer;
    }
}