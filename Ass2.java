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

                System.out.println(line);
                timeQuantum = Integer.parseInt(line);
                // read next line
                line = reader.readLine();
                UserFirst = line;
                line = reader.readLine();
                numberOfProccessesFirstUser = Integer.parseInt(line);


            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
