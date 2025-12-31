import java.util.*;

class stacky{
    int[] arr = new int[20];
    private int index = 0;
   
    public void push(int n){
        arr[index] = n;
        index++;
        System.out.println(n+" is Added!");
        return;
    }
   
     public int pop(){
        index--;
        int n = arr[index];
        arr[index]=0;
        System.out.println(n+" is Removed!");
        return n;
    }
   
    public void display(){
       
        if(arr[0]==0){
            System.out.println("CanNot Display..Empty Stack!");
            return;
        }
       
        for(var a : arr){
            if(a!=0)
            System.out.print(a+" -> ");
        }
        return;
    }
   
    public int peek(){
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]!=0){
                return arr[i];
            }
        }
        System.out.println("No Elements!");
        return -1;
    }
}

class StackUsingList {
   
   
    public static void main(String[] args) {
        stacky st = new stacky();
       
        st.display();
       
       
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(900);
       
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
    }
}
