package com.diplom.ogromazina.choicefilm.data;

public abstract class APrincipe {
    
   protected Matrix matrix;
   
   protected int[] result;
   
   APrincipe (Matrix matrix){
       this.matrix = matrix;
   }
    
   public void main() {}
   
   public int[] getResult() {
       return result;
   }
   
   public void printMatrix() {
       System.out.println("\n--------------------Исходная матрица--------------------\n");
       for (int i = 0; i < matrix.getSize(); i++)
       {
           for (int j = 0; j < matrix.getSize(); j++)
           {
               System.out.print(Double.toString(matrix.getMatrix()[i][j]) + "  ");
           }
           System.out.println();
       }
       System.out.println();
   }
   
   public void printResult() {
       System.out.println("\n--------------------Результат--------------------\n");
       for (int i = 0; i < result.length; i++) {
           System.out.print(Integer.toString(result[i])  + " ");
       }
       System.out.println();
   }
   
   public void drawMatrix() {

   }
    
}
