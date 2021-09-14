package Java.Programmers.Level_1.로또의_최고_순위와_최저_순위;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}))
        ); // [3, 5]
        System.out.println(Arrays.toString(
                solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}))
        ); // [1, 6]
        System.out.println(Arrays.toString(
                solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}))
        ); // [1, 1]
    }

    // lottoNums: 구매한 로또 번호를 담은 배열
    // winNums: 당첨 번호를 담은 배열
    // answers: 당첨 가능한 최고 순위와 최저 순위
    static int[] solution(int[] lottoNums, int[] winNums) {
        int winCount = 0;
        int zeroCount = 0;

        for (int lottoNum : lottoNums) {
            if (lottoNum == 0) {
                zeroCount++;
                continue;
            }
            for (int winNum : winNums) {
                if (lottoNum == winNum) {
                    winCount++;
                    break;
                }
            }
        }

        int highestRank = 7 - Math.max(winCount + zeroCount, 1);
        int lowestRank = 7 - Math.max(winCount, 1);

        return new int[]{highestRank, lowestRank};
    }
}