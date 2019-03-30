package me.zhangyc.study.leetcode.no00004;

class Solution {
    private int binaryFindCeil(int[] num, int left, int right, int ceil) {
        if (num[left] > ceil) {
            return -1;
        }
        int l = left, r = right;
        while (l < r) {
            if (l + 1 == r) {
                if (num[r] > ceil) {
                    return l;
                } else {
                    return r;
                }
            }
            int m = (l + r) / 2;
            if (num[m] <= ceil) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int isOdd = (nums1.length + nums2.length) % 2;
        if (nums1.length == 0) {
            if (isOdd == 1) {
                return nums2[nums2.length / 2];
            } else {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
            }
        }
        if (nums2.length == 0) {
            if (isOdd == 1) {
                return nums1[nums1.length / 2];
            } else {
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
            }
        }

        int l = Math.min(nums1[0], nums2[0]);
        int r = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);

        while (l < r) {
            int m = (l + r) / 2;
            int i1 = binaryFindCeil(nums1, 0, nums1.length - 1, m);
            int i2 = binaryFindCeil(nums2, 0, nums2.length - 1, m);
            int numi1 = i1 < 0 ? Integer.MIN_VALUE : nums1[i1];
            int numi2 = i2 < 0 ? Integer.MIN_VALUE : nums2[i2];
            int numi1n = i1 + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[i1 + 1];
            int numi2n = i2 + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[i2 + 1];

            if (i1 + 1 + i2 + 1 == (nums1.length + nums2.length + 1) / 2) {
                if (isOdd == 1) {
                    return Math.max(numi1, numi2);
                } else {
                    return (Math.max(numi1, numi2) + Math.min(numi1n, numi2n)) / 2.0;
                }
            } else if (i1 + 1 + i2 + 1 > (nums1.length + nums2.length + 1) / 2) {
                r = Math.max(numi1, numi2);
            } else {
                l = Math.min(numi1n, numi2n);
            }
        }
        return l;
    }
}

public class LeetCode4 {
    public static void main(String[] args) {

    }
}
