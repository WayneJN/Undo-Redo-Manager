package LinkedList; // ✅ Defines the package, grouping related classes for organization.

/**
 * NodeUndoRedo class:
 * - Supports generics (`<T>`) for flexible state storage.
 * - Implements `prev` pointer for undo functionality.
 * - Used in a doubly linked list for maintaining history of states.
 */
public class NodeUndoRedo<T> { // Uses `<T>` to allow storing any data type (e.g., String, Integer, Object).

    public T state; // Stores the actual data representing a state in the undo/redo history.

    public NodeUndoRedo<T> next; //  Pointer to the next state (for redo functionality).
    public NodeUndoRedo<T> prev; //  Pointer to the previous state (for undo functionality).

    /**
     * Constructor: Creates a new node with a given state.
     * Initializes `next` and `prev` as null since a new node starts unlinked.
     */
    public NodeUndoRedo(T state) {
        this.state = state;  //  Assigns the provided data (`state`) to the node.
        this.next = null;    //  Initially, prev and next doesn't link to any next state.
        this.prev = null;
    }
}
