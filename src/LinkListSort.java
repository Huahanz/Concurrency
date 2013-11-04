class ListNode {
	    public int val;
	    public ListNode next;
	}
public class LinkListSort {
	
	public static void main(String[] args) {
		ListNode a = new ListNode();
		a.val = 2;
		ListNode b = new ListNode();
		a.next = b;
		b.val = 1;
		b.next = null;
//		ListNode c = new ListNode();
//		b.next = c;
//		c.val = 3;
//		ListNode d = new ListNode();
//		c.next = d;
//		d.val = 4;
//		ListNode e = new ListNode();
//		d.next = e;
//		e.val = 5;
//		ListNode f = new ListNode();
//		e.next = f;
//		f.val = 6;
//		ListNode g = new ListNode();
//		f.next = g;
//		g.val = 7;
		LinkListSort l = new LinkListSort();
		l.sort(a);
	}
	
    public ListNode sort(ListNode head) {
        if(head == null) {
            return null;
        }
        tempHead = null;
        tempTail = null;
        ListNode l = head;
        int len = 0;
        while(l != null) {
            l = l.next;
            len++;
        }
        msort(head, len);
        return tempHead;
    }
    ListNode tempHead = null;
    ListNode tempTail = null;
    public ListNode msort(ListNode head, int len) {
    	System.out.println(head.val + " .. " + len);
        if(len == 1) {
            tempHead = head;
            tempTail = head;
            return head;
        }
        int llen = len / 2;
        int rlen = len - llen;
        ListNode leftOldTail = msort(head, llen);
        ListNode leftHead = tempHead;
        ListNode leftTail = tempTail;
        ListNode rigthOldTail = msort(leftOldTail.next, rlen);
        ListNode rightHead = tempHead;
        ListNode rightTail = tempTail;        
        ListNode dummyHead = new ListNode();
        ListNode top = dummyHead;
        ListNode leftEnd = leftTail.next;
        ListNode rightEnd = rightTail.next;
        while(leftHead != leftEnd || rightHead != rightEnd) {
        	System.out.println(leftHead + ", " + rightHead + ", " + rightTail.next);
            if(rightHead == rightTail.next || ( leftHead != leftEnd && leftHead.val < rightHead.val) ){
                top.next = leftHead;
                top = leftHead;
                leftHead = leftHead.next;
            }
            else if(leftHead == leftTail.next || ( rightHead != rightEnd &&  leftHead.val >= rightHead.val)) {
                top.next = rightHead;
                top = rightHead;
                rightHead = rightHead.next;
            }
            
        }
        tempHead = dummyHead.next;
        tempTail = top;
        return rigthOldTail;
    }
}