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
    public void run(){

        System.out.println("Thread " + this.getId() + " is starting " + arrayToString(array)); //outputing the thread ID and its current segment of the array its assigned to

        UserProcess userProcess = new UserProcess(leftHalf); //need to create an object which user process acts on
        userProcess.start(); //begin execution of left thread
        try
        {
            userProcess.join(); //trying to merge once both threads are done. Can't merge if one thread is still executing
            UserProcess(array, x , y); //Merging the two array segments

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + this.getId() + " is finished " + arrayToString(array)); //ouputs that the thread is done and what the worked on segment of the array looks like
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
