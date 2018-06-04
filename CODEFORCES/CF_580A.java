//Complexity O(n)
import java.util.*;

public class CF_580A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int maxrun = 0;
        int curr_max = 0;
        int prev = 0;
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            if(arr[i] >= prev) {
                maxrun++;
                prev = arr[i];
            }
            else {
                curr_max = maxrun > curr_max ? maxrun : curr_max;
                maxrun = 1;
                prev = arr[i];
            }
        }
        curr_max = maxrun > curr_max ? maxrun : curr_max;
        System.out.println(curr_max);
    }
}