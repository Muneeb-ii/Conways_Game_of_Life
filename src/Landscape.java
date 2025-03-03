/*
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class: This class represents a Landscape in the Game of Life.
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;
    
    /*
     * The number of rows in the Landscape
     */
    private int rows;

    /*
     * The number of columns in the Landscape
     * 
     */
    private int columns;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        landscape = new Cell[rows][columns];
        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        this.columns = columns;
        this.rows = rows;
        landscape = new Cell[rows][columns];
        initialChance = chance;
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        landscape = new Cell[this.rows][this.columns];
        initialChance = 0.5;
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(landscape[i][j]);
            }
            System.out.print("\n");
        }
        return "Current Landscape";
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        
        // Top-left corner
        if (row == 0 && col == 0) {
            neighbors.add(landscape[row][col+1]);       // right
            neighbors.add(landscape[row+1][col]);         // below
            neighbors.add(landscape[row+1][col+1]);       // bottom-right
        }
        // Top-right corner
        else if (row == 0 && col == columns - 1) {
            neighbors.add(landscape[row][col-1]);         // left
            neighbors.add(landscape[row+1][col]);         // below
            neighbors.add(landscape[row+1][col-1]);       // bottom-left
        }
        // Bottom-left corner
        else if (row == rows - 1 && col == 0) {
            neighbors.add(landscape[row-1][col]);         // above
            neighbors.add(landscape[row-1][col+1]);       // top-right
            neighbors.add(landscape[row][col+1]);         // right
        }
        // Bottom-right corner
        else if (row == rows - 1 && col == columns - 1) {
            neighbors.add(landscape[row-1][col]);         // above
            neighbors.add(landscape[row-1][col-1]);       // top-left
            neighbors.add(landscape[row][col-1]);         // left
        }
        // Top edge (but not corners)
        else if (row == 0) {
            neighbors.add(landscape[row][col-1]);         // left
            neighbors.add(landscape[row][col+1]);         // right
            neighbors.add(landscape[row+1][col-1]);       // bottom-left
            neighbors.add(landscape[row+1][col]);         // below
            neighbors.add(landscape[row+1][col+1]);       // bottom-right
        }
        // Bottom edge (but not corners)
        else if (row == rows - 1) {
            neighbors.add(landscape[row][col-1]);         // left
            neighbors.add(landscape[row][col+1]);         // right
            neighbors.add(landscape[row-1][col-1]);       // top-left
            neighbors.add(landscape[row-1][col]);         // above
            neighbors.add(landscape[row-1][col+1]);       // top-right
        }
        // Left edge (but not corners)
        else if (col == 0) {
            neighbors.add(landscape[row-1][col]);         // above
            neighbors.add(landscape[row-1][col+1]);       // top-right
            neighbors.add(landscape[row][col+1]);         // right
            neighbors.add(landscape[row+1][col]);         // below
            neighbors.add(landscape[row+1][col+1]);       // bottom-right
        }
        // Right edge (but not corners)
        else if (col == columns - 1) {
            neighbors.add(landscape[row-1][col]);         // above
            neighbors.add(landscape[row-1][col-1]);       // top-left
            neighbors.add(landscape[row][col-1]);         // left
            neighbors.add(landscape[row+1][col-1]);       // bottom-left
            neighbors.add(landscape[row+1][col]);         // below
        }
        // General case (not on any boundary)
        else {
            neighbors.add(landscape[row-1][col-1]);       // top-left
            neighbors.add(landscape[row-1][col]);         // above
            neighbors.add(landscape[row-1][col+1]);       // top-right
            neighbors.add(landscape[row][col-1]);         // left
            neighbors.add(landscape[row][col+1]);         // right
            neighbors.add(landscape[row+1][col-1]);       // bottom-left
            neighbors.add(landscape[row+1][col]);         // below
            neighbors.add(landscape[row+1][col+1]);       // bottom-right
        }
        
        return neighbors;
    }
    
    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
    }
}