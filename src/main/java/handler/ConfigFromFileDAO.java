package handler;

import config.ConfigFiled;
import models.Cell;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class ConfigFromFileDAO {
    public ConfigFiled getConfig() {
        ConfigFiled configFiled = new ConfigFiled();
        int height=0;
        int width=0;

        try(InputStream is = ConfigFromFileDAO.class.getClassLoader().getResourceAsStream("gameConfig.properties")){
            Properties properties = new Properties();
            properties.load(is);
            height=Integer.valueOf(properties.getProperty("height"));
            width= Integer.valueOf(properties.getProperty("width"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        configFiled.setWidth(width);
        configFiled.setHeight(height);
        configFiled.setCells(getCellsFromFile(height,width));
        return configFiled;
    }

    private Cell[][] getCellsFromFile(int height,int width) {
        Cell[][] cells = new Cell[height][width];

        int iter=0;
        Scanner scanner = new Scanner(ConfigFromFileDAO.class.getClassLoader().getResourceAsStream("cellsMatrix"));
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]=='X'){
                    cells[iter][i]=new Cell(false);
                }else if(chars[i]=='O'){
                    cells[iter][i]=new Cell(true);
                }
            }
            iter++;
        }
        return cells;
    }
}
