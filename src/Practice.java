class Node{
    public int val;
    public Node next = null;

    Node(){}
    Node(int val){
        this.val = val;
    }



    public Node reverse(Node head){
        Node newnode = null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = newnode;
            newnode = cur;
            cur = next;
        }
        return newnode;
    }
}
public class Practice {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        Node head = n1;
        Node n = n1.reverse(n1);
        for(Node cur = n;cur != null;cur = cur.next){
            System.out.println(cur.val);
        }
    }
}
