package com.diplom.ogromazina.choicefilm.data;

/**
 * Created by OGromazina on 4/22/2018.
 */

public class PrincipleOfNondomination {

    public static void main(int[][] matrix, int sizeOfMatrix, int[] relationships) {
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
        int[] result = new int[sizeOfMatrix];
        int c = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            if (relationships[i] == -1) {
                result[c] = i;
                c++;
            }
        }
    }
}
