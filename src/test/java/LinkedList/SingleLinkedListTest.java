package LinkedList;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.insertLinkedList(10, 0);
        list.insertLinkedList(20, 1);
        list.insertLinkedList(30, 2);
        list.traverseLinkedList();           // 10->20->30

        list.delete(0);                      // delete head
        list.traverseLinkedList();           // 20->30

        list.delete(list.size - 1);          // delete tail
        list.traverseLinkedList();           // 20

        list.delete(0);                      // delete final node
        list.traverseLinkedList();           // SLL does not exist
    }


}
