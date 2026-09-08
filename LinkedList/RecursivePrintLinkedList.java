package LinkedList;
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class RecursivePrintLinkedList {

    public static void main(String[] args) {

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        print(a);
    }

    public static void print(Node head) {
        if (head == null) {
            return;
        }
         print(head.next);
        System.out.println(head.val);
       
    }
}