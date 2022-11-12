import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Driver {
    public static int quantum_size;
    public static ArrayList<UserProcess> processes = new ArrayList<UserProcess>();
    public static int numOfInputProcesses;

    public static ArrayList<User> users = new ArrayList<User>(); //List of active users and their active processes

    public static void main(String[] args){
        Scanner reader = null;
        try {
            reader = new Scanner(new File(
                    "input.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        quantum_size = reader.nextInt();

        while(reader.hasNext()){
            String userName = "User " +reader.next();
            numOfInputProcesses = reader.nextInt();

            for(int i=0;i<numOfInputProcesses;i++){
                String processName = "Process " + i;
                int readyTime= reader.nextInt();
                int processingTime = reader.nextInt();
                processes.add(new UserProcess(userName, processName, readyTime, processingTime, "Waiting", false));

            }
        }

        FairShareScheduler arrayOfProcesses = new FairShareScheduler (processes);
        arrayOfProcesses.start();

        for(int i = 0; i < Driver.users.size(); i++) {
            System.out.print(Driver.users.get(i).userName);
        }
    }
}
