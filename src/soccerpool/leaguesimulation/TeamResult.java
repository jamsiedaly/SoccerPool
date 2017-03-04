/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerpool.leaguesimulation;

/**
 *
 * @author Joe
 */
public class TeamResult 
{
    private String teamName;
    private int gamesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;
    
    public TeamResult(String teamName, int gamesPlayed, int wins, int draws, int losses,
            int goalsFor, int goalsAgainst, int goalDifference, int points)
    {
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @return the gamesPlayed
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * @return the wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * @return the draws
     */
    public int getDraws() {
        return draws;
    }

    /**
     * @return the losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * @return the goalsFor
     */
    public int getGoalsFor() {
        return goalsFor;
    }

    /**
     * @return the goalsAgainst
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * @return the goalDifference
     */
    public int getGoalDifference() {
        return goalDifference;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }
    
    
}
