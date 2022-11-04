public class FairShareScheduler extends Thread {

    public void startCPU (int timeQuantum, String UserID1, int NumberOfProcessesForFirstUser, int processOneArrivalTime, int processOneExecTime,
                          int processTwoArrivalTime, int processTwoExecTime, String UserID2, int numberOfProcessesForSecondUser,
                          int arrivalTimeForUserBProcess, int executionTimeForUserBProcess){ //creating the fair share process in this function by taking in all these parameters

        timeQuantum = 0;
        UserID1 = "";

        clock();

    }

    public void firstUserProcesses(int timeQuantum, int NumberOfProcessesForFirstUser, int processOneArrivalTime, int processOneExecTime,
                                   int processTwoArrivalTime, int processTwoExecTime){

        int processNumber = NumberOfProcessesForFirstUser;

        int timeQuantumInitialization = timeQuantum;

        int timeProcess1 = processOneExecTime;

        int arrivalProcessOne = processOneArrivalTime;

        int arrivalProcessTwo = processTwoArrivalTime;

        int execProcessOne = processOneExecTime;

        int execProcessTwo = processTwoExecTime;

        while(true){
            int fairShare = processNumber/timeQuantumInitialization;

            for(fairShare)


        }


    }
    public void clock(){ //creating a clock function which counts the seconds
        int clock = 0;
        while(true){
            try {
                Thread.sleep(1000); //1000 milliseconds per second, therefore it iterates every second
                clock++;
                System.out.println("second");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
