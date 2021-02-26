package leetcode.editor.cn;

import java.util.*;

//1178 猜字谜
/* ["aaaa","asas","able","ability","actt","actor","access"],["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"] */
public class NumberOfValidWordsForEachPuzzle {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            Map<Integer, Integer> frequency = new HashMap<>();
            for (String word : words) {
                int mask = 0;
                for (int i = 0; i < word.length(); i++) {
                    mask |= (1 << (word.charAt(i) - 'a'));
                }
                // puzzle有7钟字符, word不可能超过7
                if (Integer.bitCount(mask) <= 7)
                    frequency.compute(mask, (x, v) -> v == null ? 1 : v + 1);
            }

            List<Integer> result = new ArrayList<>(puzzles.length);
            for (String puzzle : puzzles) {
                int count = 0;
                // 除开首位的mask,枚举puzzle子集 2^6 = 64
                for (int choose = 0; choose < 1 << 6; choose++) {
                    int mask = 1 << (puzzle.charAt(0) - 'a');
                    // 是否选中puzzle中剩下的几位
                    for (int i = 0; i < 6; i++) {
                        if ((choose & (1 << i)) != 0)
                            mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
                    }
                    count += frequency.getOrDefault(mask, 0);
                }
                result.add(count);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}