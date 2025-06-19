package LinkedList;

/**
 * UndoRedoTest class:
 * - Demonstrates the undo/redo functionality of the UndoRedo system.
 * - Tests the linked list structure by adding, undoing, redoing states.
 */
public class UndoRedoTest {
    public static void main(String[] args) { // Main method—entry point for execution.

        UndoRedo<String> history = new UndoRedo<>(); //  Creates an instance of `UndoRedo` that stores `String` states.

        // Add some states to the history list
        history.addState("State 1"); //  Adds "State 1" as the initial state.
        history.addState("State 2"); //  Additional states and more
        history.addState("State 3");
        history.addState("State 4");

        history.printStates(); //  Prints the current states in the list to verify the sequence.

        // Undo operations: Moves backward in history
        history.undo(); //  Moves from "State 4" to "State 3".
        history.undo(); //  Moves from "State 3" to "State 2".

        // Redo operation: Moves forward in history
        history.redo(); //  Moves from "State 2" back to "State 3".

        // Adding a new state clears redo path
        history.addState("State 5"); //  Adds "State 5", erasing redo possibilities beyond this point.

        history.printStates(); //  Prints the updated list after modifying history.

        history.redo(); //  Since "State 4" was removed from redo history, this action should do nothing.
    }
}
