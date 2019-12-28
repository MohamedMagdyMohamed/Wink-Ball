import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;

// floodfill algorithm//--------------------->

public class Play extends JPanel {

	private int xBallOne = 0, yBallOne = 4, xBallTwo = 1, yBallTwo = 4;
	private int c;
	public static int score;
	Random random = new Random();
	Ball b[][] = new Ball[9][9];

	private int diameter;
	public Timer timer = new Timer(1000, new TimerListener());
	
	public void drclaration() {

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				b[i][j] = new Ball();
			}
		}
		for (int i = 6; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				b[i][j].setVisible(1);
				b[i][j].setColorr(random.nextInt(First.colorr) + 3);
			}
		}
	}

	public Play() {
		
		setBackground(Color.DARK_GRAY);
		drclaration();
		timer.start();
		setFocusable(true);
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ee) {
				if ((ee.getKeyCode() == KeyEvent.VK_RIGHT || ee.getKeyCode() == KeyEvent.VK_R) && b[xBallOne][yBallOne].getVisible()==1) {
					if (First.difficulty == 0) // easy
					{
						if (yBallOne < 8) {
							if (b[xBallOne][yBallOne + 1].getVisible() == 0) {
								redraw(xBallOne, yBallOne, 0, 1);
								yBallOne++;
							}
						}
					} else if (First.difficulty == 1 || First.difficulty == 2) // meduim // hard
					{
						if (yBallOne == yBallTwo) {
							if (yBallOne < 8 && yBallTwo < 8) {
								if (b[xBallOne][yBallOne + 1].getVisible() == 0
										&& b[xBallTwo][yBallTwo + 1].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, 0, 1);
									yBallTwo++;
									redraw(xBallOne, yBallOne, 0, 1);
									yBallOne++;
								}
							}
						} else if (xBallOne == xBallTwo) {
							if (yBallTwo < 8) {
								if (b[xBallTwo][yBallTwo + 1].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, 0, 1);
									yBallTwo++;
									redraw(xBallOne, yBallOne, 0, 1);
									yBallOne++;
								}
							}
						}
					}
				} else if ((ee.getKeyCode() == KeyEvent.VK_LEFT || ee.getKeyCode() == KeyEvent.VK_L) && b[xBallOne][yBallOne].getVisible()==1) {
					if (First.difficulty == 0) // easy
					{
						if (yBallOne > 0) {
							if (b[xBallOne][yBallOne - 1].getVisible() == 0) {
								redraw(xBallOne, yBallOne, 0, -1);
								yBallOne--;
							}
						}
					} else if (First.difficulty == 1 || First.difficulty == 2) // meduim // hard
					{
						if (yBallOne == yBallTwo) // t7t b3d
						{
							if (yBallOne > 0 && yBallTwo > 0) {
								if (b[xBallOne][yBallOne - 1].getVisible() == 0
										&& b[xBallTwo][yBallTwo - 1].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, 0, -1);
									yBallTwo--;
									redraw(xBallOne, yBallOne, 0, -1);
									yBallOne--;
								}
							}
						} else if (xBallOne == xBallTwo) // gmb b3d
						{
							if (yBallOne > 0) {
								if (b[xBallOne][yBallOne - 1].getVisible() == 0) {
									redraw(xBallOne, yBallOne, 0, -1);
									yBallOne--;
									redraw(xBallTwo, yBallTwo, 0, -1);
									yBallTwo--;
								}
							}
						}
					}
				} else if (ee.getKeyCode() == KeyEvent.VK_SPACE && b[xBallOne][yBallOne].getVisible()==1) {
					if (First.difficulty == 1) // Meduim
					{
						if (yBallOne == yBallTwo) // t7t b3d
						{
							if (yBallTwo < 8) {
								if (b[xBallTwo - 1][yBallTwo + 1].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, -1, 1);
									yBallTwo++;
									xBallTwo--;
								}
							}
						} else if (xBallOne == xBallTwo) // gmb b3d
						{
							if (xBallTwo < 8) {
								if (b[xBallTwo + 1][yBallTwo - 1].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, 1, -1);
									xBallTwo++;
									yBallTwo--;
								}
							}
						}
					}
				} else if ((ee.getKeyCode() == KeyEvent.VK_DOWN || ee.getKeyCode() == KeyEvent.VK_D) && b[xBallOne][yBallOne].getVisible()==1) {
					if (First.difficulty == 0) // easy
					{
						if (xBallOne < 8) {
							if (b[xBallOne + 1][yBallOne].getVisible() == 0) {
								redraw(xBallOne, yBallOne, 1, 0);
								xBallOne++;
							}
						}
					} else if (First.difficulty == 1 || First.difficulty == 2) // meduim // hard
					{
						if (yBallOne == yBallTwo) // t7t b3d
						{
							if (xBallOne < 8 && xBallTwo < 8) {
								if (b[xBallTwo + 1][yBallTwo].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, 1, 0);
									xBallTwo++;
									redraw(xBallOne, yBallOne, 1, 0);
									xBallOne++;
								}
							}
						} else if (xBallOne == xBallTwo) // gmb b3d
						{
							if (xBallOne < 8 && yBallOne < 8) {
								if (b[xBallOne + 1][yBallOne].getVisible() == 0
										&& b[xBallTwo + 1][yBallTwo].getVisible() == 0) {
									redraw(xBallTwo, yBallTwo, 1, 0);
									xBallTwo++;
									redraw(xBallOne, yBallOne, 1, 0);
									xBallOne++;
								}
							}
						}
					}
				}
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		diameter = getWidth() / 9;
		
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (b[i][j].getVisible() == 1) {
					if (b[i][j].getColorr() == 1) {
						g.setColor(Color.WHITE);
					} else if (b[i][j].getColorr() == 2) {
						g.setColor(Color.BLACK);
					} else if (b[i][j].getColorr() == 3) {
						g.setColor(Color.BLUE);
					} else if (b[i][j].getColorr() == 4) {
						g.setColor(Color.RED);
					} else if (b[i][j].getColorr() == 5) {
						g.setColor(Color.GREEN);
					} else if (b[i][j].getColorr() == 6) {
						g.setColor(Color.MAGENTA);
					} else if (b[i][j].getColorr() == 7) {
						g.setColor(Color.YELLOW);
					}
					g.fillOval(diameter * j, diameter * i, diameter, diameter);
				}
			}
		}
	}

	private void redraw(int x, int y, int xPlusOrMinus, int yPlusOrMinus) {
		b[x][y].setVisible(0);
		x += xPlusOrMinus;
		y += yPlusOrMinus;
		b[x][y].setColorr(b[x - xPlusOrMinus][y - yPlusOrMinus].getColorr());
		b[x][y].setVisible(1);
	}

	private void newBallCoordination() {
		xBallOne = 0;
		yBallOne = 4;
		xBallTwo = 1;
		yBallTwo = 4;
	}

	private void addNewBall(int x, int y) {
		if (First.expert == 1) {
			b[x][y].setColorr(random.nextInt(First.colorr) + 3);
		} else {
			b[x][y].setColorr(random.nextInt(2 + First.colorr) + 1);
		}
		b[x][y].setVisible(1);
	}

	private void readAndWrite() {
		try {
			File file = new File("Score.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			bufferedReader.close();
			String parts[] = line.split("\t");
			if (score > Integer.parseInt(parts[1])) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Score.txt"))) {
					bw.write(First.name);
					bw.write("\t");
					bw.write(String.valueOf(score));
					bw.close();
				} catch (IOException e1) {
					
				}
			}
		} catch (Exception e2) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("Score.txt"))) {
				bw.write(First.name);
				bw.write("\t");
				bw.write(String.valueOf(score));
				bw.close();
			} catch (IOException e1) {
				
			}
		}
	}

	private void destroyBall(int x, int y) {
		CheckAndDestroy.destroy(b, x, y);
		if (CheckAndDestroy.getTempScore() < First.busting) {
			CheckAndDestroy.sta(b, x, y, 0);
		} else {
			CheckAndDestroy.sta(b, x, y, 1);
			score += CheckAndDestroy.getTempScore();
		}
		CheckAndDestroy.setTempScore(0);
	}

	private void destroyWhite(int x, int y) {

		int[][] numberOfColors = new int[2][4];

		for (int i = 0; i < numberOfColors.length; ++i) {
			numberOfColors[0][i] = 1;
		}

		if (x != 0 && b[x - 1][y].getVisible() == 1) // up
		{
			b[x][y].setColorr(b[x - 1][y].getColorr());
			CheckAndDestroy.destroy(b, x, y);
			CheckAndDestroy.sta(b, x, y, 0);
			numberOfColors[0][0] = b[x - 1][y].getColorr();
			numberOfColors[1][0] = CheckAndDestroy.getTempScore();
			CheckAndDestroy.setTempScore(0);
		}
		if (x != 8 && b[x + 1][y].getVisible() == 1) // down
		{
			b[x][y].setColorr(b[x + 1][y].getColorr());
			CheckAndDestroy.destroy(b, x, y);
			CheckAndDestroy.sta(b, x, y, 0);
			numberOfColors[0][1] = b[x + 1][y].getColorr();
			numberOfColors[1][1] = CheckAndDestroy.getTempScore();
			CheckAndDestroy.setTempScore(0);
		}
		if (y != 8 && b[x][y + 1].getVisible() == 1) // right
		{
			b[x][y].setColorr(b[x][y + 1].getColorr());
			CheckAndDestroy.destroy(b, x, y);
			CheckAndDestroy.sta(b, x, y, 0);
			numberOfColors[0][2] = b[x][y + 1].getColorr();
			numberOfColors[1][2] = CheckAndDestroy.getTempScore();
			CheckAndDestroy.setTempScore(0);
		}
		if (y != 0 && b[x][y - 1].getVisible() == 1) // left
		{
			b[x][y].setColorr(b[x][y - 1].getColorr());
			CheckAndDestroy.destroy(b, x, y);
			CheckAndDestroy.sta(b, x, y, 0);
			numberOfColors[0][3] = b[x][y - 1].getColorr();
			numberOfColors[1][3] = CheckAndDestroy.getTempScore();
			CheckAndDestroy.setTempScore(0);
		}
		int max = 0;
		int maxindexat = 0;
		for (int j = 0; j < 4; j++) {
			if (numberOfColors[1][j] > max) {
				max = numberOfColors[1][j];
			}
		}
		for (int jj = 0; jj < 4; jj++) {

			if (max == numberOfColors[1][jj]) {
				maxindexat = jj;
				break;
			}
		}
		b[x][y].setColorr(numberOfColors[0][maxindexat]);
	}

	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			////////////////////////// Easy //////////////////////////////
			if (First.difficulty == 0)
			{
				if (CheckAndDestroy.checkMiddle(b) == 0 && c == 0) {
					addNewBall(0, 4);
					repaint();
					c++;
					return;
				} else {
					if (CheckAndDestroy.checkUnder(b, xBallOne, yBallOne, xBallTwo, yBallTwo) == -1) {
						if (b[xBallOne][yBallOne].getColorr() == 2) {
							CheckAndDestroy.destroyForBlack(b, xBallOne, yBallOne);
						} else if (b[xBallOne][yBallOne].getColorr() == 1) {
							destroyWhite(xBallOne, yBallOne);
							destroyBall(xBallOne, yBallOne);
						} else {
							destroyBall(xBallOne, yBallOne);
						}
						CheckAndDestroy.gravity(b);
						Second.tf2.setText(String.valueOf(score));
						c = 0;
						newBallCoordination();
					} else {
						redraw(xBallOne, yBallOne, 1, 0);
						xBallOne++;
						repaint();
					}
				}
			}
			/////////////////////////// Medium And Hard ////////////////////////
			else if (First.difficulty == 1 || First.difficulty == 2)
			{
				if (CheckAndDestroy.checkMiddle(b) == 0 && c == 0) {
					addNewBall(0, 4);
					addNewBall(1, 4);
					repaint();
					c++;
					return;
				} else {
					if (CheckAndDestroy.checkUnder(b, xBallOne, yBallOne, xBallTwo, yBallTwo) == -1) {
						if (b[xBallTwo][yBallTwo].getColorr() == 2) {
							if (b[xBallTwo - 1][yBallTwo].getVisible() == 1) {
								b[xBallTwo - 1][yBallTwo].setVisible(0);
								score++;
							}
							CheckAndDestroy.destroyForBlack(b, xBallTwo, yBallTwo);
						} else if (b[xBallTwo][yBallTwo].getColorr() == 1) {
							destroyWhite(xBallTwo, yBallTwo);
							destroyBall(xBallTwo, yBallTwo);
						} else {
							destroyBall(xBallTwo, yBallTwo);
						}
						if (b[xBallOne][yBallOne].getVisible() == 1) {
							if (b[xBallOne][yBallOne].getColorr() == 2) {
								CheckAndDestroy.destroyForBlack(b, xBallOne, yBallOne);
							} else if (b[xBallOne][yBallOne].getColorr() == 1) {
								destroyWhite(xBallOne, yBallOne);
								destroyBall(xBallOne, yBallOne);
							} else {
								destroyBall(xBallOne, yBallOne);
							}
						}
						Second.tf2.setText(String.valueOf(score));
						CheckAndDestroy.gravity(b);
						c = 0;
						newBallCoordination();
					} else {
						redraw(xBallTwo, yBallTwo, 1, 0);
						xBallTwo++;
						redraw(xBallOne, yBallOne, 1, 0);
						xBallOne++;
						repaint();
					}
				}
			}
			////////////////////////// Check For Losing //////////////////////
			if (CheckAndDestroy.checkMiddle(b) == 1
					&& CheckAndDestroy.checkUnder(b, xBallOne, yBallOne, xBallTwo, yBallTwo) == -1) {
				timer.stop();
				System.out.println("you lose");
				if (score > 0) {
					readAndWrite();
				}
				JOptionPane.showMessageDialog(null, "You Lose");
			}
			//////////////////////////////////////////////////////////////////////
		}
	}
}
