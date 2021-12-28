package Java.Goorm.Cos_Pro.Chapter_2.C_로봇을_움직여주세요;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("URDDL")));
    }

    public static int[] solution(String commands) {
        int[] answer = {0, 0};

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'U') answer[1] = answer[1] + 1; // {+0, +1}
            if (command == 'R') answer[0] = answer[0] + 1; // {+0, +1}
            if (command == 'D') answer[1] = answer[1] - 1; // {+0, -1}
            if (command == 'L') answer[0] = answer[0] - 1; // {-1, +0}
        }

        return answer;
    }
}