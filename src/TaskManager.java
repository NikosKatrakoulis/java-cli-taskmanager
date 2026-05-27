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

    private void increaseSize() {
        Task[] temp = new Task[tasks.length * 2];

        for (int task = 0; task < tasks.length; task++) {
            temp[task] = tasks[task];
        }
        tasks = temp;
    }
}
