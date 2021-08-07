package inteview.concurrent.shopee;

/**
 * Created by momoko on 2021/8/2.
 * 寻找数组的平衡点
 * 详细描述
 * 给出一个数组，你需要找到在这个数组中的“平衡点”。
 * 一个数组的“平衡点”满足 在它左边的所有数字的和等于在它右边的所有数字的和（不包括平衡点本身）。
 * 你的代码应该返回平衡数的下标，如果平衡数存在多个，返回最小的下标。
 *
 * 输入：[1,2,3,4,6]
 * 输出：3
 */
public class FindBalancedIndex {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * find balanced index for an input array
     * @param inputArray int整型一维数组 the input array
     * @return int整型
     */
    public static int findBalancedIndex(int[] inputArray) {
        // 先计算所有数字的和
        int sum = 0;
        int N = inputArray.length;
        for (int i = 0; i < N; i++) {
            sum += inputArray[i];
        }
        // 滑动计算左子数组的和
        int leftSum = 0;
        for (int i = 0; i < N; i++) {
            if (sum - inputArray[i] - leftSum == leftSum) {
                return i;
            } else {
                leftSum += inputArray[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6};
        int balancedIndex = findBalancedIndex(nums);
        System.out.println(balancedIndex);
    }

}
