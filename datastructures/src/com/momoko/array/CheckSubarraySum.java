package com.momoko.array;

/**
 * Created by momoko on 2021/6/2.
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{23,2,6,4,7};
        checkSubarraySum(nums, 13);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;
        if (N < 2) {
            return false;
        }
        if (k == 1 && N >= 2) {
            return true;
        }
        // 使用前缀和存储从i - j之间的和
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        // 注意，这里0也为k的倍数
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                int temp = sum[j] - sum[i - 1];
                if (temp % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}