package leetcode.editor.cn;

import java.util.*;

//[1604] 警告一小时内使用相同员工卡大于等于三次的人
/* ["daniel","daniel","daniel","luis","luis","luis","luis"],["10:00","10:40","11:00","09:00","11:00","13:00","15:00"] */
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public static void main(String[] args) {
        Solution solution = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> timeMap = new HashMap<>();
            int n = keyName.length;
            for (int i = 0; i < n; i++) {
                String name = keyName[i];
                String time = keyTime[i];
                timeMap.putIfAbsent(name, new ArrayList<>());
                int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
                int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
                timeMap.get(name).add(hour * 60 + minute);
            }
            List<String> res = new ArrayList<>();
            Set<String> keySet = timeMap.keySet();
            for (String name : keySet) {
                List<Integer> list = timeMap.get(name);
                Collections.sort(list);
                int size = list.size();
                for (int i = 2; i < size; i++) {
                    int time1 = list.get(i - 2), time2 = list.get(i);
                    int difference = time2 - time1;
                    if (difference <= 60) {
                        res.add(name);
                        break;
                    }
                }
            }
            Collections.sort(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}