//package Java.Programmers.Level_1.신고_결과_받기;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class Solution {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(
//                new String[]{"a", "b", "c", "d"},
//                new String[]{"a b", "c b", "b d", "a d", "c a"}, 2)
//        )); // "[2, 1, 1, 0]"
//        System.out.println(Arrays.toString(solution(
//                new String[]{"a", "b"},
//                new String[]{"b a", "b a", "b a", "b a"}, 3)
//        )); // "[0, 0]"
//    }
//
//    static int[] solution(String[] users, String[] reports, int k) {
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String report : reports) {
//            String[] temp = report.split(" ");
//            map.put(temp[0], 1);
//        }
//
//        int[] answer = {};
//        return answer;
//    }
//}