import java.util.Scanner;

public class Player{

  private String name; //name of player
  public String NextMove; //Next Move of current player

  public Player(String aName)
  {
    name = aName;
  }
  public String getName()
  {
    return name;
  }

  public String getNextMove(GameState state)
  {
   Scanner S = new Scanner(System.in);
   System.out.println("What would you like your next move to be? (Please enter in column, row form)");
   NextMove = S.nextLine();
   return NextMove;
  }
  
}