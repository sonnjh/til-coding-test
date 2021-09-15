package Java.Programmers.Level_1.소수_만들기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4})); // 1
        System.out.println(solution(new int[]{1, 2, 7, 6, 4})); // 4
    }

    // [1, 2, 3, 4] 예시
    // 1, 2, 3 -> 6
    // 1, 2, 4 -> 7
    // 1, 3, 4 -> 8
    // 2, 3, 4 -> 9
    // 첫 번째 수는 1, 2가 나오므로 nums 길이에서 -2까지 반복한다.
    // 두 번째 수는 2, 3이 나오므로 nums 길이에서 -1까지 반복한다.
    // (1을 제외하고 나머지 인덱스를 선택해야 하므로 j = i + 1)
    // 세 번째 수는 3, 4가 나오므로 nums 길이까지 반복한다.
    // (1, 2를 제외하고 나머지 인덱스를 선택해야 하므로 k = j + 1)
    static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrimeNum(sum)) answer++;
                }
            }
        }

        return answer;
    }

    static boolean isPrimeNum(int num) {
        if (num <= 1) return false;     // 0, 1은 소수가 아니다.
        if (num == 2) return true;      // 2는 소수이다.
        if (num % 2 == 0) return false; // 2를 제외한 모든 짝수는 소수가 아니다.

        int end = (int) Math.sqrt(num);
        for (int i = 3; i <= end; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}