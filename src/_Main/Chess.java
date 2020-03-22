package _Main;

public class Chess {
	
	Piece[][] board = new Piece[8][8];
	
	public void placePiece(Piece piece) {
		
		board[piece.abspos.x][piece.abspos.y] = piece;
		
	}
	
}
