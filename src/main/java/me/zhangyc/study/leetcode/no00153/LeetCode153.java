package me.zhangyc.study.leetcode.no00153;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if ((m == 0 || m > 0 && nums[m] < nums[m - 1]) && (m == nums.length - 1 || m < nums.length - 1 && nums[m] < nums[m + 1])) {
                return nums[m];
            }
            if (nums[m] > nums[0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l < nums.length && nums[l] < nums[0]) {
            return nums[l];
        } else {
            return nums[0];
        }
    }
}

public class LeetCode153 {
    public static void main(String[] args) {

    }
}
