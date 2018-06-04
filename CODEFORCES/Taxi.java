import java.util.*;
public class Taxi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count[] = {0,0,0,0,0};
        int num_taxies;
        for(int i=0;i<n;i++) {
            count[sc.nextInt()]++;
        }
        num_taxies = count[4];
        num_taxies += count[3];
        count[1] -= count[3];
        num_taxies += count[2]/2;
        count[2] = count[2] % 2;
        if(count[1] > 0) {
            if(count[2]==1) {
                num_taxies += 1;
                count[1] -= 2;
                count[2] = 0;
            }
            if(count[1] > 0) {
                num_taxies += Math.ceil((float)count[1] / 4);
            }
        }
        else num_taxies += count[2];
        System.out.println(num_taxies);
    }
}