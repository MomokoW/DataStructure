package inteview.concurrent.aiqiyi;

import java.util.Scanner;

/**
 * Created by momoko on 2021/8/1.
 */
public class MaxPercent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        // 分割出数组和滑动窗口的大小
        String[] split = str.split(":");
        String strArray = split[0];
        int window = Integer.parseInt(split[1]);
        String[] strArr = strArray.split(",");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        double res = findMaxPercent(nums, window);
        System.out.printf("%.2f", res * 100.0);
        System.out.println("%");

    }

    public static double findMaxPercent(int[] nums, int k) {

//        double p = 1;
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += nums[i];
//        }
//        int l = 0;
//        int r = k;
//        double temp = sum;
//        while (r < nums.length) {
//            sum += nums[r] - nums[l];
//            temp = (sum - temp) / temp;
//            p = Math.max(p, temp);
//            temp = sum;
//            l++;
//            r++;
//        }
//        return p;
        int N = nums.length;
        if (k >= N) {
            return 0.0;
        }
        double sum = 0, preSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = 0.0;
        preSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max((sum - preSum) / preSum, res);
            preSum = sum;
        }
        return res;
    }
}
