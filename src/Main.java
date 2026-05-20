import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] taskTitles = new String[10];
            boolean[] taskDone = new boolean[10];
            int taskCount = 0;
            boolean isRunning = true;

            try (Scanner fileScanner = new Scanner(new File("tasks.txt"))) {

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    taskTitles[taskCount] = parts[0];
                    taskDone[taskCount] = Boolean.parseBoolean(parts[1]);
                    taskCount++;
                }
            } catch (Exception e) {
                System.out.println("No saved tasks found.");
            }

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
                        if (taskCount == 10) {
                            System.out.println("Task list is full!");
                            System.out.println();
                            continue;
                        }

                        System.out.print("Enter the task you want to add: ");
                        String task = scanner.nextLine().trim();
                        if (task.equals("exit")) {
                            continue;
                        }
                        taskTitles[taskCount] = task;
                        taskDone[taskCount] = false;
                        taskCount++;
                        System.out.println("Task: \"" + task + "\" added!");
                        System.out.println();
                        break;

                    case 2:
                        int counter = 0;
                        if (taskCount == 0) {
                            System.out.println("No tasks found!");
                            System.out.println();
                        } else {
                            for (String title : taskTitles) {
                                System.out.print("ID: " + counter + " | " + title + " | ");
                                if (taskDone[counter]) {
                                    System.out.println("✓");
                                } else {
                                    System.out.println("✗");
                                }
                                counter++;

                                if (counter >= taskCount) {
                                    break;
                                }
                            }
                            System.out.println();
                        }
                        break;

                    case 3:
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
                        break;

                    case 4:
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
                            for (int i = deletedTask; i < taskCount - 1; i++) {
                                taskTitles[i] = taskTitles[i + 1];
                                taskDone[i] = taskDone[i + 1];
                            }
                            taskCount--;
                        }
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

            try (FileWriter writer = new FileWriter("tasks.txt")) {
                for (int i = 0; i < taskCount; i++) {
                    writer.write(taskTitles[i] + "," + taskDone[i] + "\n");
                }
            } catch (Exception e) {
                System.out.println("Error saving tasks!");
            }
        }
    }
}
