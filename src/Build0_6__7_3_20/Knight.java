package Build0_6__7_3_20;

public class Knight extends Piece {
	
	Knight (boolean colour, Coords inipos) {
		
		super(colour, inipos);
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board) {
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
					
			// System.out.println("Piece is accessing a legal move (regarding boundaries)");
			
			if (Math.abs(origin.x-destiny.x)==2) {
				
				// System.out.println("On check 2 X2");
				
				if (Math.abs(origin.y-destiny.y)==1) {
					
					// System.out.println("Shift 2 on X, 1 on Y. Legal move");
					
					if (landing(destiny,board)) {
						
						// System.out.println("On check");
						
						return checkcheck(origin, destiny, board);
						
					}
					
					else return false;
					
				}
				
				else {
					
					return false; // System.out.println("Y shift too big");
					
				}
				
			}
			
			else if (Math.abs(origin.y-destiny.y)==2) {
				
				// System.out.println("On check 2 Y2"); // Second time it doesn't even enter landing();
				
				if (Math.abs(origin.x-destiny.x)==1) {
					
					// System.out.println("Shift 2 on Y, 1 on X. Legal move");
					
					if (landing(destiny,board)) {
						
						// System.out.println("On check");
						
						return checkcheck(origin, destiny, board);
						
					}
					
					else return false;
					
				}
				
				else {
					
					return false; // System.out.println("X shift too big");
					
				}
				
			}
			
			else {
				
				return false; // System.out.println("Knight tried to move out of range. Either x or y shift too big");
				
			}
					
		}
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board, boolean abstraction) {
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
					
			// System.out.println("Piece is accessing a legal move (regarding boundaries)");
			
			if (Math.abs(origin.x-destiny.x)==2) {
				
				// System.out.println("On check 2 X2");
				
				if (Math.abs(origin.y-destiny.y)==1) {
					
					// System.out.println("Shift 2 on X, 1 on Y. Legal move");
					
					return landing(destiny,board);
					
				}
				
				else {
					
					return false; // System.out.println("Y shift too big");
					
				}
				
			}
			
			else if (Math.abs(origin.y-destiny.y)==2) {
				
				// System.out.println("On check 2 Y2"); // Second time it doesn't even enter landing();
				
				if (Math.abs(origin.x-destiny.x)==1) {
					
					// System.out.println("Shift 2 on Y, 1 on X. Legal move");
					
					return (landing(destiny,board));
					
				}
				
				else {
					
					return false; // System.out.println("X shift too big");
					
				}
				
			}
			
			else {
				
				return false; // System.out.println("Knight tried to move out of range. Either x or y shift too big");
				
			}
					
		}
		
	}
	
	public boolean landing(Coords destiny, Piece[][] board) {
		
		return super.landing(destiny, board);
		
	}
	
	public boolean checkcheck(Coords origin, Coords destiny, Piece[][] board) {
		
		// Spin it : If the action fails, the pieces are re-created in their original position
		
		// boolean found = false;
		
		board[origin.x][origin.y] = null;
		
		board[destiny.x][destiny.y] = new Knight(this.colour, new Coords(destiny.x,destiny.y));
		
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
							
							board[origin.x][origin.y] = new Knight(this.colour, new Coords(origin.x,origin.y));
							
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
							
							board[origin.x][origin.y] = new Knight(this.colour, new Coords(origin.x,origin.y));
							
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
