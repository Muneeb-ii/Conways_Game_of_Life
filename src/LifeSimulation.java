/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: The class runs a simulation of the Game of Life.
 * It takes command-line parameters in the following order:
 * 1. Number of rows in the grid
 * 2. Number of columns in the grid
 * 3. Initial chance that a cell is alive (as a decimal between 0 and 1)
 * 4. Number of simulation iterations (time steps)
 */
public class LifeSimulation {

    public static void main(String[] args) throws InterruptedException {
        // Check for required command-line arguments.
        if (args.length < 4) {
            System.out.println("Usage: java LifeSimulation <rows> <cols> <chance> <iterations>");
            return;
        }
        
        // Parse the command-line arguments.
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        double chance = Double.parseDouble(args[2]);
        int iterations = Integer.parseInt(args[3]);
        
        // Create the Landscape with the specified rows, columns, and chance.
        Landscape scape = new Landscape(rows, cols, chance);
        
        // Create the display with a default scale (adjust as needed).
        LandscapeDisplay display = new LandscapeDisplay(scape, 10);

        // Prints the number of alive cells in the game before simulation
        System.out.println("Number of alive cells before simulation: " + countLivingCells(scape));
        
        // Run the simulation for the specified number of iterations.
        for (int i = 0; i < iterations; i++) {
            scape.advance();
            display.repaint();
            Thread.sleep(250);
        }

        // Prints the number of alive cells in the game before simulation
        System.out.println("Number of alive cells after simulation: " + countLivingCells(scape));
    }

    /**
     * Counts the number of living cells in the given Landscape.
     *
     * @param scape the Landscape whose living cells will be counted
     * @return the number of living cells
     */
    private static int countLivingCells(Landscape scape) {
        int count = 0;
        for (int i = 0; i < scape.getRows(); i++) {
            for (int j = 0; j < scape.getCols(); j++) {
                if (scape.getCell(i, j).getAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}