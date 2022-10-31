public class FairShareScheduler extends Thread {

    public void startCPU (int timeQuantum, String UserID1, int NumberOfProcessesForFirstUser, int processOneArrivalTime, int processOneExecTime,
                          int processTwoArrivalTime, int processTwoExecTime, String UserID2, int numberOfProcessesForSecondUser,
                          int arrivalTimeForUserBProcess, int executionTimeForUserBProcess){

        timeQuantum = 0;
        UserID1 = "";

        clock();

    }

    public void clock(){
        int clock = 0;
        while(true){
            try {
                Thread.sleep(1000);
                clock++;
                System.out.println("second");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
