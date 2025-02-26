/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class:
 */

public class Grid{
    public static void main(String args[]){
        Integer[][] grid;
        grid = new Integer[3][5];

        for(int i=0;i<3;i++) {
            for(int j=0;j<5;j++) {
               grid[i][j]=i+j;
            }
        }

        for(int i=0;i<3;i++) {
            System.out.print("| ");
            for(int j=0;j<5;j++) {
               System.out.print(grid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}