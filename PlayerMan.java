import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class PlayerMan extends JPanel
{
	private JButton p1Button;	
	private int totalPlayers = 5;
	
	public PlayerMan()
	{
		this.setButton();
	}
	
	private void setButton()
	{
		this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));	
		this.add(Box.createRigidArea(new Dimension(0,100)));
		
		for (int i = 1; i <= totalPlayers; i++)
		{
			p1Button = new Player(i);
			p1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.add(p1Button);
			this.add(Box.createRigidArea(new Dimension(0,25)));
		}
		
	}

}