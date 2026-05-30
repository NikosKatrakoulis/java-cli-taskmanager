import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        try (Scanner scanner = new Scanner(System.in))
        {
            boolean isRunning = true;
            TaskManager manager = new TaskManager();
            manager.loadFromFile();

            while (isRunning)
            {

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

                switch (menuChoice)
                {
                    case 1:
                        System.out.print("Enter the task title: ");
                        String title = scanner.nextLine().trim();
                        if (title.equals("exit"))
                        {
                            continue;
                        }
                        manager.addTask(title);
                        System.out.println("Task: \"" + title + "\" added!");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Task List:");
                        manager.viewTasks();
                        break;
                    case 3:
                        System.out.print("Enter the task you completed: ");
                        String taskInput = scanner.nextLine().trim();
                        int taskCompleted = Integer.parseInt(taskInput);
                        if (taskCompleted < 0) {
                            System.out.println("Invalid choice! Please enter a valid number.");
                            continue;
                        }
                        manager.completeTask(taskCompleted);
                        System.out.println();
                        break;
                    case 4:
                        System.out.print("Enter the task you want to delete: ");
                        String deletedTaskInput = scanner.nextLine().trim();
                        int deletedTask = Integer.parseInt(deletedTaskInput);
                        if (deletedTask < 0) {
                            System.out.println("Invalid choice! Please enter a valid number.");
                            continue;
                        }
                        manager.deleteTask(deletedTask);
                        break;
                    case 5:
                        System.out.println("Thank you for using my application!");
                        System.out.println("Bye!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Please enter a number between 1 and 5!");
                        System.out.println();
                        break;
                }
            }
            manager.saveToFile();
        }
    }
}
