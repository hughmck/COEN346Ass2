import java.util.*;

public class FairShareScheduler extends Thread {

    public static ArrayList<UserProcess> scheduleProcesses = new ArrayList<UserProcess>();
    public FairShareScheduler(ArrayList<UserProcess> scheduleProcesses)
    {
        this.scheduleProcesses = scheduleProcesses;
    }

    public static Queue<UserProcess> q = new LinkedList<>();
    public static int clock = 1;

    public void run() {
        while (q.size() !=0 || clock == 1) // checks if the queue is empty or if the clock is at time 1
            for(int j=0; j<scheduleProcesses.size();j++)
            {
            UserProcess nextProcess  = scheduleProcesses.get(j);
            Thread.yield();
            if(nextProcess.getReadyTime() == clock) //checks if the program is ready. of the arrival time is bigger than the current time it will send to else
                {
                    q.add(nextProcess); //adds the process to the back of the queue
                    UserProcess nextSchedule = new UserProcess(q.peek()); //adds the first element of the queue
                    nextSchedule.start();
                    User temp = getUser(nextProcess.processName); //checks if the user exists in the arrayList already
                    if(temp == null) // if not add the User
                    {
                        Driver.users.add(new User(nextProcess.getUserName(), 1));
                        System.out.println("Added a User");
                    }
                    else // if the user does, just increment their number of active processes
                    {
                        temp.addActiveProcesses();
                        System.out.println("Added a process");
                    }
                }
            }
    }

    public User getUser(String username)
    {
        for (int i = 0; i < Driver.users.size(); i++) //scans users to see if the user already exists by userName
        {
            User temp = Driver.users.get(i);

            if(username == temp.userName)
            {
                return temp;
            }
        }
        return null;
    }
}
