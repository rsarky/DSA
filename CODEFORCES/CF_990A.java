import java.util.Scanner;
public class CF_990A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        long n,m,a,b;
        n = sc.nextLong();
        m = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        long ans =  Math.min((n%m)*b, (m-(n%m))*a);
        System.out.println(ans);
    }
}