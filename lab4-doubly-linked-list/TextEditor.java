public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        currentNode = new Node("", null, null); // start empty
    }

    // Appends newText to current state and creates a new node
    // If you add after undo, redo history is cleared
    public void add(String newText) {
        String updated = currentNode.textState + newText;

        // Clear redo history
        currentNode.next = null;

        Node newNode = new Node(updated, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
        }
        return currentNode.textState;
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println("Current text: " + currentNode.textState);
    }
}
