/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Create a grid of random numbers and transpose it.
 */

import java.util.Random;

public class Grid{
    public static void main(String args[]){

        if (args.length < 2){
            System.out.println("Please provide at least 2 integer arguments");
            return;
        }
        int numberOfRows = Integer.parseInt(args[0]);
        int numberOfColumns = Integer.parseInt(args[1]);
        int rangeOfRandomNums = 10;
        
        if (args.length > 2){
            rangeOfRandomNums = Integer.parseInt(args[2]);
        }

        int[][] grid;
        grid = new int[numberOfRows][numberOfColumns];
        Random rand = new Random();

        for(int i=0;i<numberOfRows;i++) {
            for(int j=0;j<numberOfColumns;j++) {
               grid[i][j]=rand.nextInt(rangeOfRandomNums);
            }
        }

        for(int i=0;i<numberOfRows;i++) {
            System.out.print("| ");
            for(int j=0;j<numberOfColumns;j++) {
               System.out.print(grid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }

        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        int[][] arr3;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                arr1[i][j] = i+j;
                arr2[i][j] = i+j;
            }
        }
        arr3 = arr1; 

        boolean arr1IsEqualsToarr2 = arr1==arr2;
        boolean arr1IsEqualsToarr3 = arr1==arr3;

        System.out.println(arr1IsEqualsToarr2);
        System.out.println(arr1IsEqualsToarr3);
        
        System.out.println(gridEquals(arr1, arr2));
        System.out.println(gridEquals(arr1, grid));


        System.out.println("Original Matrix");
        System.out.println();
        for(int i=0;i<grid.length;i++) {
            System.out.print("| ");
            for(int j=0;j<grid[i].length;j++) {
               System.out.print(grid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }

        int[][] newGrid = transpose(grid);
        System.out.println();
        System.out.println("Transposed Matrix");
        System.out.println();
        for(int i=0;i<newGrid.length;i++) {
            System.out.print("| ");
            for(int j=0;j<newGrid[i].length;j++) {
               System.out.print(newGrid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
    
    
    }

    public static boolean gridEquals(int[][] arr1, int[][] arr2){
        if (!(arr1.length  == arr2.length)){
            return false;
        }

        for(int i=0;i<arr1.length;i++) {
            for(int j=0;j<arr1[i].length;j++) {
               if (!(arr1[i][j]==arr1[i][j])){
                    return false;
               }
            }
        }
        return true;
    }

    public static int[][] transpose(int[][] arr){
        int[][] newGrid = new int[arr[0].length][arr.length];

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                newGrid[j][i] = arr[i][j];
            }
        }

        return newGrid;
    }
}