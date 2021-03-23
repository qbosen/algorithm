package leetcode.editor.cn;

import java.util.*;

//341 扁平化嵌套列表迭代器
/* [[1,1],2,[1,1]] */
public class FlattenNestedListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     */
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    public class NestedIterator implements Iterator<Integer> {

        private final Deque<Iterator<NestedInteger>> iterators = new LinkedList<>();
        private Integer number;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iterators.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return number;
        }

        @Override
        public boolean hasNext() {
            while (!iterators.isEmpty() && !iterators.peek().hasNext()) {
                iterators.pop();
            }
            if (iterators.isEmpty()) return false;
            NestedInteger next = iterators.peek().next();
            if (next.isInteger()) {
                number = next.getInteger();
                return true;
            } else {
                iterators.push(next.getList().iterator());
                return hasNext();
            }
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}