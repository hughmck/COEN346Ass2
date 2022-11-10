public class UserProcess extends Thread {
    String userName;
    int readyTime;
    int processingTime;

    private int[] array;
    public UserProcess(int[] array) {
        this.array = array;
    }

    UserProcess(String userName, int readyTime, int processingTime){
        this.userName = userName;
        this.readyTime= readyTime;
        this.processingTime=processingTime;

    }

    public void run(){
        System.out.println("Thread " + this.getId() + " is starting " + arrayToString(array)); //outputing the thread ID and its current segment of the array its assigned to
        int inputLength = array.length;

        UserProcess userProcess = new UserProcess(leftHalf); //need to create an object which user process acts on
        userProcess.start(); //begin execution of left thread
        try
        {
            userProcess.join(); //trying to merge once both threads are done. Can't merge if one thread is still executing
            UserProcess(array, x , y); //Merging the two array segments

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        System.out.println("Thread " + this.getId() + " is finished " + arrayToString(array)); //ouputs that the thread is done and what the worked on segment of the array looks like

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

