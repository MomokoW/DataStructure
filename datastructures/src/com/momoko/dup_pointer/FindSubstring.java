package com.momoko.dup_pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by momoko on 2021/6/10.
 */
public class FindSubstring {

    class Counter extends HashMap<String, Integer> {

        public Integer get(Object key) {
            return containsKey(key) ? super.get(key) : 0;
        }

        public void add(String k, Integer v) {
            put(k, get(k) + v);
            if (get(k) <= 0) {
                remove(k);
            }
        }

    }
    public List<Integer> findSubstring(String s, String[] words) {
        Counter H = new Counter();
        int wordLength = 0;
        // 统计字典中单词出现的次数
        for (String w : words) {
            wordLength = w.length();
            H.add(w, 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (int start = 0; start < wordLength; start++) {
            // 记录当前位置开始切分的单词的
            // 计数器
            Counter R = new Counter();
            int left = start - wordLength;
            int equalCount = 0;
            // 有效的区间是(left, i]
            int counter = 0;

            for (int i = start; i + wordLength <= s.length(); i += wordLength) {
                String tmp = s.substring(i, i + wordLength);
                R.add(tmp, 1);

                if (R.get(tmp) == H.get(tmp)) {
                    equalCount++;
                }

                counter++;

                // 如果窗口太小
                if (counter < words.length) {
                    continue;
                }

                // 到这里时，窗口的长度已经一样了
                // 看一下命中率
                if (equalCount == H.size()) {
                    ans.add(left + wordLength);
                }

                // 移除开头的那个元素
                left += wordLength;
                String rm = s.substring(left, left + wordLength);
                if (R.get(rm) == H.get(rm)) {
                    equalCount--;
                }
                R.add(rm, -1);
            }
        }

        return ans;
    }
}
