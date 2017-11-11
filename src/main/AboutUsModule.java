import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.*;

public class AboutUsModule implements Observer{


	public AboutUsModule(){

		//constructor

	}

	public void executeModule(){


		JFrame frame = init();
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
		fillPanel(panel);
        frame.add(panel);

	}

	private JFrame init(){

		JFrame frame = new JFrame("Credits Module");
		//change layout as needed
        frame.setSize(300, 300);
        frame.setLocation(300,0);
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
		return frame;

	}
	
	private void fillPanel(JPanel panel){

		JTextArea textArea = new JTextArea(5, 20);
		textArea.setMargin(new Insets(10,10,10,10));
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		textArea.append("Jeff Easton: Product Owner/Developer. Graduate MS Computer Science student. 2 more classes to graduate!\n\n");

		textArea.append("Adam Gruszczynski: Depaul University Senior in Bachelor/Masters Program. Avid gamer and creator of the Card Deck Module.\n\n");

		textArea.append("Mingfei (Travis) Shao: Developer/Main Menu and Settings Menu. Master student in Computer Science. Loves everything about video games, civil aviation and good foods. \n\n");
		
		textArea.append("Clarke Roche: \n\n");
		
		textArea.append("Francisco De La O: Developer/GameBoard Module. After completing my hot air balloon race around the world I thought "
		+"I would try something more challenging that is why I have chosen a carrier in software development.\n\n");

		panel.add(scrollPane);


	}

	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
	}
}
