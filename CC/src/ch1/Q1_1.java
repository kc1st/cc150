package ch1;

/**
 * Feb 11, 2016
 * Cracking the Coding Interview
 * Chapter 1 Arrays and Strings
 * 1.1 check if a string has all unique characters
        1. ask: if a string of ASCII elements
        2. if case sensitive
        3. space and time complexity:  no additional data structures
 * Solution: 
        1. use a hashmap, char as the key, and 0/1 as value
        2. Scan the string, if the char is not in the hashmap, put it in
        3. if the char is in, return false
 */
import java.util.*;

public class Q1_1 {

  public static void main(String[] args) {
    System.out.println(new MySolution().hasUniqueCharacter("FOLLOW UP")
        + "\n" + new MySolution().hasUniqueCharacter("pear"));

  }
}

class MySolution {
  boolean hasUniqueCharacter(String s) {
    if (s.length() <= 1) return true;
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    int e;
    
    for (int i = 0; i < s.length(); i++) {
      e = s.charAt(i);
      if (map.containsKey(e)) return false;
      else map.put(e, 0);
    }
    
    return true;
  }
  
  /*
   * HashMap is additional data structure, and only takes objects
   * a boolean array is set to an array of false
   */
  
  boolean isUniqueChars(String str) {
    if (str.length() > 256) return false;
    
    boolean[] char_set = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val]) return false;
      
      char_set[val] = true;
    }
    return true;
  }
}


