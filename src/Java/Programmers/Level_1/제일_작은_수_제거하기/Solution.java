package Java.Programmers.Level_1.제일_작은_수_제거하기;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solutionB(new int[]{10}))); // [-1]
        System.out.println(Arrays.toString(solutionB(new int[]{4, 3, 2, 1}))); // [4, 3, 2]
        System.out.println(Arrays.toString(solutionB(new int[]{3, 4, 1, 2}))); // [3, 4, 2]
        System.out.println(Arrays.toString(solutionB(new int[]{1, 1, 1, 1}))); // [-1]
    }

    static int[] solutionA(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : arr) set.add(num);

        int min = arr[0];
        for (int num : set) {
            if (num < min) {
                min = num;
            }
        }
        set.remove(min);

        return set.isEmpty() ? new int[]{-1} : set.stream().mapToInt(Integer::intValue).toArray();
    }

    static int[] solutionB(int[] arr) {
        int[] copy = Arrays.stream(arr).distinct().toArray();

        int min = copy[0];
        for (int num : copy) {
            if (num < min) {
                min = num;
            }
        }

        int finalMin = min;
        copy = Arrays.stream(arr).filter(i -> i != finalMin).toArray();

        return copy.length == 0 ? new int[]{-1} : copy;
    }
}