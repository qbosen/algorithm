package leetcode.editor.cn;

//[1598] 文件夹操作日志搜集器
/* ["d1/","d2/","../","d21/","./"] */
public class CrawlerLogFolder {
    public static void main(String[] args) {
        Solution solution = new CrawlerLogFolder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(String[] logs) {
            int res = 0;
            for (String log : logs) {
                if ("../".equals(log)) {
                    if (res > 0) res--;
                } else if ("./".equals(log)) {

                } else {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}