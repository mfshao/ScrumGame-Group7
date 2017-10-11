import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class DrawBoard extends JLabel //was JPanel
{	
	public DrawBoard()
	{
		//Constructor
		ImageIcon board = new ImageIcon(getClass().getResource(
									"images/Hell board.jpg"));
		Image image = board.getImage();
		
		setIcon(board);
		setOpaque(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
		ImageIcon board = new ImageIcon(getClass().getResource(
									"images/Hell board.jpg"));
		Image image = board.getImage();
		
		
	    g.drawImage(image,200,0,400,800,null);
	}
	
}