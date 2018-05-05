package com.diplom.ogromazina.choicefilm.data.utils;

import com.diplom.ogromazina.choicefilm.data.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OGromazina on 5/5/2018.
 */

public class PrincipeNandM {

    public static void principeNandM(Matrix matrix){
        List<int[]> factorList = factorization(matrix.getMatrix());
        
    }

    public static List<int[]> factorization(int[][] matrix){
        List<int[]> result = new ArrayList<>();
        int[] vertexes = new int [matrix[0].length];
        int numOfVertex = 0;
        boolean flagOfMissVertexRow;
        boolean flagOfMissVertexCol;
        int flagOfDominations;
        while (numOfVertex != matrix[0].length){
            flagOfMissVertexRow = false;
            flagOfMissVertexCol = false;
            flagOfDominations = 0;
            for (int i = 0; i < matrix[0].length; i++){
                for (int l : vertexes){
                    if (i == l){
                        flagOfMissVertexRow = true;
                        break;
                    }
                }
                if(flagOfMissVertexRow == true){
                    continue;
                }
                for (int j = 0; j < matrix[0].length; j++){
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

    public static int[] kernelAllocation(List<int[]> listOfDegrees, int[][] matrix){
        int[] result = new int[matrix[0].length];
        //TODO: implement this nethod
        return result;
    }

}
