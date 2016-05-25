public class ButtonConnector {
	
	static Board board;
	static Player p;
	public static void colmnGiver(int y)		// gives to board
	{
		board = Board.getInstance();
		board.add(y);
	}
	
	public static int rowTaker()			// takes from board
	{
		return board.getBoardRow();
	}
	
	public static int getCurrentPlayer()
	{
		p =board.getCurrentPlayer();
		return p.getPlayNum();
	}
	
}


