// Complexity  = O(T.N)
import java.util.*;

public class CF_266B {
    static void exchangeStudents(char[] list) {
        for(int i=0;i<list.length-1;i++) {
            if(list[i] == 'B' && list[i+1] == 'G') {
                list[i] = 'G';
                list[i+1] = 'B';
                i+=1;
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String queue = sc.next();
        char q[] = queue.toCharArray();
        for(int i=0;i<t;i++)
            exchangeStudents(q);
        String ans = new String(q);
        System.out.println(ans);
    }
}