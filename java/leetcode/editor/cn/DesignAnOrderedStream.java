package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//[1656] 设计有序流
/* ["OrderedStream","insert","insert","insert","insert","insert"],[[5],[3,"ccccc"],[1,"aaaaa"],[2,"bbbbb"],[5,"eeeee"],[4,"ddddd"]] */
public class DesignAnOrderedStream {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class OrderedStream {

        String[] data;
        int ptr;

        public OrderedStream(int n) {
            data = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            data[idKey] = value;
            List<String> res = new ArrayList<>();
            while (ptr < data.length && data[ptr] != null) {
                res.add(data[ptr]);
                ptr++;
            }
            return res;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}