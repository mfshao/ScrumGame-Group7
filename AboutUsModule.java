import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;  

public class AboutUsModule implements Observer{

	
	public AboutUsModule(){
		
		//constructor
		
	}

	public void executeModule(){
		
		
		JFrame frame = init();
		//begin!
		
	}
	
	private JFrame init(){
		
		JFrame frame = new JFrame("Credits Module");
        JPanel panel = new JPanel();
		//change layout as needed
        panel.setLayout(new FlowLayout());
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocation(300,0);
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		return frame;
		
	}
	
	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
	}
}