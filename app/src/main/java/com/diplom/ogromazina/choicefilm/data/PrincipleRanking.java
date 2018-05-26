package com.diplom.ogromazina.choicefilm.data;

import com.diplom.ogromazina.choicefilm.data.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OGromazina on 5/7/2018.
 */

public class PrincipleRanking {

    public static void main(Matrix matrix){
        subtleRanking(roughRanking(matrix.getMatrix(), matrix.getSize()), matrix.getMatrix(), matrix.getSize());
    }

    private static List<int[]> roughRanking(double[][] matrix, int sizeOfMatrix){

        for (int i = 0; i < sizeOfMatrix; i++){
            for (int j = 0; j < sizeOfMatrix; j++){
                if (matrix[i][j] == Constants.nocomparable.index()){
                    matrix[i][j] = Constants.dominance.index();
                }
            }
        }

        double[][] matrixDegrees2 = multiplicationOfMatrix(sizeOfMatrix, matrix, matrix);
        double[][] matrixDegrees3 = multiplicationOfMatrix(sizeOfMatrix, matrixDegrees2, matrix);

        if (matrixDegrees2 == matrixDegrees3){
            for (int i = 0; i < sizeOfMatrix; i++){
                for (int j = 0; j <= i; j++){
                    if (matrix[j][i] != matrix[i][j]){
                        matrix[j][i] = Constants.dominated.index();
                        matrix[i][j] = Constants.dominated.index();
                    }
                }
            }
        }//TODO

        List<int[]> result = new ArrayList<>();
        boolean isCircuit = true;
        int sizeOfCircuit = 0;
        int[] vertexes = new int[sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++){
            for (int j = i; j >= 0; j--) {
                if (matrix[i][j] == Constants.dominated.index() || matrix[j][i] == Constants.dominated.index()) {
                    isCircuit = false;
                    break;
                }
            }
            if (!isCircuit){
                isCircuit = true;
                int[] tmp = new int[sizeOfCircuit];
                for (int z = 0; z < sizeOfCircuit; z++){
                    tmp[z] = vertexes[z];
                    vertexes[z] = 0;
                }
                sizeOfCircuit = 0;
                result.add(tmp);
            } else {
                vertexes[sizeOfCircuit] = i;
                sizeOfCircuit++;
            }
        }
        return result;
    }

    private static void subtleRanking(List<int[]> routhRankedList, double[][] matrix, int sizeOfMatrix){

    }

    private static double[][] multiplicationOfMatrix(int sizeOfMatrix, double[][] matrix1, double[][] matrix2){
        double[][] result = new double[sizeOfMatrix][sizeOfMatrix];
        for(int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                result[i][j] = 0;
                for (int k = 0; k < sizeOfMatrix; k++)
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
        return result;
    }
}
