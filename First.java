
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class First extends JFrame {

	public static String name = "Demo";
	public static int difficulty; // ------> 0-easy 1-meduim 2-hard
	public static int expert; // ------> 0-no 1-yes
	public static int colorr = 3;
	public static int busting = 3;

	public First() {

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// ================= Picture Panel =================================

		JPanel imagePanel = new JPanel();
		ImageIcon image = new ImageIcon(getClass().getResource("hi.jpg"));
		JLabel imageLabel = new JLabel(image);
		imagePanel.add(imageLabel);
		imagePanel.setBackground(Color.white);
		container.add(imagePanel, BorderLayout.NORTH);

		// ================== Play & Quit ==================================

		JPanel botButtons = new JPanel();
		botButtons.setLayout(new BorderLayout(5, 0));
		JButton quitButton = new JButton("Quit");
		JButton playButton = new JButton("Play");
		botButtons.add(quitButton, BorderLayout.WEST);
		botButtons.add(playButton, BorderLayout.CENTER);
		container.add(botButtons, BorderLayout.SOUTH);

		// =================== ActionListener of Quit Button==========================

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "Quit") {
					System.exit(0);
				}
			}
		});

		// =================== ActionListener of Play Button==========================

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Play")) {
					setVisible(false);
					Second s = new Second();
					s.setTitle("Wink Ball - Game");
					s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					s.setSize(511, 590);
					s.setResizable(false);
					s.setLocation(800, 100);
					s.setVisible(true);
				}
			}
		});

		// =================== Center Panel ==========================

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 1));

		// =================== Name =======================
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l = new JLabel("  Name ?");
		l.setPreferredSize(new Dimension(100, 24));
		namePanel.add(l);
		JTextField nameTextField = new JTextField("Demo", 15);
		namePanel.add(nameTextField);
		centerPanel.add(namePanel);

		nameTextField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent ee) {
				name=nameTextField.getText();
				if (name.equals("")) {
					name = "Demo";
				}
			}
		});

		// =================== Difficulty =======================

		JPanel difficultyPanel = new JPanel();
		difficultyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel difficultyLabel = new JLabel("  Difficulty ?");
		difficultyLabel.setPreferredSize(new Dimension(100, 24));
		difficultyPanel.add(difficultyLabel);

		JRadioButton easyRadioButton = new JRadioButton("Easy");
		JRadioButton mediumRadioButton = new JRadioButton("Medium");
		JRadioButton hardRadioButton = new JRadioButton("Hard");

		easyRadioButton.setSelected(true);
		ButtonGroup bg = new ButtonGroup();

		bg.add(easyRadioButton);
		bg.add(mediumRadioButton);
		bg.add(hardRadioButton);

		difficultyPanel.add(easyRadioButton);
		difficultyPanel.add(mediumRadioButton);
		difficultyPanel.add(hardRadioButton);

		centerPanel.add(difficultyPanel);

		ListnerForRadioButton lfrb = new ListnerForRadioButton();
		easyRadioButton.addActionListener(lfrb);
		mediumRadioButton.addActionListener(lfrb);
		hardRadioButton.addActionListener(lfrb);

		// ========================== Expert ==============================

		JPanel expertPanel = new JPanel();
		expertPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel expertLabel = new JLabel("  Expert ?");
		expertLabel.setPreferredSize(new Dimension(100, 24));
		expertPanel.add(expertLabel);
		JCheckBox jcb = new JCheckBox("Yes");
		expertPanel.add(jcb);
		centerPanel.add(expertPanel);

		jcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcb.isSelected()) {
					expert = 1;
				} else {
					expert = 0;
				}
			}
		});

		// ===================== Colors ============================

		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel colorLabel = new JLabel("  Colors ?");
		colorLabel.setPreferredSize(new Dimension(100, 24));
		colorPanel.add(colorLabel);

		String colorNumbers[] = { "3", "4", "5" };
		JComboBox jc = new JComboBox(colorNumbers);
		colorPanel.add(jc);
		centerPanel.add(colorPanel);

		jc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jc.getSelectedIndex() == 0) {
					colorr = 3;
				} else if (jc.getSelectedIndex() == 1) {
					colorr = 4;
				} else if (jc.getSelectedIndex() == 2) {
					colorr = 5;
				}
			}
		});

		// ================ Busting ====================

		JPanel BustingPanel = new JPanel();
		BustingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel BustingButton = new JLabel("  Busting ?");
		BustingButton.setPreferredSize(new Dimension(100, 24));
		BustingPanel.add(BustingButton);
		SpinnerNumberModel sp = new SpinnerNumberModel(3, 3, 5, 1);
		JSpinner jsp = new JSpinner(sp);
		jsp.setPreferredSize(new Dimension(40, 20));
		BustingPanel.add(jsp);
		centerPanel.add(BustingPanel);

		jsp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if ((int) jsp.getValue() == 3) {
					busting = 3;
				} else if ((int) jsp.getValue() == 4) {
					busting = 4;
				} else if ((int) jsp.getValue() == 5) {
					busting = 5;
				}
			}
		});

		container.add(centerPanel, BorderLayout.CENTER);
	}

	class ListnerForRadioButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Easy")) {
				difficulty = 0;
			} else if (e.getActionCommand().equals("Medium")) {
				difficulty = 1;
			} else if (e.getActionCommand().equals("Hard")) {
				difficulty = 2;
			}
		}
	}
}
