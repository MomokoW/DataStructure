package com.momoko.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by momoko on 2021/4/14.
 */
public class Trie {
    Set<String> words;
    Set<String> prefixs;
    /** Initialize your data structure here. */
    public Trie() {
        words = new HashSet<>();
        prefixs = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (!words.contains(word)) {
            words.add(word);
        }
        for (int i = word.length(); i > 0; i--) {
            String sub = word.substring(0, i);
            if (!prefixs.contains(sub)) {
                prefixs.add(sub);
            } else {
                break;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return words.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return prefixs.contains(prefix);
    }
}