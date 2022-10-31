import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ass2 {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "input.txt"));
            String line = reader.readLine();
            while (line != null) {
                int timeQuantum = 0;
                String UserFirst = "";
                int numberOfProccessesFirstUser  =0;
                int processOneArrivalTime = 0;
                int processOneExecutionTime =0;
                int processTwoArrivalTime = 0;
                int processTwoExecutionTime =0;

                String UserSecond = "";
                int numberOfProcessesSecondUser = 0;
                int arrivalTimeUserBProcess = 0;
                int executionTimeUserBProcess = 0;

                timeQuantum = Integer.parseInt(line);
                // read next line
                line = reader.readLine();
                UserFirst = line;
                line = reader.readLine();
                numberOfProccessesFirstUser = Integer.parseInt(line);
                line = reader.readLine();
                processOneArrivalTime = Integer.parseInt(line);
                line = reader.readLine();
                processOneExecutionTime = Integer.parseInt(line);
                line = reader.readLine();
                processTwoArrivalTime = Integer.parseInt(line);
                line = reader.readLine();
                processTwoExecutionTime = Integer.parseInt(line);
                line = reader.readLine();
                UserSecond = line;
                line = reader.readLine();
                numberOfProcessesSecondUser = Integer.parseInt(line);
                line = reader.readLine();
                arrivalTimeUserBProcess = Integer.parseInt(line);
                line = reader.readLine();
                executionTimeUserBProcess = Integer.parseInt(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FairShareScheduler fairShareScheduler = new FairShareScheduler();

        fairShareScheduler.clock();




    }
}
