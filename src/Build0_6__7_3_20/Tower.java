package Build0_6__7_3_20;

public class Tower extends Piece {
	
	boolean cancast = true;
	
	Tower (boolean colour, Coords inipos) {
		
		super(colour, inipos);
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board) {
		
		cancast = false;
		
		// System.out.println(origin + " - " + destiny);
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
				
			// System.out.println("Piece tried to move out of the bounds");
			
			return false;
					
		}
				
		else {
					
			if (destiny.x != origin.x) {
				
				if (destiny.y == origin.y) {
					
					// System.out.println("Legal X shift");
					
					if (landing(destiny, board)) {
						
						// System.out.println(swipeX(origin, destiny, board));
						
						if(swipeX(origin, destiny, board)) {
							
							return checkcheck(origin, destiny, board);
							
						}
						
						else return false;
						
					}
					
					else return false;
					
				}
				
				else {
					
					return false; // System.out.println("Illegal: Y tried to move after X shift. Prioritized");
					
				}
				
			}
			
			if (destiny.y != origin.y) {
				
				if (destiny.x == origin.x) {
					
					// System.out.println("Legal Y shift");
					
					if (landing(destiny, board)) {
						
						if (swipeY(origin, destiny, board)) {
							
							return checkcheck(origin, destiny, board);
							
						}
						
						else return false;
						
					}
					
					else return false;
					
				}	
					
			}
					
		}
		
		// FAKE EXIT //
		
		return false;
				
		// --------- //
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board, boolean abstraction) {
		
		cancast = false;
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
					
			if (destiny.x != origin.x) {
				
				if (destiny.y == origin.y) {
					
					// System.out.println("Legal X shift");
					
					if (landing(destiny, board)) {
						
						return swipeX(origin, destiny, board);
						
					}
					
					else return false;
					
				}
				
				else {
					
					return false; // System.out.println("Illegal: Y tried to move after X shift. Prioritized");
					
				}
				
			}
			
			if (destiny.y != origin.y) {
				
				if (destiny.x == origin.x) {
					
					// System.out.println("Legal Y shift");
					
					if (landing(destiny, board)) {
						
						return swipeY(origin, destiny, board);
						
					}
					
					else return false;
					
				}	
					
			}
					
		}
		
		// FAKE EXIT //
		
		return false;
				
		// --------- //
		
	}
	
	public boolean landing(Coords destiny, Piece[][] board) {
		
		return super.landing(destiny, board);
		
	}
	
	public boolean swipeX (Coords origin, Coords destiny, Piece[][] board) {
		
		// System.out.println(origin + " " + destiny);
		
		int vectorshift = origin.x-destiny.x;
		
		// System.out.println(vectorshift);
		
		boolean found = false;
		
		boolean positive = vectorshift>0;
			
		for (int i=1; i<Math.abs(vectorshift);i++) {
				
			if (positive) {
					
				if (board[(origin.x-(vectorshift-i))][origin.y]!=null) found = true;
					
			}
				
			else {
					
				if (board[(origin.x-(vectorshift+i))][origin.y]!=null) found = true;
					
			}
				
		}
		
		/* if (found) {
			
			System.out.println("Failed X swipe, there was a piece in the way");
			
		}
		
		else {
			
			System.out.println("Successful X swipe, all tiles were free");
			
		} */
		
		return !found;
		
	}
	
	public boolean swipeY (Coords origin, Coords destiny, Piece[][] board) {
		
		int vectorshift = origin.y-destiny.y;
		
		boolean found = false;
		
		boolean positive = vectorshift>0;
		
		// Correct
			
		for (int i=1; i<Math.abs(vectorshift);i++) {
				
			if (positive) {
					
				if (board[origin.x][origin.y-(vectorshift-i)]!=null) found = true;
					
			}
				
			else {
					
				if (board[origin.x][origin.y-(vectorshift+i)]!=null) found = true;
					
			}
				
		}
		
		//
		
		/* if (found) {
			
			System.out.println("Failed Y swipe, there was a piece in the way");
			
		}
		
		else {
			
			System.out.println("Successful Y swipe, all tiles were free");
			
		} */
		
		return !found;
		
	}
	
	public boolean checkcheck(Coords origin, Coords destiny, Piece[][] board) {
		
		// Spin it : If the action fails, the pieces are re-created in their original position
		
		// boolean found = false;
		
		board[origin.x][origin.y] = null;
		
		board[destiny.x][destiny.y] = new Tower(this.colour, new Coords(destiny.x,destiny.y));
		
		// System.out.println("New piece on coords " + destiny.x + "," + destiny.y);
		
		if (colour) {
			
			// Check for white king
			
			// System.out.println("Check-ing white knight");
			
			for (int i=0; i<=7; i++) {
				
				for (int j=0; j<=7; j++) {
					
					if (board[i][j] instanceof King && board[i][j].colour==true) {
						
						// System.out.println("Execute only once");
						
						if ((board[i][j].checkcheck(board[i][j].abspos, board))) {
							
							// System.out.println("Changes shall be made permanent");
							
							return true;
							
						}
						
						else {
							
							board[origin.x][origin.y] = new Tower(this.colour, new Coords(origin.x,origin.y));
							
							board[destiny.x][destiny.y] = null;
							
							return false;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		else {
			
			// Check for black king
			
			// System.out.println("Check-ing black knight");
			
			for (int i=0; i<=7; i++) {
				
				for (int j=0; j<=7; j++) {
					
					if (board[i][j] instanceof King && board[i][j].colour==false) {
						
						// System.out.println("Execute only once on " + i + "," + j);
						
						// System.out.println("Executing check check on this tile: " + board[i][j].checkcheck(board[i][j].abspos, board));
						
						if ((board[i][j].checkcheck(board[i][j].abspos, board))) {
							
							// System.out.println("Changes shall be made permanent");
							
							return true;
							
						}
						
						else {
							
							board[origin.x][origin.y] = new Tower(this.colour, new Coords(origin.x,origin.y));
							
							board[destiny.x][destiny.y] = null;
							
							return false;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		// FAKE EXIT //
		
		return true;			// By defect it should be true in case there is no same-colour king on the table. But on a real game it won't execute
		
		// --------- //
		
	}

}
