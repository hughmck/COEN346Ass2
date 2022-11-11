import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Driver {
    public static int quantum_size;
    public static int numOfUsers = 0;
    public static ArrayList<UserProcess> processes = new ArrayList<UserProcess>();
    public static int numOfProcesses;
    static Map<String,Integer> variables = new HashMap<String,Integer>();
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
            numOfUsers++;
            numOfProcesses = reader.nextInt();

            variables.put(userName, numOfProcesses);

            for(int i=0;i<numOfProcesses;i++){
                String processName = "Process " + i;
                int readyTime= reader.nextInt();
                int processingTime = reader.nextInt();
                processes.add(new UserProcess(userName, processName, readyTime, processingTime, "Waiting"));

            }
        }

//        for (Map.Entry<String, Integer> entry : variables.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//        }

        for(int j=0;j<processes.size();j++)
        {
            UserProcess nextProcess  = processes.get(j);
            if(nextProcess.getReadyTime() <= FairShareScheduler.clock) //checks if the program is ready. of the arrival time is bigger than the current time it will send to else
            {
                FairShareScheduler nextSchedule = new FairShareScheduler(nextProcess);
                nextSchedule.start();
            }
            else
            {
                processes.add(nextProcess); // adds the not ready program back into the loop
            }
        }
    }
}
