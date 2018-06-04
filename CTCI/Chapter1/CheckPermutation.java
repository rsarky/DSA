/**
* Given 2 strings write a method to check if one string is a permutation
* of the other.
**/
import java.util.*;

class CheckPermutation {
    //Sorts both the strings and compares them.
    //Time Complexity O(nlogn) Space Complexity O(1)
    static boolean isPermutationSort(String str1, String str2) {
        if(str1.length() != str2.length()) 
            return false;

        //Sorts the characters in the string.
        char[] str1_arr = str1.toCharArray();
        char[] str2_arr = str2.toCharArray();
        Arrays.sort(str1_arr);
        Arrays.sort(str2_arr);
        str1 = new String(str1_arr);
        str2 = new String(str2_arr);

        for(int i=0;i<str1.length();i++) {
            if(str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    //Stores the characters in a hashmap.
    //Time Complexity O(n) Space Complexity Sigma(n)
    static boolean isPermutationHash(String str1, String str2) {
        if(str1.length() != str2.length()) 
            return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<str1.length();i++) {
            if(hm.containsKey(str1.charAt(i))) {
                hm.replace(str1.charAt(i), hm.get(str1.charAt(i)) + 1);
            }
            else {
                hm.put(str1.charAt(i), 1);
            }

            if(hm.containsKey(str2.charAt(i))) {
                hm.replace(str2.charAt(i), hm.get(str2.charAt(i)) - 1);
            }
            else {
                hm.put(str2.charAt(i), -1);
            }
        }
        for(int i=0;i<str1.length();i++) {
            if( hm.get(str1.charAt(i)) != 0 || hm.get(str2.charAt(i)) != 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        if(isPermutationHash(str1, str2)) {
            System.out.println("Strings are permutations.");
        }
        else {
            System.out.println("Strings are not permutations.");
        }

    }
}