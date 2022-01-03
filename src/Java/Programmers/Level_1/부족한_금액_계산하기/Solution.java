package Java.Programmers.Level_1.부족한_금액_계산하기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4)); // 10
        System.out.println(solution(5, 50, 5)); // 25
        System.out.println(solution(5, 100, 5)); // 0
    }

    // 이용료 3원 * 4회 : (3 * 1) + (3 * 2) + (3 * 3) + (3 * 4) = 30원
    // 부족한 금액      : 30원 - 20원 = 10원

    // 등차수열의 합 (n: 항의 개수, a: 시작 항, l: 끝 항)
    // = n * (a + l) / 2

    static long solution(int price, int money, int count) {
        long charge = count * (price + ((long) price * count)) / 2;

        if (money < charge) return charge - money;
        else return 0;
    }
}