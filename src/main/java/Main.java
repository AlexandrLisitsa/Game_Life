import game.Game;


public class Main {
    public static void main(String[] args) {

    }
    private void startGame(int iteration,Game game){
        for (int i = 0; i < iteration; i++) {
            game.nextGeneration();
        }
    }

}
