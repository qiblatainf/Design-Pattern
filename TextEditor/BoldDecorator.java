package TextEditor;
public class BoldDecorator extends TextDecorator {
    public BoldDecorator(TextFormatter formatter) {
        super(formatter);
    }

    public String format(String text) {
        return "<b>" + formatter.format(text) + "</b>";
    }
}
