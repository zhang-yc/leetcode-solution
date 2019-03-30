package me.zhangyc.study.leetcode.no00887;

class Solution {
    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }
        if (K == 1) {
            return N;
        }
        int[][] c = new int[K + 1][N + 1];
        for (int i = 1; i <= K; ++i) {
            c[i][1] = 1;
        }
        for (int i = 1; i <= N; ++i) {
            c[1][i] = i;
        }
        for (int i = 2; i <= K; ++i) {
            for (int j = 2; j <= N; ++j) {
                c[i][j] = 1 + c[i - 1][j - 1] + c[i][j - 1];
                if (i == K && c[i][j] >= N) {
                    return j;
                }
            }
        }
        return N;
    }
}

public class LeetCode887 {
    public static void main(String[] args) {

    }
}
