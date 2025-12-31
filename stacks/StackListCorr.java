import java.util.*;

class Stack {
    int[] arr = new int[20];
    int top = -1;

    public void push(int n) {
        // if (top == arr.length - 1)  {
        //     System.out.println("Stack Overflow");
        //     return;
        // }
        top++;
        arr[top] = n;
        System.out.println(n + " pushed");
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackListCorr {
    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(10);
        st.push(0);   // works correctly
        st.push(30);

        System.out.println("Pop: " + st.pop());
        System.out.println("Peek: " + st.peek());

        st.display();
    }
}
