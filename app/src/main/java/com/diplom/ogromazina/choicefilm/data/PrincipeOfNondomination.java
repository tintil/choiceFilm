package com.diplom.ogromazina.choicefilm.data;

/**
 * Created by OGromazina on 4/22/2018.
 */

public class PrincipeOfNondomination extends APrincipe{

    PrincipeOfNondomination(Matrix matrix) {
        super(matrix);
    }

    public void main() {
        double[][] mat = preparation(matrix);
        result = search(mat, matrix.getSize(), buildRelationships(mat));
    }

    private double[][] preparation (Matrix matrix){
        double[][] mat = new double[matrix.getSize()][matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                mat[i][j] = matrix.getValue(i,j);
            }
        }

        for (int i = 0; i < matrix.getSize(); i++) { //удаляем рефлексивные связи
            mat[i][i] = 0;
        }

        for (int i = 0; i < matrix.getSize(); i++) {// удаляем транзитивные связи
            for (int j = 0; j < matrix.getSize(); j++) {
                if (mat[i][j] == 1) {
                    for (int z = 0; z < matrix.getSize(); z++) {
                        if ((mat[i][z] == 1) && (mat[z][j] == 1)) {
                            mat[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return mat;
    }

    private int[] buildRelationships(double[][] matrix) {
        int[] relationships = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    relationships[i]++;
                }
            }
        }
        return relationships;
    }

    private int[] search (double[][] matrix, int sizeOfMatrix, int[] relationships) {
        boolean flag = true;
        int counter = 0;
        int check;
        while (flag) {
            check = 0;
            for (int i = 0; i < sizeOfMatrix; i++) {
                if (relationships[i] == 0) {
                    counter = 0;
                    for (int k = 0; k < sizeOfMatrix; k++) {
                        if ((matrix[i][k] == 1) || (matrix[k][i] == 1)) {
                            matrix[i][k] = 0;
                            matrix[k][i] = 0;
                            relationships[k]--;
                        } else {
                            counter++;
                        }
                    }
                    if (counter == sizeOfMatrix) {
                        relationships[i] = -1;
                    } else {
                        relationships[i] = -2;
                    }
                }
                if (relationships[i] >= 0) {
                    check++;
                }
            }
            if (check == 0) {
                flag = false;
            }
        }

        int c = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            if (relationships[i] == -1) {
                c++;
            }
        }

        int[] result = new int[c];
        c = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            if (relationships[i] == -1) {
                result[c] = i + 1;
                c++;
            }
        }
        return result;
    }
}
