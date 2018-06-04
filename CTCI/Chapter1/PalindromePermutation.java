import java.util.*;

public class PalindromePermutation {
    //using hashtable O(n)
    static boolean checker(String str) {
        str = str.toLowerCase();
        HashMap<Character, Integer> hm = new HashMap<>();
        int num=0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) != ' ') {
                num++;
                if(hm.containsKey(str.charAt(i))) {
                    hm.replace(str.charAt(i), hm.get(str.charAt(i)) + 1);
                }
                else {
                    hm.put(str.charAt(i),1);
                }
            }
        }

        boolean flag = false;
        for(Map.Entry<Character,Integer> entry : hm.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                if(flag) return false;
                else flag = true;
            }
        }
        return true;
    }

    //Using bit vector O(n)
    static boolean checkerBitVector(String str) {
        int bitvector = 0;
        str = str.toLowerCase();
        for(char c: str.toCharArray()) {
            int num = getCharNumber(c);
            if(num != -1)
                bitvector = toggle(bitvector, num);
        }
        return bitvector == 0 || checkExactlyOneBitSet(bitvector);
    }
    //utilities
    static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z) {
            return val - a;
        }
        else return -1;
    }
    static int toggle(int vector,int index) {
        int mask = 1 << index;
        return vector ^ mask;
    }

    static boolean checkExactlyOneBitSet(int vector) {
        return (vector & (vector-1)) == 0;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(checkerBitVector(str)) {
            System.out.println("Permutation of Palindrome");
        }
        else {
            System.out.println("Not a permutation of Palindrome");
        }
    }
}