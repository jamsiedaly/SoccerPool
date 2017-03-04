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
import soccerpool.gamesimulation.GameResult;

import soccerpool.team.Team;
import soccerpool.gamesimulation.GameSimulation;
/**
 *
 * @author Joseph Greaney
 */
public class SimulateGameMenu extends JFrame implements ActionListener
{
    JFrame previousScreen;
    JPanel menuPanel;
    JTextField homeTeamInput;
    JTextField awayTeamInput;
    JComboBox selectHomeLeagueBox;
    JComboBox selectAwayLeagueBox;
    JButton simulateButton;
    JButton editLineupButton;
    JButton cancelButton;
    
    public SimulateGameMenu(JFrame previousScreen)
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
        JLabel team1Label = new JLabel("Home Team");
        //Setting fill to horizontal means the component will scale horizontally
        cons.fill = GridBagConstraints.HORIZONTAL;
        //Set the x position to 0
        cons.gridx = 0;
        //Set the y position to 0
        cons.gridy = 0;
        //add the userLabel to the loginPanel passing in the GridBagConstraints
        //which tell the panel how to lay the component out.
        menuPanel.add(team1Label, cons);
        
        //For the following components cons can be reused as long as it's values
        //are overrided with correct values each time.
        homeTeamInput = new JTextField(32);
        homeTeamInput.setText("milan");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        menuPanel.add(homeTeamInput, cons);
        
        String [] leagues = {"Prem", "SerieA", "Liga", "Bundesliga"};
        selectHomeLeagueBox = new JComboBox(leagues);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;
        menuPanel.add(selectHomeLeagueBox, cons);
        
        JLabel team2Label = new JLabel("Away Team");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        menuPanel.add(team2Label, cons);
        
        awayTeamInput = new JTextField(32);
        awayTeamInput.setText("roma");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 2;
        menuPanel.add(awayTeamInput, cons);
        
        selectAwayLeagueBox = new JComboBox(leagues);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 2;
        menuPanel.add(selectAwayLeagueBox, cons);
        
        simulateButton = new JButton("Simulate");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 2;
        simulateButton.addActionListener(this);
        menuPanel.add(simulateButton, cons);
        
        editLineupButton = new JButton("Edit Lineup");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 2;
        editLineupButton.addActionListener(this);
        menuPanel.add(editLineupButton, cons);
        
        cancelButton = new JButton("Cancel");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 2;
        cancelButton.addActionListener(this);
        menuPanel.add(cancelButton, cons);
        
        this.add(menuPanel);
        this.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Soccerpool");
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
                
        if (source == simulateButton)
        {
            simulateGame();
        }
        else if (source == editLineupButton)
        {
            displayEditLineupMenu();
        }
        else if (source == cancelButton)
        {
            this.hide();
            previousScreen.show();
        }
    }
    
    private void simulateGame()
    {
        Team homeTeam = new Team(homeTeamInput.getText(),"PlayerParser/" + selectHomeLeagueBox.getSelectedItem().toString());
        Team awayTeam = new Team(awayTeamInput.getText(),"PlayerParser/" + selectAwayLeagueBox.getSelectedItem().toString());
        
        GameSimulation gameSim = new GameSimulation(homeTeam, awayTeam);
        GameResult result = gameSim.calculateGameResult();
        result.printGameResultToConsole();
        
        this.hide();
        GameResultsScreen r = new GameResultsScreen(result, this);
    }
    
    private void displayEditLineupMenu()
    {
        this.hide();
        EditLineupMenu m = new EditLineupMenu(this);
    }

}
