package Java.Programmers.Level_1.최소직사각형;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); // 133
    }

    //   60 * 50
    //   30 * 70
    //   60 * 30
    //   80 * 40
    // ---------
    // = 80 * 50 (모든 명함을 수납할 수 있는 가장 작은 지갑의 크기)

    //   60 * 50 (가로 길이 > 세로 길이)
    //   70 * 30 -> 가로, 세로 길이의 값을 바꾼다. (가로 길이 > 세로 길이)
    //   60 * 30 (가로 길이 > 세로 길이)
    //   80 * 40 (가로 길이 > 세로 길이)
    // --------- -> 가로 80, 세로 50이 된다.

    static int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) { // 가로 길이(x) < 세로 길이(y)
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            maxX = Math.max(maxX, sizes[i][0]);
            maxY = Math.max(maxY, sizes[i][1]);
        }

        return maxX * maxY;
    }
}