package questionFrame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import actionListeners.FinishTimerActionListener;
import actionListeners.PauseTimerActionListener;
import actionListeners.QuestionSelectActionListener;
import actionListeners.ResetTimerActionListener;
import actionListeners.StartTimerActionListener;
import countdownTimer.CountdownTimerLabel;
import question.IQuestion;
import questionSet.IQuestionSet;
import questionSet.QuestionSet;

public class QuestionFrame {
	
	private List<IQuestion> questionList;
	private QuestionSet questionSet;
	
	public QuestionFrame(QuestionSet questionSet) {
		this.questionList = questionSet.getQuestions();
		this.questionSet = questionSet;
	}
	
	public void createFrame() {
		JFrame frame = new JFrame("Questions " + String.valueOf(questionSet.getPointValue()) + " Module");
        JPanel panel = new JPanel();
		//change layout as needed

  		panel.setLayout(new GridBagLayout());
  		
  		GridBagConstraints c = new GridBagConstraints();
  		
  		JTextArea questionL = new JTextArea("");
  		JTextArea answerL = new JTextArea("");
  		
		CountdownTimerLabel timerLabel = new CountdownTimerLabel(questionSet.getNumInMins());
  		
  		int xPos = 0;
  		int yPos = 0;
  		int qNum = 1;
		
		for (IQuestion question : questionList) {
	  		c.gridx = xPos;
	  		c.gridy = yPos;
	        
		    c.gridheight = 1;
		    c.gridwidth = 1;
		    
		    c.ipadx = 0;
		    c.ipady = 0;
		     
		    c.weightx = 1;
		    c.weighty = 1;
		    
		    c.insets = new Insets(5,0,5,10);
		     
		    c.anchor = GridBagConstraints.NORTHWEST;
		    c.fill = GridBagConstraints.BOTH;
		    
		    JButton questionButton = new JButton("Q" + qNum);
		    questionButton.addActionListener(new QuestionSelectActionListener(question, questionL, answerL,timerLabel));
		    		
		    panel.add(questionButton,c);
			
		    yPos++;
		    qNum++;
		}
    
		//TIMER
		c.gridx = 1;
		c.gridy = 0;
        
	    c.gridheight = 1;
	    c.gridwidth = 2;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    panel.add(timerLabel,c);
		
		//QUESTION
		
	    c.gridx = 1;
		c.gridy = 1;
        
	    c.gridheight = 2;
	    c.gridwidth = 2;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    questionL.setWrapStyleWord(false);
	    
	    panel.add(questionL,c);
	    
		//ANSWER
	    
	    c.gridx = 1;
		c.gridy = 3;
        
	    c.gridheight = 2;
	    c.gridwidth = 2;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    
	    answerL.setWrapStyleWord(false);
	    
	    panel.add(answerL,c);
		
		//START
	    
	    JButton startButton = new JButton("Start");
	    startButton.addActionListener(new StartTimerActionListener(timerLabel));
	    
	    c.gridx = 3;
		c.gridy = 0;
        
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    panel.add(startButton,c);
		
		//STOP
	    JButton pauseButton = new JButton("Pause");
	    pauseButton.addActionListener(new PauseTimerActionListener(timerLabel));
	    
	    c.gridx = 3;
		c.gridy = 1;
        
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    panel.add(pauseButton,c);
	    
	    
	    //RESET
	    JButton resetButton = new JButton("Reset");
	    resetButton.addActionListener(new ResetTimerActionListener(timerLabel));
	    
	    c.gridx = 3;
		c.gridy = 3;
        
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    panel.add(resetButton,c);
		
		//FINISH
	    JButton finishButton = new JButton("Finish");
	    finishButton.addActionListener(new FinishTimerActionListener(timerLabel));
	    
	    c.gridx = 3;
		c.gridy = 4;
        
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    
	    c.ipadx = 0;
	    c.ipady = 0;
	     
	    c.weightx = 1;
	    c.weighty = 1;
	    
	    c.insets = new Insets(0,0,0,0);
	     
	    c.anchor = GridBagConstraints.NORTHWEST;
	    c.fill = GridBagConstraints.BOTH;
	    
	    panel.add(finishButton,c);
	    
	    
	    
        frame.getContentPane().add(panel);
        frame.setSize(600, 300);
        frame.setLocation(700,700);
        
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
	}
}
