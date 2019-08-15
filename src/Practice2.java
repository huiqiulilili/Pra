class ListNode2{
    int val;
    ListNode2 next;

    ListNode2(int val){
        this.val = val;
    }
}

class Solution2{
    public ListNode2 partition(ListNode2 head,int x){
        ListNode2 small = null;
        ListNode2 smallLast = null;

        ListNode2 big = null;
        ListNode2 bigLast = null;

        for(ListNode2 cur = head;cur != null;cur = cur.next){
            if(cur.val <= x){
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                smallLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
        }
        if(small == null){
            return big;
        }else{
            smallLast.next = big;
            if(bigLast != null){
                bigLast.next = null;
            }
        }
        return small;
    }
}
public class Practice2 {
    public static void main(String[] args) {
        ListNode2 n1 = new ListNode2(1);
        ListNode2 n2 = new ListNode2(4);
        ListNode2 n3 = new ListNode2(3);
        ListNode2 n4 = new ListNode2(2);
        ListNode2 n5 = new ListNode2(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Solution2 s = new Solution2();
        for(ListNode2 cur = s.partition(n1,3);cur != null;cur = cur.next){
            System.out.println(cur.val);
        }
    }
}
