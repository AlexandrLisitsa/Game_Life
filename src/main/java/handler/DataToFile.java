package handler;

import config.ConfigFiled;
import game.Game;
import models.Cell;

import java.io.FileWriter;
import java.io.IOException;

public class DataToFile {

    public void toFile(String directory, Game game) {
        ConfigFiled configFiled = game.getConfigFiled();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("height=" + configFiled.getHeight() + System.lineSeparator());
        stringBuilder.append("width=" + configFiled.getWidth() + System.lineSeparator());

        Cell[][] cells = game.getHistory().get(game.getHistory().size() - 1);

        for (int i = 0; i < game.getConfigFiled().getHeight(); i++) {
            for (int j = 0; j < game.getConfigFiled().getWidth(); j++) {
                stringBuilder.append(cells[i][j].getSymbol());
            }
            stringBuilder.append(System.lineSeparator());
        }

        toFile(stringBuilder, directory);
    }

    private void toFile(StringBuilder stringBuilder, String dir) {
        try (FileWriter fileWriter = new FileWriter(dir)) {
            fileWriter.append(stringBuilder.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
