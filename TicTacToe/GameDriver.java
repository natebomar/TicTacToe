class GameDriver {
  private GameState state;

  public GameDriver(GameState initial) {
    state = initial;
  }

  public void play() {
    System.out.print(state.toString());

    while (!(state.isGameOver())) {

      state.makeMove((state.getCurrentPlayer()).getNextMove(state));

      System.out.print(state.toString());
    }
    // state.getWinner();
    if(state.getWinner() == null){
        System.out.print("It's a draw!");
    }
    else{
        System.out.println(state.getWinner().getName()+" is the winner");
    }
  }
}
// boolean isGameOver();
// Player GetWinner();
// Player getCurrentPlayer();
// ArrayList<String> getCurrentMoves();
// void makeMove(String move);
// String toString();