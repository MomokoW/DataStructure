package com.momoko.hashset;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by momoko on 2021/3/16.
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        isIsomorphic(s, t);
    }

    public static boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map = new HashMap<>();
//        Map<Character, Character> map1 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char cs = s.charAt(i);
//            char ct = t.charAt(i);
//            if ((map.containsKey(cs) && map.get(cs) != ct) || (map1.containsKey(ct) && map1.get(ct) != cs)) {
//                return false;
//            }
//            map.put(cs, ct);
//            map1.put(ct, cs);
//        }
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
