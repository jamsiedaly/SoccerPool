package soccerpool.player;

/**
 * 
 * @author James
 */

public class Attacker extends OutfieldPlayer implements IForward

{   
    public Attacker(String info)
    {
        super(info);
    }
    
     /**
     *
     * @return an evaluation of this player as an attacker
     */
    @Override
    public int getAttackerRating()
    {
        return (pace+shoot)/2; 
    }
}
	