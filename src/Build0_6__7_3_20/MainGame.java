package Build0_6__7_3_20;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGame {
	
	public static void main (String args[]) throws IOException {
		
		// Thread main = Thread.currentThread();
		
		// Set up the pieces
		
		Chess game = new Chess();
		
		// Set KINGS
		
		King wking = new King(true, new Coords(4,7));
		
		King bking = new King(false, new Coords(4,0));
		
		game.placePiece(wking);
		
		game.placePiece(bking);
		
		// Set QUEENS
		
		Queen wqueen = new Queen(true, new Coords(3,7));
		
		Queen bqueen = new Queen(false, new Coords(3,0));
		
		game.placePiece(wqueen);
		
		game.placePiece(bqueen);
		
		// Set BISHOPS
		
		Bishop wbishop1 = new Bishop(true, new Coords(2,7));
		
		Bishop wbishop2 = new Bishop(true, new Coords(5,7));
		
		Bishop bbishop1 = new Bishop(false, new Coords(2,0));
		
		Bishop bbishop2 = new Bishop(false, new Coords(5,0));
		
		game.placePiece(wbishop1);
		
		game.placePiece(wbishop2);
		
		game.placePiece(bbishop1);
		
		game.placePiece(bbishop2);
		
		// Set KNIGHTS
		
		Knight wknight1 = new Knight(true, new Coords(1,7));
		
		Knight wknight2 = new Knight(true, new Coords(6,7));
		
		Knight bknight1 = new Knight(false, new Coords(1,0));
		
		Knight bknight2 = new Knight(false, new Coords(6,0));
		
		game.placePiece(wknight1);
		
		game.placePiece(wknight2);
		
		game.placePiece(bknight1);
		
		game.placePiece(bknight2);
		
		// Set TOWERS
		
		Tower wtower1 = new Tower(true, new Coords(0,7));
		
		Tower wtower2 = new Tower(true, new Coords(7,7));
		
		Tower btower1 = new Tower(false, new Coords(0,0));
		
		Tower btower2 = new Tower(false, new Coords(7,0));
		
		game.placePiece(wtower1);
		
		game.placePiece(wtower2);
		
		game.placePiece(btower1);
		
		game.placePiece(btower2);
		
		// Set PAWNS
		
		for (int i=0; i<16; i++) {
			
			if (i<8) {
				
				game.placePiece(new Pawn(true, new Coords(i,6)));
				
			}
			
			else {
				
				game.placePiece(new Pawn(false, new Coords(i-8,1)));
				
			}
			
		}
		
		
		
		// Initiate all objects
		
		File board = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\Board.jpg");
		
		File wkings = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reyblanco.png");
		
		File bkings = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reynegro.png");
		
		File wqueens = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reinablanca.png");
		
		File bqueens = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reinanegra.png");
		
		File wbishops = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\alfilblanco.png");
		
		File bbishops = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\alfilnegro.png");
		
		File wknights = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\caballoblanco.png");
		
		File bknights = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\caballonegro.png");
		
		File wtowers = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\torreblanca.png");
		
		File btowers = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\torrenegra.png");
		
		File wpawns = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\peonblanco.png");
		
		File bpawns = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\peonnegro.png");
		
		BufferedImage image = ImageIO.read(board);
		
		JLabel boardframe = new JLabel(new ImageIcon(image));
		
		
		
		// Set initial board
		
		JFrame mainwindow = new JFrame("Felicity: Cheess Engine");
		
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainwindow.pack();
		
		mainwindow.setVisible(true);
		
		mainwindow.setSize(535, 565);
		
		mainwindow.setLocation(692, 257);
		
		mainwindow.setResizable(false);
		
		// Set up board
		
		mainwindow.getContentPane().add(boardframe, BorderLayout.CENTER);
			
		// Set loop to repaint the mainframe
		
		JLabel labelset[][] = new JLabel[8][8];
		
		Piece currentpiece;
		
		// JLabel nextlabel;
		
		// Coord reading
		
		Coords coordread = new Coords(8,8);
		
		// Mouse listeners initialization
		
		for (int i=0; i<8; i++) {
			
			int id = i;
			
			for (int j=0; j<8; j++) {
				
				int jd = j;
				
				labelset[i][j] = new JLabel();
				
				labelset[i][j].addMouseListener(new MouseAdapter() {
					
					public void mouseReleased(MouseEvent e) {
						
						if (e.getButton() == MouseEvent.BUTTON1) {
							
							coordread.x = id;
							
							coordread.y = jd;
							
							// main.notify();
							
						}
						
					}
					
				});
				
			}
			
		}
		
		// Read and repaint
		
		boolean finished = false;
		
		boolean turn = true;
		
		boolean skip = false;
		
		// try {
			
			while (!finished) {
				
				if (turn) {
					
					while (turn) {
						
						// thread.main.wait();
						
						if (game.board[coordread.x][coordread.y].colour == true) {
							
							// thread.main.wait();
							
							Coords premove = new Coords(coordread.x, coordread.y);
							
							turn = game.board[5][6].moveTo(game.board[5][6].abspos, new Coords(5,5), game.board);
							
						}
						
						else {
							
							System.out.println("Notifies incorrect turn");
							
						}
						
					}
					
				}
				
				else {
					
					while (!turn) {
						
						// thread.main.wait();
						
						if (game.board[coordread.x][coordread.y].colour == false) {
							
							// thread.main.wait();
							
							Coords premove = new Coords(coordread.x, coordread.y);
							
							turn = !(game.board[5][6].moveTo(game.board[5][6].abspos, new Coords(5,5), game.board));
							
						}
						
						else {
							
							System.out.println("Notifies incorrect turn");
							
						}
						
					}
					
				}
				
				// Reapinting...
				
				for (int i=0; i<8; i++) {
					
					for (int j=0; j<8; j++) {
						
						// Equal image depending on the piece on board
						
						currentpiece = game.board[i][j];
						
						if (currentpiece instanceof King && currentpiece.colour==true) image = ImageIO.read(wkings);
						
						else if (currentpiece instanceof King && currentpiece.colour==false) image = ImageIO.read(bkings);
						
						else if (currentpiece instanceof Queen && currentpiece.colour==true) image = ImageIO.read(wqueens);
						
						else if (currentpiece instanceof Queen && currentpiece.colour==false) image = ImageIO.read(bqueens);
						
						else if (currentpiece instanceof Bishop && currentpiece.colour==true) image = ImageIO.read(wbishops);
						
						else if (currentpiece instanceof Bishop && currentpiece.colour==false) image = ImageIO.read(bbishops);
						
						else if (currentpiece instanceof Knight && currentpiece.colour==true) image = ImageIO.read(wknights);
						
						else if (currentpiece instanceof Knight && currentpiece.colour==false) image = ImageIO.read(bknights);
						
						else if (currentpiece instanceof Tower && currentpiece.colour==true) image = ImageIO.read(wtowers);
						
						else if (currentpiece instanceof Tower && currentpiece.colour==false) image = ImageIO.read(btowers);
						
						else if (currentpiece instanceof Pawn && currentpiece.colour==true) image = ImageIO.read(wpawns);
						
						else if (currentpiece instanceof Pawn && currentpiece.colour==false) image = ImageIO.read(bpawns);
						
						else skip = true; // Skip it
						
						//
						
						if (!skip) {
							
							labelset[i][j] = new JLabel(new ImageIcon(image));
							
							labelset[i][j].setBounds(57+(i*52),59+(j*52), 45, 45);
							
							// System.out.println(currentpiece.getClass().getName() + "[" + (54+(i*52) + "," + (56+(j*52)) + "]"));
							
							boardframe.add(labelset[i][j], BorderLayout.CENTER);
							
						}
						
						skip = false;
						
					}
					
				}
				
				mainwindow.validate();
				
				mainwindow.repaint();
				
			}
			
		/* }
		
		catch (InterruptedException e) {
			
			System.out.println("Looser...");
			
		}	*/
		
	}

}
