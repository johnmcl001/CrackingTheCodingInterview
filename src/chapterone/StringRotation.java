package chapterone;

public class StringRotation {
    public static void main(String[] args){
        String str = "waterbottle";
        String strRotated = "erbottlewat";
        System.out.println(isRotationSingleCall(str, strRotated));
    }

    /**
     * Checks if a string is a rotation of another using a single substring call
     * @param strOne, original string
     * @param strTwo, potentially rotated string
     * @return boolean, true if rotation, else false
     */
    public static boolean isRotationSingleCall(String strOne, String strTwo){
        int strOneLength = strOne.length();
        if (strOneLength > 0 && strOneLength == strTwo.length()){
            String strOneDouble = strOne + strOne;
            return strOneDouble.contains(strTwo);
        }
        return false;
    }

    /**
     * Checks if strings are rotations of each other making multiple calls
     * @param strOne, original string
     * @param strTwo, potentially rotated string
     * @return boolean, true if rotation, else false
     */
    public static boolean isRotation(String strOne, String strTwo){
        char[] charsOne = strOne.toCharArray();
        char[] charsTwo = strTwo.toCharArray();

        int i = 0;
        while (i < charsOne.length){
            if (isSubstring(charsOne, charsTwo)){
                return true;
            }
            rotate(charsOne);
            i++;
        }
        return false;
    }

    /**
     * Rotates char array by one char at a time
     * @param chars, array of characters
     */
    public static void rotate(char[] chars){
        char temp = chars[0];

        for(int i = 0; i < chars.length-1; i++){
            chars[i] = chars[i+1];
        }

        chars[chars.length-1] = temp;
    }

    /**
     * Checks if char arrays are substrings
     * @param charsOne, original char array
     * @param charsTwo, potential rotated char array
     * @return boolean, true if rotation, else false
     */
    public static boolean isSubstring(char[] charsOne, char[] charsTwo){
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();

        for (char c: charsOne){
            sbOne.append(c);
        }

        for (char c: charsTwo){
            sbTwo.append(c);
        }
        return sbOne.toString().contains(sbTwo.toString());
    }
}
