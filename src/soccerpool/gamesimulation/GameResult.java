package soccerpool.gamesimulation;
import soccerpool.team.Team;

/**
 * Game Result is an entity that represents the result of a game
 * 
 * @author Kieran Flynn/Gerry Sheil 
 * @version 1.0
 */
public class GameResult
{
    private String gameID;
    protected int homeScore; 
    protected int awayScore; 
    private int homePosession; 
    private int awayPosession;
    protected int homeShots; 
    protected int awayShots;
    private int homeShotsOnTarget; 
    private int awayShotsOnTarget;
    private int homePasses; 
    private int awayPasses;
    private int homeTackles; 
    private int awayTackles;
    private int homeFouls;
    private int awayFouls;
    private int homeYellowCards;
    private int awayYellowCards;
    private int homeRedCards;
    private int awayRedCards;
    private Team homeTeam;
    private Team awayTeam;
    
    private PlayerResult [] homePlayerResults;
    private PlayerResult[] awayPlayerResults;
    private String[] gameResultsAsString = new String[15];

    /**
     * Constructor for objects of class GameResult
     */
    public GameResult(int homeScore, int awayScore, int homePosession, int awayPosession, 
    int homeShots, int awayShots, int homeTackles, int awayTackles, int homeShotsOnTarget,
    int awayShotsOnTarget, int homePasses, int awayPasses, int homeFouls,
    int awayFouls, Team homeTeam, Team awayTeam,
    PlayerResult[] homePlayerResults, PlayerResult[] awayPlayerResults)
    {
        gameID = "0";
        this.homeScore = homeScore; 
        this.awayScore = awayScore; 
        this.homePosession = homePosession; 
        this.awayPosession = awayPosession;
        this.homeShots = homeShots; 
        this.awayShots = awayShots;
        this.homeShotsOnTarget = homeShotsOnTarget; 
        this.awayShotsOnTarget = awayShotsOnTarget;
        this.homePasses = homePasses; 
        this.awayPasses = awayPasses;
        this.homeTackles = homeTackles; 
        this.awayTackles = awayTackles;
        this.homeFouls = homeFouls;
        this.awayFouls = awayFouls;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homePlayerResults = homePlayerResults;
        this.awayPlayerResults = awayPlayerResults;
        
        gameResultsAsString[0] = gameID;
        gameResultsAsString[1] = String.valueOf(homeScore);
        gameResultsAsString[2] = String.valueOf(awayScore);
        gameResultsAsString[3] = String.valueOf(homePosession);
        gameResultsAsString[4] = String.valueOf(awayPosession);
        gameResultsAsString[5] = String.valueOf(homeShots);
        gameResultsAsString[6] = String.valueOf(awayShots);
        gameResultsAsString[7] = String.valueOf(homeShotsOnTarget);        
        gameResultsAsString[8] = String.valueOf(awayShotsOnTarget);
        gameResultsAsString[9] = String.valueOf(homePasses);
        gameResultsAsString[10] = String.valueOf(awayPasses);
        gameResultsAsString[11] = String.valueOf(homeTackles);
        gameResultsAsString[12] = String.valueOf(awayTackles);
        gameResultsAsString[13] = homeTeam.getTeamName();
        gameResultsAsString[14] = awayTeam.getTeamName();        
    }
    
    public GameResult(GameResult g){
        this.homeScore = g.getHomeScore(); 
        this.awayScore = g.getAwayScore(); 
        this.homePosession = g.getHomePosession(); 
        this.awayPosession = g.getAwayPosession();
        this.homeShots = g.getHomeShots(); 
        this.awayShots = g.getAwayShots();
        this.homeShotsOnTarget = g.getHomeShotsOnTarget(); 
        this.awayShotsOnTarget = g.getAwayShotsOnTarget();
        this.homePasses = g.getHomePasses(); 
        this.awayPasses = g.getAwayPasses();
        this.homeTackles = g.getHomeTackles(); 
        this.awayTackles = g.getAwayTackles();
        this.homeFouls = g.getHomeFouls();
        this.awayFouls = g.getAwayFouls();
        this.homeTeam = g.getHomeTeam();
        this.awayTeam = g.getAwayTeam();
        this.homePlayerResults = g.getHomePlayerResults();
        this.awayPlayerResults = g.getAwayPlayerResults();
    }

