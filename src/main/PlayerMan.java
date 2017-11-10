import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.File;
import javax.swing.border.LineBorder;
import java.util.Collections;

import java.util.*;

public class PlayerMan extends JPanel
{
	private JButton p1Button;	
	private int totalPlayers = 1;
	private static int totalPlayersStat = 1;
	private int MaxPlayers = 4;
	private Random rand = new Random();
	private int randIndex = 0;
	private int current = 0;
	private static int currentStatic = 0;
	
	private BufferedImage figures;
	private String FIGURE_IMAGE_PATH = "images/figures.png";
	private int scale = 50;
	private static int imageXY = 50;
	private static String boardLength = "";
	private static List<ImageIcon> imageList = new ArrayList<ImageIcon>();
	
	private static int posX;
	private static int posY;
	private static int width;
	private static int height;
	
	public PlayerMan()
	{
		this.setRandomIndex();
		this.initFigureImgs();
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
			
			JLabel label = new JLabel();
			label.setIcon(imageList.get(current));
			this.updateIndex();
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.add(label);
			
			this.add(Box.createRigidArea(new Dimension(0,25)));
		}
		setText();
		
	}
	
	private void setText()
	{
		JPanel textPan = new JPanel();
		
		JLabel text1 = new JLabel("Select Player");
		text1.setFont(new Font("Verdana",1,15));
		text1.setAlignmentX(Component.CENTER_ALIGNMENT);
		textPan.add(text1);
		
		JLabel text2 = new JLabel("to move");
		text2.setFont(new Font("Verdana",1,15));
		text2.setAlignmentX(Component.CENTER_ALIGNMENT);
		textPan.add(text2);
		
		JLabel text3 = new JLabel("player image.");
		text3.setFont(new Font("Verdana",1,15));
		text3.setAlignmentX(Component.CENTER_ALIGNMENT);
		textPan.add(text3);
		
		textPan.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(textPan);
	}
	
	private void setRandomIndex()
	{
		this.totalPlayers = 
		ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams();
		
		randIndex = rand.nextInt(totalPlayers + 1);
		current = randIndex;
		PlayerMan.currentStatic = randIndex;
		PlayerMan.totalPlayersStat = totalPlayers;
		System.out.println("Players: "+totalPlayers+" Rand: "+randIndex+" C:"+current);
	}
	
	private void updateIndex()
	{		
		current = current + 1;
		
		System.out.println("Index: "+current);
		if (current > (totalPlayers - 1) && current != 0)
		{
			System.out.println("SET TO ZERO");
			current = 0;
		}
	}
	private static void updateIndexStatic()
	{
		currentStatic = currentStatic + 1;
		
		System.out.println("Index: "+currentStatic);
		if (currentStatic > (totalPlayersStat - 1) && currentStatic != 0)
		{
			System.out.println("SET TO ZERO");
			currentStatic = 0;
		}
	}
	/*
	 * Methods used for players 
	 * creation and movement methods
	 */
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
		label.setIcon(imageList.get(currentStatic));
		updateIndexStatic();
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
		width = imageXY;
		height = imageXY;
		
		label.setBounds(posX,posY,width,height);
		
	}
	private static void setMedPos(JLabel label, int i)
	{
		posX=145 + (75 * i);
		posY =715;
		width = imageXY;
		height = imageXY;
		
		label.setBounds(posX,posY,width,height);
	}
	private static void setLongPos(JLabel label, int i)
	{
		posX=15 + (50 * i);
		posY =740;
		width = imageXY;
		height = imageXY;
		
		label.setBounds(posX,posY,width,height);
	}

}