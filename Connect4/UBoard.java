import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class UBoard extends JFrame {
	JButton[][] fxnBtns;
	Board b;
	
	public UBoard(int size, int win) {
		b = Board.getInstance(size, win);
			
		JPanel mainpanel=new JPanel();
		mainpanel.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel endPanel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("<html>Click on the<font color ='Orange'> Orange Button </font> to add <br> Player 1 is color: <font color='green'>Green </font> Player 2 is color: <font color ='red'> Red </font> </html>"), SwingConstants.CENTER);
		mainpanel.add(panel, BorderLayout.PAGE_START);
		
		endPanel.setLayout(new FlowLayout());
		endPanel.add(new JLabel("Game By Victoria Yeung & Nityam Shrestha"));
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(size +1, size));
			
		fxnBtns = new JButton[size+1][size];
		for (int x = 0; x < fxnBtns.length ; x++) {
			for (int y = 0; y < fxnBtns[x].length; y++) {
				fxnBtns[x][y] = new JButton("");
				buttonpanel.add(fxnBtns[x][y]);
			}
		}
		for(int x=0; x<size; x++)
		{
		fxnBtns[0][x].addMouseListener(new Listener(x));
		fxnBtns[0][x].setBackground(Color.orange);
		fxnBtns[0][x].setText(""+(x+1));
		}
		mainpanel.add(buttonpanel, BorderLayout.CENTER);
		mainpanel.add(endPanel, BorderLayout.PAGE_END);
		add(mainpanel);
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
		
		public class Listener implements MouseListener{
			private int y;
			private PopUp pop;
			public Listener(int y)
			{
				this.y = y;
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				//System.out.println("Clicked");
							
				ButtonConnector.colmnGiver(y);
				//System.out.println(ButtonConnector.rowTaker());
			
			if(b.getBoardRow()==-1)
			{
				pop = new PopUp("WARNING!! Column Full");  
			}
			else{
				if(ButtonConnector.getCurrentPlayer() == new Player(1, null).getPlayNum())
				{	// change color here
					fxnBtns[ButtonConnector.rowTaker()+1][y].setBackground(Color.GREEN);
					//System.out.println("Player 1");
				}
				else if(ButtonConnector.getCurrentPlayer() == new Player(2, null).getPlayNum())
				{
					fxnBtns[ButtonConnector.rowTaker()+1][y].setBackground(Color.red);
					//System.out.println("Player 2");
				}
			  }
	
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// check winner
				if(b.getWinner()==1)
				{
					pop = new PopUp("Player1 wins");
					//System.out.print("\n \t *** Player 1 is the winner***");
				}	
				 else if(b.getWinner()==2)
				 {
					 pop = new PopUp("Player2 wins");
					 //System.out.print("\n \t *** Player 2 is the winner***");
				 }
				 else if (b.checkFull())
				 {
//					 System.out.print("\n \t No winner ");
//					 System.out.println("The game ended!!!");
					 pop = new PopUp("Game Draw!!");
				 }
			}

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			}
		}
		



