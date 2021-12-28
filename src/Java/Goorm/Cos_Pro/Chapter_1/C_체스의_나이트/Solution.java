package Java.Goorm.Cos_Pro.Chapter_1.C_체스의_나이트;

public class Solution {
    public static void main(String[] args) {
        // System.out.println((int) 'A');      // 'A' -> 65(아스키 코드)
        // System.out.println((char) 1 + '0'); // '1' -> 49(아스키 코드)

        // [A8][B8][C8][D8][E8][F8][G8][H8]
        // [A7][B7][C7][D7][E7][F7][G7][H7]
        // [A6][B6][C6][D6][E6][F6][G6][H6]
        // [A5][B5][C5][D5][E5][F5][G5][H5]
        // [A4][B4][C4][D4][E4][F4][G4][H4]
        // [A3][B3][C3][D3][E3][F3][G3][H3]
        // [A2][B2][C2][D2][E2][F2][G2][H2]
        // [A1][B1][C1][D1][E1][F1][G1][H1]
        // A7 위치일 때 C8, C6, B5 위치로 이동할 수 있다.
        // D5 위치일 때 E7, F6, F4, E3, C3, B4, B6, C7 위치로 이동할 수 있다.
        System.out.println(solution("A7"));
    }

    public static int solution(String pos) {
        int answer = 0;
        // Left:  -1, 0
        // Right: +1, 0
        // Up:    0, +1
        // Down:  0, -1
        // D5 위치일 때 E7, F6, F4, E3, C3, B4, B6, C7 위치 이동 순서로 가정했다.
        // int[][] dir = {{+1, +2}, {+2, +1}, {+2, -1}, {+1, -2}, {-1, -2}, {-2, -1}, {-2, +1}, {-1, +2}};
        int[] dx = {+1, +2, +2, +1, -1, -2, -2, -1};
        int[] dy = {+2, +1, -1, -2, -2, -1, +1, +2};

        // pos = A8, H1일 때 [0, 0], [7, 7]로 변환한다. (A7일 때 [0, 1])
        int x = Math.abs(pos.charAt(0) - 'A');
        int y = Math.abs(pos.charAt(1) - '8');
        System.out.printf("[%d, %d]\n", x, y);

        // 이동했을 때 좌표가 유효한 좌표인지 확인한다.
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > 7 || ny < 0 || ny > 7) continue;
            answer++;
        }

        return answer;
    }
}