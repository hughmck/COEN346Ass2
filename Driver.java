import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Driver {
    public static int quantum_size;
    public static ArrayList<UserProcess> processes = new ArrayList<UserProcess>();
    public static void main(String[] args){
        Scanner reader = null;
        int numOfUsers = 0;


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
            numOfUsers++;
            int numOfProcesses = reader.nextInt();

            for(int i=0;i<numOfProcesses;i++){
                String processName = "Process " + i;
                int readyTime= reader.nextInt();
                int processingTime = reader.nextInt();
                processes.add(new UserProcess(userName, processName, readyTime, processingTime, "Waiting"));

            }
        }
        for(int j=0;j<processes.size();j++)
        {
            UserProcess nextProcess  = processes.get(j);
            if(nextProcess.getReadyTime() <= FairShareScheduler.clock)
            {
                FairShareScheduler nextSchedule = new FairShareScheduler(nextProcess);
                nextSchedule.start();
            }
            else
            {
                processes.add(nextProcess);
            }
        }
    }
}
