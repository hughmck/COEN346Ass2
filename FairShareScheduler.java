import java.util.ArrayList;

public class FairShareScheduler extends Thread {

    UserProcess nextProcess;
    public FairShareScheduler(UserProcess nextProcess)
    {
        this.nextProcess = nextProcess;
    }

//    int processID;
//
//    boolean processStatus; //has the process started yet? true or false
//    String userName;
//    int readyTime;
//    int processingTime;
//
    public int allowedExecutionTime;
    int remainingTime;
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
    public static int clock = 1;
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
    public void run() {

            nextProcess.setPhase("Started");
            nextProcess.getDetails();

            this.allowedExecutionTime = Driver.quantum_size; //will need to divide quantum like they said in the assignment but still working on this for now
            this.remainingTime = nextProcess.getProcessingTime();


            if(this.remainingTime > 0)
            {
                while(allowedExecutionTime != 0)
                {
                    nextProcess.setProcessingTime(remainingTime);
                    nextProcess.setPhase("Resumed");
                    nextProcess.getDetails();
                    this.remainingTime--;//decrements the process execution time until it is complete
                    this.allowedExecutionTime--;
                    clock++;
                }
                Driver.processes.add(nextProcess); //if there is no more quantum time left send it back to the arrayList
                System.out.println("Added to Queue");
            }
            else // if remaining program time is zero (program is done)
            {
                nextProcess.setProcessingTime(remainingTime);
                nextProcess.setPhase("Finished");
                nextProcess.getDetails();
            }
    }


//    public void clock(){ //creating a clock function which counts the seconds
//        clock = 0;
//        while(true){
//        try {
//            Thread.sleep(1000); //1000 milliseconds per second, therefore it iterates every second
//            clock++;
//            System.out.println("second");
//        }
//        catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
}
