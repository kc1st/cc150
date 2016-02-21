package ch1;

/**
 * Feb 20, 2016
 * 1.8: rotate a N*N matrix of pixels by 90 degrees
 * ask: 
       1. case sensitive
 * solution:
       1. check length: s1 and s2 must be of the same length to be rotation
       2. if s2 is a rotation of s1, it must be a substring of s1 + s1
 */

public class Q1_8 {

    boolean isSubstring(String s1, String s2) {
      return true;
    }
    
    boolean isRotation(String s1, String s2) {
      if (s1.length() != s2.length()) {
        return false;
      }
      return isSubstring(s1 + s1, s2);
    }
}
