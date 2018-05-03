package com.diplom.ogromazina.choicefilm.data;

import com.diplom.ogromazina.choicefilm.data.utils.Constants;

/**
 * Created by OGromazina on 4/22/2018.
 */

public class Matrix {
    private static final int FIRST_MATRIX_NUM_ITEM = 7;
    private int[][] matrix;
    public boolean isTransitive;
    public boolean isLinear;
    private int sizeOfMatrix;
    private int[] indexes = new int[2];

    public Matrix(){
        sizeOfMatrix = FIRST_MATRIX_NUM_ITEM;
        matrix = new int[FIRST_MATRIX_NUM_ITEM][FIRST_MATRIX_NUM_ITEM];
        for (int i = 0; i < FIRST_MATRIX_NUM_ITEM; i++){
            for (int j = 0; j < FIRST_MATRIX_NUM_ITEM; j++){
                if (i != j) {
                    matrix[i][j] = Constants.nocomparable.index();
                } else {
                    matrix[i][j] = Constants.indifference.index();
                }
            }
        }
    }

    public Matrix(int numOfItems){
        sizeOfMatrix = numOfItems;
        matrix = new int[numOfItems][numOfItems];
        for (int i = 0; i < numOfItems; i++){
            for (int j = 0; j < numOfItems; j++){
                if (i != j) {
                    matrix[i][j] = Constants.nocomparable.index();
                } else {
                    matrix[i][j] = Constants.indifference.index();
                }
            }
        }
    }

    public Matrix(int[][] matrix, boolean isTransitive, boolean isLinear, int sizeOfMatrix){
        this.matrix = matrix;
        this.isTransitive = isTransitive;
        this.isLinear = isLinear;
        this.sizeOfMatrix = sizeOfMatrix;
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public boolean getTransitive(){
        return isTransitive;
    }

    public boolean getLinear(){
        return isLinear;
    }

    public int getSize(){
        return sizeOfMatrix;
    }

    public int[] full (int i, int j, int value){
        if (value == Constants.dominance.index()){
            matrix[i][j] = Constants.dominance.index();
            matrix[j][i] = Constants.dominated.index();
        }else
        if (value == Constants.dominated.index()){
            matrix[i][j] = Constants.dominated.index();
            matrix[j][i] = Constants.dominance.index();
        }else
        if (value == Constants.indifference.index()){
            matrix[i][j] = Constants.indifference.index();
            matrix[j][i] = Constants.indifference.index();
        }else
        if (value == Constants.nocomparable.index()){
            matrix[i][j] = Constants.nocomparable.index();
            matrix[j][i] = Constants.nocomparable.index();
        }
        matrix[i][j] = value;
        if ((j + 1 == sizeOfMatrix) && (i + 1 == sizeOfMatrix)){
            indexes[0] = -1;
            indexes[1] = -1;
        } else
        if ((j + 1 == sizeOfMatrix)){
            indexes[0] = i + 1;
            indexes[1] = i + 2;
        }else
        if (j + 1 != sizeOfMatrix){
            indexes[0] = i;
            indexes[1] = j + 1;
        }
        return indexes;
    }

    private void isTransitive(){
        isTransitive = true;
        for (int i = 0; i < sizeOfMatrix; i++){
            for (int j = 0; j < sizeOfMatrix; j++){
                if (matrix[i][j] == Constants.dominance.index()){
                    for (int z = 0; z < sizeOfMatrix; z++){
                        if ((matrix[j][z] == Constants.dominance.index()) && (matrix[i][z] != Constants.dominance.index())){
                            isTransitive = false;
                            break;
                        }
                    }
                }
                if (isTransitive == false){
                    break;
                }
            }
            if (isTransitive == false){
                break;
            }
        }
    }

    private void isLinear(){
        isLinear = true;
        for (int[] i : matrix){
            for (int j : i){
                if (i[j]== Constants.nocomparable.index()){
                    isLinear = false;
                }
            }
        }
    }

    public int getValue (int x, int y){
        return matrix[x][y];
    }
}
