package _Main;

import java.awt.BorderLayout;
// import java.awt.Dimension;
// import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;


public class MainGame {
	
	static File board;
	static File wkings;
	static File bkings;
	static File wqueens;
	static File bqueens;
	static File wbishops;
	static File bbishops;
	static File wknights;
	static File bknights;
	static File wtowers;
	static File btowers;
	static File wpawns;
	static File bpawns;

	public static void main (String args[]) throws IOException {
		
		// Thread main = Thread.currentThread();
		
		// Set up the pieces
		
		Chess game = new Chess();
		
		// Set KINGS
		
		/* King wking = new King(true, new Coords(4,7));
		
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
			
		} */
		
		// Promotion testing
		
		Pawn whitepawn = new Pawn(true, new Coords(2,1));
		
		Pawn blackpawn = new Pawn(false, new Coords(6,6));
		
		game.placePiece(whitepawn);

		game.placePiece(blackpawn);
		
		Tower wtower = new Tower(true, new Coords(4,4));
		
		Tower btower = new Tower(false, new Coords(3,3));
		
		game.placePiece(wtower);
		
		game.placePiece(btower);
		
		
		
		// Initiate all objects
		
		board = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\Board.jpg");
		
		wkings = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reyblanco.png");
		
		bkings = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reynegro.png");
		
		wqueens = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reinablanca.png");
		
		bqueens = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reinanegra.png");
		
		wbishops = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\alfilblanco.png");
		
		bbishops = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\alfilnegro.png");
		
		wknights = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\caballoblanco.png");
		
		bknights = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\caballonegro.png");
		
		wtowers = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\torreblanca.png");
		
		btowers = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\torrenegra.png");
		
		wpawns = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\peonblanco.png");
		
		bpawns = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\peonnegro.png");
		
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
		
		// LOOP //
		
		// AL SETUP DONE, start thread here
		
		JLabel[][] labelset = new JLabel[8][8];
		
		// PAINTED HERE
		
		Piece currentpiece;
		
		Boolean skip = false;
		
		for (int i=0; i<8; i++) {
			
			for (int j=0; j<8; j++) {
				
				// Equal image depending on the piece on board
				
				currentpiece = game.board[i][j];
				
				try {
				
					if (currentpiece instanceof King && currentpiece.colour==true) image = ImageIO.read(MainGame.wkings);
				
					else if (currentpiece instanceof King && currentpiece.colour==false) image = ImageIO.read(MainGame.bkings);
				
					else if (currentpiece instanceof Queen && currentpiece.colour==true) image = ImageIO.read(MainGame.wqueens);
				
					else if (currentpiece instanceof Queen && currentpiece.colour==false) image = ImageIO.read(MainGame.bqueens);
				
					else if (currentpiece instanceof Bishop && currentpiece.colour==true) image = ImageIO.read(MainGame.wbishops);
				
					else if (currentpiece instanceof Bishop && currentpiece.colour==false) image = ImageIO.read(MainGame.bbishops);
				
					else if (currentpiece instanceof Knight && currentpiece.colour==true) image = ImageIO.read(MainGame.wknights);
				
					else if (currentpiece instanceof Knight && currentpiece.colour==false) image = ImageIO.read(MainGame.bknights);
				
					else if (currentpiece instanceof Tower && currentpiece.colour==true) image = ImageIO.read(MainGame.wtowers);
				
					else if (currentpiece instanceof Tower && currentpiece.colour==false) image = ImageIO.read(MainGame.btowers);
				
					else if (currentpiece instanceof Pawn && currentpiece.colour==true) image = ImageIO.read(MainGame.wpawns);
				
					else if (currentpiece instanceof Pawn && currentpiece.colour==false) image = ImageIO.read(MainGame.bpawns);
				
					else skip = true; // Skip it
					
				}
				
				catch (IOException e) {
					
					System.out.println("Problems loading the images, fix later");
					
				}
				
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
		
		// STOP PAITING HERE
		
		GameThread maingame = new GameThread(mainwindow, boardframe, game, labelset);
		
		maingame.maingame.start();
		
		// Read and repaint
		
		try {
			
			maingame.maingame.join();
			
		}
		
		catch (InterruptedException e) {
			
			System.out.println("Looser...");
			
		}
		
	}

}


class GameThread implements Runnable {
	
	// Thread properties
	
	Thread maingame;
	
	boolean suspended;
	
	// Game setup
	
	Chess game;
	
	JLabel[][] labelset;
	
	JLabel boardframe;
	
	JFrame mainwindow;
	
	JLabel eventset[][];
	
	// Dynamic variables
	
	Piece currentpiece;
	
	Coords coordread;
	
	BufferedImage image;
	
	static int promotingpiece;
	
	public void setLabelset(JLabel[][] labelset) {
		
		this.labelset = labelset;
		
	}
	
	GameThread(JFrame mainwindow, JLabel boardframe, Chess game, JLabel[][] labelset) {
		
		this.mainwindow = mainwindow;
		
		this.boardframe = boardframe;
		
		this.game = game;
		
		this.labelset = labelset;
		
		coordread = new Coords(8,8);
		
		try {
			
			image = ImageIO.read(MainGame.board);
			
		}
		
		catch (IOException e) {
			
			System.out.println("Image read incorrectly...");
			
		}
		
		maingame = new Thread(this, "Main_Game");
		
		suspended = false;
		
	}
	
	synchronized public void run () {
		
		boolean finished = false;
		
		boolean turn = true;
		
		eventset = new JLabel[8][8];
		
		for (int i=0; i<8; i++) {
			
			int id = i;
			
			for (int j=0; j<8; j++) {
				
				int jd = j;
				
				eventset[i][j] = new JLabel();
				
				eventset[i][j].setBounds(57+(i*52),59+(j*52), 45, 45);
				
				eventset[i][j].addMouseListener(new MouseAdapter() {
					
					public void mouseReleased(MouseEvent e) {
						
						if (e.getButton() == MouseEvent.BUTTON1) {
							
							coordread.x = id;
							
							coordread.y = jd;
							
							resumeX();
							
						}
						
					}
					
				});
				
				boardframe.add(eventset[i][j], BorderLayout.CENTER);
				
			}
			
		}
		
		// FIX EMPTY CALLS (Second turn as well)
		
		Coords premove;
		
		while (!finished) {
			
			if (turn) {
				
				while (turn) {
					
					System.out.println("First read about to be done");
					
					synchronized (this) {
						
						try {
							
							if (!suspended) wait();
							
						}
						
						catch (InterruptedException e) {
							
							System.out.println("Game Thread interrupted");
							
						}
						
					}
					
					System.out.println("First read performed: " + coordread);
					
					if ((game.board[coordread.x][coordread.y]!=null) && (game.board[coordread.x][coordread.y].colour == true)) {
						
						premove = new Coords(coordread.x, coordread.y);
						
						System.out.println("Second read about to be made, current premove value: " + premove);
						
						synchronized (this) {
							
							try {
								
								if (!suspended) wait();
								
							}
							
							catch (InterruptedException e) {
								
								System.out.println("Game Thread interrupted");
								
							}
							
						}
							
						System.out.println("The reading position is null: " + game.board[premove.x][premove.y]==null);
						
						if (game.board[premove.x][premove.y].moveTo(game.board[premove.x][premove.y].abspos, new Coords(coordread.x,coordread.y), game.board)) {
							
							if (game.board[coordread.x][coordread.y] instanceof Pawn && coordread.y==0) {
								
								promotion(true);
								
								synchronized (this) {
									
									try {
										
										if (!suspended) wait();
										
									}
									
									catch (InterruptedException e) {
										
										System.out.println("Game Thread interrupted");
										
									}
									
								}
								
								switch (promotingpiece) {
								
									case 0: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Queen(true, coordread);
										
										System.out.println("----Promoted queen----");
										
										break;
										
									}
									
									case 1: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Bishop(true, coordread);
										
										break;
										
									}
									
									case 2: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Knight(true, coordread);
										
										break;
										
									}
									
									case 3: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Tower(true, coordread);
										
										break;
										
									}
								
								}
								
							}
							
							turn = false;
							
						}	
						
						repainting();
						
					}
					
					else {
						
						System.out.println("Notifies incorrect turn (WHITE)");
						
					}
					
				}
				
			}
			
