import java.util.*;


class Main {
    //No additional data structure used.
    // 2 options : Compare every character to every other character. -Complexity O(n^2)
    //             Sort the input string and compare consecutive characters -Complexity O(nlogn)    
    static boolean isUniqueSort(String str){
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        str =  new String(arr);
        for(int i=0;i<str.length()-1;i++) {
            if(str.charAt(i) == str.charAt(i+1)) return false;
        }
        return true;
    }
    //HashTable Used complexity = O(n) and sigma(n) space.
    static boolean isUniqueOptimal(String str){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(set.contains(str.charAt(i))) return false;
            else set.add(str.charAt(i));
        }
        return true;
    }

    //CTCI solution. Time Complexity = O(n) (Actually O(1)). Space Complexity = O(1)
    //Consider string is in ASCII.

    static boolean isUniqueCTCI(String str){
        if(str.length() > 128) return false; //ASCII has 128 characters.
        boolean charset[] = new boolean[128];
       for(int i=0;i<str.length();i++) {
           int x = str.charAt(i);
           if(charset[x]) return false;
           else charset[x] = true;
       }
       return true;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(isUniqueCTCI(str)) {
            System.out.println("All characters are unique");
        }
        else {
            System.out.println("All characters are not unique.");
        }
        sc.close();
    }
}