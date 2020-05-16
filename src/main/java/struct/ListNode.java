package struct;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author qiubaisen
 * @date 2020/4/14
 */
public class ListNode {
    public int val;
    @Nullable
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[" + val);
        ListNode itr = next;
        while (itr != null) {
            sb.append(",").append(itr.val);
            itr = itr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) return false;
        return Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}