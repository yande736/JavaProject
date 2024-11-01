package com.example;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int k = 2;
        String direction = "right";

        System.out.println("Array sebelum rotasi: " + Arrays.toString(numbers));
        
        int[] rotatedArray = rotateArray(numbers, k, direction);
        
        System.out.println("Array setelah rotasi: " + Arrays.toString(rotatedArray));
    }

    public static int[] rotateArray(int[] numbers, int k, String direction) {
        int n = numbers.length;
        k = k % n; // Mengatasi kasus k > panjang array

        // Jika arah rotasi ke kanan
        if (direction.equalsIgnoreCase("right")) {
            reverse(numbers, 0, n - 1);
            reverse(numbers, 0, k - 1);
            reverse(numbers, k, n - 1);
        } 
        // Jika arah rotasi ke kiri
        else if (direction.equalsIgnoreCase("left")) {
            reverse(numbers, 0, k - 1);
            reverse(numbers, k, n - 1);
            reverse(numbers, 0, n - 1);
        }
        
        return numbers;
    }

    // Fungsi untuk membalik elemen-elemen array dalam rentang tertentu
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}

