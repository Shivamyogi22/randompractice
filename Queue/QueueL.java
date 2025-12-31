import java.util.*;

class Queue {
    ArrayList<Integer> arr = new ArrayList<>();

    // Enqueue: Add element to the end of the list (Rear)
    public void enqueue(int n) {
        arr.add(n);
        System.out.println(n + " is enqueued");
    }

    // Dequeue: Remove element from the start of the list (Front)
    public int dequeue() {
        if (arr.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        // Removes the element at index 0 and shifts all other elements to the left
        return arr.remove(0); 
    }

    // Peek: Get the element at the start of the list (Front)
    public int peek() {
        if (arr.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr.get(0);
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public void display() {
        if (arr.isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Front -> ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            if (i < arr.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" <- Rear");
    }
}

public class QueueL {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        
        q.display();
        
        System.out.println("Dequeue: " + q.dequeue()); // Should remove 10
        q.display();
        
        System.out.println("Peek: " + q.peek());       // Should see 20
        
        q.display();
        System.out.println("Empty? " + q.isEmpty());
    }
}