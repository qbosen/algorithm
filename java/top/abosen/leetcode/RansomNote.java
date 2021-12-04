package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[383] 赎金信
/* "a","b" */
public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            char[] map = new char[26];
            for (int i = 0; i < magazine.length(); i++) {
                map[magazine.charAt(i) - 'a']++;
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                int idx = ransomNote.charAt(i) - 'a';
                if (map[idx] == 0) {
                    return false;
                }
                map[idx]--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}