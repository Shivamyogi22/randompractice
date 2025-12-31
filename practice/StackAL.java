import java.util.*;

class Stack{
    ArrayList<Integer> arr = new ArrayList<>();

    public void push(int n){
        arr.add(n);
        System.out.println(n + " is pushed");
    }
    public int pop(){
        if(arr.isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        return arr.remove(arr.size()-1);
    }
    public boolean isEmpty(){
        return arr.isEmpty();
    }
    public void display(){
        if(arr.isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        for(int i = 0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " -> ");
        }
        System.out.println("null");

    }
}

public class StackAL{
    public static void main(String[] args){
        Stack st = new Stack();
        st.push(10);
        st.push(30);
        st.push(50);
        st.push(70);
        st.display();
    }
}