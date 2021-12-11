package top.abosen.leetcode;

import java.util.HashMap;
import java.util.Map;

//[911] 在线选举
/* ["TopVotedCandidate","q","q","q","q","q","q"],[[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]] */
public class OnlineElection {
    public static void main(String[] args) {
        TopVotedCandidate candidate = new OnlineElection().new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(candidate.q(3));
        System.out.println(candidate.q(12));
        System.out.println(candidate.q(25));
        System.out.println(candidate.q(15));
        System.out.println(candidate.q(24));
        System.out.println(candidate.q(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TopVotedCandidate {
        int[] times;
        int[] topPersonInTime;
        int n;

        public TopVotedCandidate(int[] persons, int[] times) {
            Map<Integer, Integer> personVote = new HashMap<>();
            this.times = times;
            this.n = times.length;
            this.topPersonInTime = new int[n];
            int topCount = -1;
            int topCountP = -1;
            for (int i = 0; i < n; i++) {
                int vote = personVote.getOrDefault(persons[i], 0) + 1;
                personVote.put(persons[i], vote);
                if (vote >= topCount) {
                    topCount = vote;
                    topCountP = persons[i];
                }
                this.topPersonInTime[i] = topCountP;
            }
        }

        public int q(int t) {
            int l = 0, r = n - 1;
            // 找到第一个小于等于t的时间
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (times[m] > t) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            return topPersonInTime[l];
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}