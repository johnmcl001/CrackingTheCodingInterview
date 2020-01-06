package chapterone;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutations {
    public static void main(String[] args){
        // sOne and sTwo are permutations of each other, sThree is not
        String sOne = "asdf";
        String sTwo = "fsda";
        String sThree = "jklh";

        System.out.println(isPermutation(sOne, sTwo));
        System.out.println(isPermutation(sOne, sThree));
        System.out.println(isPermutation(sTwo, sThree));
    }

    public static boolean isPermutation(String sOne, String sTwo){
        if (sOne.length() != sTwo.length()){
            return false;
        }

        char[] sOneChars = sOne.toCharArray();
        char[] sTwoChars = sTwo.toCharArray();

        Arrays.sort(sOneChars);
        Arrays.sort(sTwoChars);

        for (int i = 0; i < sOneChars.length; i++){
            if (sOneChars[i] != sTwoChars[i]){
                return false;
            }
        }
        return true;
    }
}
