package leetcode.editor.cn;
// 设计推特
// 355
// ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
// [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIterableContainingInOrder;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DesignTwitter {


    public static void main(String[] args) {
        Twitter twitter = new DesignTwitter().new Twitter();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        assertThat(twitter.getNewsFeed(1), contains(5));

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        assertThat(twitter.getNewsFeed(1), IsIterableContainingInOrder.contains(6, 5));

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        assertThat(twitter.getNewsFeed(1), Matchers.<Iterable<Integer>>both(iterableWithSize(1)).and(contains(5)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Twitter {
        int guid = 0;
        Map<Integer, Set<Integer>> userFollowMap;
        Map<Integer, LinkedList<Twit>> userRecentTweet;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userFollowMap = new HashMap<>();
            userRecentTweet = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            userRecentTweet.compute(userId, (k, v) -> {
                if (v == null) {
                    v = new LinkedList<>();
                } else if (v.size() == 10) {
                    v.get(8).next = null;   // 删除对最后一个元素的引用
                    v.removeLast();
                }
                Twit e = new Twit(tweetId, guid++);
                e.next = v.peekFirst();
                v.addFirst(e);
                return v;
            });
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> users = userFollowMap.getOrDefault(userId, new HashSet<>());
            users.add(userId);

            List<Twit> collect = users.stream().map(it -> userRecentTweet.get(it)).filter(Objects::nonNull)
                    .map(LinkedList::peekFirst).filter(Objects::nonNull).collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            if (collect.isEmpty()) return result;
            while (result.size() < 10) {
                int roundMaxLoc = -1;

                for (int i = 0; i < collect.size(); i++) {
                    Twit it = collect.get(i);
                    if (it == null) continue;
                    if (roundMaxLoc == -1) {
                        roundMaxLoc = i;
                        continue;
                    }
                    if (it.gid > collect.get(roundMaxLoc).gid)
                        roundMaxLoc = i;
                }
                // 一圈结束
                if (roundMaxLoc == -1) break;
                Twit twit = collect.get(roundMaxLoc);
                result.add(twit.id);
                collect.set(roundMaxLoc, twit.next);
            }
            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            userFollowMap.compute(followerId, (k, v) -> {
                if (v == null) v = new HashSet<>();
                v.add(followeeId);
                return v;
            });
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            userFollowMap.computeIfPresent(followerId, (k, v) -> {
                v.remove(followeeId);
                return v;
            });
        }
    }

    class Twit {
        int gid;
        int id;
        Twit next;

        public Twit(int id, int guid) {
            this.gid = guid;
            this.id = id;
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}