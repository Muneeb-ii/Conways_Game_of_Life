/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: The class runs a simulation of the Game of Life.
 */


 public class LifeSimulation {

    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(5, 4, .25);

        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        for (int i = 0; i<5; i++){
            scape.advance();
            display.repaint();
            Thread.sleep(250);
        }
    }
}
