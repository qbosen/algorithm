package leetcode.editor.cn;

import java.util.Comparator;
import java.util.TreeSet;

//[729] 我的日程安排表 I
/* ["MyCalendar","book","book","book"],[[],[10,20],[15,25],[20,30]] */
public class MyCalendarI {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {
        TreeSet<int[]> booked;

        public MyCalendar() {
            booked = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        }

        public boolean book(int start, int end) {
            if (booked.isEmpty()) {
                booked.add(new int[]{start, end});
                return true;
            }
            int[] node = {end, 0};
            int[] next = booked.ceiling(node);
            int[] prev = next == null ?
                    booked.last() :
                    booked.lower(next);

            if (prev == null || prev[1] <= start) {
                booked.add(new int[]{start, end});
                return true;
            }
            return false;
        }
    }


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}