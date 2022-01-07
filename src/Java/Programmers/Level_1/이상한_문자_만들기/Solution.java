package Java.Programmers.Level_1.이상한_문자_만들기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA("try hello world")); // "TrY HeLlO WoRlD"
    }

    // 각 단어의 홀수번째 -> 소문자 변환
    // 각 단어의 0번째/짝수번째 -> 대문자 변환
    // try, hello, world
    // TrY, HeLlO, WoRlD
    static String solutionA(String s) {
        String[] letters = s.split("");
        StringBuilder answer = new StringBuilder();

        int idx = 0; // 각 단어에 대한 인덱스
        for (String letter : letters) {
            if (letter.equals(" ")) {
                answer.append(" ");
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    answer.append(letter.toUpperCase());
                } else {
                    answer.append(letter.toLowerCase());
                }
                idx++;
            }
        }

        return answer.toString();
    }

    /**
     * 채점 결과
     * 정확성: 56.3
     * 합계: 56.3 / 100.0
     */
    static String solutionB(String s) {
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (i % 2 == 0) answer.append(String.valueOf(c).toUpperCase());
                else answer.append(String.valueOf(c).toLowerCase());
            }
            answer.append(" ");
        }


        return answer.toString().trim();
    }
}