import game.Game;
import handler.ConfigFieldHandler;
import handler.DataExportProvider;
import handler.impl.ConfigFromFileDAO;
import handler.IterationHandler;
import handler.impl.DataToFile;
import handler.impl.IterationProviderFromConfig;
import models.Field;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ConfigFieldHandler handler = new ConfigFromFileDAO();
        Field field = new Field(handler.getConfig());
        Game game = new Game(field);
        IterationHandler iterationHandler = new IterationProviderFromConfig();
       // main.startGame(iterationHandler.getIterationCount(),game);
      //  DataExportProvider dataExportProvider = new DataToFile();
      //  dataExportProvider.toFile("C:\\Users\\wypik\\Desktop\\Новый текстовый документ (5).txt",game);
    }
    private void startGame(int iteration,Game game){
        for (int i = 0; i < iteration; i++) {
            game.nextGeneration();
        }
    }

}
