package soccerpool.userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Observer;

import soccerpool.leaguesimulation.LeagueSimulation;

/**
 *
 * @author Joseph Greaney
 */
public class LeagueResultsScreen extends JFrame implements ActionListener, Observer
{
    String leagueName;
    JTable leagueTable;
    JComboBox teamSelectionBox;
    JButton viewTeamResultsButton;
    JButton simulateWeekButton;
    JButton simulateLeagueButton;
    JButton finishedButton;
    JFrame previousScreen;
    JPanel menuPanel;
    LeagueSimulation league;
    
    public LeagueResultsScreen(String leagueName, JFrame previousScreen)
    {
        this.leagueName = leagueName;
        this.previousScreen = previousScreen;
        setupScreen(); 
        league.addObserver(this);
    }
    public LeagueResultsScreen(LeagueSimulation league, JFrame previousScreen)
    {
        this.leagueName = league.getLeagueName();
        this.previousScreen = previousScreen;
        this.league = league;
        setupScreen(); 
        league.addObserver(this);
    }
    
    private void setupScreen()
    {
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
        
        leagueTable = new JTable();
        initialiseLeagueTable();
        JScrollPane pane = new JScrollPane(leagueTable);
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 4;
        cons.gridheight = 4;
        menuPanel.add(pane, cons);
        
        finishedButton = new JButton("Finished");
        finishedButton.setBounds(20, 20, 20, 20);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridheight = 1;
        cons.gridwidth = 4;
        finishedButton.addActionListener(this);
        menuPanel.add(finishedButton, cons);
        
        String [] teams = league.getTeamNamesAsStrings();
        teamSelectionBox = new JComboBox(teams);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridheight = 1;
        cons.gridwidth = 2;
        teamSelectionBox.addActionListener(this);
        menuPanel.add(teamSelectionBox, cons);
        
        viewTeamResultsButton = new JButton("View Team Results");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 2;
        cons.gridy = 5;
        cons.gridheight = 1;
        viewTeamResultsButton.addActionListener(this);
        menuPanel.add(viewTeamResultsButton, cons);
        
        simulateWeekButton = new JButton("Simulate Week");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridheight = 1;
        simulateWeekButton.addActionListener(this);
        menuPanel.add(simulateWeekButton, cons);
        
        simulateLeagueButton = new JButton("Simulate League");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 2;
        cons.gridy = 6;
        cons.gridheight = 1;
        simulateLeagueButton.addActionListener(this);
        menuPanel.add(simulateLeagueButton, cons);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(menuPanel);
        this.pack();
        this.setTitle("Soccerpool");
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == viewTeamResultsButton)
        {
            displayTeamResultsScreen();
        }
        else if(source == simulateWeekButton)
        {
            league.simulateResults(league.getCurrentWeek() + 1);
        }
        else if(source == simulateLeagueButton)
        {
            league.simulateResults();
        }
        else if(source == finishedButton)
        {
            this.hide();
            previousScreen.show();
        }
    }
    
    private void displayTeamResultsScreen()
    {
        //display team results not implemented in this version
    }
    
    public void initialiseLeagueTable()
    {
        Object rowData[][] = new Object[league.getTeams().size()][9];
        for(int i = 0; i < league.getTeams().size(); i++)
        {
            rowData[i][0] = league.getTeams().get(i).getTeamName();
            rowData[i][1] = "0";
            rowData[i][2] = "0";
            rowData[i][3] = "0";
            rowData[i][4] = "0";
            rowData[i][5] = "0";
            rowData[i][6] = "0";
            rowData[i][7] = "0";
            rowData[i][8] = "0";
        }
        Object columnNames[] = { "Team", "GP", "W", "D", "L", "GF", "GA", "GD", "PTS"};
        leagueTable = new JTable(rowData, columnNames);
        
        //Table sorting Code adapted from:
        //http://stackoverflow.com/questions/9090974/problems-with-jtable-sorting-of-integer-values
        leagueTable.setModel(new DefaultTableModel(rowData, 
                new String[]{ "Team", "GP", "W", "D", "L", "GF", "GA", "GD", "PTS"})
        {
            Class[] types = {String.class, Integer.class, Integer.class, Integer.class,
                Integer.class,Integer.class,Integer.class,Integer.class,Integer.class};
            
            @Override
            public Class getColumnClass(int columnIndex)
            {
                return this.types[columnIndex];
            }
        });
        leagueTable.setAutoCreateRowSorter(true);
    }
    
    private void updateLeagueTable()
    {
        for (int i = 0; i < league.getTeams().size(); i++)
        {
            leagueTable.getModel().setValueAt(league.getTeams().get(i).getTeamName(), i, 0);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getGamesPlayed(), i, 1);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getWins(), i, 2);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getDraws(), i, 3);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getLosses(), i, 4);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getGoalsFor(), i, 5);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getGoalsAgainst(), i, 6);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getGoalDifference(), i, 7);
            leagueTable.getModel().setValueAt(league.calculateTeamResult(league.getTeams().get(i)).getPoints(), i, 8);
        }
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        System.out.println("Updated observer");
        updateLeagueTable();
    }
}
