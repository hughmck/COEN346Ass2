import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ass2 {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader( //taking the input file line by line
                    "input.txt"));
            String line = reader.readLine();
            while (line != null) {
                int timeQuantum = 0;
                String UserFirst = "";
                int numberOfProccessesFirstUser  =0; //initializing all the variables which correspond to each line from the input file
                int processOneArrivalTime = 0;
                int processOneExecutionTime =0;
                int processTwoArrivalTime = 0;
                int processTwoExecutionTime =0;

                String UserSecond = "";
                int numberOfProcessesSecondUser = 0;
                int arrivalTimeUserBProcess = 0;
                int executionTimeUserBProcess = 0;

                timeQuantum = Integer.parseInt(line); //first line in the input file is the time quantum
                // read next line
                line = reader.readLine(); //second line in the input file is the username of the first user
                UserFirst = line;
                line = reader.readLine();
                numberOfProccessesFirstUser = Integer.parseInt(line); //third line is the number of processes the first user has created
                line = reader.readLine();
                processOneArrivalTime = Integer.parseInt(line); //the arrival time of the first process user 1 has created
                line = reader.readLine();
                processOneExecutionTime = Integer.parseInt(line); //the next line is the execution time of this process
                line = reader.readLine();
                processTwoArrivalTime = Integer.parseInt(line); //same idea as before, this line is the arrival time of the second process created by the user
                line = reader.readLine();
                processTwoExecutionTime = Integer.parseInt(line); //execution time of second process
                line = reader.readLine();
                UserSecond = line; //username of second user
                line = reader.readLine();
                numberOfProcessesSecondUser = Integer.parseInt(line); //number of processes the second user creates
                line = reader.readLine();
                arrivalTimeUserBProcess = Integer.parseInt(line); //arrival time of the process user B has created
                line = reader.readLine();
                executionTimeUserBProcess = Integer.parseInt(line); //execution time of this process
            } //ALL the variables have been stored in these names, will need to manipulate these to undergo the fair share process
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FairShareScheduler fairShareScheduler = new FairShareScheduler(); //calilng the fair share scheduler

        fairShareScheduler.clock(); //calling the clock function in the main code, i dont think well need to call the clock, rather we will
        // need to call the clock in the StartCPU function, then call it here rather than calling the clock




    }
}
