package TextEditor;
public class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(TextFormatter formatter) {
        super(formatter);
    }

    public String format(String text) {
        return "<u>" + formatter.format(text) + "</u>";
    }
}