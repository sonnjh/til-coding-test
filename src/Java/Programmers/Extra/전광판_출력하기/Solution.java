package Java.Programmers.Extra.전광판_출력하기;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA(6, "hi bye", 1)); // _____h
        System.out.println(solutionA(6, "hi bye", 3)); // ___hi_
        System.out.println(solutionA(6, "hi bye", 6)); // hi_bye
        System.out.println(solutionB(6, "hi bye", 9)); // bye___
        System.out.println(solutionB(6, "hi bye", 12)); // ______
        System.out.println(solutionB(6, "hi bye", 15)); // ___hi_
    }

    // n: 전광판 개수, text: 출력 문자열, sec: 시간, 공백 문자열은 _로 치환한다.
    // [_][_][_][_][_][_] (n = 6, sec = 0) (0초일 때 ______ 글자가 출력된다.)
    // [_][_][_][_][_][h] (sec = 1) (1초가 지났을 때 _____h 글자가 출력된다.)
    // [_][_][_][h][i][_] (sec = 3) (3초가 지났을 때 ___hi_ 글자가 출력된다.)
    // [h][i][_][b][y][e] (sec = 6) (6초가 지났을 때 hi_bye 글자가 출력된다.)
    // [b][y][e][_][_][_] (sec = 9) (9초가 지났을 때 bye___ 글자가 출력된다.)
    // [_][_][_][_][_][_] (sec = 12) (12초가 지났을 때 ______ 글자가 출력된다.)
    // [_][_][_][h][i][_] (sec = 15) (15초가 지났을 때 ___hi_ 글자가 출력된다.)

    static String solutionA(int n, String text, int sec) {
        StringBuilder sb = new StringBuilder("_".repeat(n).concat(text.replaceAll(" ", "_")));

        // ______hi_bye
        // 0s  -> ______
        // 1s  -> _____h
        // 6s  -> hi_bye
        // 7s  -> i_bye_
        // 8s  -> _bye__
        // 9s  -> bye___
        // 12s -> ______

        for (int i = 0; i < sec; i++) {
            char c = sb.charAt(0);
            sb.append(c);
            sb = new StringBuilder(sb.substring(1));
        }

        return sb.substring(0, text.length());
    }

    static String solutionB(int n, String text, int sec) {
        StringBuilder sb = new StringBuilder("_".repeat(n)); // ______
        text = text.replaceAll(" ", "_").concat("_".repeat(n)); // hi_bye + ______

        // ______, hi_bye______
        // 0s  -> ______
        // 1s  -> _____h
        // 6s  -> hi_bye
        // 7s  -> i_bye_
        // 8s  -> _bye__
        // 9s  -> bye___
        // 12s -> ______

        for (int i = 0; i < sec; i++) {
            char c = text.charAt(i % text.length());
            sb.append(c);
            sb = new StringBuilder(sb.substring(1));
        }

        return sb.substring(0);
    }
}