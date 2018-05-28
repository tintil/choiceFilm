package com.diplom.ogromazina.choicefilm.data;

import com.diplom.ogromazina.choicefilm.data.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OGromazina on 5/5/2018.
 */

public class PrincipeNandM extends APrincipe{

    PrincipeNandM(Matrix matrix) {
        super(matrix);
    }

    private boolean end = false;

    public void main(){
        List<int[]> subsets = divisionsIntoSubsets(preparation(matrix), matrix.getSize());
        int[] tmp = findTheCore (subsets, preparation(matrix), matrix.getSize());
        int c = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            if (tmp[i] == 1) {
                c++;
            }
        }

        result = new int[c];
        c = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            if (tmp[i] == 1) {
                result[c] = i + 1;
                c++;
            }
        }
    }

    private List<int[]> divisionsIntoSubsets(double[][] matrix, int sizeOfMatrix){
        int[][] table = new int[3][sizeOfMatrix];
        int sizeOfTable = sizeOfMatrix;
        for (int i = 0; i < sizeOfMatrix; i++) {
            table[0][i] = i;
            table[1][i] = -1;
            table[2][i] = -1;
        }

        refreshTable(table, sizeOfTable, matrix, sizeOfMatrix);
        List<int[]> result = new ArrayList<>();
        search(table, sizeOfTable, result, matrix, sizeOfMatrix);
        return result;
    }

    private int[] findTheCore (List<int[]> listOfDegrees, double[][] matrix, int sizeOfMatrix){
        final int KERNEL = 1;
        final int NOT_KERNEL = -1;
        final int NOT_CHECKED = 0;
        boolean isKernel = true;

        int[] result = new int[sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++){
            result[i] = NOT_CHECKED;
        }
        for (int i : listOfDegrees.get(0)){
            result[i] = KERNEL;
        }

        for (int i = 1; i < listOfDegrees.size(); i++){
            for (int j = listOfDegrees.get(i-1).length; j < listOfDegrees.get(i).length; j++){
                for (int k = 0; k < sizeOfMatrix; k++){
                    isKernel = true;
                    if (result[k] == KERNEL && matrix[listOfDegrees.get(i)[j]][k] == Constants.dominance.index()){
                        isKernel = false;
                        break;
                    }
                }
                if (isKernel){
                    result[listOfDegrees.get(i)[j]] = KERNEL;
                } else {
                    result[listOfDegrees.get(i)[j]] = NOT_KERNEL;
                }
            }
        }
        return result;
    }

    private  void search(int[][] table, int sizeOfTable, List<int[]> result, double[][] matrix, int sizeOfMatrix) {
        while (!end) {
            boolean flagNull = false;
            for (int i = 0; i < sizeOfTable; i++) {
                if (table[2][i] == 0) {
                    flagNull = true;
                    break;
                }
            }

            if (flagNull) {
                int[] nullVertexes = new int[sizeOfTable];
                int countOfNull = 0;
                for (int i = 0; i < sizeOfTable; i++) {
                    if (table[2][i] == 0) {
                        nullVertexes[countOfNull] = table[0][i];
                        countOfNull++;
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            matrix[j][table[0][i]] = Constants.dominated.index();
                        }
                    }
                }
                int[] tmp;
                if (result.size() != 0) {
                    int index = result.size();
                    int sizeOfCurrentArray = result.get(index - 1).length;
                    tmp = new int[countOfNull + sizeOfCurrentArray];
                    for (int i = 0; i < countOfNull + sizeOfCurrentArray; i++) {
                        if (i < sizeOfCurrentArray) {
                            tmp[i] = result.get(index - 1)[i];
                        }else {
                            tmp[i] = nullVertexes[i - sizeOfCurrentArray];
                        }
                    }
                } else {
                    tmp = new int[countOfNull];
                    for (int i = 0; i < countOfNull; i++) {
                        tmp[i] = nullVertexes[i];
                    }
                }

                result.add(tmp);
                for (int i = 0; i < countOfNull; i++) {
                    int j = 0;
                    for (int z = 0; z < sizeOfTable; z++) {
                        if (table[0][z] == nullVertexes[i]) {
                            j = z;
                            break;
                        }
                    }
                    for (int z = j ; z < sizeOfTable - 1; z++) {
                        table[0][z] = table[0][z + 1];
                        table[1][z] = table[1][z + 1];
                        table[2][z] = table[2][z + 1];
                    }
                    sizeOfTable--;
                    if (sizeOfTable == 0) {
                        end = true;
                    }
                }
                refreshTable(table, sizeOfTable, matrix, sizeOfMatrix);
                search(table, sizeOfTable, result, matrix, sizeOfMatrix);
            } else {
                int[] minVertexes = new int[sizeOfTable];
                int min;
                int countOfMin = 1;
                min = table[2][0];
                minVertexes[0] = table[0][0];
                for (int i = 1; i < sizeOfTable; i++) {
                    if (table[2][i] < min) {
                        countOfMin = 0;
                        min = table[2][i];
                        minVertexes[countOfMin] = table[0][i];
                        countOfMin++;
                    }
                    if (table[2][i] == min) {
                        minVertexes[countOfMin] = table[0][i];
                        countOfMin++;
                    }
                }

                if (countOfMin == 1) {
                    for (int j = 0; j < sizeOfMatrix; j++) {
                        matrix[minVertexes[0]][j] = Constants.dominated.index();
                    }
                    table[2][minVertexes[0]] = 0;
                    refreshTable(table, sizeOfTable, matrix, sizeOfMatrix);
                    search(table, sizeOfTable, result, matrix, sizeOfMatrix);
                } else {
                    boolean flagInNull = false;
                    boolean flagNotFoundNull = true;
                    int[][] newTable = new int[3][sizeOfTable];
                    for (int z = 0 ; z < sizeOfTable; z++) {
                        newTable[0][z] = table[0][z];
                        newTable[1][z] = table[1][z];
                        newTable[2][z] = table[2][z];
                    }
                    double[][] newMatrix = new double[sizeOfMatrix][sizeOfMatrix];
                    for (int i = 0; i < sizeOfMatrix; i++) {
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            newMatrix[i][j] = matrix[i][j];
                        }
                    }

                    for (int i = 0; i < countOfMin; i++) {
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            newMatrix[minVertexes[i]][j] = Constants.dominated.index();
                        }
                        newTable[2][minVertexes[i]] = 0;
                        refreshTable(newTable, sizeOfTable, newMatrix, sizeOfMatrix);
                        for (int k = 0; k < sizeOfTable; k++) {
                            if (newTable[1][k] == 0) {
                                flagInNull = true;
                                break;
                            }
                        }
                        if (flagInNull) {
                            flagNotFoundNull = false;
                            search(newTable, sizeOfTable, result, newMatrix, sizeOfMatrix);
                            break;
                        } else {
                            for (int z = 0 ; z < sizeOfTable - 1; z++) {
                                newTable[0][z] = table[0][z];
                                newTable[1][z] = table[1][z];
                                newTable[2][z] = table[2][z];
                            }
                            for (int m = 0; m < sizeOfMatrix; m++) {
                                for (int j = 0; j < sizeOfMatrix; j++) {
                                    newMatrix[m][j] = matrix[m][j];
                                }
                            }
                        }
                    }
                    if (flagNotFoundNull) {
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            matrix[minVertexes[0]][j] = Constants.dominated.index();
                        }
                        table[2][minVertexes[0]] = 0;
                        refreshTable(table, sizeOfTable, matrix, sizeOfMatrix);
                        search(table, sizeOfTable, result, matrix, sizeOfMatrix);
                    }
                }
            }
        }
    }

    private double[][] preparation (Matrix matrix){
        double[][] mat = new double[matrix.getSize()][matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                mat[i][j] = matrix.getValue(i,j);
            }
        }

        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = i; j < matrix.getSize(); j++) {
                if (i == j){
                    mat[i][j] = Constants.dominated.index();
                }
                if (mat[i][j] == Constants.nocomparable.index() || mat[i][j] == Constants.indifference.index()){
                    mat[i][j] = Constants.dominated.index();
                }
                if(mat[i][j] == Constants.dominance.index() || mat[j][i] == Constants.dominance.index()) {
                    double tmp;
                    tmp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = tmp;
                }
            }
        }
        return mat;
    }

    private void refreshTable(int[][] table, int size, double[][] matrix, int sizeOfMatrix){
        int countOfIn;
        int countOfOut;
        for (int i = 0; i < size; i++) {
            countOfIn = 0;
            countOfOut = 0;
            for(int j = 0; j < sizeOfMatrix; j++) {
                if (matrix[table[0][i]][j] == Constants.dominance.index()) {
                    countOfOut++;
                }
                if (matrix[j][table[0][i]] == Constants.dominance.index()) {
                    countOfIn++;
                }
            }
            table[1][i] = countOfIn;
            table[2][i] = countOfOut;
        }
    }
}
