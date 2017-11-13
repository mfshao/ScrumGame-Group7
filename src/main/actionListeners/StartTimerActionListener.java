package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import countdownTimer.CountdownTimerLabel;

public class StartTimerActionListener implements ActionListener {
	private CountdownTimerLabel timer;
	
	public StartTimerActionListener(CountdownTimerLabel timer) {
		this.timer = timer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.countDown();
	}	
}
