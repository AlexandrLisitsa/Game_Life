package handler;

import config.ConfigFiled;
import models.Cell;

import java.util.Scanner;

public class ConfigFieldFromFileDAO {

    public ConfigFiled getConfig() {
        ConfigFiled configFiled = new ConfigFiled();
        Cell[][] mas = null;
        int height = 0;
        int width = 0;

        Scanner scanner = new Scanner(ConfigFieldFromFileDAO.class.getClassLoader().getResourceAsStream("cellsMatrix"));
        int iteration = 0;
        while (scanner.hasNextLine()) {
            String expression = scanner.nextLine();
            if (expression.contains("width")) {
                width = Integer.parseInt(expression.substring(expression.indexOf('=') + 1, expression.length()));
            } else if (expression.contains("height")) {
                height = Integer.parseInt(expression.substring(expression.indexOf('=') + 1, expression.length()));
            } else if (expression.contains("X") || expression.contains("O")) {
                if (height != 0 && width != 0 && mas == null) mas = new Cell[height][width];
                char[] chars = expression.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == 'X') {
                        mas[iteration][i] = new Cell(false);
                    } else if (chars[i] == 'O') {
                        mas[iteration][i] = new Cell(true);
                    }
                }
                iteration++;
            }
        }

        configFiled.setWidth(width);
        configFiled.setHeight(height);
        configFiled.setCells(mas);
        return configFiled;
    }

}
