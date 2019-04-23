package game;


import handler.ConfigFiled;
import models.Cell;
import models.Field;

import java.util.ArrayList;


public class Game {

    private Field field;

    private ArrayList<ArrayList<Cell>> history = new ArrayList<>();

    public Game(Field field){
        this.field=field;
    }

    public void nextGeneration(){
        for (int j = 0; j < field.getCurrentGeneration().size(); j++) {
            int cellNeighborsCount = getCellNeighborsCount2(j);
            Cell cell = field.getCurrentGeneration().get(j);

            if((cell.isAlive())&&cellNeighborsCount>3||cellNeighborsCount<2){
                field.getSecondGeneration().add(new Cell(false));
            }
            else if((cell.isAlive())&&cellNeighborsCount==2||cellNeighborsCount==3){
                field.getSecondGeneration().add(new Cell(true));
            }
            else if((!cell.isAlive()&&cellNeighborsCount==3)){
                field.getSecondGeneration().add(new Cell(true));
            }
            else if((!cell.isAlive())&&cellNeighborsCount<3||cellNeighborsCount>3){
                field.getSecondGeneration().add(new Cell(false));
            }
        }
        drawField();
        replaceCellsArray();
        history.add(field.getCurrentGeneration());
    }

    private void drawField() {
        int counter=0;
        for (Cell cell : field.getCurrentGeneration()) {
            System.out.print(cell.getSymbol());
            counter++;
            if(counter>field.getConfigFiled().getWidth()-1){
                System.out.println();
                counter=0;
            }
        }
        System.out.println();
        System.out.println();
    }

    private void replaceCellsArray() {
        field.getCurrentGeneration().clear();
        field.getCurrentGeneration().addAll(field.getSecondGeneration());
        field.getSecondGeneration().clear();
    }


    private int getCellNeighborsCount2(int cell_position){
        int counter=0;
        for(int i=(field.getConfigFiled().getWidth()*-1);
                i<field.getConfigFiled().getWidth()*2;
                i+=field.getConfigFiled().getWidth()){
            int startPos=-1;
            int endPos=2;
            if(cell_position%field.getConfigFiled().getWidth()==0)startPos=0;
            else if((cell_position+1)%(field.getConfigFiled().getWidth())==0)endPos=1;
            else if(cell_position==0){
             startPos=-1;endPos=2;
            }
            for (int j=startPos;j<endPos;j++){
                int expression=cell_position-i+j;
                if(expression>=0&&expression<field.getCurrentGeneration().size()-1){
                    if(field.getCurrentGeneration().get(expression).isAlive()&&expression!=cell_position){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    private int getCellNeighborsCount(int cell_position){
        int counter=0;
        ConfigFiled configFiled = field.getConfigFiled();
        for (int i = -1; i < 2; i++) {
            if(cell_position-configFiled.getWidth()-i>=0&&
                    cell_position-configFiled.getWidth()-i< field.getCurrentGeneration().size()&&
                    field.getCurrentGeneration().get(cell_position-configFiled.getWidth()-i).isAlive()){
                counter++;
            }
            if(cell_position+configFiled.getWidth()-i>=0&&
                    cell_position+configFiled.getWidth()-i< field.getCurrentGeneration().size()&&
                    field.getCurrentGeneration().get(cell_position+configFiled.getWidth()-i).isAlive()){
                counter++;
            }
        }
        if(cell_position-1>=0&&
                cell_position+1< field.getCurrentGeneration().size()&&
                field.getCurrentGeneration().get(cell_position-1).isAlive()){
            counter++;
        }
        if(cell_position-1>=0&&
                cell_position+1< field.getCurrentGeneration().size()&&
                field.getCurrentGeneration().get(cell_position+1).isAlive()){
            counter++;
        }
        return counter;
    }

    public ArrayList<ArrayList<Cell>> getHistory() {
        return history;
    }

    public ConfigFiled getConfigFiled(){
        return field.getConfigFiled();
    }

}
