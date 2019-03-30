package me.zhangyc.study.leetcode.no00125;

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            while (i < j) {
                if (ci >= 'a' && ci <= 'z' || ci >= 'A' && ci <= 'Z' || ci >= '0' && ci <= '9') {
                    break;
                } else {
                    i += 1;
                    ci = s.charAt(i);
                    continue;
                }
            }
            char cj = s.charAt(j);
            while (i < j) {
                if (cj >= 'a' && cj <= 'z' || cj >= 'A' && cj <= 'Z' || cj >= '0' && cj <= '9') {
                    break;
                } else {
                    j -= 1;
                    cj = s.charAt(j);
                    continue;
                }
            }
            if (i < j) {
                if (ci == cj || ci >= 'a' && ci <= 'z' && ci + ('A' - 'a') == cj || ci == cj + ('A' - 'a') && cj >= 'a' && cj <= 'z') {
                    i += 1;
                    j -= 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

public class LeetCode125 {
    public static void main(String[] args) {

    }
}
