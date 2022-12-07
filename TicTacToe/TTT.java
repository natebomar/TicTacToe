import java.util.ArrayList;
import pkg.*;
public class TTT implements GameState {
  private String[][] grid;
  private Player p1;
  private Player p2;
  private String default_val;
  private ArrayList<String> moves;
  private int playerCoin;
  private Player winner;

  public TTT() {
    grid = new String[3][3];
    default_val = "_";
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        grid[row][col] = default_val;
      }
    } // established "_" as default value in grid 2D
    this.p1 = new Player("Player 1(X)");
    this.p2 = new Player("Player 2(O)");
    // defines avaliable moves
    moves = new ArrayList<String>();
    // adding possible moves
    moves.add("1,1");
    moves.add("1,2");
    moves.add("1,3");
    moves.add("2,1");
    moves.add("2,2");
    moves.add("2,3");
    moves.add("3,1");
    moves.add("3,2");
    moves.add("3,3");
    playerCoin = 1;
  }

  public boolean isGameOver(){
      
      for(int row = 0; row < grid.length; row++){
          if((grid[row][0].equals(grid[row][1])) && (grid[row][1].equals(grid[row][2]))){
              if(!(grid[row][0].equals(default_val))){
                  winner = getCurrentPlayer();
                  return true;
              }
          }
      }
      for(int col = 0; col < grid[0].length; col++){
          if((grid[0][col].equals(grid[1][col])) && (grid[1][col].equals(grid[2][col]))){
              if(!(grid[0][col].equals(default_val))){
                  winner = getCurrentPlayer();
                    return true;
                }
            }
      }
     if(!(grid[1][1].equals(default_val))){
       if((grid[0][0].equals(grid[1][1])) && (grid[2][2].equals(grid[1][1]))){
         winner = getCurrentPlayer();
         return true;
       }
       else if((grid[0][2].equals(grid[1][1])) && (grid[2][0].equals(grid[1][1]))){
           winner = getCurrentPlayer();
         return true;
       }
     }
     if(moves.isEmpty()){
          winner = null;
          return true;
      }
    return false;
}

  // moves will be given as String: row, column
  // ex: "1, 2"
  public void makeMove(String move) {
    // take in {row}, {col}, split at comma
    if (moves.contains(move)) {
      int comma_pos = move.indexOf(",");
      String row_move = move.substring(0, comma_pos);
      String col_move = move.substring(comma_pos + 1, move.length());
      int r = Integer.parseInt(row_move);
      int c = Integer.parseInt(col_move);
      System.out.println(r + " " + c);
      if (getCurrentPlayer().getName().equals("Player 1(X)")) {
        grid[r - 1][c - 1] = "X";
      } else {
        grid[r - 1][c - 1] = "O";
      }

    // removes move from arraylist (adrianna)
    int indexOfMove = -1;
    for (int i = 0; i < moves.size(); i++) {
      if (moves.get(i).indexOf(move) != -1) {
        indexOfMove = i;
      }
    }
    moves.remove(indexOfMove);
    if(!(isGameOver())){
        playerCoin++;
    }
    }
    else{
        System.out.println("Invalid move, please try again");
    }
  }

  public Player getWinner() {
      return winner;
  }

  public Player getCurrentPlayer() {
    // if playercoin is an odd number, returns player 1
    if (playerCoin % 2 != 0) {
      return p1;
    }
    // if playercoin is even, returns player 2
    else {
      return p2;
    }

  }

  public ArrayList<String> getCurrentMoves() {
    return moves;
  }

  public String toString() {
    String template = "      1      2     3\n";
    for (int c = 0; c < grid[0].length; c++) {
      template += (c + 1) + "   ";
      for (int r = 0; r < grid.length; r++) {
        if (c < grid[0].length) {
          template += "_ " + grid[r][c] + " _";
        } else {
          template += "  " + grid[r][c] + "  ";
        }
        if (r < grid.length - 1) {
          template += "| ";
        }
      }
      template += "\n";
    }
    return template;
  }
}