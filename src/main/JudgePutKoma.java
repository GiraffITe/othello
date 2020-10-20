package main;

public class JudgePutKoma {

	public void judgeUp(int y, int x, String putKoma, String reputKoma) {
		if (y > 0) {
			String next = Reversi.board[y - 1][x];
			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (y - i < 0 || Reversi.board[y - i][x].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y - i][x].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から下方向にひっくり返す駒を判定しひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	public void judgeDown(int y, int x, String putKoma, String reputKoma) {
		if (y < 6) {
			String next = Reversi.board[y + 1][x];

			if (next.equals(reputKoma)) {

				for (int i = 2; true; i++) {

					if (y + i > 7 || Reversi.board[y + i][x].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y + i][x].equals(putKoma)) {

						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から左方向にひっくり返すことができるかを判定する
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	public void judgeLeft(int y, int x, String putKoma, String reputKoma) {
		if (x > 1) {
			String next = Reversi.board[y][x - 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x - i < 0 || Reversi.board[y][x - i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y][x - i].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から右方向にひっくり返すことができるかを判定する
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputkoma
	 */
	public void judgeRight(int y, int x, String putKoma, String reputkoma) {
		if (x < 6) {
			String next = Reversi.board[y][x + 1];

			if (next.equals(reputkoma)) {
				for (int i = 2; true; i++) {
					if (x + i > 7 || Reversi.board[y][x + i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y][x + i].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から右斜め上方向にひっくり返すことができるかを判定する
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	public void judgeRightUp(int y, int x, String putKoma, String reputKoma) {
		if (x < 6 && y > 1) {
			String next = Reversi.board[y - 1][x + 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x + i > 7 || y - i < 0 || Reversi.board[y - i][x + i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y - i][x + i].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から右斜め下方向にひっくり返すことができるかを判定する
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	public void judgeRightDown(int y, int x, String putKoma, String reputKoma) {
		if (x < 6 && y < 6) {
			String next = Reversi.board[y + 1][x + 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x + i > 7 || y + i > 7 || Reversi.board[y + i][x + i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y + i][x + i].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から左斜め下方向にひっくり返すことができるかを判定する
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	public void judgeLeftDown(int y, int x, String putKoma, String reputKoma) {
		if (x > 1 && y < 6) {
			String next = Reversi.board[y + 1][x - 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x - i < 0 || y + i > 7 || Reversi.board[y + i][x - i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y + i][x - i].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

	/**
	 * 判定したい場所から左斜め上方向にひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	public void judgeLeftUp(int y, int x, String putKoma, String reputKoma) {
		if (x > 1 && y > 1) {
			String next = Reversi.board[y - 1][x - 1];
			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x - i < 0 || y - i < 0 || Reversi.board[y - i][x - i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y - i][x - i].equals(putKoma)) {
						if (putKoma.equals("●")) {
							Reversi.judgeBlack = true;
						} else if (putKoma.equals("◎")) {
							Reversi.judgeWhite = true;
						}
						break;
					}
				}
			}
		}
	}

}
