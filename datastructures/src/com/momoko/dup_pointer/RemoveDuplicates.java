package com.momoko.dup_pointer;

/**
 * Created by momoko on 2021/4/6.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        removeDuplicates(arr);
    }
    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int len = nums.length;
        while (j < len) {
            if (nums[i] != nums[j]) {
                if (j - i > 2) {
                    int pos = i + 2;
                    int end = j;
                    while (end < nums.length) {
                        nums[pos++] = nums[end++];
                    }
                    len = len - (j - (i + 2));
                    j = i + 2;
                    i = j;
                } else {
                    i = j;
                }
            } else {
                j++;
            }
        }
        return j - i > 1 ? i + 2 : j + 1;
    }
}