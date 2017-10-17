import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class QuizModule extends Observable implements Observer{

	public Timer timer = null;

	public QuizModule(){

		//constructor
		//
	}

	public void executeModule(){


		JFrame frame = init();
		//begin!
		//observer example.
		setChanged();
		notifyObservers("Hi. I am quiz module. I am sending a message to all of my observers.");

	}

	private JFrame init(){

		JFrame frame = new JFrame("Quiz Module");
    JPanel panel = new JPanel();
		//change layout as needed
    panel.setLayout(new FlowLayout());
		//place holder for the quiz question
		JLabel question = new JLabel("QUESTION");
		question.setPreferredSize(new Dimension(250,50));
		panel.add(question);
		//addButtons(panel);

		JLabel choice = new JLabel("CHOICE");
		choice.setPreferredSize(new Dimension(250,50));
		panel.add(choice);
		//addButtons(panel);

    frame.add(panel);
    frame.setSize(600, 300);
    frame.setLocation(0,300);
    //might be messy coding show/hiding these windows(?)
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);

		timer = new Timer (500, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //if (timerGetsToZero) {
                //    ((Timer)e.getSource()).stop();
                //} else {
                    //undefined below
					//timeLabel.setText(getRemainingTime());
                //}
            }
        });

		return frame;

	}

	private void startButtonActionPerformed(ActionEvent e) {
        timer.start();
				
    }

	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
		System.out.println("Quiz received message: " + arg.toString());
	}

}
