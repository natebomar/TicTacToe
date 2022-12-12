class Main{
  public static void main(String[] args) {
    GameState joe = new TTT(); //TBD parameters
    GameDriver mary = new GameDriver(joe);
    mary.play();

  }
}