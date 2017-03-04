package soccerpool.userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import soccerpool.loginmanager.IUser;
import soccerpool.loginmanager.Manager;

/**
 *
 * @author Joseph Greaney
 */
public class MainMenu extends JFrame implements ActionListener
{
    JLabel userInfoLabel;
    JFrame previousScreen;
    JPanel menuPanel;
    JButton simGameButton;
    JButton createLeagueButton;
    JButton viewLeagueButton;
    
    public MainMenu(IUser user, JFrame previousScreen)
    {
        this.previousScreen = previousScreen;
        menuPanel = new JPanel();
        
        //Set loginPanel's layout to a new GridBagLayout
        menuPanel.setLayout(new GridBagLayout());
        
        //Create new gridbag constraints
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        cons.ipady = 10;
        cons.insets = new Insets(5,5,5,5);
        
        //For each new component set the item's fill to HORIZONTAL
        //Set their gridx and gridy positions in the gridbag
        //and add them to the loginpanel
        
        userInfoLabel = new JLabel("Logged in as: " + user.getType() + " " + user.getUsername());
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 2;
        menuPanel.add(userInfoLabel, cons);
        
        simGameButton = new JButton("Simulate Game");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;
        simGameButton.addActionListener(this);
        menuPanel.add(simGameButton, cons);
        
        viewLeagueButton = new JButton("View League");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 2;
        viewLeagueButton.addActionListener(this);
        menuPanel.add(viewLeagueButton, cons);
        
        if(user instanceof Manager)
        {
            createLeagueButton = new JButton("Create League");
            cons.fill = GridBagConstraints.HORIZONTAL;
            cons.gridx = 0;
            cons.gridy = 3;
            cons.gridwidth = 2;
            createLeagueButton.addActionListener(this);
            menuPanel.add(createLeagueButton, cons);
        }
        
        this.add(menuPanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Soccerpool");
        this.pack();
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == simGameButton)
        {
            displaySimulateGameMenu();
        }
        else if(source == viewLeagueButton)
        {
            displayViewLeagueMenu();
        }
        else if(source == createLeagueButton)
        {
            displayCreateLeagueMenu();
        }
    }
    
    public void displaySimulateGameMenu()
    {
        this.hide();
        SimulateGameMenu s = new SimulateGameMenu(this);
        s.show();
    }
    
    public void displayViewLeagueMenu()
    {
        this.hide();
        ViewLeagueMenu m = new ViewLeagueMenu(this);
        m.show();
    }
    
    public void displayCreateLeagueMenu()
    {
        this.hide();
        CreateLeagueMenu m = new CreateLeagueMenu(this);
        m.show();
    }
}
