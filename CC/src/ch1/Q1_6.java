package ch1;

/**
 * Feb 20, 2016
 * 1.6: rotate a N*N matrix of pixels by 90 degrees
 * ask: 
       1. space and time complexity
       2. rotate to right or left: right
       3. a matrix of int/object
 * solution:
       1. split one layer into top, right, bottom, left four lines
       2. for every element of each line：
               store the top
               take orders moving the other three lines
 */

import java.util.Arrays;

public class Q1_6 {

  public static void main(String[] args) {
    int[][] images = new int[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        images[i][j] = j;
      }
      System.out.println(Arrays.toString(images[i]));
    }
    
    Solution s = new Solution();
    s.rotate90(images);
    for (int[] a: images ) {
      System.out.println(Arrays.toString(a));
    }
  }
  
  static class Solution {
    void rotate90 (int[][] images) {
      int n = images.length;
      for (int layer = 0; layer < n / 2; layer ++) {
        int first = layer;
        int last = n - layer - 1;
        
        for (int i = first; i < last; i++) {
          
          int offset = i - first;
          // save elements of top row in this index i
          int tmp = images[first][i];
          
          // left to top
          images[first][i] = images[last-offset][first];
          
          // bottom to left
          images[last-offset][first] = images[last][last-offset];
          
          // right to bottom
          images[last][last-offset] = images[i][last];
          
          // top to right
          images[i][last] = tmp;
        }
      }
    }
  }
}