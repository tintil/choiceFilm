package com.diplom.ogromazina.choicefilm.data;

import com.diplom.ogromazina.choicefilm.data.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OGromazina on 5/5/2018.
 */

public class PrincipeNandM {

    public static int[] principeNandM(Matrix matrix){
        List<int[]> factorList = factorization(matrix.getMatrix(), matrix.getSize());
        return kernelAllocation(factorList, matrix.getMatrix(), matrix.getSize());
    }

    public static List<int[]> factorization(int[][] matrix, int sizeOfMatrix){
        List<int[]> result = new ArrayList<>();
        int[] vertexes = new int [sizeOfMatrix];
        int numOfVertex = 0;
        boolean flagOfMissVertexRow;
        boolean flagOfMissVertexCol;
        int flagOfDominations;
        while (numOfVertex != sizeOfMatrix){
            flagOfMissVertexRow = false;
            flagOfMissVertexCol = false;
            flagOfDominations = 0;
            for (int i = 0; i < sizeOfMatrix; i++){
                for (int l : vertexes){
                    if (i == l){
                        flagOfMissVertexRow = true;
                        break;
                    }
                }
                if(flagOfMissVertexRow == true){
                    continue;
                }
                for (int j = 0; j < sizeOfMatrix; j++){
                    for (int m : vertexes){
                        if (i == m){
                            flagOfMissVertexCol = true;
                            break;
                        }
                    }
                    if(flagOfMissVertexCol == true){
                        continue;
                    }
                    if (matrix[i][j] == Constants.dominance.index()){
                        flagOfDominations++;
                    }

                }
                if (flagOfDominations == 0){
                    vertexes[numOfVertex] = i;
                    numOfVertex++;
                }
            }
            int[] tmp = new int[numOfVertex];
            for (int k = 0; k < numOfVertex; k++){
                tmp[k] = vertexes[k];
            }
            result.add(tmp);
        }
        return result;
    }

    public static int[] kernelAllocation(List<int[]> listOfDegrees, int[][] matrix, int sizeOfMatrix){
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

}
