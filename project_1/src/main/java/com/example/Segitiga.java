package com.example;

import java.util.Scanner;

public class Segitiga {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Masukkan panjang ketiga sisi segitiga:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == b && b == c) {
                System.out.println("Segitiga Sama Sisi");
            } else if (a == b || b == c || a == c) {
                System.out.println("Segitiga Sama Kaki");
            } else {
                System.out.println("Segitiga Sembarang");
            }
        }
    }
}

