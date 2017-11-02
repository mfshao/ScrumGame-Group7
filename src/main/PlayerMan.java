import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Color;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.File;

public class PlayerMan extends JPanel
{
	private JButton p1Button;	
	private int totalPlayers = 1;
	
	private BufferedImage figures;
	private String FIGURE_IMAGE_PATH = "/images/figures.png";
	private int scale = 50;
	private ImageIcon doughnut;
	
	public PlayerMan()
	{
		this.initFigures();
		this.setButton();
	}
	
	private void setButton()
	{
		this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));	
		this.add(Box.createRigidArea(new Dimension(0,100)));
		
		this.totalPlayers = 
		ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams();
		
		System.out.println("**************"+this.totalPlayers+"************");
		
		for (int i = 1; i <= totalPlayers; i++)
		{
			p1Button = new Player(i);
			p1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.add(p1Button);
			
			JLabel label = new JLabel();
			label.setIcon(doughnut);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.add(label);
			
			this.add(Box.createRigidArea(new Dimension(0,25)));
		}
		
	}
	
	private void initFigures()
	{
		try{
			figures = ImageIO.read(new File(FIGURE_IMAGE_PATH));
			doughnut = new ImageIcon(figures.getSubimage(100,0,scale,scale));			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}