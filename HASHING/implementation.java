import java.util.ArrayList;

class SeparateChainingHT<Key, Value> {
    private int N;
    private int M;
    private class HashNode {
        Key key;
        Value val;
        HashNode next;
        HashNode(Key k, Value v) {
            key = k;
            val = v;
        }
    }
    private ArrayList<HashNode> table;

    SeparateChainingHT(){
        this(997);
    }
    SeparateChainingHT(int M) {
        this.M = M;
        this.N = 0;
        table = new ArrayList<>();
        for(int i=0;i<M;i++) {
            table.add(null);
        }
    }

    int size() {
        return this.N;  
    }

    boolean isEmpty() {
        return this.N == 0;
    }

    int getIndex(Key k) {
        int hashcode = k.hashCode() & 0x7fffffff; //Make hashcode positive.
        return hashcode % M;
    }

    Value get(Key k) {
        int hash = getIndex(k);
        HashNode list = table.get(hash);
        while( list != null) {
            if(list.key == k) return list.val;
            list = list.next;
        }
        return null;
    }

    boolean contains(Key k) {
        if(this.get(k) == null) return false;
        return true;
    }
    
    void add(Key k, Value v) {
        HashNode newNode = new HashNode(k, v);
        int hash = getIndex(k);
        HashNode list = table.get(hash);
        if(list == null) {
            table.set(hash, newNode);
            return;
        }

        while(list.next != null) {
            list = list.next;
        }
        list.next = newNode;
        N++;
        return;
    }

    public static void main(String args[]) {
        SeparateChainingHT<Integer, String> map = new SeparateChainingHT<>();
        map.add(1,"Rohit");
        map.add(2, "Sarkar");
        System.out.println(map.get(1));
    }

}