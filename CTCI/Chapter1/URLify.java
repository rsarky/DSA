import java.util.*;

public class URLify {
    static void replaceSpaces(char arr[], int truelength) {
        int spaces = 0;
        for(int i=0;i<truelength;i++){
            if(arr[i]==' ')
                spaces++;
        }
        int index = truelength + 2*spaces;
        //Iterate the string in reverse order
        for(int i=truelength-1;i>=0;i--) {
            if(arr[i]==' '){
                arr[index-1] = '0';
                arr[index-2] = '2';
                arr[index-3] = '%';
                index -= 3;
            } else {
                arr[index-1] = arr[i];
                index-=1;
            }
        }
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        char[] characters = str.toCharArray();
        replaceSpaces(characters, n);
        String ans = new String(characters);
        System.out.println(ans);
    }
}