import java.util.ArrayList;

public class FairShareScheduler extends Thread {
    public int quantumTime;

    public ArrayList<String> userNames;

    public ArrayList<String> processes;

    public int clock;

    public boolean running;

    public boolean enteredReadyQueue;

    public boolean readyState;
    public boolean isRunning() {
        return running;
    }

    public boolean inReadyQueue() {
        return enteredReadyQueue;
    }

    public boolean readyToRun() {
        return readyState;
    }
    public void run() {

        int userTime = this.quantumTime/userNames.size(); //gives the amount of fair share time to each
        
        UserProcess userProcess = new UserProcess(process.userName, process.readyTime, process.processingTime); //need to create an object which user process acts on. need a process function
        userProcess.start(); //begin execution of left thread

        System.out.println("Process " + this.userNames + this.process + ", started");
        while (this.processExecutionTime > 0) {
            this.processExecutionTime--; //decrements the process execution time until it is complete
            clock();
        }
        System.out.println("Process " + this.userNames + this.process + ", resumed");
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
