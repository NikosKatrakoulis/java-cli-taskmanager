import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String [] taskTitles = new String[10];
        boolean [] taskDone = new boolean[10];
        int taskCount = 0;

        while (true) {

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



            if (menuChoice == 1) {
                if (taskCount == 10) {
                    System.out.println("Task list is full!");
                    System.out.println();
                    continue;
                }

                System.out.print("Enter the task you want to add: ");
                String task = scanner.nextLine().trim();
                if (task.equals("exit")){
                    break;
                }
                taskTitles[taskCount] = task;
                taskDone[taskCount] = false;
                taskCount++;
                System.out.println("Task: \"" + task + "\" added!");
                System.out.println();

            } else if (menuChoice == 2) {
                if (taskCount == 0) {
                    System.out.println("No tasks found!");
                    System.out.println();
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.print("ID: " + i + " | " + taskTitles[i] + " | ");
                        if (taskDone[i]) {
                            System.out.println("✓");
                        } else {
                            System.out.println("✗");
                        }
                    }
                    System.out.println();
                }

            } else if (menuChoice == 3) {
                System.out.print("Enter the task you completed: ");
                String taskInput = scanner.nextLine().trim();
                int taskCompleted = Integer.parseInt(taskInput);
                System.out.println();

                if (taskCompleted < 0) {
                    System.out.println("Invalid choice! Please enter the existing number of the task.");
                    System.out.println();
                    continue;
                } else if (taskCount == 0) {
                    System.out.println("Invalid choice! Please enter the existing number of the task.");
                    System.out.println();
                    continue;
                } else if (taskCompleted >= taskCount) {
                    System.out.println("Invalid choice! Please enter the existing number of the task.");
                    System.out.println();
                    continue;
                } else if (taskDone[taskCompleted]) {
                    System.out.println("ID[" + taskCompleted + "]: \"" + taskTitles[taskCompleted] + "\" ---> Task is already completed!");
                    System.out.println();
                } else {
                    taskDone[taskCompleted] = true;
                    System.out.println("ID[" + taskCompleted + "]: \"" + taskTitles[taskCompleted] + "\" ---> Done! (✓)");
                    System.out.println();
                }

            } else if (menuChoice == 4) {
                System.out.print("Enter the task you want to delete: ");
                String deletedTaskInput = scanner.nextLine().trim();
                int deletedTask = Integer.parseInt(deletedTaskInput);

                if (deletedTask < 0) {
                    System.out.println("Invalid choice! Please enter the existing number of the task.");
                    System.out.println();
                    continue;
                } else if (taskCount == 0) {
                    System.out.println("Invalid choice! Please enter the existing number of the task.");
                    System.out.println();
                    continue;
                } else if (deletedTask >= taskCount) {
                    System.out.println("Invalid choice! Please enter the existing number of the task.");
                    System.out.println();
                    continue;

                } else {
                    System.out.println("ID[" + deletedTask + "]: \"" + taskTitles[deletedTask] + "\" --- Deleted!");
                    System.out.println();
                    for (int i = deletedTask; i < taskCount -1; i++) {
                        taskTitles[i] = taskTitles[i + 1];
                        taskDone[i] = taskDone[i + 1];
                    }
                    taskCount--;
                }

            } else if ( menuChoice == 5){
                System.out.println("Thank you for using my application!");
                System.out.println("Bye!");
                break;

            } else {
                System.out.println("Please enter a number between 1 and 5!");
                System.out.println();
                continue;
            }
        }
    }
}
