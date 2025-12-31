import java.util.*;

class Stack {
    ArrayList<Integer> arr = new ArrayList<>();

    public void push(int n) {
        arr.add(n);
        System.out.println(n + " pushed");
    }

    public int pop() {
        if (arr.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr.remove(arr.size() - 1);
    }

    public int peek() {
        if (arr.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr.get(arr.size() - 1);
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public void display() {
        if (arr.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " -> ");
        }
        
        System.out.println("null");
    }

}

public class StackArrListCorr {
    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(10);
        st.push(20);   // works correctly now
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
              st.display();
        System.out.println("Pop: " + st.pop());
          st.display();
        System.out.println("Peek: " + st.peek());

        st.display();
        System.out.println("Empty? " + st.isEmpty());
    }
}
