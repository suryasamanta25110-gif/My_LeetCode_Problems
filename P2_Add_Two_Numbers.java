public class P2_Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Initializing variables and objects.
        ListNode head = null, temp = null;
        int carry = 0;

        // Finding the sum.
        // At each step, we check whether 'l1' and 'l2' is null or not. If not, we add the digits.
        // We update the 'sum' and 'carry' accordingly.
        // If it's the first node, we initialize 'head', or else, we initialize 'temp.next'.
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry++;
            }
            if (head == null) {
                temp = new ListNode(sum, null);
                head = temp;
            } else {
                temp.next = new ListNode(sum, null);
                temp = temp.next;
            }
        }

        // Returning the value.
        return head;
    }
}
