/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerpool.leaguesimulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import soccerpool.gamesimulation.GameResult;
import soccerpool.team.Team;
import java.util.Observable;
import java.util.Random;
import soccerpool.gamesimulation.GameSimulation;
/**
 *
 * @author Gerry Sheil/Kieran Flynn
 */
public class LeagueSimulation extends Observable
{
    
    private ArrayList<Fixture> fixtures = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<GameResult> results = new ArrayList<>();
    private String leagueType;
    private String leagueName;
    private int currentWeek;
    private String[] gameResultsAsString = new String[15];
    private String[] leagueDetailsAsString = new String[15];
    
    public LeagueSimulation(String leagueType, String leagueNickname)
    {     
        currentWeek = 0;
        //int fixturesPerWeek = leagueTeams.size()/2;
        this.leagueType = leagueType;
        this.leagueName = leagueNickname; 
        generateTeams();
        generateFixtures();
    }
    
    //Fixtures are generated here with an associated week number starting from 0
    //I have to start from 0 to make the math work
    public void generateFixtures()
    {
        int fixturesPerWeek = teams.size()/2;
        int weekNumber = 1;
        
        for(int i = 0; i < getTeams().size(); i++){
            for(int k = 0; k < getTeams().size(); k++){
                //If all the weeks fixtures have been generated (ie fixturesPerWeek reached 0)
                //Move on to the next week and reset fixturesPerWeek
                if(fixturesPerWeek == 0){
                    weekNumber++;
                    fixturesPerWeek = teams.size()/2;
                }
                //If statement prevents a team from playing itself
                //The way the two for loops work is that a team is picked and then a fixture is generated with everybody else
                //This means the fixtures have the same team in every fixture for "leagueTeams.size" number of matches
                if(getTeams().get(i) == getTeams().get(k)){}
                else{       
                    fixtures.add(new Fixture(getTeams().get(i), getTeams().get(k), weekNumber));
                    fixturesPerWeek--;
                }     
                long seed = System.nanoTime();
                Collections.shuffle(fixtures, new Random(seed));
            }
        }
        
        fixturesPerWeek = teams.size()/2;
        weekNumber = 1;
        
        for(int i = 0; i<fixtures.size(); i++){
            fixtures.get(i).setWeekNumber(weekNumber);
            fixturesPerWeek--;
            if(fixturesPerWeek == 0){
                weekNumber++;
                fixturesPerWeek = teams.size()/2;
            }
        }
    } 
    
