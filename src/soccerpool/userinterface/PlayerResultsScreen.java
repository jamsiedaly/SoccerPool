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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import soccerpool.gamesimulation.PlayerResult;
import soccerpool.gamesimulation.GameResult;

/**
 *
 * @author Joe
 */
public class PlayerResultsScreen extends JFrame implements ActionListener
{
    JFrame previousScreen;
    JPanel menuPanel;
    JComboBox playerSelection;
    JButton selectPlayerButton;
    JButton finishedButton;
    JTable resultsTable;
    PlayerResult displayResult;
    PlayerResult[] homeResults;
    PlayerResult[] awayResults;
    
    
    public PlayerResultsScreen(GameResult gameResult, JFrame previousScreen)
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
        
        System.out.println("HomeResults: " + gameResult.getHomePlayerResults().length);
        System.out.println("AwayResults: " + gameResult.getAwayPlayerResults().length);
        int playerNum = gameResult.getHomePlayerResults().length + gameResult.getAwayPlayerResults().length;
        String [] players = new String[playerNum];
        int i = 0;
        homeResults = gameResult.getHomePlayerResults();
        awayResults = gameResult.getAwayPlayerResults();
        while(i < gameResult.getHomePlayerResults().length)
        {
            players[i] = homeResults[i].getPlayer();
            i++;
        }
        int j = 0;
        while (i < playerNum)
        {
            players[i] = awayResults[j].getPlayer();
            j++;
            i++;
        }
        playerSelection = new JComboBox(players);
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 2;
        menuPanel.add(playerSelection, cons);
        
        selectPlayerButton = new JButton("Select Player");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 2;
        cons.gridy = 5;
        cons.gridwidth = 1;
        selectPlayerButton.addActionListener(this);
        menuPanel.add(selectPlayerButton, cons);
        
        this.add(menuPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Soccerpool");
        this.setBounds(0,0,800,800);
        this.setLocationRelativeTo(null);
        this.show();
    }
    
    private void updateResultsTable()
    {
        if (resultsTable == null)
        {
            //Implement results update here
            Object rowData[][] = new Object[11][2];
            rowData[0][0] = "Name";
            rowData[0][1] = "PLAYER_NAME";
            
            rowData[1][0] = "Shots";
            rowData[1][1] = "0";
            
            rowData[2][0] = "Shots on target";
            rowData[2][1] = "0";
            
            rowData[3][0] = "Goals Scored";
            rowData[3][1] = "0";
            
            rowData[4][0] = "Tackles";
            rowData[4][1] = "0";
            
            rowData[5][0] = "Interceptions";
            rowData[5][1] = "0";
            
            rowData[6][0] = "Attempted Passes";
            rowData[6][1] = "0";
            
            rowData[7][0] = "Passes Completed";
            rowData[7][1] = "0";
            
            rowData[8][0] = "Fouls";
            rowData[8][1] = "0";
            
            rowData[9][0] = "Yellow Cards";
            rowData[9][1] = "0";
            
            rowData[10][0] = "Red Cards";
            rowData[10][1] = "0";
            Object columnNames[] = { "Stat", "Value"};

            resultsTable = new JTable(rowData, columnNames);
        }
        else
        {
            resultsTable.getModel().setValueAt(displayResult.getPlayer(), 0, 1);
            resultsTable.getModel().setValueAt(displayResult.getShots(), 1, 1);
            resultsTable.getModel().setValueAt(displayResult.getShotsOnTarget(), 2, 1);
            resultsTable.getModel().setValueAt(displayResult.getGoalsScored(), 3, 1);
            resultsTable.getModel().setValueAt(displayResult.getTacklesMade(), 4, 1);
            resultsTable.getModel().setValueAt(displayResult.getInterceptionsMade(), 5, 1);
            resultsTable.getModel().setValueAt(displayResult.getPassesAttempted(), 6, 1);
            resultsTable.getModel().setValueAt(displayResult.getPassesCompleted(), 7, 1);
            resultsTable.getModel().setValueAt(displayResult.getFouls(), 8, 1);
            resultsTable.getModel().setValueAt(displayResult.getYellowCards(), 9, 1);
            resultsTable.getModel().setValueAt(displayResult.getRedCards(), 10, 1);
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
                
        if (source == selectPlayerButton)
        {
            int index = playerSelection.getSelectedIndex();
            if (index < 10)
            {
                displayResult = homeResults[index];
            }
            else
            {
                index -= 10;
                displayResult = awayResults[index];
            }
            updateResultsTable();
        }
        else if (source == finishedButton)
        {
            this.hide();
            previousScreen.show();
        }
    }
}
