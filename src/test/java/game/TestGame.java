package game;

import config.ConfigFiled;
import models.Cell;
import models.Field;
import org.junit.Assert;
import org.junit.Test;

public class TestGame {

    @Test
    public void testNeighborsCount(){

        ConfigFiled configFiled = new ConfigFiled();
        configFiled.setHeight(10);
        configFiled.setWidth(10);
        Cell[][] cells = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j]=new Cell(true);
            }
        }

        configFiled.setCells(cells);
        Field field = new Field(configFiled);
        Game game = new Game(field);


        int cellNeighborsCount = game.getCellNeighborsCount(1, 1);

        Assert.assertEquals(cellNeighborsCount,8);

    }

}
