/*
 * @lc app=leetcode.cn id=7 lang=golang
 *
 * [7] 整数反转
 */

// @lc code=start
func reverse(x int) int {
	rev := 0
	for x!=0 {
		if rev < math.MinInt32/10 || rev > math.MaxInt32/10{
			return 0
		}
		digit := x%10
		x/=10
		rev = rev*10 + digit
	}
	return rev
}
// @lc code=end

