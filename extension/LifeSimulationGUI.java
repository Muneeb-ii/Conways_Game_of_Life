/*
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implement a GUI for a simulation of the Game of Life.
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LifeSimulationGUI extends JFrame {

    private Landscape scape;
    private LandscapeDisplayGUI display;
    private Timer timer;

    /**
     * Constructor that sets up the GUI.
     */
    public LifeSimulationGUI() {
        // Default simulation parameters
        int rows = 100;
        int cols = 100;
        double chance = 0.25;
        
        // Create the Landscape and its display
        scape = new Landscape(rows, cols, chance);
        display = new LandscapeDisplayGUI(scape, 10); // This now only creates the canvas, not a separate window.
        
        // Set up the frame
        setTitle("Conway's Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add the drawing canvas from the display to the center of the GUI.
        add(display.getCanvas(), BorderLayout.CENTER);
        
        // Create a panel for control buttons
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JButton resumeButton = new JButton("Resume");
        JButton resetButton = new JButton("Reset");
        
        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(resumeButton);
        controlPanel.add(resetButton);
        
        add(controlPanel, BorderLayout.SOUTH);
        
        // Set up a timer to update the simulation every 250ms
        timer = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scape.advance();
                display.getCanvas().repaint();
            }
        });
        
        // Action Listeners for buttons:
        
        // Start button: start the simulation timer
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        
        // Pause button: stop the simulation timer
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        
        // Resume button: start the timer again (if paused)
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        
        // Reset button: reinitialize the Landscape to its original state
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scape.reset();
                display.getCanvas().repaint();
            }
        });
        
        pack();
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ensure GUI creation runs on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LifeSimulationGUI();
            }
        });
    }
}