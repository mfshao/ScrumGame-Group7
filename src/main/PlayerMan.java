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

import java.util.*;

public class PlayerMan extends JPanel
{
	private JButton p1Button;	
	private int totalPlayers = 1;
	private int MaxPlayers = 4;
	
	private BufferedImage figures;
	private String FIGURE_IMAGE_PATH = "images/figures.png";
	private int scale = 50;
	private static String boardLength = "";
	private static List<ImageIcon> imageList = new ArrayList<ImageIcon>();
	
	private static int posX;
	private static int posY;
	private static int width;
	private static int height;
	
	public PlayerMan()
	{
		this.initFigureImgs();
		this.setButton();
	}
	
	private void setButton()
	{
		this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));	
		this.add(Box.createRigidArea(new Dimension(0,100)));
		
		this.totalPlayers = 
		ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams();
		
		for (int i = 1; i <= totalPlayers; i++)
		{
			p1Button = new Player(i);
			p1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.add(p1Button);
			
			JLabel label = new JLabel();
			label.setIcon(imageList.get(i-1));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.add(label);
			
			this.add(Box.createRigidArea(new Dimension(0,25)));
		}
		
	}
	
	private void initFigureImgs()
	{
		try{
			figures = ImageIO.read(getClass().getResource(FIGURE_IMAGE_PATH));
			
			for(int i = 0; i < MaxPlayers; i++)
			{
				ImageIcon current = new ImageIcon(figures.getSubimage(50*i,0,scale,scale));
				imageList.add(current);
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static JLabel getPlayer(int i)
	{
		JLabel label = new JLabel();
		label.setIcon(imageList.get(i));
		setPosition(label, i);
		return label;
	}
	
	private static void setPosition(JLabel label, int i)
	{
		boardLength =
		ConfigurationManager.getConfigurationManager().getConfiguration().getBoardLenght();
		
		switch (boardLength.toLowerCase())
		{
			case "short":
				setShortPos(label, i);
				break;
			case "medium":
				setMedPos(label, i);
				break;
			case "long":
				setLongPos(label, i);
				break;
			default:
				setShortPos(label, i);
				break;
		}
	}
	
	private static void setShortPos(JLabel label, int i)
	{
		posX=145 + (75 * i);
		posY =715;
		width = 50;
		height = 50;
		
		label.setBounds(posX,posY,width,height);
		
	}
	private static void setMedPos(JLabel label, int i)
	{
		posX=145 + (75 * i);
		posY =715;
		width = 50;
		height = 50;
		
		label.setBounds(posX,posY,width,height);
	}
	private static void setLongPos(JLabel label, int i)
	{
		posX=15 + (50 * i);
		posY =750;
		width = 50;
		height = 50;
		
		label.setBounds(posX,posY,width,height);
	}

}