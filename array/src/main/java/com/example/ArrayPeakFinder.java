package com.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayPeakFinder {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 4, 1, 5, 2};

        List<Integer> peakValues = new ArrayList<>();
        List<Integer> peakPositions = new ArrayList<>();

        // Periksa elemen pertama sebagai kasus khusus
        if (numbers.length > 1 && numbers[0] > numbers[1]) {
            peakValues.add(numbers[0]);
            peakPositions.add(0);
        }

        // Periksa elemen-elemen tengah
        for (int i = 1; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i - 1] && numbers[i] > numbers[i + 1]) {
                peakValues.add(numbers[i]);
                peakPositions.add(i);
            }
        }

        // Periksa elemen terakhir sebagai kasus khusus
        if (numbers.length > 1 && numbers[numbers.length - 1] > numbers[numbers.length - 2]) {
            peakValues.add(numbers[numbers.length - 1]);
            peakPositions.add(numbers.length - 1);
        }

        // Output hasil
        System.out.println("Peak Values: " + peakValues);
        System.out.println("Peak Positions: " + peakPositions);
    }
}

