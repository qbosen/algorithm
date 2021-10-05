package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[284] 窥探迭代器
/* ["PeekingIterator","next","peek","next","next","hasNext"],[[[1,2,3]],[],[],[],[],[]] */
public

//leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer cur = null;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            cur = this.iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = cur;
        if (this.iterator.hasNext()) {
            cur = this.iterator.next();
        }else{
            cur = null;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return this.cur != null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

