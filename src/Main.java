import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String [] taskTitles = new String[10];
        boolean [] taskDone = new boolean[10];
        int taskCount = 0;
        boolean isRunning = true;
        boolean isQuitting = false;

        while (true) {

            System.out.println("===== MENU =====");

            System.out.println("1. Add a new task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Quit");
            System.out.print("Choose one: ");
            String menuChoice = scanner.nextLine().trim();
            System.out.println();

            while (isRunning) {

                if (menuChoice.equals("1")) {
                    System.out.print("Enter the task you want to add: ");
                    String task = scanner.nextLine().trim();
                    if (task.equals("exit")){
                        isRunning = false;
                        break;
                    }
                    taskTitles[taskCount] = task;
                    taskDone[taskCount] = false;
                    taskCount++;
                    System.out.println("Task: \"" + task + "\" added!");
                    System.out.println();

                } else if (menuChoice.equals("2")) {
                    for (int i = 0; i <= taskCount; i++) {
                        System.out.println("ID: ");
                    }

                } else if (menuChoice.equals("3")) {
                    return;

                } else if (menuChoice.equals("4")) {
                    return;

                } else if ( menuChoice.equals("5")){
                    System.out.println("Thank you for using my application!");
                    System.out.println("Bye!");
                    isRunning = false;
                    isQuitting = true;
                    break;

                } else {
                    System.out.println("Please enter a number between 1 and 5!");
                    System.out.println();
                    break;
                }
            }
            if (isQuitting)
                break;
        }
    }
}
