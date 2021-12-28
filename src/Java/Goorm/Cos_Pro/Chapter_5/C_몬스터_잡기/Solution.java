package Java.Goorm.Cos_Pro.Chapter_5.C_몬스터_잡기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 3}, new int[]{1, 3}));       // 2
        System.out.println(solution(new int[]{1, 1, 1}, new int[]{1, 2, 3, 4})); // 3
    }

    public static int solution(int[] enemies, int[] armies) {
        int answer = 0;

        // 값 비교이므로 오름차순 정렬한다.
        Arrays.sort(enemies);
        Arrays.sort(armies);

        // 두 배열의 길이가 다르므로 가장 작은 배열의 길이를 기준으로 한다.
        int length = Math.min(enemies.length, armies.length);

        // 1, 3, 4 <-> 1, 3
        for (int i = 0; i < length; i++) {
            if (armies[i] >= enemies[i]) {
                answer++;
            }
        }
        return answer;
    }
}