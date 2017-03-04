package soccerpool.player;

/**
 *
 * @author James
 */
public class CentralMidfielder extends OutfieldPlayer implements IMidfield
{
    public CentralMidfielder(String info)
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
}
