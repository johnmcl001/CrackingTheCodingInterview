package chapterthree;

import java.util.Arrays;

public class StackMin {
    public static void main(String[] args){
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (1 + Math.random()*20);
        }

        StackMin stackMin = new StackMin();

        for (int i: arr){
            stackMin.push(i);
        }

        while (!stackMin.isEmpty()){
            System.out.println(stackMin);
            System.out.println("min: " + stackMin.min());
            System.out.println("removed: " + stackMin.pop());
            System.out.println();
        }
    }
    // Attributes

    // Adapt doubly linked list to store ints
    private StackNode top;
    int size = 0;

    // Constructors

    public StackMin() {
        top = null;
    }

    // Getters

    /**
     * returns smallest element of the stack
     * @return int, smallest element of the stack;
     */
    public int min() {
        return top.getMin();
    }

    /**
     * returns current size of stack
     *
     * @return int, number of elements in the stack
     */
    public int getSize() {
        return size;
    }

    /**
     * checks if stack is empty
     *
     * @return boolean, true if empty else false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns top most element of the stack without removing it
     *
     * @return int, top most element of the stack
     */
    public int top() {
        if (isEmpty()){
            return -1;
        }

        return top.getElement();
    }

    // Setters

    /**
     * inserts new element at top of the stack
     *
     * @param i, new element to be inserted
     */
    public void push(int i) {
        StackNode newNode;
        if (isEmpty()){
            newNode = new StackNode(i, top, i);
        } else if (i < top.getMin()) {
            newNode = new StackNode(i, top, i);
        } else {
            newNode = new StackNode(i, top, top.getMin());
        }
        top = newNode;
        size++;
    }

    /**
     * removes and returns top most element of the stack
     * @return int, top most element of the stack
     */
    public int pop(){
        if (isEmpty()){
            return -1;
        }
        int ans = top.getElement();
        top = top.getNext();
        size--;
        return ans;
    }

    // Utilities

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        StackNode walker = top;
        while (walker != null) {
            sb.append(walker.getElement());
            sb.append(" ");
            walker = walker.getNext();
        }

        return sb.toString();
    }

    // Nested Class

    private class StackNode {
        private int element;
        private StackNode next;
        private final int min;

        public StackNode(int e, StackNode n, int m){
            element = e;
            next = n;
            min = m;
        }

        public int getElement(){
            return element;
        }

        public StackNode getNext() {
            return next;
        }

        public int getMin(){
            return min;
        }

        public void setElement(int e){
            element = e;
        }

        public void setNext(StackNode n){
            next = n;
        }
    }
}

