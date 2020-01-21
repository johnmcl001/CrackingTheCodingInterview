package chapterthree;

import ChapterTwo.DoublyLinkedList;

import java.sql.SQLOutput;

public class Queue <E> {
    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();

        while (queue.getSize() <= 10){
            queue.enqueue((int) (1 + Math.random()*10));
        }

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
    // Attributes

    // Adapt DoublyLinkedList
    private DoublyLinkedList<E> list;

    // Contructors

    public Queue() {
        list = new DoublyLinkedList<>();
    }

    // Getters

    /**
     * return current size of queue
      * @return int, size of queue
     */
    public int getSize() {
        return list.getSize();
    }

    /**
     * check if queue is emtpy
     * @return boolean, true if empty else false
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * return element at front of queue without removing it
     * @return E, element at the front of the queue
     */
    public E front() {
        if (isEmpty()){
            return null;
        }
        return list.getFirst().getElement();
    }

    // Setters

    /**
     * adds new element to the rear of the queue
     * @param newElement, new element to be added to the queue
     */
    public void enqueue(E newElement) {
        list.insertLast(newElement);
    }

    /**
     * removes and returns element at the front of the queue
     * @return E, element at the front of the queue
     */
    public E dequeue(){
        if (isEmpty()) {
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
