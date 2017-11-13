package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import countdownTimer.CountdownTimerLabel;

public class FinishTimerActionListener implements ActionListener {
	private CountdownTimerLabel timer;
	
	public FinishTimerActionListener(CountdownTimerLabel timer) {
		this.timer = timer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.finish();
	}	
}
