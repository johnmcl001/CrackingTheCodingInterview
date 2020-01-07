package chapterone;

import java.util.ArrayList;

public class ZeroMatrix {
    public static void main(String[] args){
        int [][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 11},
                {12, 13, 14, 15}
        };

        zero(matrix);

        for (int[] ints: matrix) {
            for (int i: ints) {
                System.out.printf("%2d ", i);
            }
            System.out.print("\n");
        }
    }

    /**
     * Locates zero positions then invokes makeZero method to make columns and rows zero
     * @param matrix, mxn matrix of integers
     */
    public static void zero(int[][] matrix){
        ArrayList<Integer> zeroes = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == 0){
                    zeroes.add(i);
                    zeroes.add(j);
                }
            }
        }
        makeZero(matrix, zeroes);
    }

    /**
     * Makes columns and rows of zero positions zero
     * @param matrix, mxn matrix of integers
     * @param zeroes, list of zero positions
     */
    public static void makeZero(int[][] matrix, ArrayList<Integer> zeroes){
        for (Integer i: zeroes){
            for (int j = 0; j < matrix.length; j++){
                matrix[j][i] = 0;
            }

            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = 0;
            }
        }
    }
}
