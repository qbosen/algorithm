package leetcode.editor.cn;

import java.util.List;

//[648] 单词替换
/* ["cat","bat","rat"],"the,cattle,was,rattled,by,the,battery" */
public class ReplaceWords {
    public static void main(String[] args) {
        Solution solution = new ReplaceWords().new Solution();
        System.out.println(solution.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(solution.replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
        System.out.println(solution.replaceWords(List.of("aa", "ab", "a","cads"), "aadsfasf absbs bbab cadsfafs"));
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

            public void insert(String s) {
                Trie node = this;
                for (int i = 0; i < s.length(); i++) {
                    int pos = s.charAt(i) - 'a';
                    if (node.children[pos] == null) {
                        node.children[pos] = new Trie();
                    }
                    node = node.children[pos];
                }
                node.isEnd = true;
            }

            /**
             * 按范围查找, 左闭右开
             *
             * @return 最短词根的长度, 没有返回 范围大小
             */
            public int searchShortestLength(String s, int l, int r) {
                Trie node = this;
                int range = r - l;
                for (int i = l; i < r; i++) {
                    int pos = s.charAt(i) - 'a';
                    node = node.children[pos];
                    if (node == null) {
                        return range;
                    }
                    if (node.isEnd) {
                        return i - l + 1;
                    }
                }
                return range;
            }
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            dictionary.forEach(trie::insert);
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i < sentence.length()) {
                int start = i;
                while (i < sentence.length() && sentence.charAt(i) != ' ') {
                    i++;
                }
                int size = trie.searchShortestLength(sentence, start, i);
                for (int j = start; j < start + size; j++) {
                    sb.append(sentence.charAt(j));
                }

                if (i < sentence.length()) {
                    sb.append(' ');
                }
                i++;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}