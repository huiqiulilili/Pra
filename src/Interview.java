
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }

    public String toString(){
        return String.format("Node(%d)",val);
    }

}

class Review{
    public ListNode pushFront(ListNode head,int val){
        ListNode node = new ListNode(val);
        node.next = head;
        return node;
    }

    public ListNode popBack(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        }

        ListNode last = head;
        while(last.next.next != null){
            last = last.next;
        }
        last.next = null;
        return head;
    }
}

class Solution{
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode newList = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = newList;
            newList = cur;
            cur = next;
        }
        return newList;
    }

    public ListNode FindKthToTail(ListNode head,int k){
        int length = 0;

        for(ListNode cur = head;cur != null;cur = cur.next){
            length++;
        }
        if(length < k){
            return null;
        }

        int n = length - k;
        ListNode kth = head;
        for(int i = 0;i < n;i ++){
            kth = kth.next;
        }
        return kth;
    }

    public ListNode removeElements(ListNode head,int val){
        if(head == null){
            return null;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head,int var){
        ListNode result = null;
        ListNode last = null;
        ListNode cur = head;

        while(cur != null){
            if(cur.val != var){
                if(result == null){
                    result = cur;
                }else{
                    last.next = cur;
                }
                last = cur;
            }
            cur = cur .next;
        }
        if(last !=null){
            last.next = null;
        }
        return result;
    }

    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class Interview {
    public static ListNode tests() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        ListNode head = s.reverseList(tests());
//        for(ListNode cur = head;cur != null;cur = cur.next){
//            System.out.println(cur.val);
//    }

//        System.out.println(s.FindKthToTail(tests(),1));

        ListNode L = s.removeElements2(tests(), 3);
        for (ListNode cur = L; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }

    }

}
