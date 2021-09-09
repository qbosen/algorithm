package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.List;

//68 文本左右对齐
/* ["This",,"is",,"an",,"example",,"of",,"text",,"justification."],16 */
public class TextJustification {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int idx = 0, n = words.length;
            List<String> ans = new ArrayList<>();
            List<String> wordLine = new ArrayList<>();
            StringBuilder lineBuilder = new StringBuilder(maxWidth + 1);
            while (idx < n) {
                wordLine.clear();
                // 当前的行长度，词组间带一个空格
                int lineLen = 0;
                // 空行直接加，非空行 判断能不能再加一个词
                while (idx < n && (wordLine.isEmpty() || (lineLen + words[idx].length() + 1) <= maxWidth)) {
                    if (wordLine.isEmpty()) {
                        lineLen += words[idx].length();
                    } else {
                        // 空格加在左边
                        lineLen += 1 + words[idx].length();
                    }
                    wordLine.add(words[idx]);
                    idx++;
                }
                // 当前行放不下下一个词了， 重新组织当前行空格
                lineBuilder.setLength(0);
                if (idx == n) {
                    // 最后一行 左对齐
                    wordLine.forEach(w -> lineBuilder.append(w).append(' '));
                    if (lineBuilder.length() > maxWidth) {
                        lineBuilder.deleteCharAt(lineBuilder.length() - 1);
                    } else {
                        for (int i = lineBuilder.length(); i < maxWidth; i++) {
                            lineBuilder.append(' ');
                        }
                    }
                } else {
                    // 中间行，两边对齐
                    int spaceCount = wordLine.size() - 1;
                    int spaceSize = maxWidth - (lineLen - spaceCount);
                    //spaceCount=0, 只有一个词，会自动跳过词间填空环境，所以minSpace、moreOneCount不用考虑
                    int minSpace = spaceCount == 0 ? 0 : spaceSize / spaceCount;
                    int moreOneCount = spaceCount == 0 ? 0 : spaceSize % spaceCount;

                    for (int i = 0; i < wordLine.size() - 1; i++) {
                        lineBuilder.append(wordLine.get(i));
                        for (int j = 0; j < minSpace; j++) {
                            lineBuilder.append(' ');
                        }
                        if (i < moreOneCount) {
                            lineBuilder.append(' ');
                        }
                    }
                    lineBuilder.append(wordLine.get(wordLine.size() - 1));
                    for (int i = lineBuilder.length(); i < maxWidth; i++) {
                        lineBuilder.append(' ');
                    }
                }

                ans.add(lineBuilder.toString());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}