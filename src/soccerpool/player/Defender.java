package soccerpool.player;

/**
 *
 * @author James
 */
public class Defender extends OutfieldPlayer implements IDefense
{
    public Defender(String info)
    {
        super(info);
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
