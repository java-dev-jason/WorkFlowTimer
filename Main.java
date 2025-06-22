import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private Timer Time = null;
	private JTextField txtSeconds;
	private JTextField txtPauseTime;
	private int seconds = 25 * 60;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTimer = new JLabel("00:00");
		lblTimer.setFont(new Font("Arial", Font.PLAIN, 48));
		lblTimer.setBounds(163, 62, 133, 48);
		frame.getContentPane().add(lblTimer);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(27, 87, 89, 23);
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Time == null || !Time.isAlive()) {
					Time = new Timer();
					Time.setSeconds(seconds);
					Time.setRunning(true);
					Time.setLblTimer(lblTimer);
					Time.start();
				}
			}
			
		});
		frame.getContentPane().add(btnStart);
		
		JButton btnEnd = new JButton("End");
		btnEnd.setBounds(336, 87, 89, 23);
		btnEnd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Time.setRunning(false);
				lblTimer.setText("00:00");
			}
			
		});
		frame.getContentPane().add(btnEnd);
		
		JLabel lblSeconds = new JLabel("Work Time:");
		lblSeconds.setBounds(20, 186, 66, 14);
		frame.getContentPane().add(lblSeconds);
		
		txtSeconds = new JTextField();
		txtSeconds.setBounds(90, 186, 39, 14);
		txtSeconds.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seconds = Integer.valueOf(txtSeconds.getText());
			}
			
		});
		frame.getContentPane().add(txtSeconds);
		txtSeconds.setColumns(10);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(181, 138, 89, 23);
		btnPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnPause.getText().equals("Pause")) {
					Time.Pause();
					btnPause.setText("Continue");
				}else {
					Time.Continue();
					btnPause.setText("Pause");
				}
			}
			
		});
		frame.getContentPane().add(btnPause);
		
		JLabel lblPauseTime = new JLabel("Pause Time:");
		lblPauseTime.setBounds(152, 186, 79, 14);
		frame.getContentPane().add(lblPauseTime);
		
		txtPauseTime = new JTextField();
		txtPauseTime.setColumns(10);
		txtPauseTime.setBounds(231, 186, 39, 14);
		txtPauseTime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Time.setPauseSeconds(Integer.valueOf(txtPauseTime.getText()));
			}
			
		});
		frame.getContentPane().add(txtPauseTime);
	}
}
