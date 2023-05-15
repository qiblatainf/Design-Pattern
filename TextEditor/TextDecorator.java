package TextEditor;
public abstract class TextDecorator implements TextFormatter {
    protected TextFormatter formatter;

    public TextDecorator(TextFormatter formatter) {
        this.formatter = formatter;
    }
}

