package TextEditor;
public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(TextFormatter formatter) {
        super(formatter);
    }

    public String format(String text) {
        return "<i>" + formatter.format(text) + "</i>";
    }
}
