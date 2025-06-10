package LinkedList;

import java.util.LinkedList;

public class SingleLinkedListTest {

    // ───────────────────────────────────
    //  fields
    // ───────────────────────────────────
    public Node head;
    public Node tail;
    public int  size;

    // ───────────────────────────────────
    //  create a one-node list
    // ───────────────────────────────────
    public Node createSingleLinkedlist(int nodeValue) {
        Node node  = new Node();
        node.value = nodeValue;
        node.next  = null;
        head = tail = node;
        size = 1;
        return head;
    }

    // (the LinkedList import isn’t used, but the professor left it here)
    LinkedList<String> lit = new LinkedList<>();

    // ───────────────────────────────────
    //  insert
    // ───────────────────────────────────
    public void insertLinkedList(int nodeValue, int location) {
        Node node  = new Node();
        node.value = nodeValue;

        if (head == null) {                     // empty list
            createSingleLinkedlist(nodeValue);
            return;
        }

        if (location == 0) {                    // insert at head
            node.next = head;
            head      = node;
        } else if (location >= size) {          // insert at tail
            tail.next = node;
            tail      = node;
        } else {                                // insert in the middle
            Node temp = head;
            int  idx  = 0;
            while (idx < location - 1) {
                temp = temp.next;
                idx++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;                                 // ← make sure size is updated
    }

    // ───────────────────────────────────
    //  traverse/print
    // ───────────────────────────────────
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
            return;
        }
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value);
            if (i != size - 1) System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }

    // ───────────────────────────────────
    //  search
    // ───────────────────────────────────
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.value == nodeValue) {
                    System.out.println("Found the node at location: " + i);
                    return true;
                }
                temp = temp.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // ───────────────────────────────────
    //  delete  ← the part you had to finish
    // ───────────────────────────────────
    public void delete(int position) {

        // 1. empty list
        if (head == null) {
            System.out.println("The list is empty. There is nothing to delete");
            return;
        }

        // 2. invalid position
        if (position < 0 || position >= size) {
            System.out.println(
                    "Invalid position. Please provide a valid index between 0 and "
                            + (size - 1));
            return;
        }

        // 3. delete at head
        if (position == 0) {
            head = head.next;
            size--;
            if (size == 0) tail = null;   // list became empty
            return;
        }

        // 4. traverse to node just before the one we’ll remove
        Node prev = head;
        for (int i = 0; i < position - 1; i++) {
            prev = prev.next;
        }

        // 5. delete at tail or middle
        if (position == size - 1) {       // tail case
            prev.next = null;
            tail      = prev;
        } else {                          // middle case
            prev.next = prev.next.next;
        }
        size--;
    }

}
