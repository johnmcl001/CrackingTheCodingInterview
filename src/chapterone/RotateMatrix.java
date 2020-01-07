package chapterone;

public class RotateMatrix {
    public static void main(String[] args){
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

        rotateInPlace(matrix);

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.printf("%c ", aChar);
            }
            System.out.print("\n");
        }
    }

    /**
     * Rotates matrix in place
     * @param matrix, square matrix
     */
    public static void rotateInPlace(char[][] matrix){
        char temp;
        for (int i = 0; i < matrix.length-1; i++){
            for (int j = 0; j < matrix.length-1-i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
                matrix[matrix.length-1-j][matrix.length-1-i] = temp;
            }
        }

        char[] tempArr;
        for (int i = 0; i < matrix.length / 2; i++){
            tempArr = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = tempArr;
        }
    }

    /**
     * Rotates matrix not in place
     * @param matrix, square matrix
     */
    public static void rotate(char[][] matrix){
        char[][] newMatrix = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                newMatrix[j][i] = matrix[i][j];
            }
        }

        for (char[] chars: newMatrix){
            char temp = chars[0];
            chars[0] = chars[chars.length-1];
            chars[chars.length-1] = temp;
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
