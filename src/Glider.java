/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: The class runs a simulation of the Game of Life preset glider.
 * 
 */
public class Glider {

    public static void main(String[] args) throws InterruptedException {
        
        // Create the Landscape with the specified rows, columns, and chance.
        Landscape scape = new Landscape(50, 50, 0);
        
        // Create the display with a default scale (adjust as needed).
        LandscapeDisplay display = new LandscapeDisplay(scape, 10);

        scape.getCell(2,0).setAlive(true);
        scape.getCell(2,1).setAlive(true);
        scape.getCell(2,2).setAlive(true);
        scape.getCell(1,2).setAlive(true);
        scape.getCell(0,1).setAlive(true);
        
        // Run the simulation for the specified number of iterations.
        for (int i = 0; i < 10000; i++) {
            scape.advance();
            display.repaint();
            Thread.sleep(250);
        }

    }
}
    