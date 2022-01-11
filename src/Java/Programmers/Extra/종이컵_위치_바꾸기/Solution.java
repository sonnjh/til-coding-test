package Java.Programmers.Extra.종이컵_위치_바꾸기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{1, 2, 3, 4, 5, 6},
                new int[][]{{2, 3}, {3, 5}, {1, 4}}
        ))); // [4, 3, 5, 1, 2, 6]
    }

    // 1부터 6까지 번호가 적힌 종이컵이 배열로 주어진다.
    // 이때 2번째와 3번째, 3번째와 5번째, 1번째와 4번째의 종이컵 위치를 변경했을 때 만들어지는 종이컵 배열을 구한다.
    // (인덱스 1이 2번째임을 유의한다.)
    // [1, 2, 3, 4, 5, 6], [[2, 3], [3, 5], [1, 4]]
    // [1, 3, 2, 4, 5, 6]
    // [1, 3, 5, 4, 2, 6]
    // [4, 3, 5, 1, 2, 6]

    static int[] solution(int[] cups, int[][] changes) {
        for (int[] change : changes) {
            int before = change[0] - 1; // 인덱스로 표현하기 위해 -1한다.
            int after = change[1] - 1;

            int temp = cups[before];
            cups[before] = cups[after];
            cups[after] = temp;
        }

        return cups;
    }
}