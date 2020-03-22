package Build0_8__10_3_20;

public class Pawn extends Piece {
	
	Pawn (boolean colour, Coords inipos) {
		
		super(colour, inipos);
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board) {
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
			
			// Base movement
			
			if (colour==true) {
				
				if (origin.y-destiny.y==1) {
					
					// System.out.println("White tries to move forward");
					
					if (origin.x-destiny.x==0) {
						
						if (board[destiny.x][destiny.y]!=null) {
							
							return false; // System.out.println("White tried to move to a busy tile");
							
						}
						
						else {
							
							if (destiny.y==0) {
								
								System.out.println("Promotion triggered for white");
								
								return checkcheck(origin, destiny, board);
								
							}
							
							return checkcheck(origin, destiny, board);
							
						}
						
					}
					
					else if (Math.abs(origin.x-destiny.x)==1) {
												
						if (board[destiny.x][destiny.y]==null) {
							
							return false; // System.out.println("Nothing on diagonal. White can't interact");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==true){
							
							return false; // System.out.println("White cannot kill white");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==false) {
							
							if (destiny.y==0) {
								
								System.out.println("Promotion triggered for white");
								
								return checkcheck(origin, destiny, board);
								
							}
							
							return checkcheck(origin, destiny, board);
							
						}
						
					}
					
					else {
						
						return false; // System.out.println("White moves out of range, X checked");
						
					}
					
				}
				
				else {
					
					return false; // System.out.println("Y shift is not possible for this WHITE piece");
					
				}
				
			}
			
			else {
				
				if (origin.y-destiny.y==-1) {
					
					// System.out.println("Black tries to move forward");
					
					if (origin.x-destiny.x==0) {
						
						if (board[destiny.x][destiny.y]!=null) {
							
							return false; // System.out.println("Black tried to move to a busy tile");
							
						}
						
						else {
							
							if (destiny.y==7) {
								
								System.out.println("Promotion triggered for black");
								
								return checkcheck(origin, destiny, board);
								
							}
							
							return checkcheck(origin, destiny, board);
							
						}
						
					}
					
					else if (Math.abs(origin.x-destiny.x)==1) {
						
						if (board[destiny.x][destiny.y]==null) {
							
							return false; // System.out.println("Nothing on diagonal. Black can't interact");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==false){
							
							return false; // System.out.println("Black cannot kill black");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==true) {
							
							if (destiny.y==7) {
								
								System.out.println("Promotion triggered for black");
								
								return checkcheck(origin, destiny, board);
								
							}
							
							return checkcheck(origin, destiny, board);
							
						}				
											
					}
					
					else {
						
						return false; // System.out.println("Black moves out of range, X checked");
						
					}
					
				}
				
				else {
					
					return false; // System.out.println("Y shift is not possible for this BLACK piece");
					
				}
				
			}
		
		}
		
		// FAKE EXIT //
		
		return false;
		
		// --------- //
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board, boolean abstraction) {
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
			
			// Base movement
			
			if (colour==true) {
				
				if (origin.y-destiny.y==1) {
					
					// System.out.println("White tries to move forward");
					
					if (origin.x-destiny.x==0) {
						
						if (board[destiny.x][destiny.y]!=null) {
							
							return false; // System.out.println("White tried to move to a busy tile");
							
						}
						
						else {
							
							return true; // System.out.println("Clean landing for white");
							
						}
						
					}
					
					else if (Math.abs(origin.x-destiny.x)==1) {
												
						if (board[destiny.x][destiny.y]==null) {
							
							return false; // System.out.println("Nothing on diagonal. White can't interact");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==true){
							
							return false; // System.out.println("White cannot kill white");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==false) {
							
							return true; // System.out.println("Killing landing for white");
							
						}
						
					}
					
					else {
						
						return false; // System.out.println("White moves out of range, X checked");
						
					}
					
				}
				
				else {
					
					return false; // System.out.println("Y shift is not possible for this WHITE piece");
					
				}
				
				if (destiny.y==0) {
					
					System.out.println("Promotion triggered for white");
					
					return true;
					
				}
				
			}
			
			else {
				
				if (origin.y-destiny.y==-1) {
					
					// System.out.println("Black tries to move forward");
					
					if (origin.x-destiny.x==0) {
						
						if (board[destiny.x][destiny.y]!=null) {
							
							return false; // System.out.println("Black tried to move to a busy tile");
							
						}
						
						else {
							
							return true; // System.out.println("Clean landing for black");
							
						}
						
					}
					
					else if (Math.abs(origin.x-destiny.x)==1) {
						
						if (board[destiny.x][destiny.y]==null) {
							
							return false; // System.out.println("Nothing on diagonal. Black can't interact");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==false){
							
							return false; // System.out.println("Black cannot kill black");
							
						}
						
						else if (board[destiny.x][destiny.y].colour==true) {
							
							return true; // System.out.println("Killing landing for black");
							
						}				
											
					}
					
					else {
						
						return false; // System.out.println("Black moves out of range, X checked");
						
					}
					
				}
				
				else {
					
					return false; // System.out.println("Y shift is not possible for this BLACK piece");
					
				}
				
				if (destiny.y==7) {
					
					System.out.println("Promotion triggered for black");
					
					return true;
					
				}
				
			}
		
		}
		
		// FAKE EXIT //
		
		return false;
		
		// --------- //
		
	}
	
	public boolean checkcheck(Coords origin, Coords destiny, Piece[][] board) {
		
		// Spin it : If the action fails, the pieces are re-created in their original position
		
		// boolean found = false;
		
		board[origin.x][origin.y] = null;
		
		board[destiny.x][destiny.y] = new Pawn(this.colour, new Coords(destiny.x,destiny.y));
		
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
							
							board[origin.x][origin.y] = new Pawn(this.colour, new Coords(origin.x,origin.y));
							
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
							
							board[origin.x][origin.y] = new Pawn(this.colour, new Coords(origin.x,origin.y));
							
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
