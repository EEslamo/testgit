public class Process {
    public String Name;
    public String Color;
    public int ProcessNumber;
    public int ArrivalTime;
    public int BurstTime;
    public long WaitingTime;
    public long TurnAroundTime;
    public int PriorityNumber;

    public Process (String name, String color, int arrival, int burst, int priority, int pnum){
        this.Name = name;
        this.Color = color;
        this.ArrivalTime = arrival;
        this.BurstTime = burst;
        this.PriorityNumber = priority;
        this.ProcessNumber = pnum;
    }

}
