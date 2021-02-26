package com.momoko.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by momoko on 2021/2/26.
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *
 */
public class FindNumOfValidWords {
    public static void main(String[] args) {
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};


//        Set<Integer> set = findWordsBin(words);
//        set.forEach(System.out::println);

        List<Integer> numOfValidWords = findNumOfValidWords(words, puzzles);
        numOfValidWords.forEach(System.out::println);

        int num = 0;
        num--;
        for(int i=0;i<32;i++){
            int t=(num & 0x80000000>>>i)>>>(31-i);
            System.out.print(t);
        }

    }

    /*
    因为只有26个小写字母，则可以使用int来表示每个单词中包含的字母，在单词中的为1，不在的为0，如ab为11，ac为101
    思路：先将words中的每个单词代表的二进制数存起来，即单词中的字符 s，初始化num=1，num=1<<(s - 'a')&num;这样就得到了每个单词对应的二进制数
    注意：如果两个word的二进制数相同，则需要在对应二进制数的位置上加一
    由于要求谜底包含谜面的第一个字符，则可以列举出谜面包含第一个字符的所有字符组合，然后用相应的二进制数在字典中查找。这些组合查找出来的次数总和即为谜底的个数
     */
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //第一步，首先将words中的每个单词代表的二进制数存进去，并获取对应的次数
        HashMap<Integer,Integer> map = new HashMap<>();

        int num = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                num = (1 << (word.charAt(i) - 'a')) | num;
            }
            //如果word中包含的字符>7，则不用将其加入到map中
            if (Integer.bitCount(num) <= 7) {
                map.put(num,map.getOrDefault(num,0) + 1);
            }
            num = 0;
        }
        List<Integer> result = new ArrayList<>();
        //然后对puzzle进行组合，这里puzzle.length == 7，且没有重复的字符，先求出puzzle[i]对应的二进制数，再采用通用的枚举子集的方法求子集
        int numP = 0;
        int count = 0;
        for (String puzzle : puzzles) {
            //求numP除去第一个字符的所有子集
            for (int i = 1; i < puzzle.length(); i++) {
                numP = (1 << (puzzle.charAt(i) - 'a')) | numP;
            }
            //求numP对应的子集在哈希表中出现的次数，且子集要包含第一个字符
            int sub = numP;
//            do {
//                int s = sub | (1 << (puzzle.charAt(0) - 'a'));
//
//                if (map.containsKey(s)) {
//                    count += map.get(s);
//                }
//                sub = (sub - 1) & numP;
//            } while (sub != numP);
            while (sub > 0) {
                //这样写就不会漏掉第一个，但是会漏掉为0的字串
                int s = sub | (1 << (puzzle.charAt(0) - 'a'));
                if (map.containsKey(s)){
                    count += map.get(s);
                }
                sub = (sub - 1) & numP;
            }
            result.add(count);

            //每算完一个就要重置变量
            numP = 0;
            count = 0;
        }
        return result;

    }

    public static Set<Integer> findWordsBin(String[] words) {
        //第一步，首先将words中的每个单词代表的二进制数存进去，并获取对应的次数
        HashMap<Integer,Integer> map = new HashMap<>();

        int num = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                num = (1 << (word.charAt(i) - 'a')) | num;
            }
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            map.put(num, 1);
            num = 0;
        }
        return map.keySet();
    }
}