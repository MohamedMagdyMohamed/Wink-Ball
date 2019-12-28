import javax.swing.*;

public class Tester10 {
	public static void main(String[] args) {

		First f = new First();
		f.setTitle("Wink Ball - Menu");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(320, 520);
		f.setLocation(100, 100); // ---->>> appear in the middle of the screen.
		f.setResizable(false);
		f.setVisible(true);
	}

}
