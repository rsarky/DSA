import java.util.*;

public class CF_271A {
    static boolean isDistinct(int num) {
        int arr[] = {
                num%10,
                (num%100)/10,
                (num%1000)/100,
                (num%10000)/1000
            };

        for(int i=0;i<4;i++) {
            for(int j=i+1;j<4;j++){
                if(arr[i] == arr[j]) return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        for(int i=year+1;i<Integer.MAX_VALUE;i++) {
            if(isDistinct(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}