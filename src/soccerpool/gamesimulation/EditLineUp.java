package soccerpool.gamesimulation;

import soccerpool.team.Team;


/**
 * EditLineUp instantiates two team names from strings and then takes two objects of type team from the database that match these strings
 * This class then edits these team objects as per the wishes of the user
 * Game Simulation will then ask for these edited teams if necessary
 * @author Kieran Flynn/Gerry Sheil
 * @version 1.0
 */
public class EditLineUp
{
    private String team1;
    private String team2;
    public Team[] teams = new Team[2];

    /**
     * Constructor for objects of class EditLineUp
     */
    public EditLineUp()
    {
        team1 = this.team1;
        team2 = this.team2;
        
    }

    public Team updateLineup(Team team)
    {
        // TO DO: Edit Team Object
        return team;
    }
    
    public void backToSimulator()
    {
        return;
    }
    
    public Team[] getTeams(String team1, String team2)
    {
        /* I'm assuming here that theres a method in the Team package that will
         * returns a team object if I pass it a string with the team name
         */
        
        return teams;
    }
}
