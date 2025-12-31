class Node {
    int data;
    Node next;
    Node prev; // Extra pointer for previous node

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    Node head;

    // ---------------- INSERTION OPERATIONS ----------------

    // 1. Insert at HEAD
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        
        // Agar list khali nahi hai, toh purane head ka prev update karo
        if (head != null) {
            head.prev = newNode;
        }
        
        head = newNode;
    }

    // 2. Insert at END
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // Case: Agar list khali hai
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        
        // Linking
        temp.next = newNode;
        newNode.prev = temp; // Piche ka link joodna mat bhoolna
    }

    // 3. Insert at INDEX
    public void insertAtIndex(int data, int index) {
        if (index == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;

        // Us node tak jao jiske PEECHE insert karna hai (index - 1)
        while (temp != null && count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid Index");
            return;
        }

        // Main Logic for DLL Insertion
        newNode.next = temp.next;
        newNode.prev = temp;
        
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    // ---------------- DELETION OPERATIONS ----------------

    // 1. Delete at HEAD
    public void deleteAtHead() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        head = head.next;
        
        // Agar list abhi bhi khali nahi hui, toh naye head ka prev null karo
        if (head != null) {
            head.prev = null;
        }
    }

    // 2. Delete at END
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Temp is now the last node. Go to previous node and make its next null.
        temp.prev.next = null;
    }

    // 3. Delete at INDEX
    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (index == 0) {
            deleteAtHead();
            return;
        }

        Node temp = head;
        int count = 0;

        // Us node par jao jise DELETE karna hai
        while (temp != null && count < index) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid Index");
            return;
        }

        // Logic: Pichle wale ka next = agla wala
        //        Agle wale ka prev = pichla wala
        
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Display Method (Forward Direction)
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        System.out.print("null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL dll = new DLL();

        // Testing Insertions
        dll.insertAtHead(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtIndex(25, 2); 
        
        dll.display(); // Output: null <-> 10 <-> 20 <-> 25 <-> 30 <-> null

        // Testing Deletions
        // System.out.println("Deleting Head...");
        // dll.deleteAtHead();
        // dll.display();

        // System.out.println("Deleting End...");
        // dll.deleteAtEnd();
        // dll.display();

        System.out.println("Deleting at Index 1...");
        dll.deleteAtIndex(1);
        dll.display();
    }
}