package Java.Programmers.Level_1.신규_아이디_추천;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        // "bat.y.abcdefghi"
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        // "z--"
        System.out.println(solution("z-+.^."));
        // "aaa"
        System.out.println(solution("=.="));
        // "123_.def"
        System.out.println(solution("123_.def"));
        // "abcdefghijklmn"
        System.out.println(solution("abcdefghijklmn.p"));
    }

    static String solution(String newId) {
        // 1단계: 모든 대문자를 대응되는 소문자로 치환한다.
        String step1 = newId.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거한다.
        StringBuilder step2 = new StringBuilder();
        char[] stepArr1 = step1.toCharArray();
        for (char c : stepArr1) {
            if ('a' <= c && c <= 'z') {
                step2.append(c);
            } else if ('0' <= c && c <= '9') {
                step2.append(c);
            } else if (c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }

        // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환한다.
        // String step3 = step2.toString().replace("..", ".");
        String step3 = step2.toString();
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }

        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거한다.
        String step4 = step3;
        System.out.println(step4);
        if (step4.length() > 0 && step4.charAt(0) == '.') {
            step4 = step4.substring(1);
        }

        if (step4.length() > 0 && step4.charAt(step4.length() - 1) == '.') {
            step4 = step4.substring(0, step4.length() - 1);
        }

        // 5단계: 빈 문자열이라면, newId에 "a"를 대입한다.
        String step5 = step4;
        // if (step5.equals("")) step5 = "a";
        if (step5.length() == 0) {
            step5 = "a";
        }

        // 6단계: 길이가 16자 이상이면, newId의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거한다.
        // (만약 제거 후 마침표(.)가 newId의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거한다.)
        String step6 = step5;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);

            if (step6.charAt(step6.length() - 1) == '.') {
                step6 = step6.substring(0, step6.length() - 1);
            }
        }

        // 7단계: 길이가 2자 이하라면, newId의 마지막 문자를 newId의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        StringBuilder step7 = new StringBuilder(step6);
        if (step7.length() <= 2) {
            char lastChar = step7.charAt(step7.length() - 1);

            while (step7.length() != 3) {
                step7.append(lastChar);
            }
        }

        return step7.toString();
    }
}