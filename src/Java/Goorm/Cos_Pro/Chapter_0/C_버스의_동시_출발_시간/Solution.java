package Java.Goorm.Cos_Pro.Chapter_0.C_버스의_동시_출발_시간;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 8, 20, 5})); // 120
    }

    // 버스1: 6분 간격으로 운행한다. (6, 12, ..., 120)
    // 버스2: 8분 간격으로 운행한다. (8, 16, ..., 120)
    // 버스3: 20분 간격으로 운행한다. (20, 40, ..., 120)
    // 버스4: 5분 간격으로 운행한다. (5, 10, ..., 120)
    // 버스 4대가 동시에 출발하는 시간 간격은 120분이다.

    public static int solution(int[] arr) {
        int gcd = gcd(arr[0], arr[1]);
        int lcm = lcm(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
            lcm = lcm(lcm, arr[i]);
        }

        return lcm;
    }

    // 최소 공배수 = 두 수의 곱 / 두 수의 최대 공약수
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대 공약수
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    // 최대 공약수
    // public static int gcd(int a, int b) {
    //     while (b != 0) {
    //         int c = a % b;
    //         a = b; b = c;
    //     }
    //     return a;
    // }
}
