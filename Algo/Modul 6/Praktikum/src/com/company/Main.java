package com.company;

import java.util.*;

public class Main {

    static final int max = 8;
    static final int min = 0;

    static final int digitMax = 9;
    static final int digitMin = 1;

    static final int easyMin = 36;
    static final int easyMax = 49;

    static final int mediumMin = 32;
    static final int mediumMax = 35;

    static final int hardMin = 22;
    static final int hardMax = 27;

    // N is the size of the 2D matrix   N*N
//    static int N = 9;
//
//    /* Takes a partially filled-in grid and attempts
//    to assign values to all unassigned locations in
//    such a way to meet the requirements for
//    Sudoku solution (non-duplication across rows,
//    columns, and boxes) */
//    static boolean solveSudoku(int grid[][], int row,
//                               int col)
//    {
//
//        /*if we have reached the 8th
//           row and 9th column (0
//           indexed matrix) ,
//           we are returning true to avoid further
//           backtracking       */
//        if (row == N - 1 && col == N)
//            return true;
//
//        // Check if column value  becomes 9 ,
//        // we move to next row
//        // and column start from 0
//        if (col == N) {
//            row++;
//            col = 0;
//        }
//
//        // Check if the current position
//        // of the grid already
//        // contains value >0, we iterate
//        // for next column
//        if (grid[row][col] != 0)
//            return solveSudoku(grid, row, col + 1);
//
//        for (int num = 1; num < 10; num++) {
//
//            // Check if it is safe to place
//            // the num (1-9)  in the
//            // given row ,col ->we move to next column
//            if (isSafe(grid, row, col, num)) {
//
//                /*  assigning the num in the current
//                (row,col)  position of the grid and
//                assuming our assigned num in the position
//                is correct */
//                grid[row][col] = num;
//
//                // Checking for next
//                // possibility with next column
//                if (solveSudoku(grid, row, col + 1))
//                    return true;
//            }
//            /* removing the assigned num , since our
//               assumption was wrong , and we go for next
//               assumption with diff num value   */
//            grid[row][col] = 0;
//        }
//        return false;
//    }
//
//    /* A utility function to print grid */
//    static void print(int[][] grid)
//    {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++)
//                System.out.print(grid[i][j] + " ");
//            System.out.println();
//        }
//    }
//
//    // Check whether it will be legal
//    // to assign num to the
//    // given row, col
//    static boolean isSafe(int[][] grid, int row, int col,
//                          int num)
//    {
//
//        // Check if we find the same num
//        // in the similar row , we
//        // return false
//        for (int x = 0; x <= 8; x++)
//            if (grid[row][x] == num)
//                return false;
//
//        // Check if we find the same num
//        // in the similar column ,
//        // we return false
//        for (int x = 0; x <= 8; x++)
//            if (grid[x][col] == num)
//                return false;
//
//        // Check if we find the same num
//        // in the particular 3*3
//        // matrix, we return false
//        int startRow = row - row % 3, startCol
//                = col - col % 3;
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++)
//                if (grid[i + startRow][j + startCol] == num)
//                    return false;
//
//        return true;
//    }


    public static void main(String[] args) throws Exception {

        int[][] grid = new int[9][9];

        String option = "medium";

        Random random = new Random();

        int row = 0;
        int col = 0;

        int randomNumber = 0;
        int noOfCellsToBeGenerated = 0;

        if ("easy".equals(option)) {
            noOfCellsToBeGenerated = random.nextInt((easyMax - easyMin) + 1) + easyMin;
        } else if ("medium".equals(option)) {
            noOfCellsToBeGenerated = random.nextInt((mediumMax - mediumMin) + 1) + mediumMin;
        } else {
            noOfCellsToBeGenerated = random.nextInt((hardMax - hardMin) + 1) + hardMin;
        }

        for (int i = 1; i <= noOfCellsToBeGenerated; i++) {
            row = random.nextInt((max - min) + 1) + min;
            col = random.nextInt((max - min) + 1) + min;
            randomNumber = random.nextInt((digitMax - digitMin) + 1) + digitMin;

            if (grid[row][col] == 0 && noConflict(grid, row, col, randomNumber)) {
                grid[row][col] = randomNumber;
            } else {
                i--;
            }

        }

//        print(grid);

//        if (solveSudoku(grid, 0, 0))
//            print(grid);
//        else
//            System.out.println("No Solution exists");

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(grid[i][j] + "  ");
//            }
//            System.out.println();
//        }

        int[][] arr = {{5, 8, 0, 2, 0, 0, 4, 7, 0},
                {0, 2, 0, 0, 0, 0, 0, 3, 0},
                {0, 3, 0, 0, 5, 4, 0, 0, 0},
                {0, 0, 0, 5, 6, 0, 0, 0, 0},
                {0, 0, 7, 0, 3, 0, 9, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 0, 0},
                {0, 0, 0, 8, 2, 0, 0, 6, 0},
                {0, 7, 0, 0, 0, 0, 0, 8, 0},
                {0, 9, 4, 0, 0, 6, 0, 1, 5}};

        print_initial(arr, arr.length);
        sudoku(arr);
        System.out.println("AFTER SOLVING : ");
        print(arr, arr.length);

    }

    public static boolean noConflict(int[][] array, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (array[row][i] == num) {
                return false;
            }
            if (array[i][col] == num) {
                return false;
            }
        }

        int gridRow = row - (row % 3);
        int gridColumn = col - (col % 3);
        for (int p = gridRow; p < gridRow + 3; p++) {
            for (int q = gridColumn; q < gridColumn + 3; q++) {
                if (array[p][q] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudoku(int[][] grid) {
        int[] ra = Unassigned(grid);
        if (ra[0] == -1) {
            return true;
        }

        int row = ra[0];
        int col = ra[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {


                grid[row][col] = num;
                boolean check = sudoku(grid);
                if (check == true) {
                    return true;
                }
                grid[row][col] = 0;


            }
        }
        return false;
    }


    public static int[] Unassigned(int[][] arr) {

        int[] ra = new int[2]; //returns the position of first unassigned position
        ra[0] = -1;
        ra[1] = -1;

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (arr[row][col] == 0) {
                    ra[0] = row;
                    ra[1] = col;
                    return ra;
                }
            }
        }

        return ra;


    }//returns the first unassigned position

    public static boolean usedInRow(int[][] grid, int row, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return true;
            }
        }
        return false;
    }//is it used in that row?

    public static boolean usedIncol(int[][] grid, int col, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }//is it used in that col?

    public static boolean usedInBox(int[][] grid, int row1Start, int col1Start, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + row1Start][col + col1Start] == num) {
                    return true;
                }
        return false;

    }//is it used in that box?

    public static boolean isSafe(int[][] grid, int row, int col, int num) {//is it safe to place that number at that position, might not be correct nut just safe

        return (!usedIncol(grid, col, num) && !usedInRow(grid, row, num) && !usedInBox(grid, row - row % 3, col - col % 3, num));

    }

    public static void print(int[][] arr, int N) {// prints the sudoku
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            int count1 = 0;
            for (int j = 0; j < N; j++) {


                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + arr[i][j]
                        + " ");

            }
            System.out.println();
        }


    }
    public static void print_initial(int[][] arr, int N) {// prints the sudoku
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            int count1 = 0;
            for (int j = 0; j < N; j++) {


                if (j % 3 == 0) {
                    System.out.print("|");
                }
                if(arr[i][j]==0){
                    System.out.print(" " + "-"
                            + " ");
                }
                else {
                    System.out.print(" " + arr[i][j]
                            + " ");
                }

            }
            System.out.println();
        }


    }


    public static boolean isSafe(int row, int col, int[][] board, int N) {
        //checking rows
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; i >= 0 && j < N; j++, i--)
            if (board[i][j] == 1)
                return false;

        return true;

    }


}
