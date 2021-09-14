package Java.Programmers.Level_1.크레인_인형뽑기_게임;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution1(
                new int[][]{
                        {0, 0, 0, 0, 0}, // [0][0~4]
                        {0, 0, 1, 0, 3}, // [1][0~4]
                        {0, 2, 5, 0, 1}, // [2][0~4]
                        {4, 2, 4, 4, 2}, // [3][0~4]
                        {3, 5, 1, 3, 1}, // [4][0~4]
                      // 1  2  3  4  5
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ));
    }

    static int solution1(int[][] board, int[] moves) {
        ArrayList<Integer> basket = new ArrayList<>();
        basket.add(0); // 바구니에 인형이 없는 상태를 방지하기 위함 (결과에 지장을 주지 않는다.)
        int result = 0;

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int doll = board[i][move - 1];
                if (doll == 0) {
                    continue;
                }

                if (basket.get(basket.size() - 1) == doll) {
                    basket.remove(basket.size() - 1);
                    result += 2;
                } else {
                    basket.add(doll);
                }

                board[i][move - 1] = 0; // 꺼낸 인형 표시
                break;
            }
        }

        return result;
    }

    static int solution2(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        basket.push(0); // 바구니에 인형이 없는 상태를 방지하기 위함 (결과에 지장을 주지 않는다.)
        int result = 0;

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int doll = board[i][move - 1];
                if (doll == 0) {
                    continue;
                }

                if (basket.peek() == doll) {
                    basket.pop();
                    result += 2;
                } else {
                    basket.push(doll);
                }

                board[i][move - 1] = 0; // 꺼낸 인형 표시
                break;
            }
        }

        return result;
    }
}