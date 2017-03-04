package soccerpool.player;

/**
 *
 * @author James
 * www.tutorialspoint.com/design_pattern/factory_pattern
 * This page provided me with the basic structures of the factory design pattern  
 */
public class IPlayerFactory
{   
    /**
    *This factory method allows another programmer
    *to create a specific player object without knowing
    *what type of player they're creating
     * @param info is a string containing all relevant player information
     * @return an IPlayer object 
    */
    public static IPlayer getIPlayer(String info)
    { 
        String[] stats = new String[9];
        stats = info.split(",");
        IPlayer player = null;
        if(null!=stats[1])
        switch (stats[1]) {
            case "ST":
            case "CF":
            case "RW":
            case "LW":
                player = new Attacker(info);
                break;
            case "CM":
            case "LM":
            case "RM":
                player = new CentralMidfielder(info);
                break;
            case "CB":
            case "LB":
            case "LWB":
            case "RB":
            case "RWB":
                player = new Defender(info);
                break;
            case "CAM":
                player = new AttackingMidfielder(info);
                break;
            case "CDM":
                player = new DefensiveMidfielder(info);
                break;
            default:
                player = new GoalKeeper(info);
                break;
        }
    return player;
    }
}
