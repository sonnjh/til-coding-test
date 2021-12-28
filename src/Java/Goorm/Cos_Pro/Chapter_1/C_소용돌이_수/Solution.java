package Java.Goorm.Cos_Pro.Chapter_1.C_소용돌이_수;

public class Solution {
    public static void main(String[] args) {
        // [ 1][ 2][ 3][ 4]
        // [12][13][14][ 5]
        // [11][16][15][ 6]
        // [10][ 9][ 8][ 7]
        System.out.println(solution(4)); // 1 + 13 + 15 + 7 = 36 (대각선 합계)

        // [1][2][3]
        // [8][9][4]
        // [7][6][5]
        System.out.println(solution(3)); // 1 + 9 + 5 = 15

        // [1][2]
        // [4][3]
        System.out.println(solution(2)); // 1 + 3 = 4
    }

    public static int solution(int n) {
        int[][] arr = new int[n][n]; // 맵 생성
        int dir = 0;                 // 방향 지정 (0: Right, 1: Down, 2: Left, 3: Up)
        int i = 0, j = 0;            // 시작 위치의 좌표 지정
        int num = 1;                 // 시작 위치의 값 지정

        while (true) {
            arr[i][j] = num;
            System.out.printf("[%d][%d] = %d\n", i, j, num);

            // [0][0], [0][1], [0][2]
            // [1][0], [1][1], [1][2]
            // [2][0], [2][1], [2][2]
            // 방향 전환 (Right -> Down)
            if (dir == 0 && (j == n-1 || arr[i][j+1] != 0)) dir = 1;
                // 방향 전환 (Down -> Left)
            else if (dir == 1 && (i == n-1 || arr[i+1][j] != 0)) dir = 2;
                // 방향 전환 (Left -> Up)
            else if (dir == 2 && (j == 0 || arr[i][j-1] != 0)) dir = 3;
                // 방향 전환 (Up -> Right)
            else if (dir == 3 && (i == 0 || arr[i-1][j] != 0)) dir = 0;
            // 이미 값을 채운 좌표에 값을 덮어쓰지 않도록 ? != 0 조건을 추가한다.

            // 좌표 이동
            if (dir == 0) j++;
            else if (dir == 1) i++;
            else if (dir == 2) j--;
            else i--; // else if (dir == 3) i--;

            // 3 * 3 크기일 때 9가 종료 조건이다.
            if (num == (n * n)) break;
            num++;
        }

        int answer = 0;
        // 대각선 합을 구한다.
        for (int k = 0; k < n; k++) {
            answer += arr[k][k];
        }
        return answer;
    }
}