import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

import java.util.*;

public class ClickEvent extends JLayeredPane implements MouseListener
{
	private JPanel figure;
	private Point position;
	
	private int posX=261;
	private int posY =752;
	private int width = 50;
	private int height = 50;
	String boardLength = "";
	
	private static boolean moved = true;
	
	private int players = 1;
	private static int currentIndex = 0;
	private List <JPanel> panelList = new ArrayList <JPanel>();
	
	
	public ClickEvent()
	{			
		//Create Board
		DrawBoard board = new DrawBoard();
		board.setBounds(2,0,600,800);
	
		this.add(board, new Integer(0));
		this.setPlayers();

		board.addMouseListener(this);
		this.addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent e) {
		/*
        System.out.println("Mouse pressed (# of clicks: "
                + e.getClickCount() + ")");
		*/
    }
    
    public void mouseReleased(MouseEvent e) {
		/*
        System.out.println("Mouse released (# of clicks: "
                + e.getClickCount() + ")");
		*/
    }
    
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Mouse entered");
    }
    
    public void mouseExited(MouseEvent e) {
        //System.out.println("Mouse exited");
    }
    
    public void mouseClicked(MouseEvent e) {
		/*
        System.out.println("Mouse clicked (# of clicks: "
                + e.getClickCount() + ")");	
		*/
		position = e.getPoint();
		moveFigure(position);
		
    }
	
	public static void setCurrent(int c) 
	{
		ClickEvent.currentIndex = c -1;
		System.out.println("current: "+c);
		ClickEvent.moved = false;
	}
	
	private void moveFigure(Point p)
	{
		if(moved == false)
		{
			System.out.println("x: "+ p.x + "y: "+ p.y);
		
			figure = panelList.get(currentIndex);
		
			int x = p.x - 10;
			int y = p.y - 10;
			figure.setLocation(x, y);
			
			this.moved = true;
		}
		
	}
	
	private void setPlayers()
	{
		this.players =
		ConfigurationManager.getConfigurationManager().getConfiguration().getNumberOfTeams();
		
		for(int i = 1; i <= players; i++)
		{
			this.createPlayerPan();
			this.setPosition(i-1);
			
			this.add(figure, new Integer (i));
			panelList.add(figure);
		}
	}
	
	private void createPlayerPan()
	{
		figure = new JPanel();
		figure.setBackground(Color.BLUE);
		figure.setOpaque(true);
	}
	
	private void setPosition(int i)
	{
		boardLength =
		ConfigurationManager.getConfigurationManager().getConfiguration().getBoardLenght();
		
		switch (boardLength.toLowerCase())
		{
			case "short":
				this.setShortPos(i);
				break;
			case "medium":
				this.setMedPos(i);
				break;
			case "long":
				this.setLongPos(i);
				break;
			default:
				this.setShortPos(i);
				break;
		}
	}
	
	private void setShortPos(int i)
	{
		posX=145 + (75 * i);
		posY =715;
		width = 25;
		height = 25;
		
		figure.setBounds(posX,posY,width,height);
		
	}
	private void setMedPos(int i)
	{
		posX=145 + (75 * i);
		posY =715;
		width = 25;
		height = 25;
		
		figure.setBounds(posX,posY,width,height);
	}
	private void setLongPos(int i)
	{
		posX=20 + (50 * i);
		posY =760;
		width = 25;
		height = 25;
		
		figure.setBounds(posX,posY,width,height);
	}
	
	
}// end class