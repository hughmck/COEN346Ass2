public class UserProcess extends Thread {
    int processID;

    boolean processStatus; //has the process started yet? true or false
    String userName;
    int readyTime;
    int processingTime;

    public int processExecutionTime;
    private boolean running;
    private boolean enteredReadyQueue;
    private boolean readyState;

    private UserProcess process;
    Thread thread;

    UserProcess(String userName, int readyTime, int processingTime){ //how do we get the variables from the input file into here?
        this.process = process;
        this.userName = userName;
        this.enteredReadyQueue = enteredReadyQueue;
        this.processExecutionTime = processExecutionTime;
        this.running = false;
        this.thread = new Thread();
    }
}

