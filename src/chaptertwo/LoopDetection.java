package chaptertwo;

public class LoopDetection {
    public static void main(String[] args){
        DoublyLinkedList<Character> tLooped = new DoublyLinkedList<>();
        DoublyLinkedList<Character> tNoLoop = new DoublyLinkedList<>();

        tLooped.insertLast('a');
        tLooped.insertLast('b');
        tLooped.insertLast('c');
        DNode<Character> loopPoint = tLooped.getLast();
        tLooped.insertLast('d');
        tLooped.insertLast('e');
        tLooped.getLast().setNext(loopPoint);
        loopPoint.setPrev(tLooped.getLast());

        tNoLoop.insertLast('a');
        tNoLoop.insertLast('b');
        tNoLoop.insertLast('c');
        tNoLoop.insertLast('d');
        tNoLoop.insertLast('e');

        System.out.println("Should be true: " + isLoop(tLooped));
        System.out.println("Should be false: " + isLoop(tNoLoop));
    }

    public static boolean isLoop(DoublyLinkedList<Character> dll){
       int numberOfIterations = 0;
       int listSize = dll.getSize();

       DNode<Character> walker = dll.getFirst();
       while(walker.getNext() != null){
           if (numberOfIterations > listSize){
               return true;
           }
           numberOfIterations++;
           walker = walker.getNext();
       }

       return false;
    }


}
