import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Driver {
    public static int quantum_size;
    public static void main(String[] args){
        Scanner reader = null;
        int numOfUsers = 0;
        ArrayList<UserProcess> processes = new ArrayList<UserProcess>();

        try {
            reader = new Scanner(new File(
                    "input.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        quantum_size = reader.nextInt();
        System.out.println(quantum_size);

        while(reader.hasNext()){
            String userName = "User " +reader.next();
            numOfUsers++;
            int numOfProcesses = reader.nextInt();

            for(int i=0;i<numOfProcesses;i++){
                String processName = "Process " + i;
                int readyTime= reader.nextInt();
                int processingTime = reader.nextInt();
                processes.add(new UserProcess(userName, processName, readyTime, processingTime, "Waiting"));//im still a bit confused with the list

            }
        }
        for(int j=0;j<processes.size();j++)
        {
            UserProcess nextProcess  = processes.get(j);
            FairShareScheduler nextSchedule = new FairShareScheduler(nextProcess);
            nextSchedule.start();
        }
    }
}
