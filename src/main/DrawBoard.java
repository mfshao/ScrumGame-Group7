import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class DrawBoard extends JPanel
{
	private static final String GAME_BOARD_IMAGE_PATH = "/images/Hell board.jpg";

	public DrawBoard()
	{
		try{
		BufferedImage image = ImageIO.read(getClass().getResource(GAME_BOARD_IMAGE_PATH));
		JLabel label = new JLabel(new ImageIcon(image));
		this.add(label);
		} catch (IOException e){

		}
	}

}
