import java.util.ArrayList;

public class Solver {
	
	private Piece[] pieces;
	private Board board;
	private boolean verbose;
	private int attempts;
	
	
	public Solver(Piece[] _pieces, Board _board, boolean _verbose) {
		pieces = _pieces;
		board = _board;
		verbose = _verbose;
		attempts = 0;
		reorderPiecesByScore();
	}
	
	private void reorderPiecesByScore() {
		Piece[] tempPieces = new Piece[pieces.length];
		for(int i = 0; i < pieces.length; i++) {
			Piece highestScorePiece = null;
			int highestPieceIndex = 0;
			for(int j = 0; j < pieces.length; j++) {
				if(highestScorePiece == null) {
					highestScorePiece = pieces[j];
					highestPieceIndex = j;
				}
				else if(pieces[j] != null && pieces[j].getScore() > highestScorePiece.getScore()) {
					highestScorePiece = pieces[j];
					highestPieceIndex = j;
				}
			}
			tempPieces[i] = highestScorePiece;
			pieces[highestPieceIndex] = null;
		}
		pieces = tempPieces;
	}
	
	private void printPieceLettersInOrder() {
		for(int i = 0; i < pieces.length; i++) {
			System.out.print(pieces[i].getLetter());
			if(i < pieces.length - 1)
				System.out.print(", ");
		}
		System.out.println();
	}
	
	public void startSolve() {
		printPieceLettersInOrder();
		attempts = 0;
		if(solvePiece(0)) {
			System.out.println("***Solve COMPLETED after " + attempts + " checks.***");
			board.printBoardContent();
		}else
			System.out.println("Solve failed after " + attempts + " checks.");
	}
	
	private boolean solvePiece(int piece) {
		if(piece == pieces.length)
			return true;
		
		ArrayList<Placement> placements = board.findAllPossiblePlacements(pieces[piece]);
		for (Placement placement : placements) {
			attempts++;
			if(verbose && attempts % 2500 == 0)
				System.out.println("Done " +attempts + " checks...");
			
			board.placePiece(placement.getX(), placement.getY(), pieces[piece], placement.getOrientation());
			
			if(solvePiece(piece + 1)) {
				return true;
			}
			
			board.removePiece(pieces[piece]);
		}
		
		return false;
	}

}
