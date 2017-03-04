package soccerpool.userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joseph Greaney
 */
public class EditLineupMenu extends JFrame implements ActionListener
{
    final int teamSize = 11;
    JFrame previousScreen;
    JPanel menuPanel;
    String [] team1Players;
    String [] team2Players;
    JComboBox[] team1PlayerSelections;
    JComboBox[] team2PlayerSelections;
    
    JButton finishedButton;
    public EditLineupMenu(JFrame previousScreen)
    {
        this.previousScreen = previousScreen;
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
        
        JLabel team1NameLabel = new JLabel("Team 1");
        cons.gridy = 0;
        cons.gridx = 0;
        menuPanel.add(team1NameLabel, cons);
        
        JLabel team2NameLabel = new JLabel("Team 2");
        cons.gridy = 0;
        cons.gridx = 1;
        menuPanel.add(team2NameLabel, cons);
        
        team1Players = getPlayerNames();
        team2Players = getPlayerNames();
        
        //For each new component set the item's fill to HORIZONTAL
        //Set their gridx and gridy positions in the gridbag
        //and add them to the loginpanel
        team1PlayerSelections = new JComboBox[11];
        team2PlayerSelections = new JComboBox[11];
        for(int i = 0; i < teamSize; i++)
        {
            cons.gridx = 0;
            cons.gridy = i+1;
            team1PlayerSelections[i] = new JComboBox(team1Players);
            menuPanel.add(team1PlayerSelections[i], cons);
            
            cons.gridx = 1;
            cons.gridy = i+1;
            team2PlayerSelections[i] = new JComboBox(team2Players);
            menuPanel.add(team2PlayerSelections[i], cons);
            
        }
        
        finishedButton = new JButton("Finished");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = teamSize+2;
        cons.gridheight = 1;
        cons.gridwidth = 2;
        finishedButton.addActionListener(this);
        menuPanel.add(finishedButton, cons);
        
        this.add(menuPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Soccerpool");
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
    
    public String[] getPlayerNames()
    {
        String[] names = new String[20];
        for (int i = 0 ; i < names.length; i++)
        {
            names[i] = "Player " + (i+1);
        }
        return names;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
         
        if (source == finishedButton)
        {
            //Update lineup for the team
            this.hide();
            previousScreen.show();
        }
    }

}
