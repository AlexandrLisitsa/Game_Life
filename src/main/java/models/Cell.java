package models;

public class Cell {

    private boolean isAlive;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public Cell(boolean alive){
        setAlive(alive);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        if(alive){
            symbol="O";
        }else{symbol="X";}
        isAlive = alive;
    }
}
