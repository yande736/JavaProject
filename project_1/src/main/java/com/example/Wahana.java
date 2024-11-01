package com.example;

import java.util.Scanner;

public class Wahana {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Masukkan tinggi Anda (dalam cm): ");
            int tinggi = sc.nextInt();

            System.out.print("Masukkan umur Anda: ");
            int umur = sc.nextInt();

            System.out.print("Apakah Anda memiliki kondisi jantung? (ya/tidak): ");
            String kondisiJantung = sc.next();

            boolean bolehNaik = true;
            String alasan = "";

            if (tinggi < 150) {
                bolehNaik = false;
                alasan = "Anda harus setidaknya setinggi 150 cm untuk naik wahana.";
            } else if (umur < 12) {
                System.out.print("Apakah Anda didampingi oleh orang dewasa? (ya/tidak): ");
                String denganDewasa = sc.next();
                if (!denganDewasa.equalsIgnoreCase("ya")) {
                    bolehNaik = false;
                    alasan = "Anak-anak di bawah 12 tahun harus didampingi oleh orang dewasa.";
                }
            }

            if (kondisiJantung.equalsIgnoreCase("ya")) {
                bolehNaik = false;
                alasan = "Orang dengan kondisi jantung tidak boleh naik wahana.";
            }

            if (umur > 65) {
                System.out.print("Apakah Anda memiliki surat keterangan dokter? (ya/tidak): ");
                String suratDokter = sc.next();
                if (!suratDokter.equalsIgnoreCase("ya")) {
                    bolehNaik = false;
                    alasan = "Penumpang di atas 65 tahun harus memiliki surat keterangan dokter.";
                }
            }

            if (bolehNaik) {
                System.out.println("Anda diperbolehkan naik wahana.");
            } else {
                System.out.println("Anda tidak diperbolehkan naik wahana karena: " + alasan);
            }
        }
    }
}
