package Java.Goorm.Cos_Pro.Chapter_2.C_합이_k_배가_되는_수;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}, 3)); // 4
    }

    public static int solution(int[] arr, int K) {
        int answer = 0;

        for (int n1 = 0; n1 < arr.length - 2; n1++) {          // 1번째 숫자 (1 ~ 3)
            for (int n2 = n1 + 1; n2 < arr.length - 1; n2++) { // 2번째 숫자 (2 ~ 4)
                for (int n3 = n2 + 1; n3 < arr.length; n3++) { // 3번째 숫자 (3 ~ 5)
                    if ((arr[n1] + arr[n2] + arr[n3]) % K == 0) {
                        // System.out.printf("%d + %d + %d\n", arr[n1], arr[n2], arr[n3]);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}