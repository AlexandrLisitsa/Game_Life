import game.Game;
import handler.ConfigFieldFromFileDAO;
import handler.DataToFile;
import models.Field;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ConfigFieldFromFileDAO handler = new ConfigFieldFromFileDAO();
        Field field = new Field(handler.getConfig());
        Game game = new Game(field);
        main.startGame(10,game);
        DataToFile dataToFile = new DataToFile();
        dataToFile.toFile("C:\\Users\\wypik\\Desktop\\Новый текстовый документ (5).txt",game);
    }

    private void startGame(int iteration, Game game) {
        for (int i = 0; i < iteration; i++) {
            game.nextGeneration();
        }
    }

}
