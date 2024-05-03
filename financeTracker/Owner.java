public class Owner extends User 
{
    private String username;
    private String password;

    public Owner(int userID, String name, String username, String password)
    {
        super(userID, name);
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }
}