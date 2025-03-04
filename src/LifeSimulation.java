/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: The class runs a simulation of the Game of Life.
 */


 public class LifeSimulation {

    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(100, 100, .25);

        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        for (int i = 0; i<100; i++){
            scape.advance();
            display.repaint();
            Thread.sleep(250);
        }
    }
}
