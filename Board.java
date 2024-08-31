import java.util.Scanner;

class Board
  {
    private int gamemode;
    private int turn;
    private Position[][] board;
    private static String valid = "ABC123";

    public Board(int mode)
    {
      gamemode = mode;
      turn = 0;
      board = new Position[3][3];
      for(int i = 0; i < board.length; i++)
        {
          for(int j = 0; j < board[0].length; j++)
            {
              board[i][j] = new Position();
            }
        }
    }

    public int getTurn()
    {
      return turn;
    }

    public void displayBoard()
    {
      System.out.println("- 1 2 3");
      System.out.println("A " + board[0][0].getValue() + " " + board[0][1].getValue() + " " + board[0][2].getValue());
      System.out.println("B " + board[1][0].getValue() + " " + board[1][1].getValue() + " " + board[1][2].getValue());
      System.out.println("C " + board[2][0].getValue() + " " + board[2][1].getValue() + " " + board[2][2].getValue());
    }

    public void takeTurn()
    {
      Scanner scan = new Scanner(System.in);
      String coordinates = "";
      int r = 0;
      int c = 0;
      if(turn % 2 == 0)
      {
        System.out.println("Input position");
        coordinates = scan.next();
        r = valid.indexOf(coordinates.toUpperCase().charAt(0));
        c = valid.indexOf(coordinates.substring(1, 2)) - 3;
while(valid.indexOf(coordinates.toUpperCase().charAt(0)) == -1 || valid.indexOf(coordinates.substring(1, 2)) - 3 == -4 || board[r][c].getValue() != '-')
        {
          System.out.println("Invalid input, please try again.");
          coordinates = scan.next();
          r = valid.indexOf(coordinates.toUpperCase().charAt(0));
          c = valid.indexOf(coordinates.substring(1, 2)) - 3;
        }
        r = valid.indexOf(coordinates.toUpperCase().charAt(0));
        c = valid.indexOf(coordinates.substring(1, 2)) - 3;
        board[r][c].setValue(turn);
      }
      else
      {
        if(gamemode == 1)
        {
          System.out.println("Input position");
          coordinates = scan.next();
          r = valid.indexOf(coordinates.toUpperCase().charAt(0));
          c = valid.indexOf(coordinates.substring(1, 2)) - 3;
while(valid.indexOf(coordinates.toUpperCase().charAt(0)) == -1 || valid.indexOf(coordinates.substring(1, 2)) - 3 == -4 || board[r][c].getValue() != '-')
          {
            System.out.println("Invalid input, please try again.");
            coordinates = scan.next();
            r = valid.indexOf(coordinates.toUpperCase().charAt(0));
            c = valid.indexOf(coordinates.substring(1, 2)) - 3;
          }
          r = valid.indexOf(coordinates.toUpperCase().charAt(0));
          c = valid.indexOf(coordinates.substring(1, 2)) - 3;
          board[r][c].setValue(turn);
        }
        if(gamemode == 2)
        {
          System.out.println("AI's turn");
          r = (int)(Math.random() * 3);
          c = (int)(Math.random() * 3);
          while(board[r][c].getValue() != '-')
          {
            r = (int)(Math.random() * 3);
            c = (int)(Math.random() * 3);
          }
          board[r][c].setValue(turn);
        }
        if(gamemode == 3)
        {
          System.out.println("AI's turn");
          boolean turnUsed = false;
          for(int p = 0; p < 3; p++)
          {
            if(check2(p, 'r', 'O') && !turnUsed)
            {
              for(int i = 0; i < 3; i++)
              {
                if(board[p][i].getValue() == '-')
                {
                  board[p][i].setValue(turn);
                  turnUsed = true;
                }
              }
            }
            if(check2(p, 'c', 'O') && !turnUsed)
            {
              for(int i = 0; i < 3; i++)
              {
                if(board[i][p].getValue() == '-')
                {
                  board[i][p].setValue(turn);
                  turnUsed = true;
                }
              }
            }
          }
          if(check2(0, 'd', 'O') && !turnUsed)
          {
            for(int i = 0; i < 3; i++)
            {
              if(board[i][i].getValue() == '-')
              {
                board[i][i].setValue(turn);
                turnUsed = true;
              }
            }
          }
          if(check2(2, 'd', 'O') && !turnUsed)
          {
            for(int i = 0; i < 3; i++)
            {
              if(board[i][2 - i].getValue() == '-')
              {
                board[i][2 - i].setValue(turn);
                turnUsed = true;
              }
            }
          }
          for(int p = 0; p < 3; p++)
          {
            if(check2(p, 'r', 'X') && !turnUsed)
            {
              for(int i = 0; i < 3; i++)
              {
                if(board[p][i].getValue() == '-')
                {
                  board[p][i].setValue(turn);
                  turnUsed = true;
                }
              }
            }
            if(check2(p, 'c', 'X') && !turnUsed)
            {
              for(int i = 0; i < 3; i++)
              {
                if(board[i][p].getValue() == '-')
                {
                  board[i][p].setValue(turn);
                  turnUsed = true;
                }
              }
            }
          }
          if(check2(0, 'd', 'X') && !turnUsed)
          {
            for(int i = 0; i < 3; i++)
            {
              if(board[i][i].getValue() == '-')
              {
                board[i][i].setValue(turn);
                turnUsed = true;
              }
            }
          }
          if(check2(2, 'd', 'X') && !turnUsed)
          {
            for(int i = 0; i < 3; i++)
            {
              if(board[i][2 - i].getValue() == '-')
              {
                board[i][2 - i].setValue(turn);
                turnUsed = true;
              }
            }
          }
          if(!turnUsed)
          {
            r = (int)(Math.random() * 3);
            c = (int)(Math.random() * 3);
            while(board[r][c].getValue() != '-')
            {
              r = (int)(Math.random() * 3);
              c = (int)(Math.random() * 3);
            }
            board[r][c].setValue(turn);
          }
        }
      }
      turn++;
    }

    public char win()
    {
      if(board[0][0].getValue() == 'X' && board[1][1].getValue() == 'X' && board[2][2].getValue() == 'X')
      {
        return 'X';
      }
      if(board[0][0].getValue() == 'O' && board[1][1].getValue() == 'O' && board[2][2].getValue() == 'O')
      {
        return 'O';
      }
      if(board[0][2].getValue() == 'X' && board[1][1].getValue() == 'X' && board[2][0].getValue() == 'X')
      {
        return 'X';
      }
      if(board[0][2].getValue() == 'O' && board[1][1].getValue() == 'O' && board[2][0].getValue() == 'O')
      {
        return 'O';
      }
      for(int i = 0; i < 3; i++)
        {
          if(board[i][0].getValue() == 'X' && board[i][1].getValue() == 'X' && board[i][2].getValue() == 'X')
          {
            return 'X';
          }
          if(board[i][0].getValue() == 'O' && board[i][1].getValue() == 'O' && board[i][2].getValue() == 'O')
          {
            return 'O';
          }
          if(board[0][i].getValue() == 'X' && board[1][i].getValue() == 'X' && board[2][i].getValue() == 'X')
          {
            return 'X';
          }
          if(board[0][i].getValue() == 'O' && board[1][i].getValue() == 'O' && board[2][i].getValue() == 'O')
          {
            return 'O';
          }
        }
      return '-';
    }

    public boolean check2(int placement, char type, char goal)
    {
      int counter = 0;
      if(type == 'r')
      {
        for(int i = 0; i < 3; i++)
        {
          if(board[placement][i].getValue() == goal)
          {
            counter++;
          }
        }
      }
      if(type == 'c')
      {
        for(int i = 0; i < 3; i++)
        {
          if(board[i][placement].getValue() == goal)
          {
            counter++;
          }
        }
      }
      if(type == 'd')
      {
        for(int i = 0; i < 3; i++)
        {
          if(board[i][Math.abs(placement - i)].getValue() == goal)
          {
            counter++;
          }
        }
      }
      if(counter == 2)
      {
        return true;
      }
      return false;
    }
  }