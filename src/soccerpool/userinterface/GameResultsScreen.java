package soccerpool.userinterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import soccerpool.gamesimulation.GameResult;

/**
 *
 * @author Joseph Greaney
 */
public class GameResultsScreen extends JFrame implements ActionListener
{
    JFrame previousScreen;
    JPanel menuPanel;
    JLabel team1Score;
    JLabel team2Score;
    JButton viewPlayerResultsButton;
    JButton finishedButton;
    JTable resultsTable;
    GameResult result;
    
    public GameResultsScreen(GameResult result, JFrame previousScreen)
    {
        this.result = result;
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
        
        updateResultsTable();
        JScrollPane pane = new JScrollPane(resultsTable);
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 3;
        cons.gridheight = 3;
        menuPanel.add(pane, cons);
        
        finishedButton = new JButton("Finished");
        finishedButton.setBounds(20, 20, 20, 20);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridheight = 1;
        finishedButton.addActionListener(this);
        menuPanel.add(finishedButton, cons);
        
        viewPlayerResultsButton = new JButton("View Player Results");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        viewPlayerResultsButton.addActionListener(this);
        menuPanel.add(viewPlayerResultsButton, cons);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(menuPanel);
        this.pack();
        this.setTitle("Soccerpool");
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
    
    public void updateResultsTable()
    {
        //Implement results update here
        Object rowData[][] = new Object[10][3];
        rowData[0][0] = "Team Name";
        rowData[0][1] = result.getHomeTeam().getTeamName();
        rowData[0][2] = result.getAwayTeam().getTeamName();
        
        rowData[1][0] = "Score";
        rowData[1][1] = result.getHomeScore();
        rowData[1][2] = result.getAwayScore();
        
        rowData[2][0] = "Posession";
        rowData[2][1] = result.getHomePosession();
        rowData[2][2] = result.getAwayPosession();
        
        rowData[3][0] = "Shots";
        rowData[3][1] = result.getHomeShots();
        rowData[3][2] = result.getAwayShots();
        
        rowData[4][0] = "Shots on target";
        rowData[4][1] = result.getHomeShotsOnTarget();
        rowData[4][2] = result.getAwayShotsOnTarget();
        
        rowData[5][0] = "Tackles";
        rowData[5][1] = result.getHomeTackles();
        rowData[5][2] = result.getAwayTackles();
        
        rowData[6][0] = "Fouls";
        rowData[6][1] = result.getHomeFouls();
        rowData[6][2] = result.getAwayFouls();
        
        rowData[7][0] = "Passes Completed";
        rowData[7][1] = result.getHomePasses();
        rowData[7][2] = result.getAwayPasses();
        //Cards need to be added to results
        rowData[8][0] = "Yellow Cards";
        rowData[8][1] = result.getHomeYellowCards();
        rowData[8][2] = result.getAwayYellowCards();
        
        rowData[9][0] = "Red Cards";
        rowData[9][1] = result.getHomeRedCards();
        rowData[9][2] = result.getAwayRedCards();
        
        Object columnNames[] = { "Result", "Home", "Away"};
        resultsTable = new JTable(rowData, columnNames);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
                
        if (source == viewPlayerResultsButton)
        {
            displayPlayerResultsScreen();
        }
        else if (source == finishedButton)
        {
            this.hide();
            previousScreen.show();
        }
    }
    
    private void displayPlayerResultsScreen()
    {
        this.hide();
        PlayerResultsScreen s = new PlayerResultsScreen(result, this);
    }
}
