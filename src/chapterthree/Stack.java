package chapterthree;

import ChapterTwo.DNode;
import ChapterTwo.DoublyLinkedList;

public class Stack<E> {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        while (stack.getSize() <= 10){
            stack.push((int) (1 + Math.random() * 20));
        }

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);
    }
    // Attributes

    // Adapt Doubly linked list
    private DoublyLinkedList<E> list;

    // Constructors

    public Stack(){
        list = new DoublyLinkedList<>();
    }

    // Getters

    /**
     * returns size of stack
     * @return int, number of elements in the stack
     */
    public int getSize(){
        return list.getSize();
    }

    /**
     * check if stack is empty or not
     * @return boolean, true if empty else false
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * retruns top element from stack without removing it
     * @return E, element stored in top of stack, null if empty
     */
    public E top(){
        if (isEmpty()){
            return null;
        }
        return list.getFirst().getElement();
    }

    // Setters

    /**
     * add new element to top of stack
     * @param newElement, new element to be added to top of stack
     */
    public void push (E newElement){
        list.insertFirst(newElement);
    }

    /**
     * removes and returns element from top of stack
     * @return E, element at top of stack
     */
    public E pop(){
        if (isEmpty()){
            return null;
        }
        return list.removeFirst();
    }

    // Utilities

    @Override
    public String toString(){
        return list.toString();
    }
}
