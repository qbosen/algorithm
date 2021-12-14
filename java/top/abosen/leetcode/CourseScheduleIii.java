package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[630] 课程表 III
/* [[100,200],[200,1300],[1000,1250],[2000,3200]] */
public class CourseScheduleIii{
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIii().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;
        for (int[] c : courses) {
            int d = c[0], e = c[1];
            sum += d;
            q.add(d);
            if (sum > e) sum -= q.poll();
        }
        return q.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}