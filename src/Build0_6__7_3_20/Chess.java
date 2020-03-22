package Build0_6__7_3_20;

public class Chess {
	
	Piece[][] board = new Piece[8][8];
	
	public void placePiece(Piece piece) {
		
		board[piece.abspos.x][piece.abspos.y] = piece;
		
	}
	
}
