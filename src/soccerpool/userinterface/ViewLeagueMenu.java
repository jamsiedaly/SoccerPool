/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerpool.userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Joe
 */
public class ViewLeagueMenu extends JFrame implements ActionListener
{
    JComboBox selectLeagueBox;
    JButton viewButton;
    JButton cancelButton;
    JFrame previousScreen;
    JPanel menuPanel;
    
    public ViewLeagueMenu(JFrame previousScreen)
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
        
        String [] leagues = {"League1", "League2", "League3"};
        selectLeagueBox = new JComboBox(leagues);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        menuPanel.add(selectLeagueBox, cons);
        
        viewButton = new JButton("View League");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        viewButton.addActionListener(this);
        menuPanel.add(viewButton, cons);
        
        cancelButton = new JButton("Cancel");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        viewButton.addActionListener(this);
        menuPanel.add(viewButton, cons);
        
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
        if (source == viewButton)
        {
            displayLeagueResultsScreen();
        }
    }
    
    private void displayLeagueResultsScreen()
    {
        this.hide();
        LeagueResultsScreen s = new LeagueResultsScreen("League Name", this);
        s.show();
    }
}
