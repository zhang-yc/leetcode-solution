package me.zhangyc.study.leetcode.no00240;

class Solution {
    private boolean searchLine(int[] line, int target) {
        int l = 0, r = line.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (line[m] == target) {
                return true;
            } else if (line[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l < r) {
            return line[l] == target;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] line : matrix) {
            if (searchLine(line, target)) {
                return true;
            }
        }
        return false;
    }
}

public class LeetCode240 {
    public static void main(String[] args) {

    }
}
