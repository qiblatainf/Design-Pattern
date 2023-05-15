package TextEditor;
//IMPLEMENTATION OF FACTORY PATTERN
public class TextFormatterFactory {
    public TextFormatter createTextFormatter(String type) {
        TextFormatter formatter = new PlainTextFormatter();

        if (type.contains("bold")) {
            formatter = new BoldDecorator(formatter);
        }
        if (type.contains("italic")) {
            formatter = new ItalicDecorator(formatter);
        }
        if (type.contains("underline")) {
            formatter = new UnderlineDecorator(formatter);
        }

        return formatter;
    }
}
