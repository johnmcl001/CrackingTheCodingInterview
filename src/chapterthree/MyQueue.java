package chapterthree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyQueue <E> {
    public static void main(String[] args){
        int[] arr = new int[10];
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (1 + Math.random() * 20);
        }

        for (int i: arr){
            myQueue.enqueue(i);
            queue.add(i);
        }

        System.out.println(myQueue.toString());
        System.out.println(queue.toString());

        System.out.println(myQueue.dequeue().equals(queue.remove()));

        System.out.println(myQueue.toString());
        System.out.println(queue.toString());

    }

    // Attributes

    private Stack<E> rear = new Stack<>();
    private Stack<E> front = new Stack<>();

    // Constructors

    public MyQueue(){}

    // Getters

    public int size() {
        return front.getSize();
    }

    public boolean isEmpty() {
        return front.isEmpty();
    }

    public E front () {
        if (isEmpty()) {
            return null;
        }
        return front.top();
    }

    // Setters

    public void enqueue(E e) {
        while (!front.isEmpty()) {
            rear.push(front.pop());
        }
        rear.push(e);

        while (!rear.isEmpty()) {
            front.push(rear.pop());
        }
    }

    public E dequeue(){
        if (isEmpty()){
            return null;
        }
        return front.pop();
    }

    @Override
    public String toString(){
        return front.toString();
    }
}
