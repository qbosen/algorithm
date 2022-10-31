package leetcode.editor.cn;

//[481] 神奇字符串
/* 6 */
public class MagicalString {
    public static void main(String[] args) {
        Solution solution = new MagicalString().new Solution();
        System.out.println(solution.magicalString(100000)); //49972
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
            public int magicalString(int n) {
                if (n < 4) {
                    return 1;
                }
                int[] arr = new int[n];
                arr[0] = 1;
                arr[1] = 2;
                arr[2] = 2;

                int res = 1;
                int i = 2;
                int j = 3;
                while (j < n) {
                    int size = arr[i] ;
                    int num = 3 - arr[j - 1];
                    while (size > 0 && j < n) {
                        arr[j] = num;
                        if (num == 1) {
                            ++res;
                        }
                        ++j;
                        --size;
                    }
                    ++i;
                }
                return res;
            }

    }
//leetcode submit region end(Prohibit modification and deletion)

}