import java.util.Scanner;

//O(n) Solution where n is the length of the shorter string.
public class OneAway {
    static boolean isOneAway(String str1,String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if(Math.abs(l1 - l2) > 1) return false;
        int i,j;
        i=0;
        j=0;
        boolean flag = false;
        while(i < l1 && j < l2) {
            if(str1.charAt(i) != str2.charAt(j)) {
                if(flag)
                    return false;
                flag = true;
                if(l1 == l2) {
                    i++;
                    j++;
                }
                else if(l1 > l2) {
                    i++;
                }
                else {
                    j++;
                }
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        if(isOneAway(str1, str2)) {
            System.out.println("One Away");
        }
        else {
            System.out.println("Not One Away");
        }
    }
}