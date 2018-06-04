class Driver {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(4);
        list.deleteKey(2);
        list.printList();
    }
}