class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int historySize;
    private int count;

    TextEditor(int historySize) {
        this.historySize = historySize;
        this.count = 0;
        this.current = new TextState("");
    }

    void addState(String content) {
        TextState newState = new TextState(content);
        newState.prev = current;
        if (current != null) current.next = newState;
        current = newState;
        count++;

        if (count > historySize) {
            TextState temp = current;
            while (temp.prev != null && count > historySize) {
                temp = temp.prev;
                count--;
            }
            temp.prev = null;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void displayCurrentState() {
        System.out.println("Current State: " + (current != null ? current.content : ""));
    }
}

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
