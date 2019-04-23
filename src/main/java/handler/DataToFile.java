package handler;

import game.Game;
import models.Cell;

import java.io.FileWriter;
import java.io.IOException;

public class DataToFile {


    public void toFile(String directory, Game game) {
        ConfigFiled configFiled = game.getConfigFiled();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("height="+configFiled.getHeight()+System.lineSeparator());
        stringBuilder.append("width="+configFiled.getWidth()+System.lineSeparator());

        int counter=0;
        for (Cell cell : game.getHistory().get(game.getHistory().size()-1)) {
            stringBuilder.append(cell.getSymbol());
            counter++;
            if(counter>configFiled.getWidth()-1){
                stringBuilder.append(System.lineSeparator());
                counter=0;
            }
        }
        toFile(stringBuilder,directory);
    }

    private void toFile(StringBuilder stringBuilder,String dir){
        try(FileWriter fileWriter = new FileWriter(dir)){
            fileWriter.append(stringBuilder.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
