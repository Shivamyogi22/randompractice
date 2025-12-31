import java.util.*;

class stacky{
    ArrayList<Integer> arr = new ArrayList<>();
   
    public void push(int n){
        arr.add(n);
        System.out.println(n+" is Added!");
        return;
    }
   
     public int pop(){
        for(int i=arr.size()-1; i>=0; i--){
            if(arr.get(i)!=0){
                int n = arr.get(i);
                arr.remove(i);
                System.out.println(n+" is Removed!");
                return n;
            }
        }
        return -1;
    }
   
    public void display(){
        for(var a : arr){
            if(a!=0)
            System.out.print(a+" -> ");
        }
        return;
    }
   
    public int peek(){
        for(int i=arr.size()-1; i>=0; i--){
            if(arr.get(i)!=0){
                return arr.get(i);
            }
        }
        System.out.println("No Elements!");
        return -1;
    }
   
    public void isEmpty(){
        if(arr.size()<=0){
            System.out.println("Stack is Empty!");
        }else {
            System.out.println("Stack is NOT Empty!");
        }
    }
   
}

class StackUsingArList {
   
   
    public static void main(String[] args) {
        stacky st = new stacky();
       
        st.isEmpty();
       
        st.push(10);
        st.push(20);
        st.push(30);
       
        System.out.println("Popped: "+st.pop());
       
       
        System.out.println("Peeked: "+st.peek());
        st.display();
       
        System.out.println();
        st.push(40);
        st.push(50);
        st.push(60);
        st.display();
       
        System.out.println();
        System.out.println("Peeked: "+st.peek());
       
        st.isEmpty();
    }
    
}



