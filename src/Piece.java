import java.util.ArrayList;

import javax.swing.text.AbstractDocument.Content;

public class Piece {

	private int width;
	private int height;
	private char letter;
	private int[][] content;
	private int[][] contentRotatedCW1;
	private int[][] contentRotatedCW2;
	private int[][] contentRotatedCW3;
	private int[][][] allOrientations;
	private double score;

	public Piece(int _width, int _height, char _letter, int[] _content) {
		width = _width;
		height = _height;
		letter = _letter;

		content = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				content[i][j] = _content[(j * width) + i];
			}
		}

		contentRotatedCW1 = getRotationCW(content);
		contentRotatedCW2 = getRotationCW(contentRotatedCW1);
		contentRotatedCW3 = getRotationCW(contentRotatedCW2);
		allOrientations = new int[4][][];
		allOrientations[0] = content;
		allOrientations[1] = contentRotatedCW1;
		allOrientations[2] = contentRotatedCW2;
		allOrientations[3] = contentRotatedCW3;

		ArrayList<int[][]> orientationsArrayList = new ArrayList<int[][]>();

		for (int i = 0; i < allOrientations.length; i++) {
			for (int j = i + 1; j < allOrientations.length; j++) {
				if (allOrientations[i] != null && allOrientations[j] != null
						&& compareContent(allOrientations[i], allOrientations[j])) {
					allOrientations[j] = null;
				}
			}
		}

		for (int i = 0; i < allOrientations.length; i++) {
			if (allOrientations[i] != null) {
				orientationsArrayList.add(allOrientations[i]);
			}
		}

		allOrientations = new int[orientationsArrayList.size()][][];
		for (int i = 0; i < allOrientations.length; i++) {
			allOrientations[i] = orientationsArrayList.get(i);
		}
		
		score = calculateScore();
	}

	public double getScore() {
		return score;
	}

	public char getLetter() {
		return letter;
	}
	
	private double calculateScore() {
		double currentScore = 0;
		for (int i = 0; i < content.length; i++) {
			for (int j = i + 1; j < content[0].length; j++) {
				currentScore += content[i][j];
			}
		}
		
		return currentScore + width + height - (getOrientationAmount()/4.0);
	}

	private int[][] getRotationCW(int[][] original) {
		int[][] rotatedContent = new int[original[0].length][original.length];
		for (int x = 0; x < original.length; x++) {
			for (int y = 0; y < original[0].length; y++) {
				rotatedContent[y][x] = original[x][original[0].length - y - 1];
			}
		}
		return rotatedContent;
	}

	public int[][] getOrientation(int o) {
		return allOrientations[o];
	}

	public int getOrientationAmount() {
		return allOrientations.length;
	}

	public void printAllOrientations() {
		printContent(content);
		System.out.println();
		printContent(contentRotatedCW1);
		System.out.println();
		printContent(contentRotatedCW2);
		System.out.println();
		printContent(contentRotatedCW3);
		System.out.println();
	}

	private void printContent(int[][] original) {
		for (int y = 0; y < original[0].length; y++) {
			for (int x = 0; x < original.length; x++) {
				if (original[x][y] == 1)
					System.out.print(letter);
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

	public boolean compareContent(int[][] c1, int[][] c2) {
		if (c1.length != c2.length || c1[0].length != c2[0].length)
			return false;

		for (int y = 0; y < c1[0].length; y++) {
			for (int x = 0; x < c1.length; x++) {
				if (c1[x][y] != c2[x][y])
					return false;
			}
		}

		return true;
	}

}
