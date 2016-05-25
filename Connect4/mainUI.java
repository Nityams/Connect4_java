public class mainUI {

	public static void main(String[] args)
	{
		int x,y;	
		x = Integer.parseInt(args[0]);
		 y = Integer.parseInt(args[1]);
		if(x<2 || y <1)
			new PopUp("2 or Win Combination less than 1", 400);
		else if(y>x)
			new PopUp("Win Combination ",400);
		else
			new UBoard(x,y); 

	}
}
