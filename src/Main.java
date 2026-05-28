import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            TaskManager manager = new TaskManager();
            manager.loadFromFile();

            while (isRunning) {

                System.out.println("===== MENU =====");

                System.out.println("1. Add a new task");
                System.out.println("2. View tasks");
                System.out.println("3. Complete task");
                System.out.println("4. Delete task");
                System.out.println("5. Quit");
                System.out.print("Choose one: ");
                String menuInput = scanner.nextLine().trim();
                int menuChoice = Integer.parseInt(menuInput);
                System.out.println();

                switch (menuChoice) {
                    case 1:
                        System.out.print("Enter the task you want to add: ");
                        String task = scanner.nextLine().trim();
                        if (task.equals("exit")) {
                            continue;
                        } else {
                            manager.addTask(task);
                        }
                }
            }

        }
    }
}
