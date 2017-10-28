import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Player extends JButton implements ActionListener
{
	int index;
	
	public Player(int i)
	{
		this.setText("Player "+ i);
		addActionListener(this);
		this.index = i;
	}
	
	@Override
	public void actionPerformed (ActionEvent e)
	{
		System.out.println("Press Player: " + index);
		ClickEvent.setCurrent(index);
	}
	
	

}