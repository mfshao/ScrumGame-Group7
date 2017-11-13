package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import countdownTimer.CountdownTimerLabel;
import question.IQuestion;
import question.Question;

public class QuestionSelectActionListener implements ActionListener {
	private Question question;
	private JTextArea questionL;
	private JTextArea answerL;
	private CountdownTimerLabel timer;
	
	public QuestionSelectActionListener(IQuestion question, JTextArea questionL, JTextArea answerL, CountdownTimerLabel timer) {
		this.question = (Question) question;
		this.questionL = questionL;
		this.answerL = answerL;
		this.timer = timer;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		questionL.setText(question.getQuestion());
		if (timer.isFinished()) {
			answerL.setText(question.getAnswer());
		}
		else {
			answerL.setText("");
		}
	}
}
