package Java.Programmers.Extra.과반수_숫자_찾기;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 2, 1, 3})); // -1
        System.out.println(solution(new int[]{5, 2, 5, 5, 5, 3})); // 5
        System.out.println(solution(new int[]{3, 5, 3, 3, 3, 4, 3, 1})); // 3
        System.out.println(solution(new int[]{1, 5, 3, 6, 3, 4, 3, 1})); // -1
    }

    // 숫자 배열이 주어질 때 과반수 이상의 개수를 갖는 숫자를 출력한다. 없다면 -1을 출력한다.
    // (숫자는 양의 정수만 주어진다.)
    // (특정 숫자의 개수가 길이 / 2를 초과할 때 과반수 이상이 된다.)
    // [4, 2, 2, 1, 3] -> -1
    // [5, 2, 5, 5, 5, 3] -> 5

    static int solution(int[] nums) {
        int answer = -1;
        int maxCount = 0;
        int baseline = nums.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);

            if (count > maxCount) {
                maxCount = count;
                if (count > baseline) {
                    answer = key;
                }
            }
        }

        return answer;
    }
}