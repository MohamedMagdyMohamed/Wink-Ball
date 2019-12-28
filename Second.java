import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Second extends JFrame {

	JPanel p1;
	public static JTextField tf2;

	public Second() {
		Container c2 = getContentPane();
		c2.setLayout(new BorderLayout());

		Play game = new Play();
		c2.add(game, BorderLayout.CENTER);

		p1 = new JPanel();
		p1.setLayout(new BorderLayout(5, 0));
		JButton b1 = new JButton("Menue");
		JButton b2 = new JButton("Restart");
		p1.add(b1, BorderLayout.WEST);
		p1.add(b2, BorderLayout.CENTER);
		c2.add(p1, BorderLayout.SOUTH);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Menue")) {
					game.timer.setRepeats(false);
					First.name = "Demo";
					First.difficulty = 0;
					First.expert = 0;
					First.colorr = 3;
					First.busting = 3;
					Play.score = 0;
					dispose();

					First f = new First();
					f.setTitle("Wink Ball - Menu");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(320, 520);
					f.setLocation(100, 100);
					f.setResizable(false);
					f.setVisible(true);
				}
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Restart")) {
					game.timer.setRepeats(false);
					Play.score = 0;
					dispose();

					Second s = new Second();
					s.setTitle("Wink Ball - Game");
					s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					s.setSize(511, 590);
					s.setLocation(800, 100);
					s.setVisible(true);
					s.setResizable(false);
				}
			}
		});

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 3));

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l1 = new JLabel("Player");
		p3.add(l1);
		JTextField tf1 = new JTextField(First.name, 10);
		tf1.setBackground(Color.WHITE);
		tf1.setEditable(false);
		p3.add(tf1);
		p2.add(p3);

		JPanel p4 = new JPanel();
		JLabel l2 = new JLabel("Score");
		p4.add(l2);
		tf2 = new JTextField("0", 10);
		tf2.setBackground(Color.WHITE);
		tf2.setEditable(false);
		p4.add(tf2);
		p2.add(p4);

		JPanel p5 = new JPanel();
		JLabel l3 = new JLabel("Top");
		p5.add(l3);
		JTextField tf3 = new JTextField(10);
		tf3.setBackground(Color.WHITE);
		tf3.setEditable(false);

		try {
			File file = new File("Score.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			tf3.setText(bufferedReader.readLine());
			bufferedReader.close();
			p5.add(tf3);
			p2.add(p5);
		} catch (IOException e) {

		}

		tf1.setFocusable(false);
		tf2.setFocusable(false);
		tf3.setFocusable(false);

		c2.add(p2, BorderLayout.NORTH);

	}

}
