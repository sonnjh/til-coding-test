package Java.Programmers.Level_2.JadenCase_문자열_만들기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me")); // "3people Unfollowed Me"
        System.out.println(solution("for the last week"));     // "For The Last Week"
        System.out.println(solution(" aaaaa aaa"));             // " Aaaaa Aaa"
        System.out.println(solution("aaaaa aaa"));             // "Aaaaa Aaa"
    }

    // 공백 문자를 기준으로 문자열을 나눈다.
    // 각 문자열에서 첫 문자가 대문자 또는 숫자일 때, 다음 문자는 소문자를 사용한다.

    static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] letters = s.toLowerCase().split("");
        boolean isUpper  = true;
        boolean isBlank  = s.charAt(0) == ' ';

        for (String letter : letters) {
            if (isBlank) {
                answer.append(letter.toUpperCase());
                isUpper = false;
            } else if (isUpper) {
                answer.append(letter.toUpperCase());
                isUpper = false;
            } else {
                answer.append(letter);
            }

            isBlank = letter.equals(" ");
        }

        return answer.toString();
    }

    // static String solution(String s) {
    //     String[] arr = s.split(" ");
    //
    //     for (int i = 0; i < arr.length; i++) {
    //         char   ch   = arr[i].charAt(0);
    //         String rest = arr[i].substring(1).toLowerCase();
    //
    //         if ('a' <= ch && ch <= 'z') arr[i] = Character.toUpperCase(ch) + rest;
    //     }
    //
    //     return String.join(" ", arr);
    // }
}