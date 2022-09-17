import java.util.ArrayList;

public class Root {
	
	public static void main(String[] args) {
		solvePuzzle14();
	}
	
	public static void solvePuzzle14() {
		Piece l = new Piece(2, 2, 'L', new int[] {1, 0, 1, 1});
		Piece r = new Piece(2, 2, 'R', new int[] {1, 0, 1, 1});
		Piece g = new Piece(2, 2, 'G', new int[] {1, 0, 1, 1});
		Piece j = new Piece(1, 3, 'J', new int[] {1, 1, 1});
		Piece y = new Piece(1, 3, 'Y', new int[] {1, 1, 1});
		Piece a = new Piece(2, 2, 'A', new int[] {1, 1, 1, 1});
		Piece o = new Piece(2, 2, 'O', new int[] {1, 1, 1, 1});
		Piece i = new Piece(2, 6, 'I', new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		Piece w = new Piece(1, 1, 'W', new int[] {1});
		
		Piece[] pieces = new Piece[] {i, a, o, l, r, g, j, y, w};
		
		Board board = new Board(8, 7, null);
		board.setTileAsObstacle(0, 0);
		board.setTileAsObstacle(3, 0);
		board.setTileAsObstacle(4, 0);
		board.setTileAsObstacle(7, 0);
		board.setTileAsObstacle(1, 3);
		board.setTileAsObstacle(2, 3);
		board.setTileAsObstacle(0, 4);
		board.setTileAsObstacle(1, 4);
		board.setTileAsObstacle(2, 4);
		board.setTileAsObstacle(7, 4);
		board.setTileAsObstacle(0, 5);
		board.setTileAsObstacle(1, 5);
		board.setTileAsObstacle(6, 5);
		board.setTileAsObstacle(7, 5);
		board.setTileAsObstacle(0, 6);
		board.setTileAsObstacle(1, 6);
		board.setTileAsObstacle(2, 6);
		board.setTileAsObstacle(5, 6);
		board.setTileAsObstacle(6, 6);
		board.setTileAsObstacle(7, 6);
		
		board.saveOriginalBoard();
		
		board.printBoardContent();
		
//		Placement.printListOfPlacements(board.findAllPossiblePlacements(pieces[0]));
		
		Solver solver = new Solver(pieces, board, true);
		solver.startSolve();
	}
	
	public static void solvePuzzle2() {
		
	}
	
	public static void solvePuzzle51() {
		Piece p = new Piece(2, 3, 'P', new int[] {0, 1, 1, 1, 1, 1});
		Piece f = new Piece(2, 3, 'F', new int[] {0, 1, 1, 1, 1, 1});
		Piece c = new Piece(2, 3, 'C', new int[] {1, 1, 0, 1, 1, 1});
		Piece a = new Piece(2, 2, 'A', new int[] {1, 1, 1, 1});
		Piece l = new Piece(3, 3, 'L', new int[] {1, 1, 1, 1, 0, 0, 1, 0, 0});
		Piece s = new Piece(3, 2, 'S', new int[] {1, 1, 0, 0, 1, 1});
		Piece o = new Piece(3, 3, 'O', new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1});
		Piece d = new Piece(2, 3, 'D', new int[] {1, 1, 1, 1, 1, 1});
		Piece i = new Piece(2, 6, 'I', new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		
		Piece[] pieces = new Piece[] {i, o, p, f, c, a, l, s, d};
		
		Board board = new Board(8, 8, null);
		board.setTileAsObstacle(2, 0);
		board.setTileAsObstacle(2, 1);
		board.setTileAsObstacle(5, 3);
		board.setTileAsObstacle(5, 4);
		board.setTileAsObstacle(5, 5);
		board.setTileAsObstacle(5, 6);
		board.setTileAsObstacle(5, 7);
		board.setTileAsObstacle(4, 7);
		board.setTileAsObstacle(3, 7);
		
		board.saveOriginalBoard();
		
		board.printBoardContent();
		
//		Placement.printListOfPlacements(board.findAllPossiblePlacements(pieces[0]));
		
		Solver solver = new Solver(pieces, board, true);
		solver.startSolve();
	}

	


}
