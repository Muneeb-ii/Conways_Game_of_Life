/*
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class: This class represents a Cell in the Game of Life.
 * 
 */

import java.util.ArrayList;

public class Cell {
    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Tests the Cell class.
     * 
     * @param args
     */
    public static void main (String[] args){
        Cell cell = new Cell();
        System.out.println(cell.getAlive() + " == false");
        cell.setAlive(true);
        System.out.println(cell.getAlive() + " == true");
        cell.setAlive(false);
        System.out.println(cell.getAlive() + " == false");
        System.out.println(cell.toString().equals("0"));
    }

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this.alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        this.alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if (alive){
            return "1";
        } else {
            return "0";
        }
    }
}