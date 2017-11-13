package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import questionFrame.QuestionFrame;
import questionSet.IQuestionSet;
import questionSet.QuestionSet;

public class QuestionSetSelectActionListener implements ActionListener {

	private QuestionSet questionSet;
	
	public QuestionSetSelectActionListener(IQuestionSet questionSet) {
		this.questionSet = (QuestionSet) questionSet;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		QuestionFrame questionFrame = new QuestionFrame (questionSet);
		
		questionFrame.createFrame();
	}

	
}
