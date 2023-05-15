package TextEditor;
import java.util.List;
import java.util.ArrayList;

//IMPLEMENTATION OF SINGLETON
public class TextEditor {
    private static TextEditor instance;

    private TextEditor() {
    }

    public static TextEditor getInstance() {
        if (instance == null) {
            instance = new TextEditor();
        }
        return instance;
    }

    //Observer pattern implemented here
    private List<TextChangeListener> listeners = new ArrayList<>();
    private String text = "";

    public void addTextChangeListener(TextChangeListener listener) {
        listeners.add(listener);
    }

    public void removeTextChangeListener(TextChangeListener listener) {
        listeners.remove(listener);
    }

    public void setText(String newText) {
        this.text = newText;
        notifyTextChangeListeners();
    }

    private void notifyTextChangeListeners() {
        for (TextChangeListener listener : listeners) {
            listener.onTextChanged(text);
        }
    }
}