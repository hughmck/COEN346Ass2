public class UserProcess extends Thread {
    int processID;

    UserProcess nextProcess;

    public UserProcess(UserProcess nextProcess)
    {
        this.nextProcess = nextProcess;
    }

    String userName;
    int readyTime;
    int processingTime;

    public int allowedExecutionTime;
    int remainingTime;

    String processName;
    public int processExecutionTime;
    private boolean isComplete;

    String processStatus;

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

    void setProcessStatus(String newPhase) {
        processStatus = newPhase;
    }

    void setProcessingTime(int processExecutionTime)
    {
        processingTime = processExecutionTime;
    }

    UserProcess(String userName, String processName, int readyTime, int processingTime, String processStatus){ //how do we get the variables from the input file into here?
        this.processName  = processName;
        this.userName = userName;
        this.readyTime = readyTime;
        this.processingTime = processingTime;
        this.processStatus = processStatus;

//        this.thread = new Thread();
    }

    public void run()
    {
        nextProcess.setProcessStatus("Started");
        nextProcess.getDetails();
        String currentUser = nextProcess.getUserName();
        int thisUsersProcesses = FairShareScheduler.variables.get(currentUser);


        int quantumPerUser = Driver.quantum_size / FairShareScheduler.variables.size();
        int quantumPerProcess = quantumPerUser/ thisUsersProcesses;

        this.allowedExecutionTime = quantumPerProcess; //will need to divide quantum like they said in the assignment but still working on this for now
        System.out.println("This process has " + allowedExecutionTime + "s of allowed time");
        this.remainingTime = nextProcess.getProcessingTime();


        if(this.remainingTime > 0)
        {
            while(allowedExecutionTime != 0)
            {
                nextProcess.setProcessingTime(remainingTime);
                nextProcess.setProcessStatus("Resumed");
                nextProcess.getDetails();
                this.remainingTime--;//decrements the process execution time until it is complete
                this.allowedExecutionTime--;
                FairShareScheduler.clock++;
            }
            FairShareScheduler.scheduleProcesses.add(nextProcess); //if there is no more quantum time left send it back to the arrayList
            System.out.println("Added to Queue");
        }
        else // if remaining program time is zero (program is done)
        {
            nextProcess.setProcessingTime(remainingTime);
            nextProcess.setProcessStatus("Finished");
            nextProcess.getDetails();
        }
    }

    void getDetails()
    {
        System.out.println("Time " + FairShareScheduler.clock + ", " + userName + ", " + processName + ", Ready Time: " + readyTime + ", Remaining Time " + processingTime + ", " + processStatus);
    }
}

