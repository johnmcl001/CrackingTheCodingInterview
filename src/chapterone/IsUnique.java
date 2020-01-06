package chapterone;

import java.util.ArrayList;

public class IsUnique {
    public static void main(String[] args){
        String sUnique = "jkfl;da";
        String sNotUnique = "asdfasdf";

        System.out.println(hasUniqueCharacters(sUnique));
        System.out.println(hasUniqueCharacters(sNotUnique));
    }

    /**
     * Determines if all characters in a string are unique
     * @param s, input string
     * @return boolean, true if all characters are unique else false
     */
    public static boolean hasUniqueCharacters(String s){
        ArrayList<Character> uniqueChars = new ArrayList<>();

        for (char c: s.toCharArray()){
            if (uniqueChars.contains(c)){
                return false;
            }
            uniqueChars.add(c);
        }
        return true;
    }
}
