package chapterone;

public class StringCompression {
    public static void main(String[] args){
        String t = "aabcccccaaa";
        System.out.println(compress(t));
        String t2 = "aa";
        System.out.println(compress(t2));
    }

    /**
     * Compresses string to format char+int...repeated
     * @param str, string to be compressed
     * @return String in compressed format
     */
    public static String compress(String str){
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        int j = 1;
        for (int i = 0; i < chars.length-1; i++){
            if (chars[i] == chars[i+1]){
                j++;
            } else {
                sb.append(chars[i]);
                sb.append(j);
                j = 1;
            }
        }

        sb.append(chars[chars.length-1]);
        sb.append(j);

        return sb.toString().length() == str.length() ? str : sb.toString();
    }
}
