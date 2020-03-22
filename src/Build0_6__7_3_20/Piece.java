package Build0_6__7_3_20;

/**
 * 
 * @author Ernestas J
 * 
 * @version 0.5.3.3.30
 * 
 * @since 0.1.3.3.30
 *
 */

class Piece {
	
	/**
	 * 
	 * Indicates colour of the piece
	 * <ul> 
	 * 
	 * 	<li> True : White pieces, bottom of board</li>
	 *  <li> False : Black pieces, top of board</li>
	 * 
	 * </ul>
	 * 
	 */
	
	boolean colour;
	
	/**
	 * 
	 * Stores a Coord class position independent from the board
	 * 
	 * @see Coords
	 * 
	 */
	
	Coords abspos;
	
	/**
	 * 
	 * Defaults to false for every piece besides King and Tower
	 * 
	 */
	
	boolean cancast = false;
	
	/**
	 * Two parameters constructor. Sets initial colour and abstract position.
	 * @param colour Colour of the Piece
	 * @param inipos Initial position of the Piece, prior to be placed on a board
	 * 
	 */
	
	Piece (boolean colour, Coords inipos) {
		
		this.colour = colour;
		abspos = inipos;
		
	}
	
	/**
	 * 
	 * Method that attempts to move a piece.
	 * 
	 * @param origin Coord of the initial position
	 * @param destiny Coord of the position of destiny
	 * @param board Attribute of the Chess class that contains all the Pieces
	 * @return <table border="2">
	 * 
	 * 				<tr> <td> True </td> <td> The move was successful. Internally, board position has changed</td> </tr>
	 * 
	 * 				<tr> <td> False </td> <td> The move failed. Internally, board position remains the same</td> </tr>
	 * 
	 * 		   </table>
	 */
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board) {
		
		// Test only boundaries
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
			
			return false; // System.out.println("Piece tried to move out of the bounds");
			
		}
		
		else {
			
			return true; // System.out.println("Piece is accessing a legal move (regarding boundaries)");
			
		}
		
	}
	
	/**
	 * 
	 * Method that attempts to move a piece, but is an abstraction that avoids the call to checkcheck, to avoid recurring calls to checkcheck.
	 * 
	 * @param origin Coord of the initial position
	 * @param destiny Coord of the position of destiny
	 * @param board Attribute of the Chess class that contains all the Pieces
	 * @param abstraction Parameter that's symbolically called on true. Calls the overwritten method that skips the checkcheck call
	 * @return <table border="2">
	 * 
	 * 				<tr> <td> True </td> <td> The move was successful. Internally, board position has changed</td> </tr>
	 * 
	 * 				<tr> <td> False </td> <td> The move failed. Internally, board position remains the same</td> </tr>
	 * 
	 * 		   </table>
	 */
	
	public boolean moveTo (Coords origin, Coords destiny, Piece[][] board, boolean abstraction) {
		
		// Test only boundaries
		
		if (destiny.x > 7 || destiny.y > 7 || destiny.x < 0 || destiny.y < 0) {
			
			return false; // System.out.println("Piece tried to move out of the bounds");
			
		}
		
		else {
			
			return true; // System.out.println("Piece is accessing a legal move (regarding boundaries)");
			
		}
		
	}
	
	/**
	 * 
	 * Method called from moveTo once the previous method checks that the Piece tries to move in a legal manner
	 * 
	 * @param origin Coord of the initial position
	 * @param destiny Coord of the position of destiny
	 * @return <table border = "2">
	 * 
	 * 				<tr> <td> True </td> <td> The landing was successful. moveTo receives a True to continue execution</td> </tr>
	 * 
	 * 				<tr> <td> False </td> <td> The landing is impossible. moveTo receives a False</td> </tr>
	 * 
	 * 		   </table>
	 */
	
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
	
	/**
	 * 
	 * Method that makes sure the move won't set the King on checkmate
	 * 
	 * @param origin Coord of the initial position
	 * @param destiny Coord of the position of destiny
	 * @return Only returns false when the final result is a checkmate, otherwise it allows moveTo to finish execution
	 */
	
	public boolean checkcheck(Coords destiny, Piece[][] board) {
		
		System.out.println("Entered a generic Piece checkcheck method");
		
		return false;
		
	}

}
