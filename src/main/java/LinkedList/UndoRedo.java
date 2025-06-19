package LinkedList; // Defines the package where the class belongs, allowing organized project structure.

public class UndoRedo<T> {  //  Uses `<T>` to allow storing any type of state (e.g., Strings, Integers, Objects)

    private NodeUndoRedo<T> head; //  Pointer to the first node in the list (tracks history from the beginning).
    private NodeUndoRedo<T> currentState; //  Tracks the "current state," used for undo/redo navigation.

    /**
     * Adds a new state to the list and moves `currentState` forward.
     * Clears redo path if a new state is added.
     */
    public void addState(T newState) {
        NodeUndoRedo<T> node = new NodeUndoRedo<>(newState); // Creates a new node to store `newState`

        if (head == null) {  // If the list is empty, initialize it with this first state.
            head = currentState = node; //  Set both `head` and `currentState` to the new node (first state in history).
        } else {
            node.prev = currentState; //  Link the new node to the previous state (undo functionality).
            currentState.next = node; //  Set the current state's next pointer to the new node (redo functionality).
            currentState = node; //  Move `currentState` forward to point to the newly added state.

            // Clears redo path by disconnecting any forward states.
            node.next = null; //  Any redo possibilities after an undo are erased since a new state was added.
        }
    }

    /**
     * Moves `currentState` to the previous node (undo).
     */
    public void undo() {
        if (currentState != null && currentState.prev != null) { //  Check if there is a previous state to move back to.
            currentState = currentState.prev; //  Move the pointer back one step in history.
            System.out.println("Undo: Current state is " + currentState.state); //  Display the new current state.
        } else {
            System.out.println("No previous state to undo."); //  If no previous state exists, inform the user.
        }
    }

    /**
     * Moves `currentState` to the next node (redo).
     */
    public void redo() {
        if (currentState != null && currentState.next != null) { //  Check if there is a forward state to move to.
            currentState = currentState.next; //  Move the pointer forward one step in history.
            System.out.println("Redo: Current state is " + currentState.state); //  Display the new current state.
        } else {
            System.out.println("No next state to redo."); //  If no forward state exists, inform the user.
        }
    }

    /**
     * Prints all stored states for debugging.
     */
    public void printStates() {
        NodeUndoRedo<T> temp = head; //  Start at the beginning of the history list.
        System.out.print("States: ");

        while (temp != null) { //  Iterate through the list until reaching the last state.
            System.out.print(temp.state + " "); //  Print each stored state.
            temp = temp.next; //  Move to the next state in the sequence.
        }
        System.out.println(); //  End the printed history line with a newline for readability.
    }
}
