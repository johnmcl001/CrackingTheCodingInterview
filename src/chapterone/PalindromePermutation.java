package chapterone;

import java.util.ArrayList;

public class PalindromePermutation {
    public static void main(String[] args){
        String str = "adMam'Mi DaaM";
        System.out.println(isPalindromePermutation(str));
    }

    /**
     * Determines if string is a permutation of a palindrome
     * @param str, input string
     * @return boolean, true if a permutation of a palindrome, else false
     */
    public static boolean isPalindromePermutation(String str){
        char[] chars = convertString(str);
        ArrayList<Character> uniqueChars = new ArrayList<>();
        ArrayList<Integer> charCount = new ArrayList<>();
        int index;

        for (char c: chars){
            if (uniqueChars.contains(c)){
                index = uniqueChars.indexOf(c);
                charCount.set(index, charCount.get(index)+1);
            } else {
                uniqueChars.add(c);
                charCount.add(1);
            }
        }

        return oneOdd(charCount);
    }

    public static char[] convertString(String str){
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()){
            if (Character.isAlphabetic(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().toCharArray();
    }

    public static boolean oneOdd(ArrayList<Integer> charCount){
        int numberOdd = 0;
        for (Integer i: charCount){
            if (i % 2 != 0){
                numberOdd++;
            }
        }
        return numberOdd <= 1;
    }
}
