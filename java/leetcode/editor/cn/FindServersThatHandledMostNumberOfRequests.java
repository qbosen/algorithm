package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import leetcode.editor.cn.struct.*;

//[1606] 找到处理最多请求的服务器
/* 3,[1,2,3,4,5],[5,2,3,3,3] */
public class FindServersThatHandledMostNumberOfRequests {
    public static void main(String[] args) {
        Solution solution = new FindServersThatHandledMostNumberOfRequests().new Solution();
        solution.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            TreeSet<Integer> idle = new TreeSet<>();
            for (int i = 0; i < k; i++) {
                idle.add(i);
            }
            int maxHandles = 0;
            int[] handle = new int[k];
            // int[]{idx, finishTime}
            PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[1]));

            for (int i = 0; i < arrival.length; i++) {
                int currentTime = arrival[i];
                // 每来一个消息，移除 优先队列 中已经处理结束的服务器，放入空闲服务器
                while (!busy.isEmpty() && busy.peek()[1] <= currentTime) {
                    int[] server = busy.poll();
                    idle.add(server[0]);
                }
                // 查找空闲服务器
                if (idle.isEmpty()) continue;
                Integer targetServer = idle.ceiling(i % k);
                // 一个环, 找第一个
                if (targetServer == null) {
                    targetServer = idle.first();
                }
                idle.remove(targetServer);
                handle[targetServer]++;
                busy.offer(new int[]{targetServer, currentTime + load[i]});
                maxHandles = Math.max(maxHandles, handle[targetServer]);
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < handle.length; i++) {
                if (handle[i] == maxHandles) {
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}