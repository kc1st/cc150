package ch1;

/**
 * Feb 11, 2016
 * 1.4: replace spaces in a string (with enough spaces for extension) with '%20'
 * solution
       1. get the last character except space
       2. from the last char to the first, store character at then end of the string
       3. store '0', '2', '%' if next character is a space
 */

public class Q1_4 {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.convertStr("Mr John Smith    "));
  }

  static class Solution {
    String convertStr(String s)  {
      if (s.isEmpty()) {
        return s;
      }
      char[] chars= s.toCharArray();
      int endIndex = 0;
      int end = s.length() - 1;
      for (int i = end; i >= 0; i--) {
        if(chars[i] != ' ') {
          endIndex = i;
          break;
        }
      }
      for (int i = endIndex; i >= 0; i--) {
        if(chars[i] != ' ') {
          chars[end--] = chars[i];
        }
        else {
          chars[end--] = '0';
          chars[end--] = '2';
          chars[end--] = '%';
        }
      }

      return new String(chars);
    }
  }
}
