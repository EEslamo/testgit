import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SJF {
    private ArrayList<Process> Processes = new ArrayList<>();
    Scanner IntScanner = new Scanner(System.in);
    Scanner TextScanner = new Scanner(System.in);
    private int ContextSwitch;

    public SJF(ArrayList<Process> Processes) throws InterruptedException {
        System.out.println("- Running SFJ");
        System.out.print("- Enter Context Switch (in milliseconds):   ");
        ContextSwitch = IntScanner.nextInt();
        this.Processes = Processes;
        Collections.sort(Processes, Comparator.comparingInt(p -> p.BurstTime));

        long WaitingTime = 0;
        long TotalWaitingTime = 0;
        int TotalTurnAroundTime = 0;
        int Counter = 1;
        long Seconds = ContextSwitch/1000;


        for (Process process : Processes) {

            if (process.WaitingTime < 0)
                process.WaitingTime = 0;

            process.WaitingTime = WaitingTime;
            process.TurnAroundTime = process.WaitingTime + process.BurstTime;

            System.out.println("Process " + process.ProcessNumber);
            System.out.println("Name: " + process.Name);
            System.out.println("Burst Time: " + process.BurstTime);
            System.out.println("Waiting Time: " + process.WaitingTime);
            System.out.println("Turnaround Time: " + process.TurnAroundTime);
            System.out.println("---------------");

            WaitingTime = WaitingTime + process.BurstTime +Seconds;
            TotalWaitingTime = TotalWaitingTime + WaitingTime;
            TotalTurnAroundTime = (int) (TotalWaitingTime + process.TurnAroundTime);
            Counter++;
            System.out.println("- Running context switch");
            Thread.sleep(ContextSwitch);

        }

        long AverageWaitingTime = TotalWaitingTime/Counter;
        System.out.println("Average Waiting Time: " + AverageWaitingTime);

        long AverageTurnAroundTime = TotalTurnAroundTime/Counter;
        System.out.println("Average TurnAround Time: " + AverageTurnAroundTime);


    }
}
