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

        while (true) {

            System.out.println("===== MENU =====");

            System.out.println("1. Add a new task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Quit");
            System.out.print("Choose one: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            while (isRunning) {

                if (menuChoice == 1) {
                    System.out.println("Enter the task you want to add: ");
                    String task = scanner.nextLine().trim();
                    if (task.equals("exit")){
                        isRunning = false;
                        break;
                    }
                    taskTitles[taskCount] = task;
                    taskDone[taskCount] = false;
                    taskCount++;

                } else if (menuChoice == 2) {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println("ID: " + taskTitles[i]);
                    }
                } else if (menuChoice == 3) {
                    return;
                } else if (menuChoice == 4) {
                    return;
                } else {
                    return;
                }
            }
        }
    }
}
