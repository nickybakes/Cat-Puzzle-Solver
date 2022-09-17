import java.util.ArrayList;

public class Placement {
		private int x;
		private int y;
		private int orientation;
		
		public Placement(int _x, int _y, int _orientation) {
			x = _x;
			y = _y;
			orientation = _orientation;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getOrientation() {
			return orientation;
		}
		
		public void printPlacement() {
			System.out.println("(" + x + ", " + y + ")" + "r: " + orientation);
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")" + "r: " + orientation;
		}
		
		public static void printListOfPlacements(ArrayList<Placement> list) {
			for (Placement placement : list) {
				placement.printPlacement();
			}
		}
}
