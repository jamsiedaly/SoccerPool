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
import javax.swing.JTextField;

import soccerpool.leaguesimulation.LeagueSimulation;

/**
 *
 * @author Joseph Greaney
 */
public class CreateLeagueMenu extends JFrame implements ActionListener
{
    private JTextField leagueNameInput;
    private JComboBox selectLeagueBox;
    private JButton generateButton;
    private JFrame previousScreen;
    private JPanel menuPanel;
    
    public CreateLeagueMenu(JFrame previousScreen)
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
        JLabel leagueNameInputLabel = new JLabel("League Nickname: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        menuPanel.add(leagueNameInputLabel, cons);
        
        leagueNameInput = new JTextField(32);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        menuPanel.add(leagueNameInput, cons);
        
        String [] leagues = {"Prem", "SerieA", "Liga", "Bundesliga"};
        selectLeagueBox = new JComboBox(leagues);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;
        menuPanel.add(selectLeagueBox, cons);
        
        generateButton = new JButton("Generate League");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 2;
        generateButton.addActionListener(this);
        menuPanel.add(generateButton, cons);
        
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
        if (source == generateButton)
        {
            generateLeague();
        }
    }
    
    private void generateLeague()
    {
        LeagueSimulation s = new LeagueSimulation(selectLeagueBox.getSelectedItem().toString(), leagueNameInput.getText());
        this.hide();
        LeagueResultsScreen l = new LeagueResultsScreen(s, this);
        l.show();
    }
}
