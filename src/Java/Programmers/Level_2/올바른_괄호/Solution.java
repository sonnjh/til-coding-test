package Java.Programmers.Level_2.올바른_괄호;

import java.util.Stack;

/**
 * 채점 결과
 * 정확성: 69.5
 * 효율성: 30.5
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("()()"));    // true
        System.out.println(solution("(())()"));  // true
        System.out.println(solution(")()("));    // false
        System.out.println(solution("(()("));    // false
        System.out.println(solution("())()(()")); // false
    }

    // 열린 괄호로 시작 -> 닫힌 괄호로 닫혀야 올바른 괄호
    // 닫힌 괄호로 시작 -> 올바르지 않은 괄호

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' && stack.empty()) return false;
            if (c == '(') stack.push(c);
            if (c == ')') stack.pop();
        }

        return stack.isEmpty();
    }
}