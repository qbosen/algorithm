package leetcode.editor.cn;

//[707] 设计链表
/* ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"],[[],[1],[3],[1,2],[1],[1],[1]] */
public class DesignLinkedList {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        private Integer val;
        private MyLinkedList next;

        private MyLinkedList(Integer val, MyLinkedList next) {
            this.val = val;
            this.next = next;
        }

        public MyLinkedList() {
            // this is the dummy root
        }

        private void deleteNext() {
            if (next != null) {
                next = next.next;
            }
        }

        private void addNext(int val) {
            next = new MyLinkedList(val, next);
        }

        public int get(int index) {
            var node = this;
            for (int i = 0; i <= index; i++) {
                if (node == null) return -1;
                node = node.next;
            }
            return node == null ? -1 : node.val;
        }

        public void addAtHead(int val) {
            this.addNext(val);
        }

        public void addAtTail(int val) {
            var node = this;
            while(node.next!=null){
                node = node.next;
            }
            node.addNext(val);
        }

        public void addAtIndex(int index, int val) {
            var node = this;
            for (int i = 0; i < index; i++) {
                node = node.next;
                if(node == null) return;
            }
            node.addNext(val);
        }

        public void deleteAtIndex(int index) {
            var node = this;
            for (int i = 0; i < index; i++) {
                node = node.next;
                if(node == null) return;
            }
            node.deleteNext();
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}