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
            int menuChoice = scanner.nextInt();

            if (menuChoice == 1) {
                return;
            } else if (menuChoice == 2) {
                return;
            } else if (menuChoice == 3) {
                return;
            } else if (menuChoice == 4) {
                return;
            } else if (menuChoice == 5) {
                return;
            } else {
                return;
            }

        }
    }
}
