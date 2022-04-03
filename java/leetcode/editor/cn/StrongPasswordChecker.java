package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//[420] 强密码检验器
/* "a" */
public class StrongPasswordChecker {
    public static void main(String[] args) {
        Solution solution = new StrongPasswordChecker().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int strongPasswordChecker(String password) {
            int curLen = 0, hasLower = 0, hasUpper = 0, hasNumber = 0;
            List<Integer> continuousNum = new ArrayList<>();
            curLen = password.length();
            char[] cs = password.toCharArray();
            for (char c : cs) {
                if (Character.isLowerCase(c)) {
                    hasLower = 1;
                }
                if (Character.isUpperCase(c)) {
                    hasUpper = 1;
                }
                if (Character.isDigit(c)) {

                    hasNumber = 1;
                }
            }
            int miss = 3 - hasLower - hasUpper - hasNumber;
            for (int i = 0; i < curLen; ) {
                int j = i;
                while (j < curLen && cs[j] == cs[i]) j++;
                if (j - i >= 3) continuousNum.add(j - i);
                i = j;
            }
            //classified discussion
            if (curLen < 6) { //insertion only
                return Math.max(miss, 6 - curLen);
            } else if (curLen >= 6 && curLen <= 20) { //substitute only
                int res = 0;
                for (int conti : continuousNum) res += conti / 3;
                return Math.max(res, miss);
            } else { //delete + substitute
                int[] modCnt = new int[3];
                for (int conti : continuousNum) modCnt[conti % 3]++;
                int delete = curLen - 20;
                int substitute = 0;
                for (int conti : continuousNum) substitute += conti / 3;
                //some delete can save substitute
                int save = 0, delRemain = delete;
                for (int mod = 0; mod < 2; mod++) {
                    int ratio = mod + 1;
                    while (modCnt[mod] > 0 && delRemain >= ratio) {
                        modCnt[mod]--;
                        save++;
                        delRemain -= ratio;
                    }
                }
                save += delRemain / 3;
                int substituteFinal = substitute - save;
                int res = delete + Math.max(miss, substituteFinal);
                return res;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}