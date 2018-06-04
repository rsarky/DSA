import java.util.*;

public class Twins {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int tot = 0;
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            tot += arr[i];
        }
        Arrays.sort(arr);
        int num_coins = 0;
        int sum = 0;
        int j=n-1;
        while(sum <= tot) {
            num_coins++;
            sum+=arr[j];
            tot-=arr[j];
            j--;
        }
        System.out.println(num_coins);
    }
}