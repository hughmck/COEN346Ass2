import java.util.ArrayList;

public class FairShareScheduler extends Thread {

    public int quantumTime;

    public ArrayList<String> userNames;

    public ArrayList<String> processes;

    public int clock;

    private boolean running;
    private boolean enteredReadyQueue;
    private boolean readyState;

    private UserProcess process;


    public UserProcess getProcess() {
        return process;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean inReadyQueue() {
        return enteredReadyQueue;
    }

    public boolean readyToRun() {
        return readyState;
    }

    public void setScheduler(Scheduler scheduler,Thread schedulerThread) {
        this.scheduler = scheduler;
        this.schedulerThread = schedulerThread;
    }
    public void newProcess(){
        UserProcess userProcess = new UserProcess(leftHalf); //need to create an object which user process acts on
        userProcess.start(); //begin execution of left thread

    }
    public void run() {

        UserProcess userProcess = new UserProcess(newProcess()); //need to create an object which user process acts on. need a process function
        userProcess.start(); //begin execution of left thread

        System.out.println("Process " + this.user + this.processId + ", started");
        while (this.burstTime > 0) {
            try {
                this.burstTime--;
                clock();
            } catch (InterruptedException e) {
                System.out.println("Process " + this.user + this.processId + ", paused");
            }

        }
        System.out.println("Process " + this.user + this.processId + ", resumed");
    }


    public void clock(){ //creating a clock function which counts the seconds
        clock = 0;
        while(true){
        try {
            Thread.sleep(1000); //1000 milliseconds per second, therefore it iterates every second
            clock++;
            System.out.println("second");
        }
        catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
