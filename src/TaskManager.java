import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class TaskManager {

    private Task[]tasks;
    private int taskCount;
    private int nextId;

    public TaskManager() {
        tasks = new Task[100];
        taskCount = 0;
        nextId = 0;
    }

    public void addTask(String title) {
        if (taskCount == tasks.length) {
            increaseSize();
        }

        tasks[taskCount] = new Task(nextId, title);
        taskCount++;
        nextId++;
    }

    public void viewTasks() {
        int counter = 0;
        if (taskCount == 0) {
            System.out.println("No tasks found.");
            System.out.println();
        } else {
            for (Task task : tasks) {
                System.out.println(task);
                counter++;

                if (counter >= taskCount) {
                    break;
                }
            }
        }
    }

    public void completeTask(int id) {

        boolean found = false;

        if (taskCount == 0) {
            System.out.println("No tasks found.");
        } else {
            for (int task = 0; task < taskCount; task++) {
                if (tasks[task].getId() == id) {
                    tasks[task].markAsDone();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid choice! Please enter the existing number of the task.");
            }

        }
    }

    public void deleteTask(int id) {

        boolean found = false;

        if (taskCount == 0) {
            System.out.println("Invalid choice! Please enter the existing number of the task.");
        } else {
            for (int task = 0; task < taskCount; task++) {
                if (tasks[task].getId() == id) {
                    for (int i = task; i < taskCount - 1; i++) {
                        tasks[i] = tasks[i + 1];
                    }
                    taskCount--;
                    found = true;
                    break;
                }

            }
        }
        if (!found) {
            System.out.println("Invalid choice! Please enter the existing number of the task.");
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("tasks.txt")) {
            for (int i = 0; i < taskCount; i++) {
                writer.write(tasks[i].getTitle() + "," + tasks[i].isDone() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving tasks!");
        }
    }

    public void loadFromFile() {
        try (Scanner fileScanner = new Scanner(new File("tasks.txt"))) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (taskCount == tasks.length) {
                    increaseSize();
                } else {
                    tasks[taskCount] = new Task(nextId, parts[0]);
                    if (Boolean.parseBoolean(parts[1])) {
                        tasks[taskCount].markAsDone();
                    }
                    taskCount++;
                    nextId++;
                }
            }
        } catch (Exception e) {
            System.out.println("No saved tasks found.");
        }
    }



    private void increaseSize() {
        Task[] temp = new Task[tasks.length * 2];

        for (int task = 0; task < tasks.length; task++) {
            temp[task] = tasks[task];
        }
        tasks = temp;
    }
}
