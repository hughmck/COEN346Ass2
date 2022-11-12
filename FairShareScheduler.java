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
        while (q.size() != 0 || clock == 1)
            for(int j=0; j<scheduleProcesses.size();j++)
            {
            UserProcess nextProcess  = scheduleProcesses.get(j);

            if(nextProcess.getReadyTime() == clock) //checks if the program is ready. of the arrival time is bigger than the current time it will send to else
                {
                    q.add(nextProcess);
                    UserProcess nextSchedule = new UserProcess(q.peek());
                    nextSchedule.start();
                    User temp = getUser(nextProcess.processName);
                    if(temp == null)
                    {
                        Driver.users.add(new User(nextProcess.getUserName(), 1));
                        System.out.println("Added a User");
                    }
                    else
                    {
                        temp.addActiveProcesses();
                        System.out.println("Added a process");
                    }
                }
            }
    }

    public User getUser(String username)
    {
        for (int i = 0; i < Driver.users.size(); i++)
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
