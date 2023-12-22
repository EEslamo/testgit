import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner IntScanner = new Scanner(System.in);
        Scanner TextScanner = new Scanner(System.in);
        System.out.print("- Enter the number of Processes:  ");
        int NumProccesses = IntScanner.nextInt();
        System.out.println();
        ArrayList<Process> Processes = new ArrayList<>();
        for (int i = 0; i < NumProccesses; i++){
            int num = i +1;
            System.out.print("- Enter process " + num + " name:  ");
            String name = TextScanner.nextLine();
            System.out.println();
            System.out.print("- Enter process color:  ");
            String color = TextScanner.nextLine();
            System.out.println();
            System.out.print("- Enter process arrival time:  ");
            int arrival = IntScanner.nextInt();
            System.out.println();
            System.out.print("- Enter process burst time:  ");
            int burst = IntScanner.nextInt();
            System.out.println();
            System.out.print("- Enter prority number:  ");
            int priority = IntScanner.nextInt();
            System.out.println();
            Process p = new Process(name, color, arrival, burst, priority, i+1);
            Processes.add(i, p);
        }
        SJF sfj = new SJF(Processes);
    }
}