package Java.Goorm.Cos_Pro.Chapter_4.C_분침과_시침의_각도_구하기;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3, 0)); // "90.0"
        System.out.println(solution(6, 0)); // "180.0"
        System.out.println(solution(12, 30)); // "195.0"
    }

    // 12시 = 360도 (1시 = 30도)
    // 60분 = 360도 (1분 =  6도)
    // 12시 30분일 때, 시침은 15도 더 움직인 상태가 된다.
    // 분 각도 -> 30 * 6  = 180도
    // 시 각도 -> 12 * 30 = 360도 + (30 * (180 / 360)) = 375도

    public static String solution(int hour, int minute) {
        float mDegree = minute * 6;
        float hDegree = hour * 30 + (30 * (mDegree / 360f));

        return String.format("%.1f", Math.abs(hDegree - mDegree));
    }
}