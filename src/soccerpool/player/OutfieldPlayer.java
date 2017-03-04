package soccerpool.player;
/**
 * 
 * @author James
 */
public abstract class OutfieldPlayer implements IPlayer
{
	private String name;
	protected int rating,pace,shoot,pass,dribble,defence,physical;
	
	public OutfieldPlayer(String info)
	{
		String[] stats = new String[9];
		stats = info.split(",");
		for(int i = 0; i < stats.length;i++)
		{
			stats[i] = stats[i].trim();
		}
		setName(stats[0]);
		setRating(Integer.parseInt(stats[2]));
		setPace(Integer.parseInt(stats[3]));
		setShooting(Integer.parseInt(stats[4]));
		setPassing(Integer.parseInt(stats[5]));
		setDribbling(Integer.parseInt(stats[6]));
		setDefence(Integer.parseInt(stats[7]));
		setPhysical(Integer.parseInt(stats[8]));
	}
	
	public int getOverallRating()
	{
            return rating;
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
	private void setRating(int rating)
	{
		if(valid(rating))
			this.rating = rating;
	}
	private void setPace(int pace)
	{
		if(valid(pace))
			this.pace = pace;
	}
	private void setShooting(int shoot)
	{
		if(valid(shoot))
			this.shoot = shoot;
	}
	private void setPassing(int pass)
	{
		if(valid(pass))
			this.pass = pass;
	}
	private void setDribbling(int dribble)
	{
		if(valid(dribble))
			this.dribble = dribble;
	}
	private void setDefence(int defence)
	{
		if(valid(defence))
			this.defence = defence;
	}
	private void setPhysical(int physical)
	{	
		if(valid(physical))
			this.physical = physical;
	}
	
	private boolean valid(int stat)
	{
		if(stat>1 && stat < 100)
		{
			return true;
		}
		else
		{
			System.out.print("Corrupted Data");
			System.exit(1);
			return false;
		}
	}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the rating
     */

    public int getPace() {
        return pace;
    }

    /**
     * @return the shoot
     */
    public int getShoot() {
        return shoot;
    }

    /**
     * @return the pass
     */
    public int getPass() {
        return pass;
    }

    /**
     * @return the dribble
     */
    public int getDribble() {
        return dribble;
    }

    /**
     * @return the defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * @return the physical
     */
    public int getPhysical() {
        return physical;
    }
}
