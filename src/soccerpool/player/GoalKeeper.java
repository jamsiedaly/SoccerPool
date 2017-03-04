package soccerpool.player;
/**
 * 
 * @author James
 */
public class GoalKeeper implements IPlayer
{
	private String name;
	private int rating,diving,handling,kicking,reflexes,speed,positioning;
	
	public GoalKeeper(String info)
	{
		String[] stats = new String[9];
		stats = info.split(",");
		for(int i = 0; i < stats.length;i++)
		{
			stats[i] = stats[i].trim();
		}
		setName(stats[0]);
		setRating(Integer.parseInt(stats[2]));
		setDiving(Integer.parseInt(stats[3]));
		setHandling(Integer.parseInt(stats[4]));
		setKicking(Integer.parseInt(stats[5]));
		setReflexes(Integer.parseInt(stats[6]));
		setSpeed(Integer.parseInt(stats[7]));
		setPositioning(Integer.parseInt(stats[8]));
	}
	
    /**
     *
     * @return the players overall rating 
     */
    @Override
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
	private void setDiving(int diving)
	{
		if(valid(diving))
			this.diving = diving;
	}
	private void setHandling(int handling)
	{
		if(valid(handling))
			this.handling = handling;
	}
	private void setKicking(int kicking)
	{
		if(valid(kicking))
			this.kicking = kicking;
	}
	private void setReflexes(int reflexes)
	{
		if(valid(reflexes))
			this.reflexes = reflexes;
	}
	private void setSpeed(int speed)
	{
		if(valid(speed))
			this.speed = speed;
	}
	private void setPositioning(int positioning)
	{	
		if(valid(positioning))
			this.positioning = positioning;
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
}
