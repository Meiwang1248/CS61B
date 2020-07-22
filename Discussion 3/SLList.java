public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode (int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList() {
        first = null;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int x, int position) {
        /** Special cases: 1, when the SLList is null. 2, when the position is 0. */
        if (first == null || position == 0) {
            addFirst(x);
            return; //then do not move on
        }
        /** Other special cases to consider: 1. position is equal to the size of the IntNode.
         * 2. position is greater than the size of the IntNode. addLast()?
         * Well, solution takes advantage of the while loop so it stops at the end. */

        IntNode currentNode = first; //currentNOde is the before the inserted node.
        int index = 0; //position n, loop (n-1) times-> index means how many loops->index < position
        /** currentNode.next != null is to make sure the loop will stop at the second last position,
         *  the pointer of currentNode will point at the last IntNode.*/
        while (position > 1 && currentNode.next != null && index + 1 < position) {
            index += 1;
            currentNode = currentNode.next;
        }
        currentNode.next = new IntNode(x, currentNode.next);
    }

    public void reverse() {
        /** Special cases: when the SLList is null or it has only one element,
         * there is not need to reverse anything. */
        if (first == null || first.next == null) {
            return;
        }

        IntNode ptr = first.next;
        first.next = null;

        while(ptr != null) {
            /** Each loop connect ptr to first, and use temp to cache ptr.next.
             * so when ptr.next = null, we should still go through the loop one last time.*/
            IntNode temp = ptr.next;
            ptr.next = first;
            first = ptr;
            ptr = temp;
        }
    }

    public static void main(String[] args) {
        SLList s1 = new SLList();
        for (int i = 10; i > 0; i--) {
           s1.addFirst(i);
        }
        s1.insert(100,5); //usual case
        s1.insert(200, 50); //position is way too large
        s1.insert(300, 12); //kind of like addLast because insert at the end
        s1.insert(400,1);
        s1.insert(500,0);
        s1.insert(600, 7);
    }
}
