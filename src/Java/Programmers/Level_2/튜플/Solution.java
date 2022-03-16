package Java.Programmers.Level_2.튜플;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solutionA("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(solutionA("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(solutionA("{{20,111},{111}}"))); // [111, 20]
        System.out.println(Arrays.toString(solutionA("{{123}}"))); // [123]
        System.out.println(Arrays.toString(solutionA("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); // [3, 2, 4, 1]
    }

    static int[] solutionA(String s) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        // 아래의 1번 과정
        String[] tuples = s.substring(1, s.length() - 1)
                           .split(",\\{");

        // 2, 3번 과정
        tuples = Arrays.stream(tuples).map(tuple -> tuple
                .replaceAll("\\{", "")
                .replaceAll("}", ""))
                .toArray(String[]::new);

        // 4번 과정
        Arrays.sort(tuples, (s1, s2) -> s1.length() - s2.length());

        // 5번 과정
        for (String tuple : tuples) {
            for (String num : tuple.split(",")) {
                map.put(Integer.parseInt(num), 1);
            }
        }

        return map.keySet().stream().mapToInt(key -> key).toArray();
    }

    // "{{1,2,3},{2,1},{1,2,4,3},{2}}"

    // 1) "{1,2,3},{2,1},{1,2,4,3},{2}"          (가장 왼쪽, 오른쪽의 중괄호를 제외한다.)
    // 2) [{2}, 2,1}, 2,1,3}, 2,1,3,4}]          (",{"으로 구분해서 배열을 만든다.)
    // 3) [2, 2,1, 2,1,3, 2,1,3,4]               ("{", "}" 문자열을 빈 문자열로 치환한다.)
    // 4) [2, 2,1, 1,2,3, 1,2,4,3]으로 정렬한다. (길이 기준)

    // 5) 각 튜플에서 없는 숫자를 뽑고 배열에 저장한다.
//    static int[] solutionB(String s) {
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//        String[] tuples = s.substring(1, s.length() - 1)
//                           .split(",\\{");
//        for (int i = 0; i < tuples.length; i++) {
//            tuples[i] = tuples[i].replaceAll("\\{", "")
//                                 .replaceAll("}", "");
//        }
//
//        Arrays.sort(tuples, (s1, s2) -> s1.length() - s2.length());
//        // Arrays.sort(tuples, Comparator.comparingInt(String::length));
//
//        for (String tuple : tuples) {
//            for (String num : tuple.split(",")) {
//                map.put(Integer.parseInt(num), 1);
//            }
//        }
//
//        return map.keySet().stream().mapToInt(key -> key).toArray();
//    }

    // {{1,2,3},{2,1},{1,2,4,3},{2}}
    // 중괄호를 모두 소거하고 콤마 기호로 구분한다.
    // 1, 2, 3, 2, 1, 1, 2, 4, 3, 2
    // 맵에 키와 개수로 저장하고 키를 배열로 반환한다.
//    static int[] solutionC(String tuples) {
//        int[] answer = {};
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//
//        // {, +, *, ^ 등의 기호는 \\ 문자열을 추가한다.
//        String[] nums = tuples.replaceAll("\\{", "")
//                              .replaceAll("}", "")
//                              .split(",");
//
//        for (String num : nums) {
//            map.put(Integer.parseInt(num), 1);
//        }
//
//        return map.keySet().stream().mapToInt(key -> key).toArray();
//    }
}