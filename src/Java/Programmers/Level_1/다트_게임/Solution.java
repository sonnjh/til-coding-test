package Java.Programmers.Level_1.다트_게임;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));  // 37
        System.out.println(solution("1D2S#10S")); // 9
        System.out.println(solution("1D2S0T"));   // 3
        System.out.println(solution("1S*2T*3S")); // 23
        System.out.println(solution("1D#2S*3S")); // 5
        System.out.println(solution("1T2D3D#"));  // -4
        System.out.println(solution("1D2S3T*"));  // 59
    }

    // 0 ~ 10의 정수와 문자 S, D, T, *, #
    // 1S, 2D*, 3T / 1D, 2S#, 10S
    // 1D, 2S, 0T / 1S*, 2T*, 3S
    // 1D#, 2S*, 3S / 1T, 2D, 3D# / 1D, 2S, 3T*

    static int solution(String result) {
        int idx = 0; // scores 배열의 인덱스
        int[] scores = new int[3];
        StringBuilder temp = new StringBuilder();

        for (char c : result.toCharArray()) {
            switch (c) {
                case '*': // 스타상
                    scores[idx - 1] *= 2; // 스타상 효과
                    if (idx > 1) scores[idx - 2] *= 2; // 스타상 중첩 효과
                    break;
                case '#': // 아차상
                    scores[idx - 1] *= -1; // 아차상 효과
                    break;
                case 'S': // 싱글
                    scores[idx++] = (int) Math.pow(Integer.parseInt(temp.toString()), 1);
                    temp.setLength(0); // 점수 부분만 필요하므로 제곱한 후에 초기화한다.
                    break;
                case 'D': // 더블
                    scores[idx++] = (int) Math.pow(Integer.parseInt(temp.toString()), 2);
                    temp.setLength(0);
                    break;
                case 'T': // 트리플
                    scores[idx++] = (int) Math.pow(Integer.parseInt(temp.toString()), 3);
                    temp.setLength(0);
                    break;
                default:
                    temp.append(c);
                    break;
            }
        }

        return Arrays.stream(scores).sum();
    }
}