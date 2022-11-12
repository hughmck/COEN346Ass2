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

    void setProcessingTime()
    {
        --processingTime;
    }

    UserProcess(String userName, String processName, int readyTime, int processingTime, String processStatus, boolean isComplete){ //how do we get the variables from the input file into here?
        this.processName  = processName;
        this.userName = userName;
        this.readyTime = readyTime;
        this.processingTime = processingTime;
        this.processStatus = processStatus;
        this.isComplete = false;
    }

    public void run() {
        nextProcess.setProcessStatus("Started");
        nextProcess.getDetails();
        User temp = getUser(nextProcess.userName);
        if (temp.activeProcesses != 0)
        {
            int quantumPerUser = Driver.quantum_size;
            int quantumPerProcess = quantumPerUser / temp.activeProcesses;
            this.allowedExecutionTime = quantumPerProcess; //will need to divide quantum like they said in the assignment but still working on this for now
            if(nextProcess.getProcessingTime() > 0)
            {
                while(allowedExecutionTime != 0)
                {
                    nextProcess.setProcessStatus("Resumed");
                    nextProcess.setProcessingTime();//decrements the process execution time until it is complete
                    this.allowedExecutionTime--;
                    FairShareScheduler.clock++;
                    nextProcess.getDetails();
                }
                FairShareScheduler.q.add(nextProcess); //if there is no more quantum time left send it back to the arrayList
            }
            else // if remaining program time is zero (program is done)
            {
                nextProcess.isComplete = true;
                temp.activeProcesses--;
                nextProcess.setProcessStatus("Finished");
                nextProcess.getDetails();
            }
        }
//        else
//        {
//            Driver.users.remove(temp);
//        }
    }

    void getDetails()
    {
        System.out.println("Time " + FairShareScheduler.clock + ", " + userName + ", " + processName + ", Ready Time: " + readyTime + ", Remaining Time " + processingTime + ", " + processStatus);
    }

    public User getUser(String username)
    {
        for (int i = 0; i < Driver.users.size(); i++)
        {
            User temp = Driver.users.get(i);

            if(username == temp.userName)
            {
                return temp;

            }
        }
        return null;
    }
}

