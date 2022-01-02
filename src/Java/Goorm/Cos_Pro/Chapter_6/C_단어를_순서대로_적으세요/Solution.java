package Java.Goorm.Cos_Pro.Chapter_6.C_단어를_순서대로_적으세요;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA(10, new String[]{"nice", "happy", "hello", "world", "hi"})); // 3
        System.out.println(solutionA(10, new String[]{"apple", "mouse", "keyboard"})); // 3
    }

    // 1: nice_happy
    // 2: hello_____
    // 3: world_hi

    // 1: apple_____
    // 2: mouse_____
    // 3: keyboard

    public static int solutionA(int K, String[] words) {
        int idx = 0;
        int answer = 1;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        do {
            String word = words[idx];

            // 현재 줄에 입력할 수 있는 최대 글자 수를 초과할 경우
            if (temp.length() + word.length() > K) {
                // 입력할 수 있는 글자 수만큼 공백(_)을 입력한다.
                temp.append("_".repeat(K - temp.length()));
                result.append(temp).append("\n");
                temp.setLength(0);
                answer++;
            }

            // 현재 줄에 글자를 입력할 수 있는 경우
            if (temp.length() + word.length() <= K) {
                temp.append(word);
                // 현재 줄에 글자를 더 입력할 수 있는 경우
                if (temp.length() < K) {
                    temp.append("_");
                }
            }

            // 현재 줄에 입력할 수 있는 최대 글자 수를 채워서 개행해야 하는 경우
            if (temp.length() == K) {
                result.append(temp).append("\n");
                temp.setLength(0);
                answer++;
            }

            // 마지막 줄을 result에 저장하기 위한 테스트 코드
            if (idx == words.length - 1) {
                result.append(temp).append("\n");
            }
            idx++;
        } while (idx < words.length);

        System.out.println(result);
        return answer;
    }

    public static int solutionB(int K, String[] words) {
        int idx = 0;
        int answer = 1;
        StringBuilder temp = new StringBuilder();

        do {
            String word = words[idx];
            if (temp.length() + word.length() > K) {
                answer++;
                temp.setLength(0);
            }
            temp.append(word);
            if (temp.length() < K) {
                temp.append("_");
            }
            idx++;
            System.out.println(temp);
        } while (idx < words.length);

        return answer;
    }
}