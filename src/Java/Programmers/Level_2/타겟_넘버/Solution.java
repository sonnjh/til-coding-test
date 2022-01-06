package Java.Programmers.Level_2.타겟_넘버;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}, 3)); // 1
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}, 5)); // 3
    }

    // 수를 더하거나 빼서 타겟 숫자를 만든다.
    // -1 +1 +1 +1 +1 = 3
    // +1 -1 +1 +1 +1 = 3
    // +1 +1 -1 +1 +1 = 3
    // +1 +1 +1 -1 +1 = 3
    // +1 +1 +1 +1 -1 = 3

    // [1, 2]이 있고 타겟 숫자가 3일 때 (슬래시는 탐색 과정에서 분기됨을 의미함)
    // idx = 0 -> dfs(0, 0)
    //            dfs(1, 1) / dfs(1, -1)
    // idx = 1 -> dfs(1, 1) / dfs(1, -1)
    //            dfs(2, 3), dfs(2, -1) / dfs(2, 1), dfs(2, -3)
    // idx = 2 -> 1, 0 / 0, 0 (1 + 0 / 0 + 0)
    //            1 / 0       (1 + 0)
    //            1

    static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    static int dfs(int[] numbers, int target, int idx, int num) {
        if (idx == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return dfs(numbers, target, idx + 1, num + numbers[idx])
                    + dfs(numbers, target, idx + 1, num - numbers[idx]);
        }
    }
}
