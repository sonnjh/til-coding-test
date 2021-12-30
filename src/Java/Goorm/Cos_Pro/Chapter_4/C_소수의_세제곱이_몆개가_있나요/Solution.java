package Java.Goorm.Cos_Pro.Chapter_4.C_소수의_세제곱이_몆개가_있나요;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPrimes(6, 30));
        System.out.println(getPrimes(2, 4));
    }

    // a 이상 b 이하인 자연수 중, 소수의 제곱수와 세제곱수의 개수
    // (어떤 소수의 제곱수, 세제곱수는 a 미만, b 초과일 수 없다.)
    // 3의 제곱수   = 9, 5의 제곱수   = 25
    // 2의 세제곱수 = 8, 3의 세제곱수 = 27이므로 4개이다.

    public static int getPrimes(int a, int b) {
        ArrayList<Double> primes = new ArrayList<>();

        for (int i = 2; i <= b; i++) {
            // 소수 찾기
            if (isPrime(i)) {
                // 제곱수, 세제곱수 구하기
                double square = Math.pow(i, 2); // 4, 9, 16, ...
                double cube   = Math.pow(i, 3); // 8, 27, 64, ...
                if (square >= a && square <= b) primes.add(square);
                if (cube >= a && cube <= b) primes.add(cube);
            }
        }

        System.out.println(Arrays.toString(primes.toArray()));
        return primes.size();
    }

    public static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}