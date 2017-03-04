package soccerpool.team;
import java.util.*;
import java.io.*;
import soccerpool.player.*;


/**
 *
 * @author James
 */

public final class Team
{
        private OutfieldPlayer[] lineup;
	private ArrayList<IPlayer> players;
        private String teamName;
        private String leagueName;
        private int lineupCount = 0;
        private GoalKeeper goalKeeper;
	
	public Team(String teamName, String leagueName)
	{
        this.players = new ArrayList<>();
            this.teamName = teamName;
            this.leagueName = leagueName;
            this.lineup = new OutfieldPlayer[10];
            String path = leagueName+"/"+teamName+".txt";
            System.out.println(path);
            int attackerCounter = 0;
            int midfieldCounter = 0;
            int defenderCounter = 0;
            boolean needKeeper = true;
            try{
                    File team = new File(path);
            try (Scanner fileScanner = new Scanner(team, "UTF-8")) {
                while(fileScanner.hasNextLine())
                {
                    String nxtLn = fileScanner.nextLine();
                    if(!"".equals(nxtLn) && nxtLn != null)
                    {
                        IPlayer player = IPlayerFactory.getIPlayer(nxtLn);
                        if(player instanceof OutfieldPlayer)
                        {
                            if(player instanceof IForward && attackerCounter < 3)
                            {
                                System.out.println("Forward Added: " + ((OutfieldPlayer) player).getName());
                                addToSquad(player);
                                attackerCounter++;
                            }
                            else if(player instanceof IMidfield && midfieldCounter < 3)
                            {
                                System.out.println("Midfielder Added: " + ((OutfieldPlayer) player).getName());
                                addToSquad(player);
                                midfieldCounter++;
                            }
                            else if(player instanceof IDefense && defenderCounter < 4)
                            {
                                System.out.println("Defender Added: " + ((OutfieldPlayer) player).getName());
                                addToSquad(player);
                                defenderCounter++;
                            }
                        }
                        else if(needKeeper)
                        {
                            setGoalie((GoalKeeper) player);
                            needKeeper = false;
                        }
                        players.add(player);
                    }
                }
            }
               } catch (FileNotFoundException f)
            {
                    System.out.println("Run Update\t" + f);
            }
	}
        public void addToSquad(IPlayer p)
        {
            this.players.add(p);
            if (lineupCount < 10)
            {
                lineup[lineupCount] = (OutfieldPlayer) p;
                lineupCount++;
            }
        }
        public void setGoalie(GoalKeeper player)
        {
            goalKeeper = player;
        }

        public String getTeamName()
        {
            return teamName;
        }
        
        public String getLeagueName()
        {
            return leagueName;
        }
        
        public ArrayList<IPlayer> getPlayers()
        {
            return players;
        }
        
        public OutfieldPlayer[] getLineup()
        {
            return lineup;
        }
        
        public void setLineup(OutfieldPlayer[] lineup)
        {
            this.lineup = lineup;
        }
        
        public GoalKeeper getGoalie()
        {
            return goalKeeper;
        }
}
