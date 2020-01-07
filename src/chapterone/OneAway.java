package chapterone;

public class OneAway {
    public static void main(String[] args){
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
    }

    /**
     * Checks if a string is one edit away from another
     * @param strOne, original string
     * @param strTwo, target string
     * @return boolean, true if one away else false
     */
    public static boolean isOneAway(String strOne, String strTwo){
        if (strOne.length() == strTwo.length()){
            return replace(strOne, strTwo);
        } else if (strOne.length()+1 == strTwo.length()){
            return insert(strOne, strTwo);
        } else if (strOne.length()-1 == strTwo.length()){
            return insert(strTwo, strOne);
        } else {
            return false;
        }
    }

    /**
     * Tests to see if replacing a character will make 2 strings equal
     * @param strOne, original string
     * @param strTwo, new string
     * @return boolean, true if replacement will work else false
     */
    public static boolean replace(String strOne, String strTwo){
        int diff = 0;
        for (int i = 0; i < strOne.length(); i++){
            if (strOne.charAt(i) != strTwo.charAt(i)){
                diff++;
            }
        }
        return diff <= 1;
    }

    /**
     * Checks to see if insertion or deletion will make 2 strings equal
     * @param strOne, original string
     * @param strTwo, new string
     * @return boolean, true if insert/delete will work else false
     */
    public static boolean insert(String strOne, String strTwo){
        int indexOne = 0;
        int indexTwo = 0;

        while (indexOne < strOne.length() && indexTwo < strTwo.length()) {
            if (strOne.charAt(indexOne) != strTwo.charAt(indexTwo)) {
                if (indexOne != indexTwo) {
                    return false;
                }
            } else {
                indexOne++;
            }
            indexTwo++;
        }
        return true;
    }
}
