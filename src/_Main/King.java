package _Main;

public class King extends Piece {
	
	King (boolean colour, Coords inipos) {
		
		super(colour, inipos);
		
	}
	
	public boolean castling(Coords origin, Coords destiny, Piece[][] board) {
		
		// NULIFY cancast
		
		if (colour) {
			
			System.out.println(destiny);
			
			System.out.println(twrightcancast);
			
			if (destiny.equals(new Coords(6,7)) && twrightcancast==true) {
				
				System.out.println("PING");
				
				if (board[6][7]==null && board[5][7]==null) {
					
					// Implement here
					
					board[7][7] = null;
					
					board[4][7] = null;
					
					board[6][7] = new King(colour, destiny);
					
					board[5][7] = new Tower(colour, new Coords(5,7));
					
					if (this.checkcheck(destiny, board)) {
						
						System.out.println("Correct castle");
						
						twrightcancast = false;
						
						return true;
						
					}
					
					else {
						
						board[7][7] = new Tower(colour, new Coords(7,7));
						
						board[4][7] = new King(colour, origin);
						
						board[6][7] = null;
						
						board[5][7] = null;
						
						System.out.println("Bad castling");
						
						return false;
						
					}
					
				}
				
			}
			
			else if (destiny.equals(new Coords(1,7)) && twleftcancast==true) {
				
				if (board[1][7]==null && board[2][7]==null && board[3][7]==null) {
					
					// Implement here
					
					board[0][7] = null;
					
					board[4][7] = null;
					
					board[1][7] = new King(colour, destiny);
					
					board[2][7] = new Tower(colour, new Coords(2,7));
					
					if (this.checkcheck(destiny, board)) {
						
						System.out.println("Correct castle");
						
						twleftcancast = false;
						
						return true;
						
					}
					
					else {
						
						board[0][7] = new Tower(colour, new Coords(0,7));
						
						board[4][7] = new King(colour, origin);
						
						board[1][7] = null;
						
						board[2][7] = null;
						
						System.out.println("Bad castling");
						
						return false;
						
					}
					
				}
				
			}
			
			System.out.println("Can't castle white piece, not correct step or tower uncastled");
			
			return false;
			
		}
		
		else {
			
			if (destiny.equals(new Coords(6,0)) && tbrightcancast==true) {
				
				if (board[6][0]==null && board[5][0]==null) {
					
					// Implement here
					
					board[7][0] = null;
					
					board[4][0] = null;
					
					board[6][0] = new King(colour, destiny);
					
					board[5][0] = new Tower(colour, new Coords(5,0));
					
					if (this.checkcheck(destiny, board)) {
						
						System.out.println("Correct castle");
						
						tbrightcancast = false;
						
						return true;
						
					}
					
					else {
						
						board[7][0] = new Tower(colour, new Coords(7,0));
						
						board[4][0] = new King(colour, origin);
						
						board[6][0] = null;
						
						board[5][0] = null;
						
						System.out.println("Bad castling");
						
						return false;
						
					}
					
				}
				
			}
			
			else if (destiny.equals(new Coords(1,0)) && tbleftcancast==true) {
				
				if (board[1][0]==null && board[2][0]==null && board[3][0]==null) {
					
					// Implement here
					
					board[0][0] = null;
					
					board[4][0] = null;
					
					board[1][0] = new King(colour, destiny);
					
					board[2][0] = new Tower(colour, new Coords(2,0));
					
					if (this.checkcheck(destiny, board)) {
						
						System.out.println("Correct castle");
						
						tbleftcancast = false;
						
						return true;
						
					}
					
					else {
						
						board[0][0] = new Tower(colour, new Coords(0,0));
						
						board[4][0] = new King(colour, origin);
						
						board[1][0] = null;
						
						board[2][0] = null;
						
						System.out.println("Bad castling");
						
						return false;
						
					}
					
				}
				
			}
			
			return false;
			
		}
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board) {
		
		// Cancast is false-d too soon  -> Revised on 11-3-20
		
		if ((colour && kwcancast) || (!colour && kbcancast)) {
			
			if (!castling(origin, destiny, board)) {
				
				if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
					return false; // System.out.println("Piece tried to move out of the bounds");
							
				}
						
				else {
				
					if (Math.abs(destiny.x-origin.x)<=1) {
						
						if (Math.abs(destiny.y-origin.y)<=1) {
							
							// System.out.println("Legal move");						// It's enough, despite the form
							
							if (landing(destiny, board)) {
								
								// Here goes the check-check
								
								if (checkcheck(destiny, board)) {
									
									if (colour) kwcancast = false;
									
									if (colour) kbcancast = false;
									
									board[origin.x][origin.y] = null;
									
									board[destiny.x][destiny.y] = new King(colour, new Coords(destiny.x,destiny.y));

									return true;
									
								}
								
								else return false;
								
							}
							
						}
						
						else {
							
							return false; // System.out.println("One shift too big");
							
						}
						
					}
					
					else {
						
						return false; // System.out.println("Both shifts were too big");
						
					}
				
				}
				
				// FAKE EXIT //
				
				return false;
				
				// --------- //
				
			}
			
			else {
				
				return true;
				
			}
			
		}
		
