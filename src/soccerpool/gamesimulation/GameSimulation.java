package soccerpool.gamesimulation;
import java.util.Random; //Need math.random
import soccerpool.player.GoalKeeper;
import soccerpool.team.Team;
import soccerpool.player.IPlayer;
import soccerpool.player.OutfieldPlayer;

/**
 * Game Simulation is where the "business logic" of simulating a game of football takes place
 * It takes two team objects and compares their statistics by compiling a list of player results for each team and then summing these results to make a team result
 * 
 * @author Kieran Flynn/Gerry Sheil 
 * @version 1.0
 */
public class GameSimulation
{    
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamOverallRating;
    private int awayTeamOverallRating; 
    private OutfieldPlayer[] homePlayers = new OutfieldPlayer[10];
    private OutfieldPlayer[] awayPlayers = new OutfieldPlayer[10];    
    private PlayerResult[] homePlayerResults = new PlayerResult[10];
    private PlayerResult[] awayPlayerResults = new PlayerResult[10];
    private GoalKeeper homeKeeper;
    private GoalKeeper awayKeeper;
    private int GoalKeeperRating;
    private int numberOfOutfieldPlayers;
        
    /**
     * Constructor for objects of class GameSimulation
     */
    public GameSimulation(Team homeTeam, Team awayTeam)
    {
        // initialise instance variables
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeTeamOverallRating = 0;
        awayTeamOverallRating = 0;
        homePlayers = homeTeam.getLineup();
        awayPlayers = awayTeam.getLineup();
        this.homeKeeper = homeTeam.getGoalie();
        this.awayKeeper = awayTeam.getGoalie();
        this.numberOfOutfieldPlayers = homePlayers.length;
    }
    
    public GameSimulation(String homeTeamString, String awayTeamString)
    {
        // initialise instance variables
        Team homeTeamHere = new Team(homeTeamString,"PlayerParser/SerieA");
        Team awayTeamHere = new Team(awayTeamString,"PlayerParser/SerieA");
        this.homeTeam = homeTeamHere;
        this.awayTeam = awayTeamHere;
        homeTeamOverallRating = 0;
        awayTeamOverallRating = 0;
        homePlayers = homeTeam.getLineup();
        awayPlayers = awayTeam.getLineup();
        this.homeKeeper = homeTeam.getGoalie();
        this.awayKeeper = awayTeam.getGoalie();
    }
    
    public int calculateOverallTeamRating(IPlayer[] Players)
    {
        int rating = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            rating += Players[i].getOverallRating(); //I'm assuming the player class has a method called getRating that returns their rating as an int            
        }
        
