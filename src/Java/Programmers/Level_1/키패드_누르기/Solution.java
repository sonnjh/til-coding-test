package Java.Programmers.Level_1.키패드_누르기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")
        ); // "LRLLLRLLRRL"
        System.out.println(solution(
                new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left")
        ); // "LRLLRRLLLRR"
        System.out.println(solution(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right")
        ); // "LLRLLRLLRL"
    }

    // [ 1][ 2][ 3]
    // [ 4][ 5][ 6]
    // [ 7][ 8][ 9]
    // [10][11][12] (10: *, 11: 0, 12: #)
    static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 왼쪽, 오른쪽 엄지손가락 시작 위치: *, #
        int leftThumb = 10, rightThumb = 12;
        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }
            switch (number % 3) {
                case 0: // number = 3, 6, 9, 12
                    answer.append("R");
                    rightThumb = number; // 오른쪽 엄지손가락 위치 지정
                    break;
                case 1: // number = 1, 4, 7, 10
                    answer.append("L");
                    leftThumb = number; // 왼쪽 엄지손가락 위치 지정
                    break;
                case 2: // number = 2, 5, 8, 11
                    // (((엄지손가락이 위치한 번호 - 누를 번호) / 3) + ((엄지손가락이 위치한 번호 - 누를 번호) % 3))의 절대값
                    int leftDistance = Math.abs(((leftThumb - number) / 3) + ((leftThumb - number) % 3));
                    int rightDistance = Math.abs(((rightThumb - number) / 3) + ((rightThumb - number) % 3));

                    if (leftDistance > rightDistance) {
                        answer.append("R");
                        rightThumb = number;
                    } else if (leftDistance < rightDistance) {
                        answer.append("L");
                        leftThumb = number;
                    } else {
                        answer.append(hand.equals("right") ? "R" : "L");
                        if (hand.equals("right")) {
                            rightThumb = number;
                        } else {
                            leftThumb = number;
                        }
                    }
                    break;
            }
        }

        return answer.toString();
    }
}