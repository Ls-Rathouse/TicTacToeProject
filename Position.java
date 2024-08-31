class Position
  {
    private char gameValue;
    
    public Position()
    {
      gameValue = '-';
    }

    public char getValue()
    {
      return gameValue;
    }

    public void setValue(int turn)
    {
      if(turn % 2 == 0)
      {
        gameValue = 'X';
      }
      else
      {
        gameValue = 'O';
      }
    }
  }