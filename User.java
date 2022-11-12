public class User {
    String userName;
    int activeProcesses;

    int getActiveProcesses(String userName)
    {
        return activeProcesses;
    }

    void removeActiveProcesses(String userName)
    {
        activeProcesses -= activeProcesses;
    }

    void addActiveProcesses(String userName)
    {
        activeProcesses += activeProcesses;
    }

    User(String userName, int activeProcesses)
    {
        this.userName = userName;
        this.activeProcesses = activeProcesses;
    }
}
