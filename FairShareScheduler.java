import java.util.*;

public class FairShareScheduler extends Thread {

    public static ArrayList<UserProcess> scheduleProcesses = new ArrayList<UserProcess>();
    public FairShareScheduler(ArrayList<UserProcess> scheduleProcesses)
    {
        this.scheduleProcesses = scheduleProcesses;
    }

//    int processID;
//
//    boolean processStatus; //has the process started yet? true or false
//    String userName;
//    int readyTime;
//    int processingTime;
//

//    private boolean running;
//    private boolean enteredReadyQueue;
//    private boolean readyState;
//
//    private UserProcess process;
//
//    Thread thread;
//    public int quantumTime;
//
//    public ArrayList<String> userNames;
//
//    public ArrayList<String> processes;
//

//
//    public boolean isRunning() {
//        return running;
//    }
//
//    public boolean inReadyQueue() {
//        return enteredReadyQueue;
//    }
//
//    public boolean readyToRun() {
//        return readyState;
//    }

    public static Queue<UserProcess> q = new LinkedList<>();
    public static int clock;

    public void run() {
        for (clock = 1; clock < 17; clock ++)
            for(int j=0; j<scheduleProcesses.size();j++)
            {
            UserProcess nextProcess  = scheduleProcesses.get(j);
            if(nextProcess.getReadyTime() == clock) //checks if the program is ready. of the arrival time is bigger than the current time it will send to else
                {
                    q.add(nextProcess);
                    User temp = null;
                    if(Driver.users.contains(nextProcess.userName))
                    {
                        Driver.users.get(j).
                    }
                    else
                    {
                         temp = new User(nextProcess.getUserName(), 1);
                    }
                    UserProcess nextSchedule = new UserProcess(q.peek());
                    nextSchedule.start();
                }
            }
    }
}
