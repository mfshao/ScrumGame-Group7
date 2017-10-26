import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class DrawBoard extends JPanel
{
	public DrawBoard()
	{
		try{
		BufferedImage image = ImageIO.read(new File("images/Hell board.jpg"));
		JLabel label = new JLabel(new ImageIcon(image));
		this.add(label);
		} catch (IOException e){
			
		}
	}
	
}