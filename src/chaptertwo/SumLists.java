package chaptertwo;

public class SumLists {
    public static void main(String[] args){
        DoublyLinkedList<Integer> tOne = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> tTwo = new DoublyLinkedList<>();

        tOne.insertLast(7);
        tOne.insertLast(1);
        tOne.insertLast(6);
        tTwo.insertLast(5);
        tTwo.insertLast(9);
        tTwo.insertLast(2);

        System.out.println(sumReverse(tOne, tTwo));

        DoublyLinkedList<Integer> tThree = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> tFour = new DoublyLinkedList<>();

        tThree.insertLast(6);
        tThree.insertLast(1);
        tThree.insertLast(7);
        tFour.insertLast(2);
        tFour.insertLast(9);
        tFour.insertLast(5);

        System.out.println(sumForward(tThree, tFour));

    }

    public static DoublyLinkedList<Integer> sumForward(DoublyLinkedList<Integer> llOne,
                                                       DoublyLinkedList<Integer> llTwo){
        int sum;
        boolean carryOver = false;
        DoublyLinkedList<Integer> ans = new DoublyLinkedList<>();

        DNode<Integer> walkerOne = llOne.getLast();
        DNode<Integer> walkerTwo = llTwo.getLast();

        while(walkerOne.getPrev() != null
                && walkerTwo.getPrev() != null){

            sum = walkerOne.getElement() + walkerTwo.getElement();

            if (carryOver){
                sum += 1;
                carryOver = false;
            }

            if (sum >= 10){
                carryOver = true;
                sum -= 10;
            }

            ans.insertFirst(sum);

            walkerOne = walkerOne.getPrev();
            walkerTwo = walkerTwo.getPrev();
        }

        return ans;
    }

    public static DoublyLinkedList<Integer> sumReverse(DoublyLinkedList<Integer> llOne,
                                                 DoublyLinkedList<Integer> llTwo){
        int sum;
        boolean carryOver = false;
        DoublyLinkedList<Integer> ans = new DoublyLinkedList<>();

        DNode<Integer> walkerOne = llOne.getFirst();
        DNode<Integer> walkerTwo = llTwo.getFirst();

        while(walkerOne.getNext() != null
                && walkerTwo.getNext() != null){

            sum = walkerOne.getElement() + walkerTwo.getElement();

            if (carryOver){
                sum += 1;
                carryOver = false;
            }

            if (sum >= 10){
                carryOver = true;
                sum -= 10;
            }

            ans.insertFirst(sum);

            walkerOne = walkerOne.getNext();
            walkerTwo = walkerTwo.getNext();
        }

        return ans;
    }

}