		else if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
		
			if (Math.abs(destiny.x-origin.x)<=1) {
				
				if (Math.abs(destiny.y-origin.y)<=1) {
					
					// System.out.println("Legal move");						// It's enough, despite the form
					
					if (landing(destiny, board)) {
						
						// Here goes the check-check
						
						if (checkcheck(destiny, board)) {
							
							if (colour) kwcancast = false;
							
							if (!colour) kbcancast = false;
							
							board[origin.x][origin.y] = null;
							
							board[destiny.x][destiny.y] = new King(colour, new Coords(destiny.x,destiny.y));
							
							return true;
							
						}
						
						else return false;
						
					}
					
				}
				
				else {
					
					return false; // System.out.println("One shift too big");
					
				}
				
			}
			
			else {
				
				return false; // System.out.println("Both shifts were too big");
				
			}
		
		}
		
		// FAKE EXIT //
		
		return false;
		
		// --------- //
		
	}
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board, boolean abstraction) {
		
		// ABSTRACTION should never call concast
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
					
			return false; // System.out.println("Piece tried to move out of the bounds");
					
		}
				
		else {
		
			if (Math.abs(destiny.x-origin.x)<=1) {
				
				if (Math.abs(destiny.y-origin.y)<=1) {
					
					// System.out.println("Legal move");						// It's enough, despite the form
					
					if (landing(destiny, board)) {
						
						// Here goes the check-check
						
						return checkcheck(destiny, board);
						
					}
					
				}
				
				else {
					
					return false; // System.out.println("One shift too big");
					
				}
				
			}
			
			else {
				
				return false; // System.out.println("Both shifts were too big");
				
			}
		
		}
		
		// FAKE EXIT //
		
		return false;
		
		// --------- //
		
	}
	
	public boolean landing(Coords destiny, Piece[][] board) {
		
		return super.landing(destiny, board);
		
	}
	
	public boolean checkcheck (Coords destiny, Piece[][] board) {
		
		boolean oncheck = false;
		
		for (int i=0; i<8; i++) {
			
			for (int j=0; j<8; j++) {
				
				if (board[i][j]!=null) {
					
					if (board[i][j].colour!=this.colour) {
						
						// System.out.println("Called");
						
						// System.out.println("Trying to reach from position " + i + "," + j);
						
						// System.out.println("Trying to get to position " + destiny.x + "," + destiny.y);
						
						if (board[i][j] instanceof King) {
							
							// System.out.println("FORBIDDEN");
							
							if (destiny.x-1>=0 && destiny.y-1>=0) {
								
								if(board[destiny.x-1][destiny.y-1] instanceof King && board[destiny.x-1][destiny.y-1].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.y-1>=0) {
								
								if(board[destiny.x][destiny.y-1] instanceof King && board[destiny.x][destiny.y-1].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.x+1<=7 && destiny.y-1>=0) {
								
								if(board[destiny.x+1][destiny.y-1] instanceof King && board[destiny.x+1][destiny.y-1].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.x-1>=0) {
								
								if(board[destiny.x-1][destiny.y] instanceof King && board[destiny.x-1][destiny.y].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.x+1<=7) {
								
								if(board[destiny.x+1][destiny.y] instanceof King && board[destiny.x+1][destiny.y].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.x-1>=0 && destiny.y+1<=7) {
								
								if(board[destiny.x-1][destiny.y+1] instanceof King && board[destiny.x-1][destiny.y+1].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.y+1<=7) {
								
								if(board[destiny.x][destiny.y+1] instanceof King && board[destiny.x][destiny.y+1].colour!=this.colour) oncheck=true;
								
							}
							
							if (destiny.x+1<=7 && destiny.y+1<=7) {
								
								if(board[destiny.x+1][destiny.y+1] instanceof King && board[destiny.x+1][destiny.y+1].colour!=this.colour) oncheck=true;
								
							}
							
						}
						
						else if (board[i][j] instanceof Pawn) {
							
							// System.out.println("FORBIDDEN");
							
							if (colour) {
								
								if (board[destiny.x-1][destiny.y-1] instanceof Pawn && board[destiny.x-1][destiny.y-1].colour==false) oncheck=true;
								
								else if (board[destiny.x+1][destiny.y-1] instanceof Pawn && board[destiny.x+1][destiny.y-1].colour==false) oncheck=true;	//
								
							}
							
							else {
								
								if (board[destiny.x-1][destiny.y+1] instanceof Pawn && board[destiny.x-1][destiny.y+1].colour==true) oncheck=true;
								
								else if (board[destiny.x+1][destiny.y+1] instanceof Pawn && board[destiny.x+1][destiny.y+1].colour==true) oncheck=true;
								
							}
							
						}
						
						else if(board[i][j].moveTo(new Coords(i,j), destiny, board, true)) oncheck=true;
						
					}	
					
					if(oncheck) return false;
					
				}	
				
			}
			
		}
		
		return true;
		
	}

}
