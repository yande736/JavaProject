package com.example;


public class Catur {
    public static boolean isValidKnightMove(int startX, int startY, int endX, int endY) {
        // Memastikan koordinat berada dalam papan catur 8x8
        if (!isOnBoard(startX, startY) || !isOnBoard(endX, endY)) {
            return false;
        }
        
        // Menghitung selisih perpindahan
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        
        // Kuda bergerak dalam pola L (2 kotak satu arah dan 1 kotak arah lain)
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }
    
    private static boolean isOnBoard(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
    
    // Method untuk menampilkan semua gerakan yang valid untuk posisi kuda tertentu
    public static void showValidMoves(int currentX, int currentY) {
        System.out.println("Gerakan valid untuk kuda di posisi (" + currentX + "," + currentY + "):");
        
        // Semua kemungkinan pergerakan kuda
        int[][] moves = {
            {-2,-1}, {-2,1}, {-1,-2}, {-1,2},
            {1,-2}, {1,2}, {2,-1}, {2,1}
        };
        
        for (int[] move : moves) {
            int newX = currentX + move[0];
            int newY = currentY + move[1];
            
            if (isValidKnightMove(currentX, currentY, newX, newY)) {
                System.out.println("(" + newX + "," + newY + ")");
            }
        }
    }

    // Menambahkan method main
    public static void main(String[] args) {
        // Contoh penggunaan untuk menguji gerakan kuda
        int startX = 3;  // Posisi awal X
        int startY = 3;  // Posisi awal Y
        
        System.out.println("Menguji gerakan kuda dari posisi (3,3)");
        showValidMoves(startX, startY);
        
        // Contoh pengujian gerakan spesifik
        int endX = 5;
        int endY = 4;
        boolean isValid = isValidKnightMove(startX, startY, endX, endY);
        System.out.println("\nGerakan dari (" + startX + "," + startY + ") ke (" + endX + "," + endY + ") adalah " + (isValid ? "valid" : "tidak valid"));
    }
}