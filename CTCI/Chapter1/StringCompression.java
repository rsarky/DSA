import java.util.Scanner;

//O(n) Solution where n is the length of the string.
public class StringCompression {
    static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int run = 1;
        for(int i=0;i< str.length(); i++) {
            if(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                run++;
            }
            else {
                compressed.append(str.charAt(i));
                compressed.append(run);
                run = 1;
            }
        }
        if(compressed.length() >= str.length()) return str;
        else return compressed.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(compressString(sc.next()));
    }
}