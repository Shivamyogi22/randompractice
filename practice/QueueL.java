import java.util.*;

class Queue{
    ArrayList<Integer> arr = new ArrayList<>();

    public void Enqueue(int n){
        arr.add(n);
        System.out.println(n + " Element enqueued");
    }
    public int Dequeue(){
        if(arr.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr.remove(0);
    }

    public int peek(){
        if(arr.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr.get(0);
    }

    public boolean isEmpty(){
        return arr.isEmpty();
    }

    public void display(){
        if(arr.isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Front -> ");
        for(int i = 0; i<arr.size(); i++){
            System.out.print(arr.get(i));
            if(i<arr.size()-1){
                System.out.print(" -> ");
            }
        }
        System.out.println(" <- rear");
    }
}

public class QueueL{
    public static void main(String[] args){
        Queue qu =  new Queue();
        qu.Enqueue(10);
        qu.Enqueue(20);
        qu.Enqueue(30);
        qu.Enqueue(40);
        qu.Enqueue(50);
        qu.display();
        System.out.println("Dequeue: " + qu.Dequeue()); // Should remove 10
        qu.display();
        System.out.println("Peek: " + qu.peek()); // Should remove 10
        qu.display();
    }
}