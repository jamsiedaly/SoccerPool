package soccerpool.loginmanager;

/**
 *
 * @author Joseph Greaney
 */
public class Manager implements IUser
{
    String username;
    String password;
    
    public Manager(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String getPassword()
    {
        return password;
    }
    
    @Override
    public String getUsername()
    {
        return username;
    }
    
    @Override
    public String getType()
    {
        return "Manager";
    }
}
