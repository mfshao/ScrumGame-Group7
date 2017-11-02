import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class DrawBoard extends JPanel
{
	private String boardLength = "";
	private String src = "";
	
	public DrawBoard()
	{
		boardLength =
		ConfigurationManager.getConfigurationManager().getConfiguration().getBoardLenght();
		
		switch(boardLength.toLowerCase()) 
		{
			case "short":
				this.drawShort();
				break;
			case "medium":
				this.drawMed();
				break;
			case "long":
				this.drawLong();
				break;
			default:
				this.drawShort();
				break;
		}
		
		System.out.println("FILE IN " + src);
		
	}
	
	private void drawShort()
	{
		src = "/images/Short.png";
		
		try{
		BufferedImage image = ImageIO.read(new File("/images/Short.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		
		this.add(label);
		} catch (IOException e){
			
		}
	}
	
	private void drawMed()
	{
		try{
		BufferedImage image = ImageIO.read(new File("/images/Medium.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		this.add(label);
		} catch (IOException e){
			
		}
	}
	
	private void drawLong()
	{
		try{
		BufferedImage image = ImageIO.read(new File("/images/Long.png"));
		JLabel label = new JLabel(new ImageIcon(image));
		this.add(label);
		} catch (IOException e){
			
		}
	}
}