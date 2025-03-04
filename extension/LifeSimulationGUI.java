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
        // Prompt the user for simulation parameters using input dialogs.
        int rows = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter number of rows:", "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
        int cols = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter number of columns:", "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
        double chance = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter initial chance (0 to 1):", "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
        
        // Create the Landscape and its display using the user-provided parameters.
        scape = new Landscape(rows, cols, chance);
        display = new LandscapeDisplayGUI(scape, 10); // This version returns the canvas without creating its own window.
        
        // Set up the main frame.
        setTitle("Conway's Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add the drawing canvas from the display to the center of the GUI.
        add(display.getCanvas(), BorderLayout.CENTER);
        
        // Create a panel for control buttons.
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start/Resume");
        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");
        
        // Set background colors to differentiate the buttons.
        startButton.setBackground(Color.green);
        startButton.setOpaque(true);
        pauseButton.setBackground(Color.yellow);
        pauseButton.setOpaque(true);
        resetButton.setBackground(Color.red);
        resetButton.setOpaque(true);

        // Add buttons to the controlPanel (JPanel)
        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(resetButton);
        
        add(controlPanel, BorderLayout.SOUTH);
        
        // Set up a timer to update the simulation every 250ms.
        timer = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scape.advance();
                display.getCanvas().repaint();
            }
        });
        
        // Action Listeners for buttons:
        startButton.addActionListener(new StartButtonListener(timer));
        
        pauseButton.addActionListener(new PauseButtonListener(timer));
        
        resetButton.addActionListener(new ResetButtonListener(timer));
        
        pack();
        setLocationRelativeTo(null); // Center the frame on screen.
        setVisible(true);
    }

    // Private inner classes that handles button events.

    private class PauseButtonListener implements ActionListener {
        // Reference to the Timer controlling the simulation updates.
        private Timer timer;
    
        public PauseButtonListener(Timer timer) {
            this.timer = timer;
        }

        // This method is called when the pause button is clicked.
        // It stops the timer, effectively stopping the simulation.
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
        }
    }

    private class StartButtonListener implements ActionListener {
        // Reference to the Timer controlling the simulation updates.
        private Timer timer;
    
        public StartButtonListener(Timer timer) {
            this.timer = timer;
        }

        // This method is called when the start button is clicked.
        // It starts the timer, effectively starting the simulation.
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
        }
    }

    private class ResetButtonListener implements ActionListener {
        // Reference to the Timer controlling the simulation updates.
        private Timer timer;
    
        public ResetButtonListener(Timer timer) {
            this.timer = timer;
        }

        // This method is called when the reset button is clicked.
        // It resets the landscape to the original state and pauses the timer.
        public void actionPerformed(ActionEvent e) {
            scape.reset();
            display.getCanvas().repaint();
            timer.stop();
        }
    }

    public static void main(String[] args) {
        // Ensure GUI creation runs on the Event Dispatch Thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LifeSimulationGUI();
            }
        });
    }
}