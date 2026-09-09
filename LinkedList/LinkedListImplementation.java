
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListImplementation {

    // 1. Print Linked List
    static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 2. Recursive Print
    static void recursivePrint(Node head) {
        if (head == null) {    
            return;
        }

        System.out.print(head.val + " ");
        recursivePrint(head.next);
    }

    // 3. Reverse Print using Recursion
    static void reversePrint(Node head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.print(head.val + " ");
    }

    // 4. Insert at Beginning
    static Node insertAtBeginning(Node head, int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        return newNode;
    }

    // 5. Insert at End
    static Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    // 6. Insert at Position (1-based)
    static Node insertAtPosition(Node head, int val, int pos) {
        if(pos==0){
            insertAtBeginning(head,val);
            return head;
        }
        if(pos==length(head)){
            insertAtEnd(head,val);
            return head;
        }
        if(pos>length(head)){
         System.out.println("Invalid Position");
         return head;
        }
        Node newNode = new Node(val);
        if (pos == 1) {
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // 7. Delete First
    static Node deleteFirst(Node head) {
        if (head == null) {
            return null;
        }

        return head.next;
    }

    // 8. Delete Last
    static Node deleteLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    // 9. Delete at Position
    static Node deleteAtPosition(Node head, int pos) {
        if (head == null) {
            return null;
        }

        if (pos == 1) {
            return head.next;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // 10. Search
    static boolean search(Node head, int target) {
        Node temp = head;

        while (temp != null) {
            if (temp.val == target) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // 11. Length
    static int length(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // 12. Maximum
    static int maximum(Node head) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        int max = head.val;
        Node temp = head.next;

        while (temp != null) {
            if (temp.val > max) {
                max = temp.val;
            }

            temp = temp.next;
        }

        return max;
    }

    // 13. Reverse Linked List
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("Original: ");
        print(head);

        System.out.print("Recursive Print: ");
        recursivePrint(head);
        System.out.println();

        System.out.print("Reverse Print: ");
        reversePrint(head);
        System.out.println();

        head = insertAtBeginning(head, 5);
        System.out.print("After Insert Beginning: ");
        print(head);

        head = insertAtEnd(head, 50);
        System.out.print("After Insert End: ");
        print(head);

        head = insertAtPosition(head, 25, 4);
        System.out.print("After Insert Position: ");
        print(head);

        head = deleteFirst(head);
        System.out.print("After Delete First: ");
        print(head);

        head = deleteLast(head);
        System.out.print("After Delete Last: ");
        print(head);

        head = deleteAtPosition(head, 2);
        System.out.print("After Delete Position: ");
        print(head);

        System.out.println("Search 30: " + search(head, 30));

        System.out.println("Length: " + length(head));

        System.out.println("Maximum: " + maximum(head));

        head = reverse(head);
        System.out.print("After Reverse: ");
        print(head);
    }
}