			else {
				
				while (!turn) {
					
					synchronized (this) {
						
						try {
							
							if (!suspended) wait();
							
						}
						
						catch (InterruptedException e) {
							
							System.out.println("Game Thread interrupted");
							
						}
						
					}
					
					if ((game.board[coordread.x][coordread.y]!=null) && (game.board[coordread.x][coordread.y].colour == false)) {
						
						premove = new Coords(coordread.x, coordread.y);
						
						synchronized (this) {
							
							try {
								
								if (!suspended) wait();
								
							}
							
							catch (InterruptedException e) {
								
								System.out.println("Game Thread interrupted");
								
							}
							
						}
						
						if (game.board[premove.x][premove.y].moveTo(game.board[premove.x][premove.y].abspos, new Coords(coordread.x,coordread.y), game.board)) {
							
							if (game.board[coordread.x][coordread.y] instanceof Pawn && coordread.y==7) {
								
								promotion(false);
								
								synchronized (this) {
									
									try {
										
										if (!suspended) wait();
										
									}
									
									catch (InterruptedException e) {
										
										System.out.println("Game Thread interrupted");
										
									}
									
								}
								
								switch (promotingpiece) {
								
									case 0: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Queen(false, coordread);
										
										break;
										
									}
									
									case 1: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Bishop(false, coordread);
										
										break;
										
									}
									
									case 2: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Knight(false, coordread);
										
										break;
										
									}
									
									case 3: {
										
										game.board[coordread.x][coordread.y] = null;
										
										game.board[coordread.x][coordread.y] = new Tower(false, coordread);
										
										break;
										
									}
								
								}
								
							}
							
							turn = true;
							
						}
						
