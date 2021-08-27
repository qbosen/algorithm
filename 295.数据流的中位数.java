import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (52.13%)
 * Likes:    508
 * Dislikes: 0
 * Total Accepted:    54.9K
 * Total Submissions: 105.3K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n' +
  '[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 
 * 例如，
 * 
 * [2,3,4] 的中位数是 3
 * 
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 
 * 设计一个支持以下两种操作的数据结构：
 * 
 * 
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 
 * 
 * 示例：
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 进阶:
 * 
 * 
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 
 * 
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;

    /** initialize your data structure here. */
    public MedianFinder() {
        l = new PriorityQueue<>((a,b)->b-a);    // max
        r = new PriorityQueue<>((a,b)->a-b);    // min
    }

    public void addNum(int num) {
        int sl = l.size(), sr = r.size();
        if(sl == sr){
            if(r.isEmpty() || r.peek() >= num){
                // 正该加入左边
                l.add(num);
            }else{
                // 把右边的最小值放到左边
                l.add(r.poll());
                r.add(num);
            }
        }else{
            // 左边 >= 右边， 如果不等，则左边必然非空, 元素加入右边
            if(l.peek() <= num){
                r.add(num);
            }else{
                r.add(l.poll());
                l.add(num);
            }
        }
    }

    public double findMedian() {
        int sl = l.size(), sr = r.size();
        if(sl == sr){
            return (l.peek() + r.peek()) / 2.0;
        }else{
            return l.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
