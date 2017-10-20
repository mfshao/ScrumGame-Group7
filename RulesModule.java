import javax.swing.*;
import java.awt.*;
import java.util.*;  

public class RulesModule implements Observer{

	
	public RulesModule(){
		
		//constructor
		
	}

	public void executeModule(){
		
		
		JFrame frame = init();
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
		fillPanel(panel);
        frame.add(panel);
		//begin!
		
	}
	
	private JFrame init(){
		
		JFrame frame = new JFrame("Rules Module");
        frame.setSize(600, 600);
        frame.setLocation(300,0);
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
		return frame;
		
	}
	
	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
	}
	
	private void fillPanel(JPanel panel){
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Basic Game Rules", null, makeGamePanel(),"");
		tabbedPane.addTab("Cards", null, makeCardsPanel(),"");
		tabbedPane.addTab("Quizzes", null, makeQuizzesPanel(),"");
		tabbedPane.addTab("Game Board", null, makeGameBoardPanel(),"");
						  
		panel.add(tabbedPane);
		
	}
	
	private JComponent makeGamePanel() {
        JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel filler = new JLabel("GENERAL GAME RULES");
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);

		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textArea.append("Each team will have a game piece. The team that gets to the end of the gameboard first wins.\n\n");
	
		textArea.append("Before the game begins, each team will choose a member to be the scrum master. A scrum master will draw 2 scrum master special ability cards. All other members will draw a single efficiency card per member. Use the cards tab for information about these cards.\n\n");
		
		textArea.append("At each sprint (round), each member of each team will choose to either draw a random card, or place a bet on how many quiz answers they can answer correctly. The outcome of either of these actions determines the number of story points (positive or negative) for the member. ");
		textArea.append("After each teammember has performed an action, all teammembers story points are added up.\n\n"); 
	
		textArea.append("After adding up each team member's story point value, you can determine if you can move your game piece forward. If you are on a gameboard block with a story point value of 5, and your team has a combined velocity if 4, you cannot move forward. ");
		textArea.append("However, if your team's combined story point value at least 5, your team can move forward.\n\n");

		textArea.append("Repeat this process until a team reaches the finish line.");
		
		panel.add(scrollPane);
        
        return panel;
    }
	
	private JComponent makeCardsPanel() {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel("CARD TYPES & STRATEGY");
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	private JComponent makeQuizzesPanel() {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel("QUIZZES & STRATEGY");
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	private JComponent makeGameBoardPanel() {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel("GAME BOARDS");
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}