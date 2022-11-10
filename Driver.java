import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Driver {
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
        int quantum_size = reader.nextInt();

        while(reader.hasNext()){
            String userName = reader.next();
            numOfUsers++;
            int numOfProcesses = reader.nextInt();

            for(int i=0;i<numOfProcesses;i++){
                int readyTime= reader.nextInt();
                int processingTime = reader.nextInt();
                processes.add(new UserProcess(userName,readyTime,processingTime)); //im still a bit confused with the list
            }
        }

    }
}
