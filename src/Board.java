import java.util.ArrayList;

public class Board {

	private char[][] content;
	private char[][] originalContent;

	private int width;
	private int height;

	public Board(int _width, int _height, int[] _content) {
		width = _width;
		height = _height;

		content = new char[width][height];

		if (_content == null) {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
						content[i][j] = '-';
				}
			}
		} else {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (_content[(j * width) + i] == 1) {
						content[i][j] = '+';
					} else {
						content[i][j] = '-';
					}
				}
			}
		}
		
		saveOriginalBoard();
	}
	
	public ArrayList<Placement> findAllPossiblePlacements(Piece p){
		ArrayList<Placement> placements = new ArrayList<Placement>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				for (int o = 0; o < p.getOrientationAmount(); o++) {
					if(attemptPlacePiece(i, j, p, o))
						placements.add(new Placement(i, j, o));
				}
			}
		}
		return placements;
	}
	
	public boolean attemptPlacePiece(int x, int y, Piece p, int orientation) {
		int[][] pieceContent = p.getOrientation(orientation);
		for(int j = 0; j < pieceContent[0].length; j++) {
			for(int i = 0; i < pieceContent.length; i++) {
				if(x + i >= width || y + j >= height)
					return false;
				else if(pieceContent[i][j] == 1 && content[x + i][y + j] != '-')
					return false;
			}
		}
		return true;
	}
	
	
	public void saveOriginalBoard() {
		originalContent = new char[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				originalContent[i][j] = content[i][j];
			}
		}
	}
	
	public void resetBoard() {
		content = new char[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				content[i][j] = originalContent[i][j];
			}
		}
	}
	
	public void placePiece(int x, int y, Piece p, int orientation) {
		int[][] pieceContent = p.getOrientation(orientation);
		for(int j = 0; j < pieceContent[0].length; j++) {
			for(int i = 0; i < pieceContent.length; i++) {
				if(pieceContent[i][j] == 1)
					content[x + i][y + j] = p.getLetter();
			}
		}
	}
	
	public void removePiece(Piece p) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if(content[i][j] == p.getLetter())
					content[i][j] = '-';
			}
		}
	}
	
	public void setTileAsObstacle(int x, int y) {
		content[x][y] = '+'; 
	}
	
	private void setTile(int x, int y, char letter) {
		content[x][y] = letter; 
	}

	public void printBoardContent() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(content[x][y]);
			}
			System.out.println();
		}
	}

}
