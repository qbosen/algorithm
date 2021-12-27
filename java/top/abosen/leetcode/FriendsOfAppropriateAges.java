package top.abosen.leetcode;

import java.util.Arrays;

//[825] 适龄的朋友
/* [16,16] */
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Solution solution = new FriendsOfAppropriateAges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFriendRequests(int[] ages) {
            Arrays.sort(ages);
            int n = ages.length;
            int l = 0, r = 0, ans = 0;
            for (int age : ages) {
                if (age < 15) {
                    continue;
                }
                while (ages[l] <= 0.5 * age + 7) {
                    l++;
                }
                while (r + 1 < n && ages[r + 1] <= age) {
                    r++;
                }
                ans += r - l;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}