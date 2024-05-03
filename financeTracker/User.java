public class User {

    private int userID;
    private String name;

    public User(int userID, String name)
    {
        this.userID = userID;
        this.name = name;
    }

    public int getUserID()
    {
        return this.userID;
    }

    public String getName()
    {
        return this.name;
    }
}