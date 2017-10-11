import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ClickEvent extends JPanel implements MouseListener
{
	public ClickEvent()
	{
		//constructor
		DrawBoard board = new DrawBoard();
		add(board);
		
		board.addMouseListener(this);
		addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed (# of clicks: "
                + e.getClickCount() + ")");
    }
    
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released (# of clicks: "
                + e.getClickCount() + ")");
    }
    
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered");
    }
    
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }
    
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked (# of clicks: "
                + e.getClickCount() + ")");
    }
	
	
	
}// end class