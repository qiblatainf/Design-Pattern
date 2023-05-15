package TextEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        TextEditor editor = TextEditor.getInstance(); //creates one instance of the text editor - implements singleton
        TextFormatterFactory factory = new TextFormatterFactory();
        Scanner scanner = new Scanner(System.in);

        // Add a simple text change listener - implements Observer Pattern
        editor.addTextChangeListener(newText -> {
            System.out.println("Text changed: " + newText);
        });

        while (true) {
            System.out.println("Enter your text (type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter the formatting options (bold, italic, underline, or a combination separated by commas): ");
            String[] options = scanner.nextLine().split(",");

            List<TextFormatter> formatters = new ArrayList<>();

            for (String option : options) {
                option = option.trim().toLowerCase();
                try {
                    TextFormatter formatter = factory.createTextFormatter(option);
                    if (formatter != null) {
                        formatters.add(formatter);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid formatter type: " + option);
                }
            }

            String formattedText = input;
            for (TextFormatter formatter : formatters) {
                formattedText = formatter.format(formattedText);
            }
            
            editor.setText(formattedText);
        }

        scanner.close();
    }
}
