package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//[472] 连接词
/* ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"] */
public class ConcatenatedWords {
    public static void main(String[] args) {
        Solution solution = new ConcatenatedWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Trie trie = new Trie();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Arrays.sort(words, 0, words.length, Comparator.comparingInt(String::length));
            List<String> res = new ArrayList<>();
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                if (dfs(word, 0)) {
                    res.add(word);
                } else {
                    trie.insert(word);
                }
            }
            return res;
        }

        private boolean dfs(String word, int start) {
            if (word.length() == start) {
                // dfs 到了最后一个字符，且上一个是完整的字符
                // word不会重复，所以不会搜索到自己
                return true;
            }
            Trie node = trie;
            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                node = node.children[index];
                if (node == null) {
                    return false;
                }
                // 遇到一个完整的词语，可以继续搜索word，可以认为找到了一个组成，搜索下一个组成
                if (node.isEnd) {
                    if (dfs(word, i + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }


        class Trie {
            Trie[] children;
            boolean isEnd;

            public Trie() {
                this.children = new Trie[26];
                this.isEnd = false;
            }

            public void insert(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    int idx = ch - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new Trie();
                    }
                    node = node.children[idx];
                }
                node.isEnd = true;
            }

            public boolean search(String word) {
                Trie node = searchPrefix(word);
                return node != null && node.isEnd;
            }

            public boolean startsWith(String prefix) {
                return searchPrefix(prefix) != null;
            }

            private Trie searchPrefix(String prefix) {
                Trie node = this;
                for (int i = 0; i < prefix.length(); i++) {
                    char ch = prefix.charAt(i);
                    int idx = ch - 'a';
                    if (node.children[idx] == null) {
                        return null;
                    }
                    node = node.children[idx];
                }
                return node;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}