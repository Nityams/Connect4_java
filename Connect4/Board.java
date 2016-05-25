import java.awt.Color;
public class Board {

	private int size;						// size of the board
	private int winSize;					// numbers to win
	static int[][] arr; 					// board array[ size X size ]
	private int currentPlayer=0;
	private Player p1;								// 1st player
	private Player p2;								// 2nd player
	private int count=1;
	private int countA, countB;		
	private int rowInserted = -2;				// row no. for 
	private static Board instance = null;		
	
	private Board(int s, int w) 
	{	
		size= s; 
		winSize= w;
		arr= new int[size][size]; 				// board array created
		p1= new Player(1,Color.BLUE);			// player created
		p2 = new Player(2,Color.red);
	}
	
	public static Board getInstance()
	{											// Singleton Pattern
		return instance;
	}
	
	public static Board getInstance(int x, int y)
	{
		if(instance == null)
		{
			instance = new Board(x,y);
			return instance;
		}

		else 
			return instance;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getWinSize()
	{
		return winSize;
	}
	
	public int getBoardRow()
	{
		return rowInserted;
	}
	
	public int[][] getBoard()		
	{
		return arr;
	}
	
	public boolean checkFull()				// return true if no 0
	{
		for(int i=0; i<size; i++)
		{
			if(arr[0][i]== 0)
				return false;
		}
		return true;
	}
	
	public void populate()					// non-GUI purpose
	{
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				arr[i][j]=0;
			}
		}
	}
	
	public void display()					// non-GUI purpose
	{
		for(int i=0; i<size; i++)
		{	
			System.out.print("\t \t");
			for(int j=0;j<size;j++)
			{
				System.out.print(": "+arr[i][j]+" :");
			}
			System.out.print("\n");
		}
	}
	
	public int add(int y)
	{										// return the position it was added and reflect it into UI
		count++;
		for(int i = size-1; i >= 0; i--)
		{
			if(arr[i][y]!=p1.getPlayNum() && arr[i][y] != p2.getPlayNum() )
			{
				arr[i][y]= (count%2)+1;			
			    currentPlayer = arr[i][y];
				rowInserted = i; 
				return i;  				
			}
		}
		rowInserted = -1;
		return -1;  							// ERROR: column full
	}
	
	public Player getCurrentPlayer()			//return current player
	{
		if(currentPlayer ==1)
		return p1;//.getPlayNum();
		else if(currentPlayer ==2)
			return p2;//.getPlayNum();
		else
			return null; //-1;
	}
	
	public int getWinner()					
	{
		if(checkVertical()>0)
			return checkVertical();
		else if(checkHorizontal()>0)
			return checkHorizontal();
		else
			return checkDiagonal();				// UI checks if -1 then not a winner else value of d is the winning player
	}
	
	
	private int checkHorizontal()
	{ 
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size-winSize; j++)
			{
				countA=0; countB=0;
				for(int k=0;k<winSize;k++)
				{
					if(p1.getPlayNum()==arr[i][j+k])
						countA++;
					if(p2.getPlayNum()==arr[i][j+k])
						countB++;
				}
				if(countA==winSize)
					return p1.getPlayNum();		// winner  player1
				else if(countB==winSize)
					return p2.getPlayNum();		//winner player2
			}
		}
		return -1;							// not a winner
	}
	
	
	private int checkVertical()
	{
		for(int i=0; i<=(size-winSize); i++)
		{
			for(int j=0; j<size; j++)
			{
				countA =0; countB =0;
				for(int k=0; k<winSize; k++)
				{
					if(p1.getPlayNum()== arr[i+k][j])
						countA++;
					if(p2.getPlayNum()==arr[i+k][j])
						countB++;
				}
				if(countA == winSize)
					return p1.getPlayNum();					// winner player1
				if(countB==winSize)
					return p2.getPlayNum();					// winner player2
															
			}
		}
		
		return -1;											// not a winner
	}
	
	
	private int checkDiagonal()
	{
		// for downwards................ top left to bottom right
		for(int i=size-winSize; i<=size-winSize; i++)	// runs vertically from 0 to size-winSize
		{
			for(int j=0; j<=size-winSize; j++)			// runs horizontally from 0 to size-winSize
			{  
				countA=0; countB=0;						//reseting count for player 1 and 2
				for(int k=0; k<winSize; k++)			// runs within [i][j] from 0 to winSize
				{	
					if(p1.getPlayNum()==arr[i+k][j+k])
						countA++;
					if(p2.getPlayNum()==arr[i+k][j+k])
						countB++;
				}
				if(countA==winSize)
					return p1.getPlayNum();
				if(countB==winSize)
					return p2.getPlayNum();
			}	
		}
		
		// for upwards................  bottom left to top right
		for(int i=winSize-1; i<size; i++)			// runs vertically from winsize to size
		{
			for(int j=0; j<size-winSize;j++)		// runs horizontally from 0 to size-winsize
			{
				countA=0; countB=0;					//reseting count for player 1 and 2
				for(int k=0; k<winSize; k++)		// runs within [i][j] from 0 to winsize
				{
					if(p1.getPlayNum()== arr[i-k][j+k])
						countA++;
					if(p2.getPlayNum()==arr[i-k][j+k])
						countB++;
				}
				if(countA==winSize)
					return p1.getPlayNum();			// winner player1
				if(countB==winSize)
					return p2.getPlayNum();			// winner player2
			}
		}
		return -1;
	}
	
}
