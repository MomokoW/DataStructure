package com.momoko.tree.segment_tree;

/**
 * Created by momoko on 2021/7/12.
 */
public interface Merger<E> {
     E merge(E a, E b);
}
