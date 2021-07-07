package com.momoko.dfs;

/**
 * Created by momoko on 2021/6/23.
 */
public class CanPartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        boolean b = canPartitionKSubsets(nums, 4);
        System.out.println(b);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // 先计算每一份的和为多少
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int avgSum = totalSum / k;
        if (totalSum % k != 0) {
            return false;
        }
        // boolean数组记录某个位置是否被使用
        boolean[] used = new boolean[nums.length];
        return dfs(nums, used, avgSum, k, avgSum, 0);
    }
    /**
     * 判断能否将数组nums划分为k个和相等的子集
     * @param nums ：数组
     * @param used ：使用标记
     * @param avg ： 平均数
     * @param k ：k 个子集
     * @param temp ：也是平均数，这里用作记录子集的综合，等于0时，当前子集就确定了
     * @param index ：记录遍历数组时从哪个位置开始遍历，以防将前面的数字重新计算
     */
    public static boolean dfs(int[] nums, boolean[] used, int avg, int k, int temp, int index) {
        if (k == 0) {
            // 说明已经k个子集都已经划分完成
            return true;
        }
        if (temp == 0) {
            // 说明当前子集已经求解完成，开始求解下一个子集
            dfs(nums, used, avg, k - 1, avg, 0);
        }
        // 当前子集未划分完成
        for (int i = index; i < nums.length; i++) {
            if (used[i]) {
                // 该元素已经被用过了
                continue;
            }
            used[i] = true;
            // 递归调用子过程，父过程是否为true，取决于子过程的结果
            if(temp - nums[i] >= 0 && dfs(nums, used, avg, k, temp - nums[i], index + 1)){
                return true;
            }
            // 这一趟没有找到对应的数据，需要释放该元素，下次可以继续用
            used[i] = false;
        }
        // 遍历完了没有返回true，则返回失败
        return false;
    }
}