    //Blunt force adds the teams 
    public void generateTeams()
    {
        if(leagueType == "Prem"){
              getTeams().add(new Team("arsenal","PlayerParser/Prem"));
              getTeams().add(new Team("bournemouth","PlayerParser/Prem"));
              getTeams().add(new Team("burnley","PlayerParser/Prem"));
              getTeams().add(new Team("chelsea","PlayerParser/Prem"));
              getTeams().add(new Team("crystal-palace","PlayerParser/Prem"));    
              getTeams().add(new Team("everton","PlayerParser/Prem"));   
              getTeams().add(new Team("hull-city","PlayerParser/Prem"));   
              getTeams().add(new Team("leicester-city","PlayerParser/Prem"));   
              getTeams().add(new Team("liverpool","PlayerParser/Prem"));   
              getTeams().add(new Team("manchester-city","PlayerParser/Prem")); 
              getTeams().add(new Team("manchester-united","PlayerParser/Prem"));   
              getTeams().add(new Team("middlesbrough","PlayerParser/Prem"));   
              getTeams().add(new Team("southampton","PlayerParser/Prem"));   
              getTeams().add(new Team("stoke-city","PlayerParser/Prem"));   
              getTeams().add(new Team("sunderland","PlayerParser/Prem"));   
              getTeams().add(new Team("swansea-city","PlayerParser/Prem"));
              getTeams().add(new Team("tottenham-hotspur","PlayerParser/Prem"));   
              getTeams().add(new Team("watford","PlayerParser/Prem"));   
              getTeams().add(new Team("west-bromwich-albion","PlayerParser/Prem"));   
              getTeams().add(new Team("west-ham-united","PlayerParser/Prem"));
        }
        else if(leagueType == "SerieA")
        {
                getTeams().add(new Team("atalanta", "PlayerParser/SerieA"));
                getTeams().add(new Team("bologna","PlayerParser/SerieA"));
                getTeams().add(new Team("cagliari","PlayerParser/SerieA"));
                getTeams().add(new Team("chievo-verona","PlayerParser/SerieA"));
                getTeams().add(new Team("crotone","PlayerParser/SerieA"));
                getTeams().add(new Team("empoli","PlayerParser/SerieA"));    
                getTeams().add(new Team("fiorentina","PlayerParser/SerieA"));   
                getTeams().add(new Team("genoa","PlayerParser/SerieA"));   
                getTeams().add(new Team("inter","PlayerParser/SerieA"));   
                getTeams().add(new Team("juventus","PlayerParser/SerieA"));   
                getTeams().add(new Team("lazio","PlayerParser/SerieA")); 
                getTeams().add(new Team("milan","PlayerParser/SerieA"));   
                getTeams().add(new Team("napoli","PlayerParser/SerieA"));   
                getTeams().add(new Team("palermo","PlayerParser/SerieA"));   
                getTeams().add(new Team("pescara","PlayerParser/SerieA"));   
                getTeams().add(new Team("roma","PlayerParser/SerieA"));   
                getTeams().add(new Team("sampdoria","PlayerParser/SerieA"));
                getTeams().add(new Team("sassuolo","PlayerParser/SerieA"));   
                getTeams().add(new Team("torino","PlayerParser/SerieA"));   
                getTeams().add(new Team("udinese","PlayerParser/SerieA"));   
        }
        else if(leagueType == "Liga")
        {
            getTeams().add(new Team("athletic-club-de-bilbao", "PlayerParser/Liga"));
            getTeams().add(new Team("atletico-madrid", "PlayerParser/Liga"));
            getTeams().add(new Team("ca-osasuna", "PlayerParser/Liga"));
            getTeams().add(new Team("cd-leganes", "PlayerParser/Liga"));
            getTeams().add(new Team("deportivo-alaves", "PlayerParser/Liga"));
            getTeams().add(new Team("fc-barcelona", "PlayerParser/Liga"));
            getTeams().add(new Team("granada-cf", "PlayerParser/Liga"));
            getTeams().add(new Team("malaga-cf", "PlayerParser/Liga"));
            getTeams().add(new Team("rc-celta-de-vigo", "PlayerParser/Liga"));
            getTeams().add(new Team("rc-deportivo-de-la-coruna", "PlayerParser/Liga"));
            getTeams().add(new Team("rcd-espanyol", "PlayerParser/Liga"));
            getTeams().add(new Team("real-betis-balompie", "PlayerParser/Liga"));
            getTeams().add(new Team("real-madrid-cf", "PlayerParser/Liga"));
            getTeams().add(new Team("real-sociedad", "PlayerParser/Liga"));
            getTeams().add(new Team("real-sporting-de-gijon", "PlayerParser/Liga"));
            getTeams().add(new Team("sd-eibar", "PlayerParser/Liga"));
            getTeams().add(new Team("sevilla-fc", "PlayerParser/Liga"));
            getTeams().add(new Team("ud-las-palmas", "PlayerParser/Liga"));
            getTeams().add(new Team("valencia-cf", "PlayerParser/Liga"));
            getTeams().add(new Team("villarreal-cf", "PlayerParser/Liga"));
        }
        else if(leagueType == "Bundesliga")
        {
           getTeams().add(new Team("1-fc-koln", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("1-fsv-mainz-05", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("bayer-04-leverkusen", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("borussia-dortmund", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("borussia-monchengladbach", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("eintracht-frankfurt", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("fc-augsburg", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("fc-bayern-munchen", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("fc-ingolstadt-04", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("fc-schalke-04", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("hamburger-sv", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("hertha-berlin", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("rb-leipzig", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("sport-club-freiburg", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("sv-darmstadt-98", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("sv-werder-bremen", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("tsg-1899-hoffenheim", "PlayerParser/Bundesliga"));
           getTeams().add(new Team("vfl-wolfsburg", "PlayerParser/Bundesliga"));
        }           
    }
    
    public void generateResult(Fixture f)
    {
        f.setGame(new GameSimulation(f.getHomeTeam(), f.getAwayTeam()));
        GameSimulation game = f.getGame();
        f.setResult(game.calculateGameResult());
        f.setResultString(f.getResult()); 
        f.setFinished(true);
    }
    
    /**
     * Simulate all results until a given week
     * @param week 
     */
    public void simulateResults(int week){
        ArrayList<GameResult> results = new ArrayList<GameResult>();
        //At the moment the way this works is that a fixture gets a result if matches that week
        //You might need to change either this or generateFixtures depending on the problems
        for(int i = 0; i < fixtures.size(); i++){
            Fixture fixture = fixtures.get(i);
            if(fixture.getWeekNumber() == week){
                generateResult(fixture);
                results.add(fixture.getResult());
            }
        }
        currentWeek = week;
        setChanged();
        notifyObservers();
    }
    
    /**
     * simulate all results
     */
    public void simulateResults(){
        ArrayList<GameResult> results = new ArrayList<GameResult>();
        /*
        int fixturesPerWeek = leagueTeams.size()/2;
        int startPosition = week*fixturesPerWeek;
        int endPosition = startPosition+fixturesPerWeek;
          */      
        //At the moment the way this works is that a fixture gets a result if matches that week
        //You might need to change either this or generateFixtures depending on the problems
        for(int i = 0; i < fixtures.size(); i++){
            Fixture fixture = fixtures.get(i);
            generateResult(fixture);
            results.add(fixture.getResult());
        }
        System.out.println("Notifying observers");
        setChanged();
        notifyObservers();
    }
        
    public void setLeague(String leagueType)
    {
        this.leagueType  = leagueType;
    }

    /**
     * @return the leagueFixtures
     */
    public ArrayList<Fixture> getFixtures() {
        return fixtures;
    }

    /**
     * @return the leagueTeams
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * @return the leagueName
     */
    public String getLeagueName() {
        return leagueName;
    }
    
    public String [] getTeamNamesAsStrings()
    {
        String [] teamNames = new String [teams.size()];
        for(int i = 0; i < teams.size(); i++)
        {
            teamNames[i] = teams.get(i).getTeamName();
        }
        return teamNames;
    }
    
    /**
     * Joe
     * @param team
     * @return 
     */
    public TeamResult calculateTeamResult(Team team)
    {
        String teamName = team.getTeamName();
        int gamesPlayed = 0;
        int wins = 0;
        int draws = 0;
        int losses = 0;
        int goalsFor = 0;
        int goalsAgainst = 0;
        int goalDifference = 0;
        int points = 0;
        
        //Loop for home games
        for(int i = 0; i < fixtures.size(); i++)
        {
            Fixture f = fixtures.get(i);
            //Check if the fixture is finished
            if (f.isFinished())
            {
                //Check if the current team is the home team
                if (f.getHomeTeam().getTeamName().equals(teamName))
                {
                    GameResult r = f.getResult();
                    goalsFor += r.getHomeScore();
                    goalsAgainst += r.getAwayScore();
                    gamesPlayed++;
                    if(r.getHomeScore() > r.getAwayScore())
                    {
                        wins++;
                    }
                    else if(r.getHomeScore() < r.getAwayScore())
                    {
                        losses++;
                    }
                    else
                    {
                        draws++;
                    }
                }
                //Check if the current team is the away team
                else if(f.getAwayTeam().getTeamName().equals(teamName))
                {
                    GameResult r = f.getResult();
                    goalsFor += r.getAwayScore();
                    goalsAgainst += r.getHomeScore();
                    gamesPlayed++;
                    if(r.getHomeScore() > r.getAwayScore())
                    {
                        losses++;
                    }
                    else if(r.getHomeScore() < r.getAwayScore())
                    {
                        wins++;
                    }
                    else
                    {
                        draws++;
                    }
                }
            }
        }
        goalDifference = goalsFor - goalsAgainst;
        points = (wins * 3) + draws;
        
        return new TeamResult(teamName, gamesPlayed, wins, draws, losses, goalsFor,
            goalsAgainst, goalDifference, points);
        
    }

    /**
     * @return the currentWeek
     */
    public int getCurrentWeek() {
        return currentWeek;
    }
    
    
    public void writeResultToFile(GameResult result) throws IOException
    {
        BufferedWriter writer;
        gameResultsAsString = result.getGameResultsAsString();
        try
        {
            File file = new File("" + gameResultsAsString[13] + "vs" + gameResultsAsString[14] + "Game_Result.txt");
            file.createNewFile();
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("Game ID: " + result.getGameID());
            writer.newLine();
            writer.write(gameResultsAsString[13] + " Goals Scored: " + gameResultsAsString[1]);
            writer.newLine();
            writer.write(gameResultsAsString[14] + " Goals Scored: " + gameResultsAsString[2]);
            writer.newLine();
            writer.write(gameResultsAsString[13] + " Posession: " + gameResultsAsString[3]);
            writer.newLine();
            writer.write(gameResultsAsString[14] + " Posession: " + gameResultsAsString[4]);
            writer.newLine();
            writer.write(gameResultsAsString[13] + " Shots: " + gameResultsAsString[5]);
            writer.newLine();
            writer.write(gameResultsAsString[14] + " Shots: " + gameResultsAsString[6]);
            writer.newLine();
            writer.write(gameResultsAsString[13] + " Shots on Target: " + gameResultsAsString[7]);
            writer.newLine();
            writer.write(gameResultsAsString[14] + " Shots on Target: " + gameResultsAsString[8]);
            writer.newLine();
            writer.write(gameResultsAsString[13] + " Passes: " + gameResultsAsString[9]);
            writer.newLine();
            writer.write(gameResultsAsString[14] + " Passes: " + gameResultsAsString[10]);
            writer.newLine();
            writer.write(gameResultsAsString[13] + " : " + gameResultsAsString[11]);
            writer.newLine();
            writer.write(gameResultsAsString[14] + " : " + gameResultsAsString[12]);
         
            writer.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();  
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void readLeagueInformationFromFile(String fileLocation) throws IOException
    {
        FileReader in = new FileReader(fileLocation);
        BufferedReader br = new BufferedReader(in);
        
        String line;
        int i = 0;
        while((line = br.readLine()) != null){
            leagueDetailsAsString[i] = line;
            i++;
        }
    }
}
