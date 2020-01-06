package chapterone;

public class URLify {
    public static void main(String[] args){
        String s = "Mr John Smith";
        System.out.println(toURL(s, 13));
        System.out.println(toURL(s));
    }

    /**
     * Substitutes spaces in the input string with %20
     * @param str, string to be converted to url
     * @return String with %20 instead of spaces
     */
    public static String toURL(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c: chars){
            if (c != ' '){
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    /**
     * Substitutes spaces in the input string with %20
     * @param str, string to be converted to url
     * @param strSize, length of the input string
     * @return String with %20 instead of spaces
     */
    public static String toURL(String str, int strSize){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strSize; i++){
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
