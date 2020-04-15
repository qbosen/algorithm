package struct;

/**
 * @author qiubaisen
 * @date 2020/4/14
 */
public class ListNode {
    public int val;
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
}