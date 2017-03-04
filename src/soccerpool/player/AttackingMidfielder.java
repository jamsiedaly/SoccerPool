package soccerpool.player;

/**
 *
 * @author James
 */
public class AttackingMidfielder extends OutfieldPlayer implements IForward, IMidfield
{    
    public AttackingMidfielder(String info)
    {
        super(info);
    }

    /**
     *
     * @return an evaluation of this player as a midfielder
     */
    @Override
    public int getMidfieldRating()
    {
        return (pass+dribble)/2;
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
