package game.tictaictoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends Game{
  private char[][] board;
  private char currentPlayer;
  private boolean isComputer;
  private Scanner scanner;

public TicTacToe(boolean isComputer, Scanner scanner){
  this.isComputer = isComputer;
  this.scanner = scanner;
  this.board = new char[3][3];
  this.currentPlayer = 'X';
  initializeBoard();
}

private void initializeBoard() {
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      board[i][j] ='-';
    }
  }
}

@Override
public void startGame() {
  System.out.println("selamat datatang di game Tic Tac Toe!");
  boolean isGameRunning = true;
  while (isGameRunning) {
    displayBoard();
    if (currentPlayer == 'X' || !isComputer) {
      playerMove();
    } else {
      computerMove();
    }
    
    if (checkWinner()) {
      displayBoard();
      System.out.println("Player " + currentPlayer + " menang!");
      isGameRunning = false;
    } else if (isBoardFull()) {
      displayBoard();
      System.out.println("Permainan berakhir seri!");
      isGameRunning = false;
    } else {
      switchPlayer();
      }
  }
}

@Override
public void displayBoard() {
  System.out.println("-------------");
  for (int i = 0; i < 3; i++) {
    System.out.print("| ");
    for (int j = 0; j < 3; j++) {
      System.out.print(board[i][j] + " | ");
    }
    System.out.println();
    System.out.println("-------------");
  }
}

private void playerMove() {
  int row = -1, col = -1;

  while (true) {
      try {
          System.out.println("Player " + currentPlayer + ", masukan langkah mu (row dan column: 1-3): ");
          
          if (scanner.hasNextInt()) {
              row = scanner.nextInt() - 1;
          } else {
              System.out.println("Invalid input! masukan angka di row.");
              scanner.next();
              continue;
          }

          if (scanner.hasNextInt()) {
              col = scanner.nextInt() - 1;
          } else {
              System.out.println("Invalid input! masukan angka di column.");
              scanner.next();
              continue;
          }

          // Validasi langkah
          if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
              board[row][col] = currentPlayer;
              break;
          } else {
              System.out.println("langkah tidak valid, coba lagi");
          }
      } catch (Exception e) {
          System.out.println("An error occurred. Please try again.");
          scanner.next();
      }
  }
}

private void computerMove() {
  Random random = new Random();
  int row, col;
  System.out.println("Computer is move");
    while (true) {
        row = random.nextInt(3);
        col = random.nextInt(3);
        if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
        }
    }
}

@Override
public boolean checkWinner() {
   // Check rows dan columns
   for (int i = 0; i < 3; i++) {
    if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
        (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
        return true;
    }
}

// Check diagonals
if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
    (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
    return true;
}

return false;
  }

  private boolean isBoardFull() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == 'X')? 'O' : 'X';
  }
}