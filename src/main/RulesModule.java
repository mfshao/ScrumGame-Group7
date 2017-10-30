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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		textArea.append("Before the game begins, each team will choose a member to be the scrum master. A scrum master will draw 2 scrum master special ability cards, which can be played only once on a sprint (round) of his or her choosing. All other members will draw a single efficiency card per member. Use the cards tab for information about these cards.\n\n");

		textArea.append("At each sprint (round), each member of each team will choose to either draw a random scrum card, or place a bet on how many quiz answers they can answer correctly. The outcome of either of these actions determines the number of story points (positive or negative) for the member. ");
		textArea.append("After each teammember has performed an action, all teammembers story points are added up.\n\n");

		textArea.append("After adding up each team member's story point value (using each player's efficiency as an offset) to get your team's velocity, you can determine if you can move your game piece forward. If you are on a gameboard block with a story point value of 5, and your team has a combined velocity of 4, you cannot move forward. ");
		textArea.append("However, if your team's combined velocitys is at least 5, your team can move forward.\n\n");

		textArea.append("Repeat this process until a team reaches the finish line.");

		panel.add(scrollPane);

        return panel;
    }

	private JComponent makeCardsPanel() {
        JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel filler = new JLabel("CARD TYPES & STRATEGY");
        filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);

		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		textArea.append("There are 3 card decks in the game. An efficiency card deck. A scrum master ability card deck. And a scrum card deck.\n\n");

		textArea.append("Efficiency cards are drawn at the beginning of the game. Each teammember should draw one (1) efficiency card. The efficiency cards act as offsets. ");
		textArea.append("If you draw a -1 efficiency card, you need to subtract 1 from your individual story point value at the end of the sprint. ");
		textArea.append("If you draw a 0 efficiency card, there will be no offsets applied to your individual story point value for the sprint/round. ");
		textArea.append("If you draw a +1 efficiency card, you will be able to add 1 story point value for yourself at the end of the sprint. ");
		textArea.append("Likewise, if you have a team with 3 members, each with a +1 efficiency card, the team will add +3 to their combined story points for the sprint.\n\n");

		textArea.append("At the beginning of the game, the team will choose a single member to be the scrum master. The scrum master will draw 2 cards from the scrum master ability card deck. ");
		textArea.append("Each ability card can only be used once and can be used during any sprint to give the team a 'boost'. The team can coordinate with the scrum master to determine a strategy on when to use the ability card.\n\n");

		textArea.append("During each sprint (round) each teammember may choose to either draw a scrum card, or place bets on a timed quiz. If a player chooses to draw a scrum card, they will draw from the scrum card deck. ");
		textArea.append("Scrum cards give you either a positive or negative story point value. Example, 'big bug' scrum cards will give large negative story point values. A 'rock star developer' scrum card can give you large positive story point values. ");
		textArea.append("Common cards like scope increase or scope decrease give you smaller positive or negative story point value. The team adds up all story point values for each teammember's cards to determine if they meet the threshold to move forward.");


		panel.add(scrollPane);

        return panel;
    }

	private JComponent makeQuizzesPanel() {
        JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel filler = new JLabel("QUIZZES");
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);

		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		textArea.append("During each sprint, a player may choose to do a timed quiz instead of drawing a scrum card. The player makes a bet on how many quiz questions they can answer. ");
		textArea.append("The quiz will be timed. The player must get all quiz questions answered, according to the bet, within the time limit to get any points. ");
		textArea.append("For example, a player can bet that they get all 5 questions answered on time. If they do, they get +5 story points. Otherwise, they get 0. ");
		textArea.append("A player can try to get bonus values if choosing harder quiz questions. The same rules apply, except they get a bonus 5 story points if they get all 5 correct.");

		panel.add(scrollPane);

        return panel;
    }

	private JComponent makeGameBoardPanel() {
        JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel filler = new JLabel("GAME BOARD");
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);

		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		textArea.append("Each block of the game board has a built in story point threshold value. In order to move forward, your team has to meet the velocity requirements to move foward. If your team has left over velocity points, they can only be applied to the next block if the left over velocity is enough to move past the next block.");

		panel.add(scrollPane);

        return panel;
    }
}
