package Java.Programmers.Level_1.나머지가_1이_되는_수_찾기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(10)); // 3
        System.out.println(solution(12)); // 11
    }

    // n을 나눌 때 나머지 1을 남기는 수 : x
    // 10을 나눌 때 나머지 1을 남기는 수: 3, 9

    static int solution(int n) {
        int x = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (n % i == 1) x = Math.min(x, i);
        }

        return x;
    }
}