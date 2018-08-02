import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class CF_990B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n;
        int K = sc.nextInt();
        ArrayList<Integer> val = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            val.add(sc.nextInt());
        }
        Collections.sort(val);       

        int j = 1;
        for(int i=0;i<n-1;i++) {
            if((val.get(i+1)>val.get(i)) && (val.get(i+1)<=val.get(i)+K)) {
                count-=j;
                j = 1;
            } else if(val.get(i+1) == val.get(i)) {
                j++;
            }
        }
        System.out.println(count);
    }
}