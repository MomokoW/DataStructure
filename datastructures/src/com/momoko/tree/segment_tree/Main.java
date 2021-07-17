package com.momoko.tree.segment_tree;

/**
 * Created by momoko on 2021/7/12.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        Integer res = segmentTree.query(2, 5);
        System.out.println(res);
//        System.out.println(segmentTree);
    }
}
