package game.tictaictoe;

public abstract class Game {
  abstract void startGame();
  abstract boolean checkWinner();
  abstract void displayBoard();
}
