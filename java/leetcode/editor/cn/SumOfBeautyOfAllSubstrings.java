package leetcode.editor.cn;

//[1781] 所有子字符串美丽值之和
/* "aabcb" */
public class SumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        Solution solution = new SumOfBeautyOfAllSubstrings().new Solution();
        solution.beautySum("aabcb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] cnt = new int[26];
                int maxFreq = 0;
                for (int j = i; j < s.length(); j++) {
                    int index = s.charAt(j) - 'a';
                    cnt[index]++;
                    maxFreq = Math.max(maxFreq, cnt[index]);
                    int minFreq = s.length();
                    for (int k = 0; k < 26; k++) {
                        if (cnt[k] > 0) {
                            minFreq = Math.min(minFreq, cnt[k]);
                        }
                    }
                    res += maxFreq - minFreq;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}