						repainting();	
						
					}
					
					else {
						
						System.out.println("Notifies incorrect turn (BLACK)");
						
					}
					
				}
				
			}
			
			// Reapinting...
			
		}
		
	}
	
	void suspendX() {
		
		suspended = true;
		
	}
	
	synchronized void resumeX() {
		
		suspended = false;
		
		notify();
		
	}
	
	void repainting() {
		
		boardframe.removeAll();
		
		// boardframe.repaint();
		
		for (int i=0; i<8; i++) {
			
			int id = i;
			
			for (int j=0; j<8; j++) {
				
				int jd = j;
				
				eventset[i][j] = new JLabel();
				
				eventset[i][j].setBounds(57+(i*52),59+(j*52), 45, 45);
				
				eventset[i][j].addMouseListener(new MouseAdapter() {
					
					public void mouseReleased(MouseEvent e) {
						
						if (e.getButton() == MouseEvent.BUTTON1) {
							
							coordread.x = id;
							
							coordread.y = jd;
							
							resumeX();
							
						}
						
					}
					
				});
				
				boardframe.add(eventset[i][j], BorderLayout.CENTER);
				
			}
			
		}
		
		boolean skip = false;
		
		for (int i=0; i<8; i++) {
			
			for (int j=0; j<8; j++) {
				
				// Equal image depending on the piece on board
				
				currentpiece = game.board[i][j];
				
				try {
				
					if (currentpiece instanceof King && currentpiece.colour==true) image = ImageIO.read(MainGame.wkings);
				
					else if (currentpiece instanceof King && currentpiece.colour==false) image = ImageIO.read(MainGame.bkings);
				
					else if (currentpiece instanceof Queen && currentpiece.colour==true) image = ImageIO.read(MainGame.wqueens);
				
					else if (currentpiece instanceof Queen && currentpiece.colour==false) image = ImageIO.read(MainGame.bqueens);
				
					else if (currentpiece instanceof Bishop && currentpiece.colour==true) image = ImageIO.read(MainGame.wbishops);
				
					else if (currentpiece instanceof Bishop && currentpiece.colour==false) image = ImageIO.read(MainGame.bbishops);
				
					else if (currentpiece instanceof Knight && currentpiece.colour==true) image = ImageIO.read(MainGame.wknights);
				
					else if (currentpiece instanceof Knight && currentpiece.colour==false) image = ImageIO.read(MainGame.bknights);
				
					else if (currentpiece instanceof Tower && currentpiece.colour==true) image = ImageIO.read(MainGame.wtowers);
				
					else if (currentpiece instanceof Tower && currentpiece.colour==false) image = ImageIO.read(MainGame.btowers);
				
					else if (currentpiece instanceof Pawn && currentpiece.colour==true) image = ImageIO.read(MainGame.wpawns);
				
					else if (currentpiece instanceof Pawn && currentpiece.colour==false) image = ImageIO.read(MainGame.bpawns);
				
					else skip = true; // Skip it
					
				}
				
				catch (IOException e) {
					
					System.out.println("Problems loading the images, fix later");
					
				}
				
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
		
		boardframe.validate();
		
		boardframe.repaint();
		
	}
	
	public void promotion(boolean colour) {
		
		File wqueens = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reinablanca.png");
		
		File bqueens = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\reinanegra.png");
		
		File wbishops = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\alfilblanco.png");
		
		File bbishops = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\alfilnegro.png");
		
		File wknights = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\caballoblanco.png");
		
		File bknights = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\caballonegro.png");
		
		File wtowers = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\torreblanca.png");
		
		File btowers = new File("C:\\Users\\ernes\\Pictures\\FelicityCE images\\PieceModels\\torrenegra.png");
		
		
		
		File[] wseries = {wqueens, wbishops, wknights, wtowers};
		
		File[] bseries = {bqueens, bbishops, bknights, btowers};
		
		
		
		JFrame promotionwindow = new JFrame("Promote");
		
		JLabel boardframe = new JLabel();
		
		promotionwindow.getContentPane().add(boardframe, BorderLayout.CENTER);
		
		promotionwindow.setUndecorated(true);
		
		// promotionwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		promotionwindow.pack();
		
		promotionwindow.setVisible(true);
		
		promotionwindow.setSize(232, 65);
		
		promotionwindow.setLocation(846,505);
		
		promotionwindow.setResizable(false);
		
		JLabel[] pieces = new JLabel[4];
		
		JLabel[] eventset = new JLabel[4];

		
		if (colour) {
			
			for (int i=0; i<4; i++) {
				
				try {
					
					pieces[i]= new JLabel(new ImageIcon(ImageIO.read(wseries[i])));
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
				pieces[i].setBounds(12+(i*52),12, 45, 45);
				
				boardframe.add(pieces[i]);
						
				eventset[i] = new JLabel();
						
				eventset[i].setBounds(12+(i*52),12, 45, 45);
				
				int id = i;
						
				eventset[i].addMouseListener(new MouseAdapter() {
							
					public void mouseReleased(MouseEvent e) {
								
						if (e.getButton() == MouseEvent.BUTTON1) {
									
							promotingpiece = id;
								
							suspended = false;
							
							promotionwindow.dispose();
							
							resumeX();
									
						}
								
					}
							
				});
						
				boardframe.add(eventset[i], BorderLayout.CENTER);
				
			}

			boardframe.validate();
			
			boardframe.repaint();
			
		}
		
		else {
			
			for (int i=0; i<4; i++) {
				
				try {
					
					pieces[i]= new JLabel(new ImageIcon(ImageIO.read(bseries[i])));
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
				pieces[i].setBounds(12+(i*52),12, 45, 45);
				
				boardframe.add(pieces[i]);
						
				eventset[i] = new JLabel();
						
				eventset[i].setBounds(12+(i*52),12, 45, 45);
				
				int id = i;
						
				eventset[i].addMouseListener(new MouseAdapter() {
							
					public void mouseReleased(MouseEvent e) {
								
						if (e.getButton() == MouseEvent.BUTTON1) {
									
							promotingpiece = id;
								
							suspended = false;
							
							promotionwindow.dispose();
							
							resumeX();
									
						}
								
					}
							
				});
						
				boardframe.add(eventset[i], BorderLayout.CENTER);
				
			}

			boardframe.validate();
			
			boardframe.repaint();
			
		}	
		
	}
	
}
