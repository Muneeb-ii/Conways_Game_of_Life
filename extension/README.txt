LifeSimulation Extension - Command-Line Parameters

Overview
This version of LifeSimulation.java has been extended to use command-line parameters. This allows users to control the simulation settings dynamically without modifying the source code.

Parameters
The program expects four parameters in the following order:
1. Number of rows in the grid.
2. Number of columns in the grid.
3. Initial chance that a cell is alive (a decimal between 0 and 1).
4. Number of simulation iterations (time steps).

How to Compile and Run
1. Compilation:
   Make sure you have all required files (LifeSimulation.java, Landscape.java, LandscapeDisplay.java, and Cell.java) in the same directory. Compile them using:
   javac *.java

2. Execution:
    Run the simulation with your desired parameters. For example:
    java LifeSimulation 100 100 0.25 1000

    This command creates a 100×100 grid with a 25% initial chance of a cell being alive and runs the simulation for 1000 iterations.

3. Output
    The program will:
        - Display the simulation window.
        - Print to the console:
            - "Number of alive cells before simulation: ..." 
            - "Number of alive cells after simulation: ..."

    These outputs allow you to verify the simulation's behavior based on your parameters.

Notes
- Ensure that all dependent classes are properly compiled.
- The simulation window uses a default scale (currently set to 10), which can be adjusted if needed.
- If insufficient parameters are provided, the program prints a usage message detailing the required arguments.