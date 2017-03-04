package soccerpool.userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import soccerpool.loginmanager.IUser;
import soccerpool.loginmanager.LoginManager;

/**
 *
 * @author Joseph Greaney
 */
public class LoginMenu extends JFrame implements ActionListener
{
    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private LoginManager loginManager;
    private JLabel errorLabel;
    
    public LoginMenu()
    {
        loginManager = new LoginManager("LoginFiles/Users.csv");
        setupLoginMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == loginButton)
        {
            tryLogin();
        }
    }
    
    public void tryLogin()
    {
        //Get the text from the input fields and send to server
        String username = usernameField.getText();
        String password = passwordField.getText();
        String usernamePattern = "[A-Za-z]+";
        
        IUser user = loginManager.authenticateUser(username, password);
        if (user != null)
        {
            errorLabel.setText("");
            displayMainMenu(user);
        }
        else
        {
            errorLabel.setText("Invalid username and password combination.");
        }
    }
    
    public void displayMainMenu(IUser loggedUser)
    {
        //Hide this menu
        this.hide();
        //Make a new main menu
        MainMenu m = new MainMenu(loggedUser, this);
        m.show();
    }
    
    public void setupLoginMenu()
    {
        loginPanel = new JPanel();
        
        //Set loginPanel's layout to a new GridBagLayout
        loginPanel.setLayout(new GridBagLayout());
        
        //Create new gridbag constraints
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        //Set the padding for the gridbagconstraints
        cons.ipadx = 10;
        cons.ipady = 10;
        cons.insets = new Insets(5,5,5,5);
        
        //For each new component set the item's fill to HORIZONTAL
        //Set their gridx and gridy positions in the gridbag
        //and add them to the loginpanel
        JLabel userLabel = new JLabel("Username");
        //Setting fill to horizontal means the component will scale horizontally
        cons.fill = GridBagConstraints.HORIZONTAL;
        //Set the x position to 0
        cons.gridx = 0;
        //Set the y position to 0
        cons.gridy = 0;
        
        
        //add the userLabel to the loginPanel passing in the GridBagConstraints
        //which tell the panel how to lay the component out.
        loginPanel.add(userLabel, cons);
        
        //For the following components cons can be reused as long as it's values
        //are overrided with correct values each time.
        usernameField = new JTextField(20);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        loginPanel.add(usernameField, cons);
        
        JLabel passLabel = new JLabel("Password");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        loginPanel.add(passLabel, cons);
        
        passwordField = new JPasswordField(20);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 1;
        loginPanel.add(passwordField, cons);
        
        errorLabel = new JLabel("");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 2;
        loginPanel.add(errorLabel, cons);
        
        loginButton = new JButton("Login");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 2;
        loginButton.addActionListener(this);
        loginPanel.add(loginButton, cons);
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(loginPanel);
        this.pack();
        this.setTitle("Soccerpool");
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
}
