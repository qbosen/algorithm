package leetcode.editor.cn;

// 208 实现 Trie (前缀树)
/* ["Trie","insert","search","search","startsWith","insert","search"],[[],["apple"],["apple"],["app"],["app"],["app"],["app"]] */

public class ImplementTriePrefixTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                node = node.children[idx];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                node = node.children[idx];
                if (node == null) {
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}