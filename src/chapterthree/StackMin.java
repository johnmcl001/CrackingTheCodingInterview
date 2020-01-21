package chapterthree;

import ChapterTwo.DNode;
import ChapterTwo.DoublyLinkedList;

import java.util.Arrays;

public class StackMin {
    public static void main(String[] args){
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (1 + Math.random()*20);
        }

        System.out.println(Arrays.toString(arr));

        StackMin stackMin = new StackMin();

        for (int i: arr){
            stackMin.push(i);
        }

        System.out.println(stackMin.min());

        while (!stackMin.isEmpty()){
            System.out.println(stackMin.min());
            System.out.println(stackMin.pop());
            System.out.println();
        }
    }
    // Attributes

    // Adapt doubly linked list to store ints
    DoublyLinkedList<Integer> list;
    int min;

    // Constructors

    public StackMin() {
        list = new DoublyLinkedList<>();
        min = Integer.MAX_VALUE;
    }

    // Getters

    /**
     * returns smallest element of the stack
     * @return int, smallest element of the stack;
     */
    public int min() {
        return min;
    }

    /**
     * returns current size of stack
     *
     * @return int, number of elements in the stack
     */
    public int getSize() {
        return list.getSize();
    }

    /**
     * checks if stack is empty
     *
     * @return boolean, true if empty else false
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * returns top most element of the stack without removing it
     *
     * @return int, top most element of the stack
     */
    public int top() {
        return list.getFirst().getElement();
    }

    // Setters

    /**
     * inserts new element at top of the stack
     *
     * @param i, new element to be inserted
     */
    public void push(int i) {
        if (i < min){
            min = i;
        }
        list.insertFirst(i);
    }

    /**
     * removes and returns top most element of the stack
     * @return int, top most element of the stack
     */
    public int pop(){
        if (top() == min){
            min = findNewMin();
        }
        return list.removeFirst();
    }

    // Utilities

    private int findNewMin(){
        DNode<Integer> walker = list.getFirst();
        int minSearch = Integer.MAX_VALUE;
        while (walker.getNext().getElement() != null){
            if (walker.getElement() < minSearch){
                minSearch = walker.getElement();
            }
            walker = walker.getNext();
        }
        return minSearch;
    }
}

