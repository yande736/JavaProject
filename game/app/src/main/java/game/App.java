package game;

import java.util.Scanner;
import game.tictaictoe.TicTacToe;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Selamat datang di Tic-Tac-Toe!");
            System.out.println("Pilih mode yang di inginkan:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");

            int choice = -1;
            while (choice != 1 && choice != 2) {
                System.out.print("Masukan pilihan anda (1 or 2): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice != 1 && choice != 2) {
                        System.out.println("pilihan invalid! tolong masukan no. 1 or 2.");
                    }
                } else {
                    System.out.println("Invalid input! tolong masukan number");
                    scanner.next();
                }
            }

            boolean isComputer = choice == 2;
            TicTacToe game = new TicTacToe(isComputer, scanner);
            game.startGame();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred:");
            e.printStackTrace(); 
        }
    }

    public Object getGreeting() {
        throw new UnsupportedOperationException("Unimplemented method 'getGreeting'");
    }
}
