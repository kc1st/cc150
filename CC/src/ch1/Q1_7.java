package ch1;

/**
 * Feb 20, 2016
 * 1.7: in an M*N matrix, an element set its row and column to 0
 * ask: 
       1. additional space
       2. matrix of int
       3. time complexity
 * solution:
       1. use two arrays to store the number of rows and columns which have an 0 element
       2. scan the whole matrix, set elements to 0 according to the row and column number
       3. Space: O(m+n) Time: O(m*n)
 */

import java.util.*;
public class Q1_7 {

  public static void main(String[] args) {
    int[][] matrix = new int[5][7];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 7; j++) {
        if(j != 3*i) {
          matrix[i][j] = 1;
        }
      }
      System.out.println(Arrays.toString(matrix[i]));
    }
    
    System.out.println();
    Solution s = new Solution();
    s.row(matrix);
    for (int[] a: matrix) {
      System.out.println(Arrays.toString(a));
    }
  }

  static class Solution {
    void row(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      boolean[] rows = new boolean[m];
      boolean[] cols = new boolean[n];
      
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == 0) {
            cols[j] = true;
            rows[i] = true;
            break;
          }
        }
      }
      
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (rows[i] || cols[j]) {
            matrix[i][j] = 0;
          }
        }
      }
    } 
  }
}
