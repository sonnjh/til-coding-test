package Java.Programmers.Level_2.짝지어_제거하기;

import java.util.Stack;

/**
 * 채점 결과
 * 정확성: 60.2
 * 효율성: 39.8
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("baabaa")); // 1
        System.out.println(solution("cdcd")); // 0
    }

    // 왼쪽에서부터 같은 알파벳 2개씩 짝지어서 소거한다.
    // "baabaa" (b 'aa' baa)
    // "bbaa"   ('bb')
    // "aa"     ('aa')
    // ""

    // c = b -> [b]
    // c = a -> [b, a]
    // c = a -> [b]
    // c = b -> []
    // c = a -> [a]
    // c = a -> []

    static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}