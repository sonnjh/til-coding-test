package Java.Goorm.Cos_Pro.Chapter_0.C_내림차순_정렬_횟수;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 1, 2}));
    }

    // 3, 4, 1, 2
    // 3, 4, 2, 1 (1회)
    // 4, 3, 2, 1 (2회)
    // 맨 뒤의 원소부터 내림차순으로 정렬할 때, 바꾼 횟수는 2회이다.

    public static int solution(int[] arr) {
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    count++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        return count;
    }

    // 오름차순/내림차순 버블 정렬
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) { // arr[i] > arr[j]: 오름차순
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}