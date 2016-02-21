package ch1;

/**
 * Feb 11, 2016
 * 1.3: if a string is a permutation (has same characters) of the other
 * ask: 
       1. if case sensitive
       2. space and time complexity
       3. String of ASCII
 * solution
       1. if either is null, false
       2. if length differs, false
       3. sort two strings
       4. check if equal
 */

import java.util.*;
import java.io.*;

public class Q1_3 {
  public static void main(String[] args) throws FileNotFoundException {
    
    Solution s1 = new Solution();
    System.out.println(s1.isPermu("abcba", "cbbaa"));
    System.out.println(s1.isPermu("abcba", "cbcaa"));
    
    Solution2 s2 = new Solution2();
    System.out.println(s2.isPermu("abcba", "cbbaa"));
    System.out.println(s2.isPermu("abcba", "cbcaa"));
  }
 }

/*
 * Arrays.sort() uses quicksort 
 * time: O(n*logn)
 * space: O(n)
 */

class Solution {
  boolean isPermu(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    
    Arrays.sort(c1);
    Arrays.sort(c2);
    
    return Arrays.equals(c1, c2);
  }
}

/* 
 * time: O(n)
 * space: O(1) an int[256], 256 is a constant
 */

class Solution2 {
  boolean isPermu(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    
    int[] char_set = new int[256];
    for (int i = 0; i < s1.length(); i++) {
      char_set[s1.charAt(i)]++;
    }
    
    for (int i = 0; i < s2.length(); i++) {
      if (--char_set[s2.charAt(i)] < 0)
        return false;
    }
    
    return true;
  }
}









