import java.util.*;

public class TwoStacksOneQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
class MyQueue{
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    private static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data= data;
        }
    }
    public MyQueue(){

    }

    public boolean isEmpty(){
        return s1.isEmpty();
    }
    public int peek(){
        return s1.peek();
    }
    public void enqueue(int data){
        while(!s1.empty()) s2.push(s1.pop());
        s1.push(data);
        while(!s2.empty()) s1.push(s2.pop());
    }
    public void dequeue(){
        while(!s1.empty()) s2.push(s1.pop());
        s2.pop();
        while(!s2.empty()) s1.push(s2.pop());
    }
}
