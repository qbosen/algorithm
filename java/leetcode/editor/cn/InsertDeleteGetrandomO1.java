package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import leetcode.editor.cn.struct.*;

//[380] O(1) 时间插入、删除和获取随机元素
/* ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"],[[],[1],[2],[2],[],[1],[2],[]] */
public class InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> map;

        public RandomizedSet() {
            nums = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            map.put(last, index);
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(ThreadLocalRandom.current().nextInt(0, nums.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}