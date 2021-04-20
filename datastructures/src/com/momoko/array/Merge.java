package com.momoko.array;

/**
 * Created by momoko on 2021/4/5.
 */
public class Merge {
    public static void main(String[] args) {
        Merge m = new Merge();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        m.merge(nums1, 3, nums2, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //使用双指针，从后往前遍历，将较大的数放入nums1最后面
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n - 1;
        while (p1 >=0 || p2 >= 0) {
            if (p1 != -1 && p2 != -1) {
                nums1[cur--] = nums1[p1--] > nums2[p2--] ? nums1[p1--] : nums2[p2--];
            } else if (p1 == -1) {
                nums1[cur--] = nums2[p2--];
            } else {
                nums1[cur--] = nums1[p1--];
            }
        }
    }
}