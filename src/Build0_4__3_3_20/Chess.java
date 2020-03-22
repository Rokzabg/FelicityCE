package Build0_4__3_3_20;

public class Chess {
	
	Piece[][] board = new Piece[8][8];
	
	public void placePiece(Piece piece, Coords inipos) {
		
		board[inipos.x][inipos.y] = piece;
		
	}
	
}
