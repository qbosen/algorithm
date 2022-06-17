package leetcode.editor.cn;

//[1089] 复写零
/* [1,0,2,3,0,4,5,0] */
public class DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new DuplicateZeros().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int n = arr.length, i = 0, j = 0;
            while (j < n) {
                if (arr[i] == 0) j++;
                i++; j++;
            }
            i--; j--;
            while (i >= 0) {
                if (j < n) arr[j] = arr[i];
                if (arr[i] == 0 && --j >= 0) arr[j] = 0;
                i--; j--;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}