import java.util.Stack;

public class CheckAndDestroy {
	
	private static int tempScore;
	private static Stack<Integer> stack=new Stack<Integer>();
	
	public static void destroy(Ball b[][], int disX, int disY) {

		// left
		if (disY != 0) {
			if (b[disX][disY - 1].getVisible() == 1) {
				if (b[disX][disY - 1].getColorr() == b[disX][disY].getColorr()) {
					stack.push(disX);
					stack.push(disY-1);
					b[disX][disY - 1].setVisible(0);
					destroy(b, disX, disY - 1);
					setTempScore((getTempScore() + 1));
				}
			}
		}

		// down
		if (disX != 8) {
			if (b[disX + 1][disY].getVisible() == 1) {
				if (b[disX + 1][disY].getColorr() == b[disX][disY].getColorr()) {
					stack.push(disX+1);
					stack.push(disY);
					b[disX + 1][disY].setVisible(0);
					destroy(b, disX + 1, disY);
					setTempScore(getTempScore() + 1);
				}
			}
		}

		// up
		if (disX != 0) {
			if (b[disX - 1][disY].getVisible() == 1) {
				if (b[disX - 1][disY].getColorr() == b[disX][disY].getColorr()) {
					stack.push(disX-1);
					stack.push(disY);
					b[disX - 1][disY].setVisible(0);
					destroy(b, disX - 1, disY);
					setTempScore(getTempScore() + 1);
				}
			}
		}

		// right
		if (disY != 8) {
			if (b[disX][disY + 1].getVisible() == 1) {
				if (b[disX][disY + 1].getColorr() == b[disX][disY].getColorr()) {
					stack.push(disX);
					stack.push(disY+1);
					b[disX][disY + 1].setVisible(0);
					destroy(b, disX, disY + 1);
					setTempScore(getTempScore() + 1);
				}
			}
		}
		
	}
	
	public static void sta(Ball b[][], int disX, int disY,int u)
	{
		if(u==0)
		{
			while(!stack.empty())
			{
				int yj=(int) stack.pop();
				int xi=(int) stack.pop();
				b[xi][yj].setVisible(1);
			}
		}
		else
		{
			stack.clear();
		}
	}
	
	public static int getTempScore() {
		return tempScore;
	}

	public static void setTempScore(int x) {
		tempScore = x;
	}

	public static int checkMiddle(Ball b[][]) {
		if (First.difficulty == 0) {
			if (b[0][4].getVisible() == 1)
			{
				return 1;// fi kora
			}
		} else {
			if (b[1][4].getVisible() == 1)
			{
				return 1;// fi kora
			}
		}
		return 0;
	}
	
	public static int checkUnder(Ball b[][], int i1, int j1, int i2, int j2) {
		if (First.difficulty == 0) // easy
		{
			if (i1 == 8) {
				return -1;
			}
			if (b[i1 + 1][j1].getVisible() == 1) {
				return -1;// it canot move
			} 
		} else if (First.difficulty == 1 || First.difficulty == 2) // meduim
		{
			if (i2 == 8) {
				return -1;
			}
			if (j1 == j2) // t7t b3d //ball one aly fo2 & ball 2 aly t7t
			{
				if (b[i2 + 1][j1].getVisible() == 1) {
					return -1;// it canot move
				}
			} else// gmb b3d
			{
				if (b[i2 + 1][j2].getVisible() == 0 && b[i1 + 1][j1].getVisible() == 0) {
					return -1;// it canot move
				}
			}
		}
		return 0;// it can move under
	}

	public static void destroyForBlack(Ball b[][], int i, int j) {
		for (int k = 0; k < 9; k++) {
			if (b[i][k].getVisible() == 1) {
				b[i][k].setVisible(0);
			}
		}
		for (int k = i; k < 9; k++) {
			if (b[k][j].getVisible() == 1) {
				b[k][j].setVisible(0);
			}
		}
	}

	public static void gravity(Ball b[][])// sort bubble Working
	{
		for (int j = 0; j < 9; ++j) {
			for (int i = 8; i > -1; --i) {
				if (b[i][j].getVisible() == 0) {
					for (int k = i - 1; k > -1; --k) {
						if (b[k][j].getVisible() == 1) {
							b[k][j].setVisible(0);
							b[i][j].setVisible(1);
							b[i][j].setColorr(b[k][j].getColorr());
							break;
						}
					}
				}
			}
		}
	}

}
