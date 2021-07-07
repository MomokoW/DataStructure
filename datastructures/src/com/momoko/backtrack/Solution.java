package com.momoko.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by momoko on 2021/7/3.
 */
class Solution {
    private int totalNum = 0;
    public int combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtrace(candidates, 0, target, list);
        return totalNum;
    }

    public void backtrace(int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
           totalNum++;
        }
        if (target < 0) {
            return;
        }
        if (start >= candidates.length) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrace(candidates, i + 1, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
