package com.diplom.ogromazina.choicefilm.data;

import com.diplom.ogromazina.choicefilm.data.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OGromazina on 5/7/2018.
 */

public class PrincipleRanking {

    public static void main(Matrix matrix){


    }

    private static List<int[]> roughRanking(int[][] matrix, int sizeOfMatrix){

        for (int i = 0; i < sizeOfMatrix; i++){
            for (int j = 0; j < sizeOfMatrix; j++){
                if (matrix[i][j] == Constants.nocomparable.index()){
                    matrix[i][j] = Constants.dominance.index();
                }
            }
        }

        int[][] matrixDegrees2 = multiplicationOfMatrix(sizeOfMatrix, matrix, matrix);
        int[][] matrixDegrees3 = multiplicationOfMatrix(sizeOfMatrix, matrixDegrees2, matrix);

        if (matrixDegrees2 == matrixDegrees3){
            for (int i = 0; i < sizeOfMatrix; i++){
                for (int j = 0; j <= i; j++){
                    matrix[j][i] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < sizeOfMatrix; i++){
            
        }

        List<int[]> result = new ArrayList<>();
        return result;
    }

    private static void subtleRanking(){

    }

    private static int[][] multiplicationOfMatrix(int sizeOfMatrix, int[][] matrix1, int[][] matrix2){
        int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
        //TODO: перемножение матриц
        return result;
    }
}
