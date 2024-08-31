import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please choose gamemode");
    System.out.println("1: Player vs Player");
    System.out.println("2: Player vs AI (Random)");
    System.out.println("3: Player vs AI (Thoughtful)");
    int gamemode = scan.nextInt();
    while(gamemode != 1 && gamemode != 2 && gamemode != 3)
    {
      System.out.println("Invalid input, please try again.");
      gamemode = scan.nextInt();
    }
    Board game = new Board(gamemode);
    while(game.win() == '-' && game.getTurn() < 9)
    {
      game.displayBoard();
      game.takeTurn();
    }
    game.displayBoard();
    if(game.win() == '-')
    {
      System.out.println("Tied game");
    }
    else
    {
      System.out.println("Player " + game.win() + " wins");
    }
  }
}