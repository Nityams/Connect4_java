
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JFrame {
	public PopUp(String name){
		//setLayout(new GridLayout());
		JPanel panel = new JPanel();
		setSize(200, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		
		panel.add(new JLabel(name));
		add(panel, BorderLayout.CENTER);
		setTitle("Game Message");
	}
	public PopUp(String name, int size)
	{
		JPanel panel = new JPanel();
		setSize(size, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		panel.add(new JLabel("Warning!! Boardsize less then "+name));
		add(panel, BorderLayout.CENTER);
		setTitle("Game Warning");	
	}
}