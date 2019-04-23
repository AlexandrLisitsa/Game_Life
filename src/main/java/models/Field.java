package models;

import config.ConfigFiled;

import java.util.Random;

public class Field {

    private ConfigFiled configFiled;

    private Cell[][] currentGeneration;
    private Cell[][] secondGeneration;

    public Field(ConfigFiled configFiled) {
        this.configFiled = configFiled;
        currentGeneration=configFiled.getCells();
        secondGeneration=new Cell[configFiled.getHeight()][configFiled.getWidth()];
    }

    public Field() {
        configFiled = new ConfigFiled();
        configFiled.setHeight(7);
        configFiled.setWidth(12);

        Cell[][] mas = new Cell[7][12];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {
                Random r = new Random();
                if(r.nextInt(100)>70){
                    mas[i][j]=new Cell(true);
                }else{
                    mas[i][j]=new Cell(false);
                }
            }
        }
        currentGeneration=mas;
        secondGeneration=new Cell[7][12];
    }

    public Cell[][] getCurrentGeneration() {
        return currentGeneration;
    }

    public Cell[][] getSecondGeneration() {
        return secondGeneration;
    }

    public ConfigFiled getConfigFiled() {
        return configFiled;
    }

    public void setCurrentGeneration(Cell[][] currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    public void setSecondGeneration(Cell[][] secondGeneration) {
        this.secondGeneration = secondGeneration;
    }
}
