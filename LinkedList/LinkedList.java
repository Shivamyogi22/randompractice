class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Insert at HEAD
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at END / TAIL
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at INDEX (0-based)
    public void insertAtIndex(int data, int index) {
        if (index == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;

        while (temp != null && count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid Index");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at HEAD
    public void deleteAtHead() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        head = head.next;
    }

    public void deleteAtEnd() {
        // Case 1: Agar list khali hai
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        // Case 2: Agar list mein sirf ek hi node hai (Head hi Last hai)
        if (head.next == null) {
            head = null;
            return; 
        }

        // Case 3: Multiple nodes hain -> Second last node dhoondo
        Node temp = head;
        // Loop tab tak chalao jab tak temp ke NEXT ka NEXT null na ho jaye
        // Matlab: Hum second last node par rukenge
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Ab temp second last node hai. Iske next ko null kar do.
        // Last node disconnected ho gaya.
        temp.next = null;
    }

    // Delete at INDEX (0-based)
    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        int count = 0;

        while (temp.next != null && count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            System.out.println("Invalid Index");
            return;
        }

        temp.next = temp.next.next;
    }

    public int search(int target) {
		Node temp = head;
		int index =0;
		if(temp !=null) {
			if(temp.data == target) {
				return index;
			}
			temp = temp.next;
			index++;
		}
		
		return -1;
	}
    // Display Linked List
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class LinkedList {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);

        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.insertAtIndex(25, 2);

        list.display();   // 30 -> 20 -> 25 -> 10 -> 40 -> 50 -> null

        list.deleteAtHead();
        list.display();   // 20 -> 25 -> 10 -> 40 -> 50 -> null

        list.deleteAtIndex(2);
        list.display();   // 20 -> 25 -> 40 -> 50 -> null


        // Searching Test
        int val = 30;
        int result = list.search(val);
        
        if(result != -1) {
            System.out.println("Value " + val + " found at Index: " + result);
        } else {
            System.out.println("Value " + val + " not found");
        }

        // Searching Test (Not Found)
        System.out.println("Searching 100: Index " + list.search(100)); // Should print -1
    }
}
