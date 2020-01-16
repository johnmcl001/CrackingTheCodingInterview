package ChapterTwo;

public class Palindrome {
    public static void main(String[] args){
        DoublyLinkedList<Character> tIsPalindrome = new DoublyLinkedList<>();
        DoublyLinkedList<Character> tNotPalindrome = new DoublyLinkedList<>();
        DoublyLinkedList<Character> tIsPalindromeTwo = new DoublyLinkedList<>();

        for (Character c: "maoam".toCharArray()){
            tIsPalindrome.insertLast(c);
        }

        for (Character c: "notapalindrome".toCharArray()){
            tNotPalindrome.insertLast(c);
        }

        for (Character c: "maam".toCharArray()) {
            tIsPalindromeTwo.insertLast(c);
        }

        System.out.print("maoam: ");
        System.out.println(isPalindrome(tIsPalindrome));
        System.out.print("notapalindrome: ");
        System.out.println(isPalindrome(tNotPalindrome));
        System.out.print("maam: ");
        System.out.println(isPalindrome(tIsPalindromeTwo));
    }

    public static boolean isPalindrome(DoublyLinkedList<Character> dll){
        DNode<Character> fromHead = dll.getFirst();
        DNode<Character> fromTail = dll.getLast();

        while (fromHead.getElement() != dll.getLast().getElement()
                && fromTail.getElement() != dll.getFirst().getElement()){
            if (fromHead.getElement() != fromTail.getElement()){
                return false;
            }
            fromHead = fromHead.getNext();
            fromTail = fromTail.getPrev();
        }

        return true;
    }
}
