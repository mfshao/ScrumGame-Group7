package countdownTimer;

import java.awt.Font;
import java.awt.Label;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimerLabel extends Label {
	private Timer timer = new Timer();
	private double numInMinTotal;
	private boolean finished = false;
	private int[] timeRemaining = new int[2];
	
	public  CountdownTimerLabel(double numInMins) {
		this.numInMinTotal = numInMins;
		timeRemaining[0] = (int) Math.floor(numInMins);
		timeRemaining[1] = (int) ((numInMins - timeRemaining[0]) * 60);
		setAlignment(CENTER);
		setFont(new Font ("Arial Black",Font.BOLD,20));
		setText(String.format("%02d", timeRemaining[0]) + ":" + String.format("%02d", timeRemaining[1]));
	}
	
	public void setTimeRemainingText() {
		setText(String.format("%02d", timeRemaining[0]) + ":" + String.format("%02d", timeRemaining[1]));
	}
	
	public void printTimeRemaining() {
		System.out.println(String.format("%02d", timeRemaining[0]) + ":" + String.format("%02d", timeRemaining[1]));
	}
	
	public void reCalTimeRemaining() {
	
    	if (timeRemaining[1] < 0) {
			if (timeRemaining[0] == 0) {
				timeRemaining[1] = 0;
				timer.cancel();
				finished = true;
			}
			else {
				timeRemaining[0] -= 1;
				timeRemaining[1] += 60;
			}
		}
		
	}
	
	public void countDown(){
		timer = new Timer();
        timer.schedule( new TimerTask(){
            public void run(){
            	timeRemaining[1] -= 1;
            	reCalTimeRemaining();
            	setTimeRemainingText();
            	
            }
        },0, 1000);
	}
	
	
	public void pause() {
		timer.cancel();
	}
	
	public void reset () {
		timeRemaining[0] = (int) Math.floor(numInMinTotal);
		timeRemaining[1] = (int) ((numInMinTotal - timeRemaining[0]) * 60);
		setTimeRemainingText();
		finished = false;
		
	}
	
	public void finish() {
		timer.cancel();
		timeRemaining[0] = 0;
		timeRemaining[1] = 0;
		setTimeRemainingText();
		
		finished = true;
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public double getTimeInMinTotal() {
		return numInMinTotal;
	}
	public String getTimeRemaining() {
		return String.valueOf(timeRemaining[0]) + ":" + String.valueOf(timeRemaining[1]);
	}
	
}
