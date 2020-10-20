package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reversi extends JPanel {

	// コンストラクタ（初期化処理）
	public Reversi() {
		setPreferredSize(new Dimension(500, 550));
		addMouseListener(new MouseProc());
	}

	static String[][] board = new String[8][8];

	static final String EMPTY = "×";
	static final String BLACK = "●";
	static final String WHITE = "◎";

	static boolean canPut = false;
	static boolean judge = true;
	static int countBlack = 0;
	static int countWhite = 0;
	static boolean judgeBlack = false;
	static boolean judgeWhite = false;

	static int count = 1;

	int clickX = 0;
	int clickY = 0;

	static String message1="";
	static String message2="";


	/**
	 * 黒と白別に駒を置ける場所があるかを調査
	 * 駒を置くところがない場合次のターンに変わる
	 */
	static public void putJudge() {

		JudgePutKoma judgePutKoma = new JudgePutKoma();

		judgeBlack = false;
		judgeWhite = false;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (board[y][x].equals(EMPTY)) {
					judgePutKoma.judgeUp(y, x, BLACK, WHITE);
					judgePutKoma.judgeUp(y, x, WHITE, BLACK);
					judgePutKoma.judgeDown(y, x, BLACK, WHITE);
					judgePutKoma.judgeDown(y, x, WHITE, BLACK);
					judgePutKoma.judgeLeft(y, x, BLACK, WHITE);
					judgePutKoma.judgeLeft(y, x, WHITE, BLACK);
					judgePutKoma.judgeRight(y, x, BLACK, WHITE);
					judgePutKoma.judgeRight(y, x, WHITE, BLACK);
					judgePutKoma.judgeLeftUp(y, x, BLACK, WHITE);
					judgePutKoma.judgeLeftUp(y, x, WHITE, BLACK);
					judgePutKoma.judgeRightUp(y, x, BLACK, WHITE);
					judgePutKoma.judgeRightUp(y, x, WHITE, BLACK);
					judgePutKoma.judgeLeftDown(y, x, BLACK, WHITE);
					judgePutKoma.judgeLeftDown(y, x, WHITE, BLACK);
					judgePutKoma.judgeRightDown(y, x, BLACK, WHITE);
					judgePutKoma.judgeRightDown(y, x, WHITE, BLACK);
				}
			}
		}
	}

	static public void showBoard(int x, int y) {

		TurnKoma turnKoma = new TurnKoma();

		String putKoma = "";
		String reputKoma = "";

		canPut = false;
		judge = false;

		if (count % 2 != 0) {
			putKoma = BLACK;
			reputKoma = WHITE;
		} else {
			putKoma = WHITE;
			reputKoma = BLACK;
		}

		if (board[y][x].equals(EMPTY)) {
			turnKoma.turnDown(y, x, putKoma, reputKoma);
			turnKoma.turnUp(y, x, putKoma, reputKoma);
			turnKoma.turnRight(y, x, putKoma, reputKoma);
			turnKoma.turnLeft(y, x, putKoma, reputKoma);
			turnKoma.turnRightUp(y, x, putKoma, reputKoma);
			turnKoma.turnRightDown(y, x, putKoma, reputKoma);
			turnKoma.turnLeftUp(y, x, putKoma, reputKoma);
			turnKoma.turnLeftDown(y, x, putKoma, reputKoma);
		}

		if (canPut) {
			if (count % 2 != 0) {
				board[y][x] = putKoma;
			} else {
				board[y][x] = putKoma;
			}
			count++;
		} else {
			message2="そこに駒を置くことはできません";
		}

		putJudge();
		judge();

		if (count % 2 != 0) {
			if (judgeBlack) {
				message1="黒の番です";
			} else if (judgeWhite) {
				count++;
				message2="黒は置くことができません";
				message1="白の番です";
			} else {
				judge = false;
			}
		} else {
			if (judgeWhite) {
				message1="白の番です";
			} else if (judgeBlack) {
				count++;
				message1="白は置くことができません";
				message2="黒の番です";
			} else {
				judge = false;
			}
		}

		if(!judge) {
			if(countBlack > countWhite) {
				message1="黒の勝ち！";
			}else if(countBlack < countWhite) {
				message1="白の勝ち！";
			}else {
				message1="引き分け";
			}
		}

	}

	// 画面描画
	public void paintComponent(Graphics g) {

		// 背景
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 550);
		//盤面
		g.setColor(new Color(0, 85, 0));
		g.fillRect(50, 100, 400, 400);
		// 横線
		g.setColor(Color.black);
		for (int y = 100; y <= 500; y = y + 50) {
			g.drawLine(50, y, 450, y);
		}
		// 縦線
		for (int x = 50; x <= 450; x = x + 50) {
			g.drawLine(x, 100, x, 500);
		}
		//盤面の四角の点
		g.setColor(Color.black);
		g.fillRect(149, 199, 3, 3);
		g.fillRect(349, 399, 3, 3);
		g.fillRect(149, 399, 3, 3);
		g.fillRect(349, 199, 3, 3);

		//コマ数の表示
		g.setColor(Color.white);
		g.drawString(message1, 50, 50);
		g.drawString(message2, 50, 70);
		g.drawString("●：" + countBlack, 400, 50);
		g.drawString("○：" + countWhite, 400, 70);

		int y = 50;
		int x = 50;

		for (int i = 0; i < board.length; i++) {
			y += 50;
			x = 50;
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == "●") {
					g.setColor(Color.black);
					g.fillOval(x + 5, y + 5, 40, 40);
				}
				if (board[i][j] == "◎") {
					g.setColor(Color.white);
					g.fillOval(x + 5, y + 5, 40, 40);
				}
				x += 50;
			}
		}

	}

	static public void judge() {
		countBlack = 0;
		countWhite = 0;
		for (String[] element : board) {
			for (String ele : element) {
				if (ele == EMPTY) {
					judge = true;
				} else if (ele == BLACK) {
					countBlack++;
				} else {
					countWhite++;
				}
			}
		}
	}

	class MouseProc extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {

			message1="";
			message2="";

			int putX = 0;
			int putY = 0;
			loop1: for (int j = 50; j <= 400; j += 50) {
				putX = 0;
				for (int k = 100; k <= 450; k += 50) {
					if (e.getX() >= j && e.getX() < j + 50 && e.getY() >= k && e.getY() < k + 50) {
						break loop1;
					}
					putX++;
				}
				putY++;
			}
			showBoard(putY, putX);
			repaint();
		}
	}

	/**
	 * ゲームの初期化
	 * @return
	 */
	public static String[][] initialization() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = EMPTY;
			}
		}

		board[3][3] = BLACK;
		board[4][4] = BLACK;
		board[4][3] = WHITE;
		board[3][4] = WHITE;

		judge();
		Reversi.message1="黒の番です";

		return board;
	}

	// 起動
	public static void main(String[] args) {

		board = initialization();

		JFrame f = new JFrame();
		f.getContentPane().setLayout(new FlowLayout());
		f.getContentPane().add(new Reversi());
		f.pack();
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}