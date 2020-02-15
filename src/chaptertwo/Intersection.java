package chaptertwo;

public class Intersection {
    public static void main(String[] args){
        DoublyLinkedList<Integer> tOne = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> tTwo = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> tThree = new DoublyLinkedList<>();

        DNode<Integer> intersection = null;

        for (int i = 0; i < 10; i++){
            tOne.insertLast(i);
            if (i == 5){
                intersection = tOne.getLast();
            }
        }

        for (int i = 0; i < 20; i++){
            tTwo.insertLast(i);
            if (i == 15){
                tTwo.intersect(intersection);
            }
        }

        for (int i = 0; i < 15; i++){
            tThree.insertLast(i);
        }

        System.out.println(tOne);
        System.out.println(tTwo);

        System.out.println("Should intersect: " + isIntersection(tOne, tTwo));
        System.out.println("Should not intersect: " + isIntersection(tOne, tThree));
        System.out.println("Should not intersect: " + isIntersection(tTwo, tThree));
    }

    public static boolean isIntersection(DoublyLinkedList<Integer> tOne,
                                         DoublyLinkedList<Integer> tTwo) {
       DNode<Integer> walkerOne = tOne.getFirst();
       DNode<Integer> walkerTwo;

       while (walkerOne != null){
           walkerTwo = tTwo.getFirst();
           while (walkerTwo != null){
               if (walkerOne == walkerTwo){
                   return true;
               }
               walkerTwo = walkerTwo.getNext();
           }
           walkerOne = walkerOne.getNext();
       }

       return false;
    }
}
