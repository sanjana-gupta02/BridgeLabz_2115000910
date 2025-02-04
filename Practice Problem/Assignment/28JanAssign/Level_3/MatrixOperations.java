import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        int rows1 = 3; // Example dimensions, can be modified
        int cols1 = 3;
        int rows2 = 3;
        int cols2 = 3;

        double[][] matrix1 = createRandomMatrix(rows1, cols1);
        double[][] matrix2 = createRandomMatrix(rows2, cols2);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        if (rows1 == rows2 && cols1 == cols2) {
            System.out.println("Matrix Addition:");
            displayMatrix(addMatrices(matrix1, matrix2));
            System.out.println("Matrix Subtraction:");
            displayMatrix(subtractMatrices(matrix1, matrix2));
        } else {
            System.out.println("Matrices cannot be added or subtracted (incompatible dimensions).");
        }

        if (cols1 == rows2) {
            System.out.println("Matrix Multiplication:");
            displayMatrix(multiplyMatrices(matrix1, matrix2));
        } else {
            System.out.println("Matrices cannot be multiplied (incompatible dimensions).");
        }

        if (rows1 == cols1) { // For square matrices only
            System.out.println("Transpose of Matrix 1:");
            displayMatrix(transposeMatrix(matrix1));

            if (rows1 == 2) {
                System.out.println("Inverse of Matrix 1 (2x2):");
                displayMatrix(inverse2x2(matrix1));
            } else if (rows1 == 3) {
                System.out.println("Inverse of Matrix 1 (3x3):");
                displayMatrix(inverse3x3(matrix1));
            } else {
                System.out.println("Inverse not implemented for matrices larger than 3x3.");
            }
        } else {
            System.out.println("Transpose and Inverse are only defined for square matrices.");
        }
    }

    public static double[][] createRandomMatrix(int rows, int cols) {
        Random random = new Random();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextDouble() * 10; // Values between 0 and 10 (can be adjusted)
            }
        }
        return matrix;
    }

    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static double[][] inverse2x2(double[][] matrix) {
        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        if (det == 0) {
            System.out.println("Matrix is singular (no inverse).");
            return null; // Or handle as appropriate
        }
        double[][] result = new double[2][2];
        result[0][0] = matrix[1][1] / det;
        result[0][1] = -matrix[0][1] / det;
        result[1][0] = -matrix[1][0] / det;
        result[1][1] = matrix[0][0] / det;
        return result;
    }

    public static double[][] inverse3x3(double[][] matrix) {
        double det = determinant3x3(matrix);
        if (det == 0) {
            System.out.println("Matrix is singular (no inverse).");
            return null;
        }
        double[][] cofactorMatrix = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cofactorMatrix[i][j] = Math.pow(-1, i + j) * determinant2x2(getSubmatrix(matrix, i, j));
            }
        }
        double[][] adjugateMatrix = transposeMatrix(cofactorMatrix);
        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = adjugateMatrix[i][j] / det;
            }
        }
        return inverse;
    }

    // Helper function to get a submatrix (used for 3x3 inverse)
    private static double[][] getSubmatrix(double[][] matrix, int rowToExclude, int colToExclude) {
        double[][] submatrix = new double[2][2];
        int subRow = 0;
        for (int i = 0; i < 3; i++) {
            if (i == rowToExclude) continue;
            int subCol = 0;
            for (int j = 0; j < 3; j++) {
                if (j == colToExclude) continue;
                submatrix[subRow][subCol] = matrix[i][j];
                subCol++;
            }
            subRow++;
        }
        return submatrix;
    }


    private static double determinant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    private static double determinant3x3(double[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%8.2f", matrix[i][j]); // Adjust format as needed
            }
            System.out.println();
        }
    }
}