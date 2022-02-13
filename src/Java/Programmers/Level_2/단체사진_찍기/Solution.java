package Java.Programmers.Level_2.단체사진_찍기;

import java.util.Arrays;
import java.util.HashMap;

// https://jisunshine.tistory.com/145
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"})); // 3648
        init();
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"})); // 0
    }

    // n: 입력 조건의 개수 (1 이상 100 이하), data: n개의 입력 조건

    // 입력 조건 설명
    // 1번째, 3번째 글자는 A, C, F, J, M, N, R, T에 속한다. (어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브)
    // 2번째 글자는 항상 ~이다.
    // 4번째 글자는 =, <, > 중 1개이다. (같음, 미만, 초과)
    // 5번째 글자는 0 이상 6 이하이며 간격이다. (두 프렌즈 사이에 있는 다른 프렌즈의 개수)

    // 입력 조건 예시
    // M~C<2: 무지는 콘과 간격이 2 미만
    // C~M>1: 콘은 무지와 간격이 1 초과

    static int answer = 0;
    static int[] list = new int[8];
    static int[] visited = new int[8];
    static String[] conditions;
    static HashMap<Character, Integer> friends = new HashMap<>(){{
        put('A', 0); put('C', 1); put('F', 2); put('J', 3);
        put('M', 4); put('N', 5); put('R', 6); put('T', 7);
    }};

    static int solution(int n, String[] data) {
        conditions = Arrays.copyOf(data, data.length);
        perm(0);

        return answer;
    }

    // 8명을 1줄로 세운 조합의 개수를 찾는다.
    static void perm(int cnt) {
        if (cnt == 8) {
            if (check()) answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            list[cnt] = i;
            perm(cnt + 1);
            visited[i] = 0;
        }
    }

    // 입력 조건을 확인한다.
    static boolean check() {
        for (String c : conditions) {
            int f1 = list[friends.get(c.charAt(0))];
            int f2 = list[friends.get(c.charAt(2))];
            char op = c.charAt(3);
            int dt = c.charAt(4) - '0' + 1;

            int distance = Math.abs(f1 - f2);
            if (op == '=') {
                if (distance != dt) return false;
            } else if (op == '>') {
                if (distance <= dt) return false;
            } else if (op == '<') {
                if (distance >= dt) return false;
            }
        }

        return true;
    }

    static void init() {
        answer = 0;
        list = new int[8];
        visited = new int[8];
    }
}