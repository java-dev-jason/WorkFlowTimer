import javax.swing.JLabel;

public class Timer extends Thread{
	private int seconds = 25 * 60;
	private int workTimeSeconds = 25 * 60;
	private int pauseSeconds = 5 * 60;
	private boolean running = true;
	private boolean paused = false;
	private boolean workTime = true;
	JLabel lblTimer = new JLabel("00:00");
	
	public Timer() {}
	
	@Override
	public void run() {
		for(int i = 0; seconds >= 0 && running == true; i++) {
			if(!paused) {
				seconds--;
				
				int minLeft = seconds / 60;
				int secLeft = seconds % 60;
	            String timeText = String.format("%02d:%02d", minLeft, secLeft);
				
				lblTimer.setText(timeText);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}	
				
			}else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(seconds == 0) {
				if(workTime == true) {
					workTime = false;
					seconds = pauseSeconds;
				}else {
					workTime = true;
					seconds = workTimeSeconds;
				}
			}
		}
	}
	
	public void setLblTimer(JLabel lblTimer) {
		this.lblTimer = lblTimer;
	}

	public void setPauseSeconds(int pauseSeconds) {
		this.pauseSeconds = pauseSeconds;
	}
	
	public void Pause() {
		paused = true;
	}
	
	public void Continue() {
		paused = false;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.workTimeSeconds = seconds;
		this.seconds = seconds;
	}
}
