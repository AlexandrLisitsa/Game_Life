package models;

import handler.impl.ConfigFiled;

import java.util.ArrayList;
import java.util.Random;

public class Field {

    private ConfigFiled configFiled;

    private ArrayList<Cell> currentGeneration = new ArrayList<Cell>();
    private ArrayList<Cell> secondGeneration = new ArrayList<Cell>();

    public Field(ConfigFiled configFiled){
        this.configFiled=configFiled;

        for (int i = 0; i < configFiled.getHeight(); i++) {
            for (int j = 0; j < configFiled.getWidth(); j++) {
                currentGeneration.add(configFiled.getCells()[i][j]);
            }
        }
    }

    public Field(){
        configFiled=new ConfigFiled();
        configFiled.setHeight(7);
        configFiled.setWidth(12);
        for (int i = 0; i < 7 * 12; i++) {
            Random r = new Random();
            if(r.nextInt(50)>40){
                currentGeneration.add(new Cell(true));
            }else{
                currentGeneration.add(new Cell(false));
            }
        }
    }


    public ArrayList<Cell> getCurrentGeneration() {
        return currentGeneration;
    }

    public ArrayList<Cell> getSecondGeneration() {
        return secondGeneration;
    }

    public ConfigFiled getConfigFiled() {
        return configFiled;
    }
}
