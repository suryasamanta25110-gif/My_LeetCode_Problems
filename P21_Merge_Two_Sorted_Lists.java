public class P21_Merge_Two_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Initializing variables and objects.
        ListNode head = new ListNode(-999);
        ListNode current = head;

        // Merging the given two linked lists.
        while (list1 != null && list2 != null)  {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attaching the rest of the remaining nodes at the end of our current list.
        current.next = (list1 == null) ? list2 : list1;

        // Returning the value.
        return head.next;
    }
}
