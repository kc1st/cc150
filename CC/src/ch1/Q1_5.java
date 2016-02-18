package ch1;

public class Q1_5 {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.compressStr("aabcccccaaa"));
    System.out.println(s.compressStr("abc"));
  }

  static class Solution {
    String compressStr(String s) {
      int len = s.length();
      if(len <= compressStrLength(s) || s.isEmpty()) {
        return s;
      }
      
      StringBuffer sb = new StringBuffer();
      int cnt = 1;
      char current = s.charAt(0);
      for(int i = 1; i < len; i++) {
        if(current == s.charAt(i)) {
          cnt++;
        }
        else {
          sb.append(current);
          sb.append(cnt);
          current = s.charAt(i);
          cnt = 1;
        }
      }
      sb.append(current);
      sb.append(cnt);
      
      return sb.toString();
    }
    
    int compressStrLength(String s) {
      int cnt = 1;
      int len = 0;
      char current = s.charAt(0);
      for(int i = 1; i < s.length(); i++) {
        if(current == s.charAt(i)) {
          cnt++;
        }
        else {
          len += String.valueOf(cnt).length() + 1;
          current = s.charAt(i);
          cnt = 1;
        }
      }
      len += String.valueOf(cnt).length() + 1;
      return len;
    }
  }
}
