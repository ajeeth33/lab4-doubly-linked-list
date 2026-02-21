import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Simple Text Editor ---");
            System.out.println("1) Type / Add text");
            System.out.println("2) Undo");
            System.out.println("3) Redo");
            System.out.println("4) Print current");
            System.out.println("5) Exit");
            System.out.print("> ");

            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter text to append: ");
                String t = sc.nextLine();
                editor.add(t);
                editor.printCurrent();

            } else if (choice.equals("2")) {
                String state = editor.undo();
                System.out.println("Undo -> " + state);

            } else if (choice.equals("3")) {
                String state = editor.redo();
                System.out.println("Redo -> " + state);

            } else if (choice.equals("4")) {
                editor.printCurrent();

            } else if (choice.equals("5")) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
