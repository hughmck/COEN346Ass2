public class UserProcess extends Thread {
    int processID;

    boolean processStatus; //has the process started yet? true or false
    String userName;
    int readyTime;
    int processingTime;



    private int[] array;
    public UserProcess(int[] array) {
        this.array = array;
    }

    UserProcess(String userName, int readyTime, int processingTime, int processID, boolean processStatus){
        this.userName = userName;
        this.readyTime= readyTime;
        this.processingTime=processingTime;
        this.processID=processID;
        this.processStatus=processStatus;


    }

}

