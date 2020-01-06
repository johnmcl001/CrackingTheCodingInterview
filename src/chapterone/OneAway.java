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
        if (strOne.length() - strTwo.length() > 1){
            return false;
        }

        int minStrLeg
    }
}
