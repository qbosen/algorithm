package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[720] 词典中最长的单词
/* ["w","wo","wor","worl","world"] */
public class LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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

            private boolean search(String prefix) {
                Trie node = this;
                for (int i = 0; i < prefix.length(); i++) {
                    char ch = prefix.charAt(i);
                    int idx = ch - 'a';
                    if (node.children[idx] == null || !node.children[idx].isEnd) {
                        return false;
                    }
                    node = node.children[idx];
                }
                return true;
            }
        }

        public String longestWord(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            String res = "";
            for (String word : words) {
                if (trie.search(word) && (
                        word.length() > res.length() ||
                        (word.length() == res.length() && word.compareTo(res) < 0)
                )){
                    res = word;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}