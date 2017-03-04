package soccerpool.loginmanager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Joseph Greaney
 */
public class LoginManager 
{
    ArrayList<IUser> registeredUsers;
    
    public LoginManager(String userFilePath)
    {
        registeredUsers = new ArrayList<>();
        File file = new File(userFilePath);
        try
        {
            Scanner in = new Scanner(file);
            while(in.hasNextLine())
            {
                String[] line = in.nextLine().split(",");
                if(line.length == 3)
                {
                    if("Spectator".equals(line[2]))
                    {
                        registeredUsers.add(new Spectator(line[0],line[1]));
                        System.out.println("User added: " + line[0]);
                    }
                    else if ("Manager".equals(line[2]))
                    {
                        registeredUsers.add(new Manager(line[0],line[1]));
                        System.out.println("User added: " + line[0]);
                    }
                }
            }
            in.close();
            System.out.println("Finished reading " + userFilePath);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File: " + userFilePath + " not found for login manager.");
        }
    }
    
    public IUser authenticateUser(String username, String password)
    {
        for(IUser user : registeredUsers)
        {
            if(user.getUsername().matches(username) && user.getPassword().matches(password))
            {
                return user;
            }
        }
        return null;
    }
}
