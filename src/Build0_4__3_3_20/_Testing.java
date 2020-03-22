package Build0_4__3_3_20;

public class _Testing {
	
	public static void main (String args[]) {
		
		Chess chess = new Chess();
		
		// Creating pieces
		
		King king = new King(true, new Coords(2,0));
		
		chess.placePiece(king, king.abspos);
		
		Tower tower = new Tower(false, new Coords(5,0));
		
		chess.placePiece(tower, tower.abspos);
		
		Pawn dummy1 = new Pawn(true, new Coords(4,1));
		
		chess.placePiece(dummy1, dummy1.abspos);
		
		Pawn dummy2 = new Pawn(true, new Coords(5,6));
		
		chess.placePiece(dummy2, dummy2.abspos);
		
		/* Tower tower = new Tower(false, new Coords(7,0));
		
		chess.placePiece(tower, tower.abspos);
		
		Bishop bishop = new Bishop(false, new Coords(7,5));
		
		chess.placePiece(bishop, bishop.abspos); */
		
		
		
		// Try to move pieces
		
		System.out.println(chess.board[5][6].moveTo(chess.board[5][6].abspos, new Coords(5,5), chess.board));
		System.out.println("------------------");
		
		System.out.println(chess.board[4][1].moveTo(chess.board[4][1].abspos, new Coords(5,0), chess.board));
		System.out.println("------------------");
		
		/* System.out.println(chess.board[3][4].moveTo(chess.board[3][4].abspos, new Coords(3,3), chess.board));
		System.out.println("------------------");
		
		System.out.println(chess.board[4][5].moveTo(chess.board[4][5].abspos, new Coords(3,5), chess.board));
		System.out.println("------------------");
		
		System.out.println(chess.board[4][5].moveTo(chess.board[4][5].abspos, new Coords(3,6), chess.board));
		System.out.println("------------------"); */
		
	}

}
