import java.util.*;

public class CF_492B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        double max_diff = -1;
        for(int i=0;i<n-1;i++) {
            max_diff = Math.max(arr[i+1]-arr[i],max_diff);
        }
        double d = max_diff/2;
        double ans = Math.max(arr[0],Math.max(d,l - arr[n-1]));
        System.out.println(ans);
        sc.close();

    }
}