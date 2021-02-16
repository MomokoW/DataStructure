package com.momoko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by momoko on 2021/2/14.
 */
public class MergeInterval {
    public int[][] mergeInterval(int[][] intervals) {
        if (intervals.length < 2 || intervals[0].length == 0) {
            return intervals;
        }
        //按数组头元素升序排序（lambda表达式排序是真的慢）
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        ArrayList<int[]> itvs = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            //寻找重叠区间，如果第i个区间的末尾大于第i+1个区间的开始
            if (intervals[i][1] >= intervals[i + 1][0]) {
                //排除完全重叠区间，如[1,4]与[2,3]
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                itvs.add(intervals[i]);
            }
        }
        itvs.add(intervals[intervals.length - 1]);
        return itvs.toArray(new int[0][]);
    }
}