public class User {
    String userName;
    int activeProcesses;

    int getActiveProcesses(String userName)
    {
        return activeProcesses;
    }

    void removeActiveProcesses()
    {
        activeProcesses -= activeProcesses;
    }

    void addActiveProcesses()
    {
        activeProcesses += activeProcesses;
    }

    User(String userName, int activeProcesses)
    {
        this.userName = userName;
        this.activeProcesses = activeProcesses;
    }
}
