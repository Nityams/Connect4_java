import java.awt.Color;

public class Player {
	private int playerNum;
	private Color color;
	
	public Player(int playerNum, Color color)
	{
		this.playerNum = playerNum;
		this.color = color;
	}
	public Color getColor()
	{
		return color;
	}
	public int getPlayNum()
	{
		return playerNum;
	}
}
