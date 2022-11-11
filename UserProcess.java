public class UserProcess {
    //        extends Thread {
    int processID;

    boolean processStatus; //has the process started yet? true or false
    String userName;
    int readyTime;
    int processingTime;

    String processName;
    public int processExecutionTime;
    private boolean running;
    private boolean enteredReadyQueue;
    private boolean readyState;

    String phase;

//    private UserProcess process;
//    Thread thread;

    String getUserName() {
        return userName;
    }

    String getProcessName() {
        return userName;
    }

    int getReadyTime() {
        return readyTime;
    }

    int getProcessingTime() {
        return processingTime;
    }

    String setPhase(String newPhase) {
        phase = newPhase;
        return phase;
    }

    int setProcessingTime(int processExecutionTime)
    {
        processingTime = processExecutionTime;
        return processingTime;
    }

    UserProcess(String userName, String processName, int readyTime, int processingTime, String phase){ //how do we get the variables from the input file into here?
        this.processName  = processName;
        this.userName = userName;
        this.readyTime = readyTime;
        this.processingTime = processingTime;
        this.enteredReadyQueue = enteredReadyQueue;
        this.processExecutionTime = processExecutionTime;
        this.running = false;
        this.phase = phase;

//        this.thread = new Thread();
    }

    void getDetails()
    {
        System.out.println("Time " + FairShareScheduler.clock + ", " + userName + ", " + processName + ", Ready Time: " + readyTime + ", Remaining Time " + processingTime + ", " + phase);
    }
}

