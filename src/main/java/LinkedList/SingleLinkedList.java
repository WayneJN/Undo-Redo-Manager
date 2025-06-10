package LinkedList;

public class SingleLinkedList {

    /* ────────── internal state ────────── */
    public Node head;
    public Node tail;
    public int  size;

    /* ────────── create an initial node ────────── */
    public Node createSingleLinkedlist(int nodeValue) {
        Node node  = new Node();
        node.value = nodeValue;
        node.next  = null;
        head = tail = node;
        size = 1;
        return head;
    }

    /* ────────── insert ────────── */
    public void insertLinkedList(int nodeValue, int location) {
        Node node  = new Node();
        node.value = nodeValue;

        if (head == null) {                          // empty list: just create it
            createSingleLinkedlist(nodeValue);
            return;
        }

        if (location == 0) {                         // insert at head
            node.next = head;
            head      = node;
        } else if (location >= size) {               // insert at tail
            tail.next = node;
            tail      = node;
        } else {                                     // insert in the middle
            Node temp = head;
            for (int i = 0; i < location - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }

    /* ────────── traverse / print ────────── */
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

    /* ────────── search ────────── */
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

    /* ────────── delete method added ────────── */
    public void delete(int position) {

        /* 1. empty list */
        if (head == null) {
            System.out.println("The list is empty. There is nothing to delete");
            return;
        }

        /* 2. invalid position */
        if (position < 0 || position >= size) {
            System.out.println(
                    "Invalid position. Please provide a valid index between 0 and "
                            + (size - 1));
            return;
        }

        /* 3. delete at head */
        if (position == 0) {
            head = head.next;
            size--;
            if (size == 0) tail = null;         // list became empty
            return;
        }

        /* 4. locate the node just before the one we’ll remove */
        Node prev = head;
        for (int i = 0; i < position - 1; i++) {
            prev = prev.next;
        }

        /* 5. delete tail or middle */
        if (position == size - 1) {             // tail case
            prev.next = null;
            tail      = prev;
        } else {                                // middle case
            prev.next = prev.next.next;
        }
        size--;
    }

    /* ────────── optional helper ────────── */
    public int size() { return size; }
}
