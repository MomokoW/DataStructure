package com.momoko.dup_pointer;

/**
 * Created by momoko on 2021/6/10.
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过10^4。
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。

 */
public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        characterReplacement(s, k);
    }
    public static int characterReplacement(String s, int k) {
        // 统计字符出现的次数，替换成出现次数最多的字符
        int N = s.length();
        int left = -1;
        int oneNumber = 0;
        int ans = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            cnt[c - 'A']++;
            oneNumber = Math.max(cnt[c - 'A'], oneNumber);

            // 考点：最长区间
            // 坏了才移动原则：当新字符加进来
            // 如果除了主力字符，剩下的还是太多
            // 那么需要移除一个就可以了
            if (i - left - oneNumber > k) {
                int old = s.charAt(++left);
                cnt[old - 'A']--;
            }
            // 到这里为止，(left, i]就是一个满足要求的区间
            ans = Math.max(ans, i - left);
        }
        return ans;
    }
}
