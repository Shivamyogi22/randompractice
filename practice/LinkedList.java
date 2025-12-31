class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList{
    Node head;
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return;
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void insertAtIndex(int index, int data){
        if(index == 0){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;

        while(temp != null && count < index-1){
            temp = temp.next;
            count++;
        }
        if(temp == null){
            System.out.println("Invalid index");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public void display(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.println("List is Empty");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next == null){
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    public void deleteAtHead(){
        if(head == null)[
            System.out.println("List is Empty");
            return;
        ]
        head = head.next;
    }
    public void deleteAtIndex(int index){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        if(index == 0){
            head = head.next;
            return;
        }

        Node temp = head;
        int count  = 0;
    
        while(temp.next != null && count < index - 1){
            temp = temp.next;
            count++; 
        }    
        if(temp.next == null){
            System.out.println("Invalid Index");
            return;
        }
        temp.next = temp.next.next;
    }

}