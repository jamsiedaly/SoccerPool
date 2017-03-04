package soccerpool.player;

/**
 *
 * @author James
 */

public class Player
{
	private String name, position;
	private int rating,pace,shoot,pass,dribble,defence,physical;
	/**
         * 
         * @param info is a string of player relevant information  
         */
	public Player(String info)
	{
		String[] stats = new String[9];
		stats = info.split(",");
		for(int i = 0; i < stats.length;i++)
		{
			stats[i] = stats[i].trim();
		}
		setName(stats[0]);
		setPosition(stats[1]);
		setRating(Integer.parseInt(stats[2]));
		setPace(Integer.parseInt(stats[3]));
		setShooting(Integer.parseInt(stats[4]));
		setPassing(Integer.parseInt(stats[5]));
		setDribbling(Integer.parseInt(stats[6]));
		setDefence(Integer.parseInt(stats[7]));
		setPhysical(Integer.parseInt(stats[8]));
		System.out.println(name + " "+ position);
	}

	private void setName(String name)
	{
		this.name = name;
	}
	private void setPosition(String exactPosition)
	{
		switch (exactPosition) {
			case "GK": this.position = "Goalkeeper"; break;
			case "RB": this.position = "Back"; break;
			case "LB": this.position = "Back"; break;
			case "RWB": this.position = "Back"; break;
			case "LWB": this.position = "Back"; break;
			case "CB": this.position = "Back"; break;
			case "CDM": this.position = "BackMid"; break;
			case "CM": this.position = "Mid"; break;
			case "CAM": this.position = "MidForward"; break;
			case "RM": this.position = "Mid"; break;
			case "LM": this.position = "Mid"; break;
			case "RW": this.position = "MidForward"; break;
			case "LW": this.position = "MidForward"; break;
			case "CF": this.position = "Forward"; break;
			case "ST": this.position = "Forward"; break;
		}
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
         * 
         * @return a players name
         */
	public String getName()
	{
		return name;
	}
        /**
         * 
         * @return a players position
         */
	public String getPosition()
	{
		return position;
	}
        /**
         * 
         * @return players pace
         */
	public int getPace()
	{
		return pace;
	}
        /**
         * 
         * @return players shooting 
         */
	public int getShooting()
	{
		return shoot;
	}
        /**
         * 
         * @return players passing
         */
	public int getPassing()
	{
		return pass;
	}
        /**
         * 
         * @return players dribbling
         */
	public int getDribbling()
	{
		return dribble;
	}
        /**
         * 
         * @return players defending 
         */
        
	public int getDefending()
	{
		return defence;
	}
        /**
         * 
         * @return players physical 
         */
	public int getPhysical()
	{
		return physical;
	}
}
