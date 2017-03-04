package soccerpool.player;

/**
 *
 * @author James
 */
public class DefensiveMidfielder extends OutfieldPlayer implements IDefense, IMidfield 
{
    public DefensiveMidfielder(String info)
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
     * @return an evaluation of this player as a defender
     */
    @Override
    public int getDefenderRating()
    {
        return (defence+physical)/2;
    }
}