    public void printGameResultToConsole()
    {
        System.out.println("The results for this game are:");
        System.out.println("Home Score:" + this.homeScore);
        System.out.println("Away Score" + this.awayScore);
        System.out.println("Home Posession:" + this.homePosession);
        System.out.println("Away Posession:" + this.awayPosession);
        System.out.println("Home Shots:" + this.homeShots);
        System.out.println("Away Shots:" + this.awayShots);
        System.out.println("Home Shots on Target:" + this.homeShotsOnTarget);
        System.out.println("Away Shots on Target:" + this.awayShotsOnTarget);
        System.out.println("Home Passes:" + this.homePasses);
        System.out.println("Away Passes:" + this.awayPasses);
        System.out.println("Home Tackles:" + this.homeTackles);
        System.out.println("Away Tackles:" + this.awayTackles);
    }
    /**
     * @return the GameID
     */
    public String getGameID() {
        return gameID;
    }
    /**
     * @return the homeScore
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * @return the awayScore
     */
    public int getAwayScore() {
        return awayScore;
    }

    /**
     * @return the homePosession
     */
    public int getHomePosession() {
        return homePosession;
    }

    /**
     * @return the awayPosession
     */
    public int getAwayPosession() {
        return awayPosession;
    }

    /**
     * @return the homeShots
     */
    public int getHomeShots() {
        return homeShots;
    }

    /**
     * @return the awayShots
     */
    public int getAwayShots() {
        return awayShots;
    }

    /**
     * @return the homeShotsOnTarget
     */
    public int getHomeShotsOnTarget() {
        return homeShotsOnTarget;
    }

    /**
     * @return the awayShotsOnTarget
     */
    public int getAwayShotsOnTarget() {
        return awayShotsOnTarget;
    }

    /**
     * @return the homePasses
     */
    public int getHomePasses() {
        return homePasses;
    }

    /**
     * @return the awayPasses
     */
    public int getAwayPasses() {
        return awayPasses;
    }

    /**
     * @return the homeTackles
     */
    public int getHomeTackles() {
        return homeTackles;
    }

    /**
     * @return the awayTackles
     */
    public int getAwayTackles() {
        return awayTackles;
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
     * @return the gameResultsAsString
     */
    public String[] getGameResultsAsString() {
        return gameResultsAsString;
    }

    /**
     * @return the homePlayerResults
     */
    public PlayerResult[] getHomePlayerResults() {
        return homePlayerResults;
    }

    /**
     * @return the awayPlayerResults
     */
    public PlayerResult[] getAwayPlayerResults() {
        return awayPlayerResults;
    }

    /**
     * @param awayPlayerResults the awayPlayerResults to set
     */
    public void setAwayPlayerResults(PlayerResult[] awayPlayerResults) {
        this.awayPlayerResults = awayPlayerResults;
    }

    /**
     * @return the homeYellowCards
     */
    public int getHomeYellowCards() {
        return homeYellowCards;
    }

    /**
     * @return the awayYellowCards
     */
    public int getAwayYellowCards() {
        return awayYellowCards;
    }

    /**
     * @return the homeRedCards
     */
    public int getHomeRedCards() {
        return homeRedCards;
    }

    /**
     * @return the awayRedCards
     */
    public int getAwayRedCards() {
        return awayRedCards;
    }

    /**
     * @return the homeFouls
     */
    public int getHomeFouls() {
        return homeFouls;
    }

    /**
     * @return the awayFouls
     */
    public int getAwayFouls() {
        return awayFouls;
    }

    /**
     * @param gameResultsAsString the gameResultsAsString to set
     */
    public void setGameResultsAsString(String[] gameResultsAsString) {
        this.gameResultsAsString = gameResultsAsString;
    }

    /**
     * @param homeShots the homeShots to set
     */
    public void setHomeShots(int homeShots) {
        this.homeShots = homeShots;
    }

    /**
     * @param awayShots the awayShots to set
     */
    public void setAwayShots(int awayShots) {
        this.awayShots = awayShots;
    }
}
