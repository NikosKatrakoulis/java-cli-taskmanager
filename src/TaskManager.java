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

    private void increaseSize() {
        Task[] temp = new Task[tasks.length * 2];

        for (int task = 0; task < tasks.length; task++) {
            temp[task] = tasks[task];
        }
        tasks = temp;
    }
}
