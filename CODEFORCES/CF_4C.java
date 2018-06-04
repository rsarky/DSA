import java.util.*;

public class CF_4C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            String user = sc.next();
            if(!hm.containsKey(user)) {
                hm.put(user, 1);
                System.out.println("OK");
            }
            else {
                String name = user + hm.get(user);
                System.out.println(name);
                hm.replace(user, hm.get(user) + 1);
            }
        }
        sc.close();
    }
}