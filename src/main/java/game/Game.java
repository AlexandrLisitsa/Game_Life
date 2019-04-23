package game;


import config.ConfigFiled;
import models.Cell;
import models.Field;

import java.util.ArrayList;


public class Game {

    private Field field;

    private ArrayList<Cell[][]> history = new ArrayList<>();

    public Game(Field field) {
        this.field = field;
    }

    public void nextGeneration() {
        int height = field.getConfigFiled().getHeight();
        int width = field.getConfigFiled().getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int nCnt = getCellNeighborsCount(i, j);
                Cell cell = field.getCurrentGeneration()[i][j];
                if (cell.isAlive() && (nCnt == 2 || nCnt == 3)) {
                    putCellOnSecondGeneration(i, j, new Cell(true));
                } else if (cell.isAlive() && (nCnt < 2 || nCnt > 3)) {
                    putCellOnSecondGeneration(i, j, new Cell(false));
                } else if (!cell.isAlive() && nCnt == 3) {
                    putCellOnSecondGeneration(i, j, new Cell(true));
                } else {
                    putCellOnSecondGeneration(i, j, new Cell(false));
                }
            }
        }
        history.add(field.getSecondGeneration());
        replaceCellsArray();
    }

    private void replaceCellsArray() {
        field.setCurrentGeneration(field.getSecondGeneration());
        field.setSecondGeneration(new Cell[field.getConfigFiled().getHeight()][field.getConfigFiled().getWidth()]);
    }


    int getCellNeighborsCount(int height, int width) {
        int counter = 0;
        for (int i = height - 1; i < height + 2; i++) {
            for (int k = width - 1; k < width + 2; k++) {
                if ((i >= 0 && i < field.getConfigFiled().getHeight()) &&
                        (k >= 0 && k < field.getConfigFiled().getWidth())) {
                    if (i == height && k == width) continue;
                    if (field.getCurrentGeneration()[i][k].isAlive()) counter++;
                }
            }
        }
        return counter;
    }


    public ArrayList<Cell[][]> getHistory() {
        return history;
    }

    public ConfigFiled getConfigFiled() {
        return field.getConfigFiled();
    }

    private void putCellOnSecondGeneration(int height, int width, Cell cell) {
        field.getSecondGeneration()[height][width] = cell;
    }

}
