import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class MultipleBouncingWithOneTimer{
	private JFrame frame;
	private int WIDTH = 300, HEIGHT = 200;
	private int DELAY = 10, IMAGE_SIZE = 40;
	Timer timer;
	JButton b,b1,b2;

	ArrayList<PosImageIconWithDirection> list = new ArrayList<>();
	PosImageIconWithDirection newDie=new PosImageIconWithDirection((int)(Math.random()*(WIDTH-50)),
			(int)(Math.random()*(HEIGHT-50)),
			IMAGE_SIZE, IMAGE_SIZE);	
	public MultipleBouncingWithOneTimer(int n) {
		for (int i=0; i<n; i++) {
			list.add(new PosImageIconWithDirection(
					(int)(Math.random()*(WIDTH-50)),
					(int)(Math.random()*(HEIGHT-50)),
					IMAGE_SIZE, IMAGE_SIZE));
		}
	}

	public static void main (String[] args) {
		MultipleBouncingWithOneTimer rp = new MultipleBouncingWithOneTimer(3);
		rp.go();
	}

	public void go() {
		frame = new JFrame ("Rebound");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		DrawPanel dp = new DrawPanel();
		frame.getContentPane().add(dp);
		JPanel panel=new JPanel();
		b=new JButton("시작");
		b1=new JButton("계속");
		b2=new JButton("종료");

		panel.add(b); panel.add(b1); panel.add(b2);
		b.addActionListener(new ButtonListener());
		b1.addActionListener(new ButtonListener());
		b2.addActionListener(new ButtonListener());

		frame.add(panel, BorderLayout.SOUTH);
		frame.add(dp,BorderLayout.CENTER);
		// DELAY 마이크로 초 마다 액션을 생성하는 Timer 생성. 핸들러는 ReboundListener에
		timer = new Timer(DELAY, new TimerListener());

		frame.setVisible(true);
	}

	private class DrawPanel extends JPanel {
		public void paintComponent (Graphics page) {
			for (PosImageIcon pi : list) {
				double n=Math.sqrt(Math.pow(((pi.pX+(IMAGE_SIZE/2))-newDie.pX), 2)+Math.pow(((pi.pY+(IMAGE_SIZE/2))-newDie.pY),2));
				if(n<=IMAGE_SIZE) {
					pi.Count();
				}
				pi.draw(page);
			}

			newDie.blueDraw(page);

		}
	}
	private class TimerListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			for (PosImageIconWithDirection pi : list) {
				pi.move(pi.moveX,  pi.moveY);

				if (pi.pX <= 0 || pi.pX >= WIDTH - IMAGE_SIZE)
					pi.moveX = pi.moveX * -1;

				if (pi.pY <= 0 || pi.pY >= HEIGHT - IMAGE_SIZE-65)
					pi.moveY = pi.moveY * -1;

				WIDTH = frame.getWidth();
				HEIGHT= frame.getHeight();

				frame.repaint();
			}
			newDie.move(newDie.moveX,  newDie.moveY);

			if (newDie.pX <= 0 || newDie.pX >= WIDTH - IMAGE_SIZE)
				newDie.moveX = newDie.moveX * -1;

			if (newDie.pY <= 0 || newDie.pY >= HEIGHT - IMAGE_SIZE-65)
				newDie.moveY = newDie.moveY * -1;

		}

	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b)
				timer.start();
			else if(e.getSource()==b1)
				timer.restart();
			else if(e.getSource()==b2)
				timer.stop();
		}
	}
}