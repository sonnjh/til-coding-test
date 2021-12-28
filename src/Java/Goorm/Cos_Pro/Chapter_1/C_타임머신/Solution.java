package Java.Goorm.Cos_Pro.Chapter_1.C_타임머신;

public class Solution {
    public static void main(String[] args) {
        // 9,949,999 + 1 = 9,950,000
        // 9,951,111
        System.out.println(solution(9949999));
    }

    public static long solution(long num) {
        num++;
        String s = Long.toString(num);
        s = s.replaceAll("0", "1");
        return Long.parseLong(s);
    }
}