package com.example;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 9;

        List<int[]> result = findSubarraysWithSum(numbers, target);

        if (result.isEmpty()) {
            System.out.println("Tidak ada subarray yang memenuhi target sum.");
        } else {
            for (int[] subarray : result) {
                System.out.print("Indeks: [" + subarray[0] + ", " + subarray[1] + "] ");
                System.out.print("Elemen: ");
                for (int i = subarray[0]; i <= subarray[1]; i++) {
                    System.out.print(numbers[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static List<int[]> findSubarraysWithSum(int[] numbers, int target) {
        List<int[]> subarrays = new ArrayList<>();
        
        for (int start = 0; start < numbers.length; start++) {
            int sum = 0;
            for (int end = start; end < numbers.length; end++) {
                sum += numbers[end];

                if (sum == target) {
                    subarrays.add(new int[]{start, end});
                }
            }
        }

        return subarrays;
    }
}
