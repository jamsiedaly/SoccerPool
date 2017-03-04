package soccerpool.gamesimulation;
import soccerpool.player.OutfieldPlayer;


/**
 * PlayerResult is an entity that represents the individual statistics of a player after a game
 * 
 * 
 * @author Kieran Flynn
 * @version 1.0
 */
public class PlayerResult
{
    private String player;
    private int shots;
    private int shotsOnTarget;
    private int goalsScored;
    private int fouls;
    private int yellowCards;
    private int redCards;
    private int interceptionsMade;
    private int tacklesMade;
    private int passesAttempted;
    private int passesCompleted;
    
    private String[] playerResultsAsString = new String[13];
    /**
     * Constructor for objects of class PlayerResult
     */
    public PlayerResult(OutfieldPlayer ourPlayer, int shots, int shotsOnTarget, int goalsScored, int fouls, int yellowCards, int redCards, 
     int interceptionsMade, int tacklesMade, int passesAttempted, int passesCompleted)
    {
        player = ourPlayer.getName();
        this.shots = shots;
        this.shotsOnTarget = shotsOnTarget;
        this.goalsScored = goalsScored;
        this.fouls = fouls; 
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.interceptionsMade = interceptionsMade;
        this.tacklesMade = tacklesMade;
        this.passesAttempted = passesAttempted;
        this.passesCompleted = passesCompleted;
        
        playerResultsAsString[0] = player;
        playerResultsAsString[1] = String.valueOf(player);
        playerResultsAsString[2] = String.valueOf(shots);
        playerResultsAsString[3] = String.valueOf(shotsOnTarget);
        playerResultsAsString[4] = String.valueOf(goalsScored);
        playerResultsAsString[5] = String.valueOf(fouls); 
        playerResultsAsString[6] = String.valueOf(yellowCards);
        playerResultsAsString[7] = String.valueOf(redCards);
        playerResultsAsString[8] = String.valueOf(interceptionsMade);
        playerResultsAsString[9] = String.valueOf(tacklesMade);
        playerResultsAsString[11] = String.valueOf(passesAttempted);
        playerResultsAsString[12] = String.valueOf(passesCompleted);
    }
    
    public void printPlayerResultToConsole(PlayerResult OurPlayer)
    {
        System.out.println("The results for " + OurPlayer.player + " are:");
        System.out.println("Shots:" + OurPlayer.shots);
        System.out.println("Shots on Target:" + OurPlayer.shotsOnTarget);
        System.out.println("Goals Scored:" + OurPlayer.goalsScored);
        System.out.println("Fouls:" + OurPlayer.fouls);
        System.out.println("Yellow Cards" + OurPlayer.yellowCards);            
        System.out.println("Red Cards:" + OurPlayer.redCards);
        System.out.println("Interceptions Made:" + OurPlayer.interceptionsMade);       
        System.out.println("Tackles Made:" + OurPlayer.tacklesMade);     
        System.out.println("Passes Attempted:" + OurPlayer.passesAttempted);
        System.out.println("Passes Completed:" + OurPlayer.passesCompleted);
        return;
    }
    
    public void storePlayerResult(PlayerResult OurPlayer)
    {
        this.player = OurPlayer.player;
        this.shots = OurPlayer.shots;
        this.shotsOnTarget = OurPlayer.shotsOnTarget;
        this.goalsScored = OurPlayer.goalsScored;
        this.fouls = OurPlayer.fouls; 
        this.yellowCards = OurPlayer.yellowCards;
        this.redCards = OurPlayer.redCards;
        this.interceptionsMade = OurPlayer.interceptionsMade;
        this.tacklesMade = OurPlayer.tacklesMade;
        this.passesAttempted = OurPlayer.passesAttempted;
        this.passesCompleted = OurPlayer.passesCompleted;  
    }

    /**
     * @return the player
     */
    public String getPlayer() {
        return player;
    }

    /**
     * @return the shots
     */
    public int getShots() {
        return shots;
    }

    /**
     * @return the shotsOnTarget
     */
    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    /**
     * @return the goalsScored
     */
    public int getGoalsScored() {
        return goalsScored;
    }

    /**
     * @return the fouls
     */
    public int getFouls() {
        return fouls;
    }

    /**
     * @return the yellowCards
     */
    public int getYellowCards() {
        return yellowCards;
    }

    /**
     * @return the redCards
     */
    public int getRedCards() {
        return redCards;
    }

    /**
     * @return the interceptionsMade
     */
    public int getInterceptionsMade() {
        return interceptionsMade;
    }

    /**
     * @return the tacklesMade
     */
    public int getTacklesMade() {
        return tacklesMade;
    }

    /**
     * @return the passesAttempted
     */
    public int getPassesAttempted() {
        return passesAttempted;
    }

    /**
     * @return the passesCompleted
     */
    public int getPassesCompleted() {
        return passesCompleted;
    }

    /**
     * @return the playerResultsAsString
     */
    public String[] getPlayerResultsAsString() {
        return playerResultsAsString;
    }
}
