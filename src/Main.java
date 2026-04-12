import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String [] taskTitles = new String[10];
        boolean [] taskDone = new boolean[10];
        int taskCount = 1;

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
                for (int i = 1; i < taskCount; i++) {
                    System.out.print("ID: " + i + " | " + taskTitles[i] + " | ");
                    if (taskDone[i]) {
                        System.out.println("✓");
                    } else {
                        System.out.println("✗");
                    }
                }
                System.out.println();

            } else if (menuChoice == 3) {


            } else if (menuChoice == 4) {
                return;

            } else if ( menuChoice == 5){
                System.out.println("Thank you for using my application!");
                System.out.println("Bye!");
                break;

            } else {
                System.out.println("Please enter a number between 1 and 5!");
                System.out.println();
                break;
            }
        }
    }
}
