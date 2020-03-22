package Build0_4__3_3_20;

class Piece {
	
	boolean colour;
	Coords abspos;
	boolean cancast = false;
	
	Piece (boolean colour, Coords inipos) {
		
		this.colour = colour;
		abspos = inipos;
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board) {
		
		// Test only boundaries
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
			
			return false; // System.out.println("Piece tried to move out of the bounds");
			
		}
		
		else {
			
			return true; // System.out.println("Piece is accessing a legal move (regarding boundaries)");
			
		}
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board, boolean abstraction) {
		
		// Test only boundaries
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
			
			return false; // System.out.println("Piece tried to move out of the bounds");
			
		}
		
		else {
			
			return true; // System.out.println("Piece is accessing a legal move (regarding boundaries)");
			
		}
		
	}
	
	public boolean landing (Coords destiny, Piece[][] board) {
		
		if (board[destiny.x][destiny.y]==null) {
			
			return true; // System.out.println("Clean landing");
			
		}
		
		else if (board[destiny.x][destiny.y].colour==this.colour) {
			
			return false; // System.out.println("Can't land, there is a piece of the same colour here");
			
		}
		
		else {
			
			return true; // System.out.println("Killing landing");
			
		}
		
	}
	
	public boolean checkcheck(Coords destiny, Piece[][] board) {
		
		System.out.println("Entered a generic Piece checkcheck method");
		
		return false;
		
	}

}
