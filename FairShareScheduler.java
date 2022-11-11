import java.util.ArrayList;

public class FairShareScheduler extends Thread {

    ArrayList<UserProcess> processArrayList = new ArrayList<>();
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
    public int processExecutionTime;
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
    public static int clock;
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
        int userTime = Driver.quantum_size; //gives the amount of fair share time to each
        nextProcess.setPhase("Started");
        nextProcess.getDetails();



        this.processExecutionTime = nextProcess.getProcessingTime();


        while (this.processExecutionTime > 0) {
            this.processExecutionTime--; //decrements the process execution time until it is complete
//            clock();
            nextProcess.setPhase("Resumed");
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
