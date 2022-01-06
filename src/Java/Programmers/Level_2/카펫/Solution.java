package Java.Programmers.Level_2.카펫;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8, 1)));   // [3, 3]
        System.out.println(Arrays.toString(solution(10, 2)));  // [4, 3]
        System.out.println(Arrays.toString(solution(24, 24))); // [8, 6]
    }

    // [b][b][b]
    // [b][y][b]
    // [b][b][b] -> 3 * 3
    // [b][b][b][b]
    // [b][y][y][b]
    // [b][b][b][b] -> 4 * 3
    // 1) b, y의 개수의 합 = 면적
    // 2) 가로 길이 >= 세로 길이

    // brown 개수 = (a * 2) + (b * 2) - 4 (a = 가로, b = 세로)
    //            = (3 * 2) + (3 * 2) - 4 = 8
    // yellow 개수 = (a - 2) * (b - 2)
    //             = (3 - 2) * (3 - 2) = 1

    static int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        int width = 0;
        int length = 0;
        int[] answer = new int[2];

        for (int i = 1; i < area; i++) {
            width = i;             // 1, 2, 3, 4, ...
            length = area / width; // area = 12 -> 12, 6, 4, 3, ...

            if (width < length) continue;
            boolean bCheck = (width * 2) + (length * 2) - 4 == brown;
            boolean yCheck = (width - 2) * (length - 2) == yellow;
            if (bCheck && yCheck) {
                answer[0] = width;
                answer[1] = length;
                break;
            }
        }

        return answer;
    }
}