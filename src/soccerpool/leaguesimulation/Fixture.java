package soccerpool.leaguesimulation;

import java.io.BufferedWriter;
import soccerpool.gamesimulation.GameResult;
import soccerpool.gamesimulation.GameSimulation;
import soccerpool.team.Team;

/**
 *
 * @author Gerry Sheil/Kieran Flynn
 */
public class Fixture {
    private int weekNumber;
    private Team homeTeam;
    private Team awayTeam;
    private GameSimulation game;
    private GameResult result;
    private boolean finished;
    private String[] gameResultsAsString = new String[15];
    BufferedWriter writer;

public Fixture(Team homeTeam, Team awayTeam, int weekNumber)
{
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.weekNumber = weekNumber;
    finished = false;
}

public void setResult(GameResult result)
{
    this.result = result;
}

public void setResultString(GameResult result)
{
    gameResultsAsString = result.getGameResultsAsString();
}

    /**
     * @return the weekNumber
     */
    public int getWeekNumber() {
        return weekNumber;
    }

    /**
     * @param weekNumber the weekNumber to set
     */
    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * @return the result
     */
    public GameResult getResult() {
        return result;
    }

    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * @return the game
     */
    public GameSimulation getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(GameSimulation game) {
        this.game = game;
    }
}