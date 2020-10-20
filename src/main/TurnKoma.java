package main;

public class TurnKoma {

	/**
	 * 駒を置いた場所から下方向にひっくり返す駒を判定しひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnDown(int y, int x, String putKoma, String reputKoma) {
		if (y < 6) {
			String next = Reversi.board[y + 1][x];

			if (next.equals(reputKoma)) {

				for (int i = 2; true; i++) {

					if (y + i > 7 || Reversi.board[y + i][x].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y + i][x].equals(putKoma)) {

						for (int j = 1; j < i; j++) {
							Reversi.board[y + j][x] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から上方向にひっくり返す駒を判定しひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnUp(int y, int x, String putKoma, String reputKoma) {
		if (y > 0) {
			String next = Reversi.board[y - 1][x];

			if (next.equals(reputKoma)) {

				for (int i = 2; true; i++) {

					if (y - i < 0 || Reversi.board[y - i][x].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y - i][x].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y - j][x] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から左方向にひっくり返す駒を判定してひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnLeft(int y, int x, String putKoma, String reputKoma) {
		if (x > 1) {
			String next = Reversi.board[y][x - 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x - i < 0 || Reversi.board[y][x - i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y][x - i].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y][x - j] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から右方向にひっくり返す駒を判定してひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputkoma
	 */
	 public void turnRight(int y, int x, String putKoma, String reputkoma) {
		if (x < 6) {
			String next = Reversi.board[y][x + 1];

			if (next.equals(reputkoma)) {
				for (int i = 2; true; i++) {
					if (x + i > 7 || Reversi.board[y][x + i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y][x + i].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y][x + j] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から右斜め上方向にひっくり返す駒を判定してひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnRightUp(int y, int x, String putKoma, String reputKoma) {
		if (x < 6 && y > 1) {
			String next = Reversi.board[y - 1][x + 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x + i > 7 || y - i < 0 || Reversi.board[y - i][x + i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y - i][x + i].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y - j][x + j] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から右斜め下方向にひっくり返す駒を判定してひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnRightDown(int y, int x, String putKoma, String reputKoma) {
		if (x < 6 && y < 6) {
			String next = Reversi.board[y + 1][x + 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x + i > 7 || y + i > 7 || Reversi.board[y + i][x + i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y + i][x + i].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y + j][x + j] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から左斜め下方向にひっくり返す駒を判定してひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnLeftDown(int y, int x, String putKoma, String reputKoma) {
		if (x > 1 && y < 6) {
			String next = Reversi.board[y + 1][x - 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x - i < 0 || y + i > 7 || Reversi.board[y + i][x - i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y + i][x - i].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y + j][x - j] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}

	/**
	 * 駒を置いた場所から左斜め上方向にひっくり返す駒を判定してひっくり返す
	 * @param y
	 * @param x
	 * @param putKoma
	 * @param reputKoma
	 */
	 public void turnLeftUp(int y, int x, String putKoma, String reputKoma) {
		if (x > 1 && y > 1) {
			String next = Reversi.board[y - 1][x - 1];

			if (next.equals(reputKoma)) {
				for (int i = 2; true; i++) {
					if (x - i < 0 || y - i < 0 || Reversi.board[y - i][x - i].equals(Reversi.EMPTY)) {
						break;
					} else if (Reversi.board[y - i][x - i].equals(putKoma)) {
						for (int j = 1; j < i; j++) {
							Reversi.board[y - j][x - j] = putKoma;
						}
						Reversi.canPut = true;
						break;
					}
				}
			}
		}
	}


}
