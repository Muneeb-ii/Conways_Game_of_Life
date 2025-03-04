# Conway's Game of Life Simulation

This project implements Conway’s Game of Life using Java. It explores how simple rules governing cellular automata can lead to complex, emergent behavior. The simulation is built using object-oriented design, with an emphasis on efficient grid representation using arrays and dynamic neighbor management with ArrayLists.

## Project Overview

### Core Components
- **Cell Class:**  
  Represents an individual cell on the grid, encapsulating its state (alive or dead) and providing methods to update its state based on its neighbors.
  
- **Landscape Class:**  
  Manages a 2D grid of Cell objects using arrays. This grid is the foundation of the simulation and is responsible for maintaining and updating cell states.
  
- **LandscapeDisplay & LandscapeDisplayGUI Classes:**  
  These classes render the grid graphically. The CLI version displays the grid using a simple window, while the GUI version integrates user interaction (e.g., start, pause, reset) into a single unified interface.
  
- **LifeSimulation & LifeSimulationGUI Classes:**  
  Contain the main simulation loops. The command-line version accepts parameters for grid dimensions, initial cell density, and iterations, while the GUI version prompts the user for parameters and provides interactive controls.

### Simulation Rules
Conway’s Game of Life follows these simple rules:
1. Any live cell with fewer than 2 live neighbors dies (underpopulation).
2. Any live cell with 2 or 3 live neighbors survives.
3. Any live cell with more than 3 live neighbors dies (overpopulation).
4. Any dead cell with exactly 3 live neighbors becomes alive (reproduction).

## Extensions

### Command-line Parameters
- **What I Did:**  
  Modified the `LifeSimulation.java` class to accept command-line parameters for the grid size, initial alive chance, and number of iterations.  
- **Why:**  
  This makes the simulation flexible and easy to configure without changing the source code.
- **Outcome:**  
  Users can run, for example:

  `java LifeSimulation 100 100 0.3 1000`
to simulate a 100×100 grid with a 30% initial alive chance for 1000 iterations. The program prints the number of living cells before and after the simulation.

### Glider Preset
- **What I Did:**  
Created a separate `Glider.java` file to test a preset pattern (the glider) in the Game of Life.  
- **Why:**  
To verify that the simulation correctly handles and evolves predetermined configurations.
- **Outcome:**  
The glider pattern moves diagonally across the grid, demonstrating the proper evolution of known patterns.

### Graphical User Interface
- **What I Did:**  
Developed a complete GUI using `JFrame` and `JPanel` (via `LifeSimulationGUI` and `LandscapeDisplayGUI`). The GUI prompts the user for simulation parameters and provides control buttons for start/resume, pause, and reset.  
- **Why:**  
To offer an interactive, user-friendly way to explore the simulation in real time.
- **Outcome:**  
The integrated GUI allows dynamic interaction with the simulation, and all components are housed within a single window.

## How to Run the Project

### 1. Clone the Repository

`git clone https://github.com/Muneeb-ii/Conways-Game-of-Life.git
cd Conways-Game-of-Life`

### 2. Compile the Code:
Ensure you have Java installed. Compile all the Java files:
`javac *.java`

### 3. Run the Simulation:

**Command-Line Mode:**
To run a simulation with user-defined parameters, use:
`java LifeSimulation <rows> <cols> <chance> <iterations>`
For example:
`java LifeSimulation 100 100 0.3 1000`

**GUI Mode:**
To run the interactive GUI version:
`java LifeSimulationGUI`

Upon startup, you will be prompted to enter the number of rows, columns, and the initial probability. The simulation window will then display the evolving grid along with control buttons to start, pause, and reset the simulation.

## Results and Observations

- **Visualization:**  
  Figures in the report show the initial state of the board and the state after one simulation step, confirming that the simulation updates correctly.

- **Experimentation:**  
  Tests indicate that moderate initial probabilities yield stable patterns, while too low or too high probabilities lead to extinction.

- **Scalability:**  
  Larger grids result in more surviving cells in absolute terms, but the relative fraction of living cells remains consistent.
