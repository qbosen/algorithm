package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//[745] 前缀和后缀搜索
/* ["WordFilter","f"],[[["apple"]],["a","e"]] */
public class PrefixAndSuffixSearch {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordFilter {
        static class Node {
            Node[] next = new Node[26];
            List<Integer> indices = new ArrayList<>();
        }

        private final Node root;
        private final Node tail;

        public WordFilter(String[] words) {
            root = new Node();
            tail = new Node();
            for (int i = 0; i < words.length; i++) {
                Node prefix = root;
                Node suffix = tail;
                char[] arr = words[i].toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    int idx = arr[j] - 'a';
                    if (prefix.next[idx] == null) {
                        prefix.next[idx] = new Node();
                    }
                    prefix = prefix.next[idx];
                    prefix.indices.add(i);

                    idx = arr[arr.length - j - 1] - 'a';
                    if (suffix.next[idx] == null) {
                        suffix.next[idx] = new Node();
                    }
                    suffix = suffix.next[idx];
                    suffix.indices.add(i);
                }
            }
        }

        public int f(String pref, String suff) {
            Node node = root;
            for (char c : pref.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null) {
                    return -1;
                }
            }
            List<Integer> prefixIndices = node.indices;

            node = tail;
            char[] arr = suff.toCharArray();
            for (int i = arr.length - 1; i >= 0; i--) {
                node = node.next[arr[i] - 'a'];
                if (node == null) {
                    return -1;
                }
            }
            List<Integer> suffixIndices = node.indices;

            int i = prefixIndices.size() - 1;
            int j = suffixIndices.size() - 1;
            while (i >= 0 && j >= 0) {
                int a = prefixIndices.get(i);
                int b = suffixIndices.get(j);
                if (a == b) {
                    return a;
                } else if (a > b) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}