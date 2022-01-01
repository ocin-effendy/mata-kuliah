package com.company;


import java.util.Objects;
import java.util.Scanner;

class Sudoku {
    int[] mat[];
    int N; // number of columns/rows.
    int SRN; // square root of N
    int K; // No. Of missing digits

    // Constructor
    Sudoku(int N, int K) {
        this.N = N;
        this.K = K;

        // Compute square root of N
        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();

        mat = new int[N][N];
    }

    // Sudoku Generator
    public void fillValues() {
        // Fill the diagonal of SRN x SRN matrices
        fillDiagonal();

        // Fill remaining blocks
        fillRemaining(0, SRN);

        // Remove Randomly K digits to make game
        removeKDigits();
    }

    // Fill the diagonal SRN number of SRN x SRN matrices
    void fillDiagonal() {

        for (int i = 0; i < N; i = i + SRN) fillBox(i, i);
    }

    // Returns false if given 3 x 3 block contains num.
    boolean unUsedInBox(int rowStart, int colStart, int num) {
        for (int i = 0; i < SRN; i++)
            for (int j = 0; j < SRN; j++)
                if (mat[rowStart + i][colStart + j] == num) return false;

        return true;
    }

    // Fill a 3 x 3 matrix.
    void fillBox(int row, int col) {
        int num;
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                do {
                    num = randomGenerator(N);
                }while (!unUsedInBox(row, col, num));

                mat[row + i][col + j] = num;
            }
        }
    }

    // Random generator
    int randomGenerator(int num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    // Check if safe to put in cell
    boolean CheckIfSafe(int i, int j, int num) {
        return (unUsedInRow(i, num) && unUsedInCol(j, num) && unUsedInBox(i - i % SRN, j - j % SRN, num));
    }

    // check in the row for existence
    boolean unUsedInRow(int i, int num) {
        for (int j = 0; j < N; j++) if (mat[i][j] == num) return false;
        return true;
    }

    // check in the row for existence
    boolean unUsedInCol(int j, int num) {
        for (int i = 0; i < N; i++)
            if (mat[i][j] == num) return false;
        return true;
    }

    // A recursive function to fill remaining
    // matrix
    boolean fillRemaining(int i, int j) {
        //  System.out.println(i+" "+j);
        if (j >= N && i < N - 1) {
            i = i + 1;
            j = 0;
        }
        if (i >= N && j >= N) return true;

        if (i < SRN) {
            if (j < SRN) j = SRN;
        } else if (i < N - SRN) {
            if (j == (int) (i / SRN) * SRN) j = j + SRN;
        } else {
            if (j == N - SRN) {
                i = i + 1;
                j = 0;
                if (i >= N)  return true;
            }
        }

        for (int num = 1; num <= N; num++) {
            if (CheckIfSafe(i, j, num)) {
                mat[i][j] = num;
                if (fillRemaining(i, j + 1)) return true;
                mat[i][j] = 0;
            }
        }
        return false;
    }

    // Remove the K no. of digits to
    // complete game
    public void removeKDigits() {
        int count = K;
        while (count != 0) {
            int cellId = randomGenerator(N * N) - 1;

            int i = (cellId / N);
            int j = cellId % 9;
            if (j != 0) j = j - 1;

            if (mat[i][j] != 0) {
                count--;
                mat[i][j] = 0;
            }
        }
    }

    // Print sudoku
    public void printSudoku() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

}
    public class Main {

    public static void printArray(int[][] arrInt){
        for (int[] ints : arrInt) {
            for (int j = 0; j < arrInt.length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    public static boolean checkColum(int[][] arrInt, int colum, int random){
        boolean check = false;
        for (int[] ints : arrInt) {
            if (ints[colum] == random) {
                check = true;
                break;
            }
        }

        return check;
    }

    public static boolean checkRow(int[][] arrInt, int row, int random){
        boolean check = false;
        for (int i = 0; i < arrInt.length; i++){
            if (arrInt[row][i] == random) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static int random(int[][] arrInt, int ordo, int row, int colum) {
        int range = ordo -1 + 1;
        int value = 0;
        boolean check = true;
        while(check){
            value = (int)(Math.random() * range) + 1;
            System.out.println("ini random : " + value);
            if (!checkRow(arrInt,row,value) && !checkColum(arrInt,colum,value)){
                check = false;
            }
        }
        return value;
    }



    public static void main(String[] args) {

        int N = 9, K = 20;
        Sudoku sudoku = new Sudoku(N, K);
        sudoku.fillValues();


        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (sudoku.mat[i][j] == 0){
                    sudoku.mat[i][j] = random(sudoku.mat,N,i,j);
                }
            }
        }
        sudoku.printSudoku();

//        Scanner userInput = new Scanner(System.in);
//        System.out.print("Input Matriks: ");
//        int ordo = userInput.nextInt();
//        int[][] arrInt = { {1,2,3},
//                           {3,2,1},
//                           {2,3,1}};
//        if (IntStream.of(arrInt[2]).anyMatch(x -> x == 300)){
//            System.out.println("aada cokk");
//        }else System.out.println("angka tidak ada");


//        checkColum(arrInt,0,2);
//        checkRow(arrInt,0,3);


//        int[][] arr = new int[ordo][ordo];



//
//        for (int i = 0; i < ordo; i++){
//                for (int j = 0; j < ordo; j++){
//                    arr[i][j] = random(arr,ordo,i,j);
//                }
//            }
//
//            printArray(arr);
//





//        String[] text = {"n","i","c","o","a","r","d","i","a"};
//        String[] pattern = {"a", "r", "d","i"};
//
//        int n = text.length-1;
//        int m = pattern.length-1;
//
//        int check = bruteForce(n,m,text,pattern);
//        if (check>0) System.out.println("data berada di : " + check);
//        else System.out.println("tidak ada kecocokan");



    }

    public static int bruteForce(int n, int m, String[] t, String[] p){
        for (int i = 0; i < n-m; i++){
            System.out.println("ini i : "  + i);
            int j = 0;
            while(j < m && Objects.equals(t[i + j], p[j])){
                System.out.println("cok");
                j++;
            }
            if(j==m) return i;
        }

        return -1;
    }
}
