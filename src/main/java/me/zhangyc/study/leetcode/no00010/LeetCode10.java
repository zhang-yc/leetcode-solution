package me.zhangyc.study.leetcode.no00010;

class Solution {
    boolean isMatch(char s, char p2) {
        if (p2 == s) {
            return true;
        }
        if (p2 == '.') {
            return true;
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 0; j <= p.length(); ++j) {
                if (i == 0 && j == 0) {
                    m[i][j] = true;
                } else if (i == 0) {
                    if (p.charAt(j - 1) == '*') {
                        m[i][j] = m[i][j - 2];
                    }
                } else if (j == 0) {
                    m[i][j] = false;
                } else {
                    if (p.charAt(j - 1) == '*') {
                        if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                            m[i][j] = m[i - 1][j - 2] || m[i - 1][j] || m[i][j - 2];
                        } else {
                            m[i][j] = m[i][j - 2];
                        }
                    } else {
                        if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                            m[i][j] = m[i - 1][j - 1];
                        } else {
                            m[i][j] = false;
                        }
                    }
                }
            }
        }
        return m[s.length()][p.length()];
    }
}

public class LeetCode10 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.isMatch("aa", "a"));
        System.err.println(solution.isMatch("aa", "a*"));
        System.err.println(solution.isMatch("ab", ".*"));
        System.err.println(solution.isMatch("aab", "c*a*b"));
        System.err.println(solution.isMatch("mississippi", "mis*is*p*."));
    }
}


