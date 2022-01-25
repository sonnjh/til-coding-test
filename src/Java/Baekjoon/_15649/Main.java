package Java.Baekjoon._15649;

import java.io.*;
import java.util.*;

public class Main {
    // https://st-lab.tistory.com/114
    // https://iseunghan.tistory.com/241
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new int[N];

        dfs(0);
        System.out.println("v: " + Arrays.toString(visited));
        System.out.println("a: " + Arrays.toString(arr));

        exit();
    }

    // input = 2 2;
    // a = [0, 0];
    // v = [0, 0];
    // dfs(0);
    // i = 0, v[0] = 1, a[0] = 1, dfs(1);                                           // v = [1, 0], a = [1, 0]
    //                            i = 0 (continue);                                 // v = [1, 0], a = [1, 0]
    //                            i = 1, v[1] = 1, a[1] = 2, dfs(2);                // v = [1, 1], a = [1, 2]
    //                                                       out = 1 2 (return);    // v = [1, 1], a = [1, 2]
    //                            i = 1, v[1] = 0;                                  // v = [1, 0], a = [1, 2]
    // i = 0, v[0] = 0;                                                             // v = [0, 0], a = [1, 2]
    //
    // i = 1, v[1] = 1, a[0] = 2, dfs(1);                                           // v = [0, 1], a = [2, 2]
    //                            i = 0, v[0] = 1, a[1] = 1, dfs(2);                // v = [1, 1], a = [2, 1]
    //                                                       out = 2 1 (return);    // v = [1, 1], a = [2, 1]
    //                            i = 0, v[0] = 0;                                  // v = [0, 1], a = [2, 1]
    //                            i = 1 (continue);                                 // v = [0, 1], a = [2, 1]
    // i = 1, v[1] = 0;                                                             // v = [0, 0], a = [2, 1]

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                writer.write(arr[i] + " ");
            }
            writer.write("\n");
            System.out.println("v: " + Arrays.toString(visited));
            System.out.println("a: " + Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            arr[depth] = i + 1;
            dfs(depth + 1);
            visited[i] = 0;
        }
    }

    private static void exit() throws IOException {
        reader.close();
        writer.flush();
        writer.close();
    }

    // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 오름차순으로 출력한다.
    // N: 2, M: 2
    // 1 2
    // 2 1
    // N: 3, M: 3
    // 1 2 3
    // 1 3 2
    // 2 1 3
    // 2 3 1
    // 3 1 2
    // 3 2 1
}