        rating = rating/numberOfOutfieldPlayers;
        return rating;      
    }
    
    public GameResult calculateGameResult()
    {
        System.out.println("HomeTeam: " + homeTeam.getTeamName());
        homeTeamOverallRating = calculateOverallTeamRating(homePlayers);
        System.out.println("Away Team: " + awayTeam.getTeamName());
        awayTeamOverallRating = calculateOverallTeamRating(awayPlayers);
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            homePlayerResults[i] = calculatePlayerResult(getHomePlayers()[i], homeTeamOverallRating, getAwayKeeper().getOverallRating());
            awayPlayerResults[i] = calculatePlayerResult(awayPlayers[i], awayTeamOverallRating, homeKeeper.getOverallRating());
        }
        
        int homeScore = calculateTeamScore(homePlayerResults); 
        int awayScore = calculateTeamScore(awayPlayerResults); 
        int[] posessionInfo = calculateTeamPosession(homeTeamOverallRating, awayTeamOverallRating);
        int homePosession = posessionInfo[0];
        int awayPosession = posessionInfo[1];
        int homeShots = calculateTeamShots(homePlayerResults); 
        int awayShots = calculateTeamShots(awayPlayerResults);
        int homeShotsOnTarget = calculateTeamShotsOnTarget(homePlayerResults); 
        int awayShotsOnTarget = calculateTeamShotsOnTarget(awayPlayerResults);
        int homePasses = calculateTeamPasses(homePlayerResults); 
        int awayPasses = calculateTeamPasses(awayPlayerResults); 
        int homeTackles = calculateTeamTackles(homePlayerResults);  
        int awayTackles = calculateTeamTackles(awayPlayerResults); 
        int homeFouls = calculateTeamFouls(homePlayerResults);
        int awayFouls = calculateTeamFouls(awayPlayerResults);
        
        GameResult thisGamesResult = new goalsLessThanShots(new GameResult(homeScore, awayScore, homePosession, awayPosession, 
        homeShots, awayShots, homeTackles, awayTackles, homeShotsOnTarget, awayShotsOnTarget,
        homePasses, awayPasses, homeFouls, awayFouls, homeTeam, awayTeam, homePlayerResults, awayPlayerResults)); 
        
        thisGamesResult.getHomeShots();
        thisGamesResult.getAwayShots();
        
        return thisGamesResult;
    }
    
    public PlayerResult calculatePlayerResult(OutfieldPlayer ourPlayer, int teamRating, int enemyGoalieRating)
    {
        double weight = 0.001;
        int upper1 = 3;
        int lower1 = 1;
        double upper2 = 1.0;
        double lower2 = 0.0;
        int offset1;
        int passOffset = 4;
        int interceptions = randomInteger(0, 15);
        double offset2;
        double foulsPerYellow = 0.095;
        double foulsPerRed = 0.05;
        int shots;            
        int shotsOnTarget;
        int goalsScored;
        int fouls;
        int yellowCards;
        int redCards;
        int interceptionsMade;
        int tacklesMade;
        int passesAttempted;
        int passesCompleted;
        double enemyGoalieRatio = enemyGoalieRating/100;
        
        
        offset1 = randomInteger(lower1, upper1);
        offset2 = (Math.random()*(upper2 - lower2)) + lower2;
        shots = Math.max((int)(ourPlayer.getShoot() * teamRating * weight)/2,0);
        shotsOnTarget = Math.max(shots - (int)(offset1/1.05),0);
        goalsScored = Math.max((int) ((shotsOnTarget * offset2)*(1 - enemyGoalieRatio)),0);
        tacklesMade = (int) (((ourPlayer.getDefence() * teamRating * weight) + (ourPlayer.getPhysical() * teamRating * weight))/3);
        fouls = (int) (tacklesMade -(tacklesMade*(ourPlayer.getDefence() * 0.01)));
        yellowCards = (int) (fouls * foulsPerYellow);
        redCards = (int) (fouls * foulsPerRed);
        interceptionsMade = interceptions;
        //savesMade stays 0 for now, will calculate it in version 2 when we accomodate goalkeepers
        passesAttempted = (int) (ourPlayer.getPass() * teamRating * weight) * passOffset;
        passesCompleted = (int) (passesAttempted*(ourPlayer.getPass()*0.01));
        
        PlayerResult OurPlayerResult = new PlayerResult(ourPlayer, shots, shotsOnTarget, goalsScored, fouls, yellowCards,
         redCards, interceptionsMade, tacklesMade, passesAttempted, passesCompleted); 
        return OurPlayerResult;
    }
    
    public int calculateTeamScore(PlayerResult[] ourResults)
    {
        int score = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            int upperBound = 100;
            int lowerBound = 0;
            if(randomInteger(lowerBound, upperBound) > GoalKeeperRating)
            {
                score += ourResults[i].getGoalsScored();
            }
        }
        
        return score;
    }
    
    public int [] calculateTeamPosession(int homeTeamOverallRating, int awayTeamOverallRating)
    {
        int homePosession;
        int awayPosession;
        int[] posessionInfo = new int[2];
        int difference = homeTeamOverallRating - awayTeamOverallRating;
        homePosession = 50 + difference + randomInteger(-3,3);
        awayPosession = 100 - homePosession;
        
        posessionInfo[0] = homePosession;
        posessionInfo[1] = awayPosession;
        return posessionInfo;
    }
    
    public int calculateTeamShots(PlayerResult[] ourResults)
    {
        int shots = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            shots += ourResults[i].getShots();
        }
        
        return shots;
    }
    
    public int calculateTeamShotsOnTarget(PlayerResult[] ourResults)
    {
        int shotsOnTarget = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            shotsOnTarget += ourResults[i].getShotsOnTarget();
        }
        
        return shotsOnTarget;
    }
    
    public int calculateTeamPasses(PlayerResult[] ourResults)
    {
        int passes = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
           passes += ourResults[i].getPassesAttempted();
        }
        
        return passes;
    }
    
    public int calculateTeamTackles(PlayerResult[] ourResults)
    {
        int tackles = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            tackles += ourResults[i].getTacklesMade();
        }
        
        return tackles;
    }
    
    public int calculateTeamFouls(PlayerResult[] ourResults)
    {
        int fouls = 0;
        
        for(int i = 0; i < numberOfOutfieldPlayers; i++)
        {
            fouls += ourResults[i].getFouls();
        }
        
        return fouls;
    }
    
    public int randomInteger(int min, int max) 
    {

        Random rand = new Random();

        // nextInt excludes the top value so we have to add 1 to include the top value
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * @return the homePlayers
     */
    public OutfieldPlayer[] getHomePlayers() {
        return homePlayers;
    }

    /**
     * @return the awayKeeper
     */
    public GoalKeeper getAwayKeeper() {
        return awayKeeper;
    }
}
