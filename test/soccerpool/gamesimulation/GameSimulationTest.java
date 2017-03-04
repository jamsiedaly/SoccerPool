/*
 @Author:Kieran Flynn
 */
package soccerpool.gamesimulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import soccerpool.player.GoalKeeper;
import soccerpool.player.Player;
import soccerpool.player.OutfieldPlayer;

/**
 *
 * @author Kieran
 */
public class GameSimulationTest {
    
    public GameSimulationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calculateTeamPosession method, of class GameSimulation.
     */
    @Test
    public void testCalculateTeamPosession() {
        System.out.println("calculateTeamPosession");
        int homeTeamOverallRating = 75;
        int awayTeamOverallRating = 75;
        GameSimulation instance = new GameSimulation("milan", "roma");
        int[] boundary = new int[2];
        boundary[0] = 47;
        boundary[1] = 53;
        int[] result = instance.calculateTeamPosession(homeTeamOverallRating, awayTeamOverallRating);
        //Home Posession is within the range 47 - 53
        assertTrue(result[0] >= boundary[0]);
        assertTrue(result[0] <= boundary[1]);
        //Away Posession is within the range 47 - 53
        assertTrue(result[1] >= boundary[0]);
        assertTrue(result[1] <= boundary[1]);
        
        homeTeamOverallRating = 95;     
        result = instance.calculateTeamPosession(homeTeamOverallRating, awayTeamOverallRating);
        boundary[0] = 67;
        boundary[1] = 73;
        //Home Posession is within the range 67 - 73
        assertTrue(result[0] >= boundary[0]);
        assertTrue(result[0] <= boundary[1]);
        boundary[0] = 27;
        boundary[1] = 33;
        //Away Posession is within the range 27 - 33
        assertTrue(result[1] >= boundary[0]);
        assertTrue(result[1] <= boundary[1]);
        
        homeTeamOverallRating = 75;
        awayTeamOverallRating = 95;
        result = instance.calculateTeamPosession(homeTeamOverallRating, awayTeamOverallRating);
        boundary[0] = 27;
        boundary[1] = 33;
        //Home Posession is within the range 27 - 33
        assertTrue(result[0] >= boundary[0]);
        assertTrue(result[0] <= boundary[1]);
        boundary[0] = 67;
        boundary[1] = 73;
        //Away Posession is within the range 67 - 23
        assertTrue(result[1] >= boundary[0]);
        assertTrue(result[1] <= boundary[1]);
        
    }

    /**
     * Test of calculateTeamShots method, of class GameSimulation.
     * */
    @Test
    public void testCalculateTeamShots() {
        System.out.println("calculateTeamShots");
        GameSimulation instance = new GameSimulation("milan", "roma");
        PlayerResult[] ourResults = new PlayerResult[10];
        OutfieldPlayer[] ourPlayers = new OutfieldPlayer[10];
        ourPlayers = instance.getHomePlayers();
        GoalKeeper keeper = instance.getAwayKeeper();
        
        for(int i = 0; i < 10; i++)
        {
            ourResults[i] = instance.calculatePlayerResult(ourPlayers[i], 75, keeper.getOverallRating());
        }
        
        int result = instance.calculateTeamShots(ourResults);
        assertTrue(result >= 0);      
        assertTrue(result < 100);
    }
    
    
    /**
     * Test of calculateTeamShotsOnTarget method, of class GameSimulation.
     */
    @Test
    public void testCalculateTeamShotsOnTarget() {
        System.out.println("calculateTeamShotsOnTarget");
        GameSimulation instance = new GameSimulation("milan", "roma");
        PlayerResult[] ourResults = new PlayerResult[10];
        OutfieldPlayer[] ourPlayers = new OutfieldPlayer[10];
        ourPlayers = instance.getHomePlayers();
        GoalKeeper keeper = instance.getAwayKeeper();
        
        for(int i = 0; i < 10; i++)
        {
            ourResults[i] = instance.calculatePlayerResult(ourPlayers[i], 75, keeper.getOverallRating());
        }
        int shots = instance.calculateTeamShots(ourResults);
        int shotsOnTarget = instance.calculateTeamShotsOnTarget(ourResults);
        assertTrue(shotsOnTarget >= 0);        
        assertTrue(shotsOnTarget < 100);
        assertTrue(shotsOnTarget <= shots);
    }

    /**
     * Test of calculateTeamTackles method, of class GameSimulation.
     */
    @Test
    public void testCalculateTeamTackles() {
        System.out.println("calculateTeamTackles");
        GameSimulation instance = new GameSimulation("milan", "roma");
        PlayerResult[] ourResults = new PlayerResult[10];
        OutfieldPlayer[] ourPlayers = new OutfieldPlayer[10];
        ourPlayers = instance.getHomePlayers();
        GoalKeeper keeper = instance.getAwayKeeper();
        
        for(int i = 0; i < 10; i++)
        {
            ourResults[i] = instance.calculatePlayerResult(ourPlayers[i], 75, keeper.getOverallRating());
        }
        
        
        int result = instance.calculateTeamTackles(ourResults);
        assertTrue(result >= 0);      
        assertTrue(result < 100);
    }

    /**
     * Test of calculateTeamFouls method, of class GameSimulation.
     */
    @Test
    public void testCalculateTeamFouls() {
        System.out.println("calculateTeamFouls");
        GameSimulation instance = new GameSimulation("milan", "roma");
        PlayerResult[] ourResults = new PlayerResult[10];
        OutfieldPlayer[] ourPlayers = new OutfieldPlayer[10];
        ourPlayers = instance.getHomePlayers();
        GoalKeeper keeper = instance.getAwayKeeper();
        
        for(int i = 0; i < 10; i++)
        {
            ourResults[i] = instance.calculatePlayerResult(ourPlayers[i], 75, keeper.getOverallRating());
        }
        int tackles = instance.calculateTeamTackles(ourResults);
        int fouls = instance.calculateTeamFouls(ourResults);
        assertTrue(fouls >= 0);        
        assertTrue(fouls < 100);
        assertTrue(fouls <= tackles);
    }
    
}
