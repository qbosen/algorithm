// @algorithm @lc id=1000038 lang=java 
// @title find-majority-element-lcci

// @test([1,2,5,9,5,9,5,5,5])=5
// @test([3,2])=-1
// @test([2,2,1,1,1,2,2])=2
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        // 确认这个candidate是否过半
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count * 2 > nums.length ? candidate : -1;
    }
}