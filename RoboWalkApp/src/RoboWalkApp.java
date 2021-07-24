import java.util.Scanner;

public class RoboWalkApp {
	
	// main game logic
	public static void main(String[] args) {
		
		// square width + height
		final int W = 10; // local scope
		final int H = 10; //local scope
		
		// robot coordinates row + column
		int rr = 7;
		int rc = 2;
		
		// garbage coordinates row + column + colected status
		int gr = 7;
		int gc = 7;
		boolean garbageColected = false;
		int garbageCount = 0;
		
		// directions
		String dir;
		
		Scanner in = new Scanner(System.in);

		// loop for change robot positions
		while(true) {
			clearScreen();
			renderMap(W, H, rr, rc, gr, gc, garbageColected);
			System.out.println();
			System.out.println("Garbage colected: " + garbageCount);
			System.out.println("Choice directions: w, s, a, d");
			System.out.print("next step >>> ");
			dir = in.next();
			
			if( rr == gr && rc == gc && garbageColected == false) {
				garbageColected = true;
				garbageCount++;
			} 
			
			// STOP AT BORDER
			// left direction
//			if(dir.equals("a") && rc != W-W) {
//				rc--;
//			}
			// right direction
//			if(dir.equals("d") && rc != W-1) {
//				rc++;
//			}
			// bottom direction
//			if(dir.equals("s") && rr != H-1) {
//				rr++;
//			}
			// top direction
//			if(dir.equals("w") && rr != H-H) {
//				rr--;
//			}

			
			// TELEPORT
			// left  direction
			if(dir.equals("a") || dir.equals("A")) {
				if (rc == W-W) {
					rc = W-1;
				} else {
					rc--;
				}
			}
			// right  direction
			if(dir.equals("d") || dir.equals("D")) {
				if (rc == W-1) {
					rc = W-W;
				} else {
					rc++;
				}
			}
			// bottom  direction
			if(dir.equals("s") || dir.equals("S")) {
				if (rr == H-1) {
					rr = H-H;
				} else {
					rr++;
				}
				
			}
			// top  direction
			if(dir.equals("w") || dir.equals("W")) {
				if (rr == H-H) {
					rr = H-1;
				} else {
					rr--;
				}
			}
		}

	}
	
	// custom methods
	static void renderMap(final int W, final int H, int rr, int rc, int gr, int gc, boolean garbageColected) {
		for (int row = 0; row < W; row++) {
			for (int col = 0; col < H; col++) {
				if (row == rr && col == rc) {
					System.out.print("R ");
				} else if (row == gr && col == gc && garbageColected == false) {
					System.out.print("X ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	
	// scroll console position
	static void clearScreen() {
		for (int i = 0; i < 43; i++) {
			System.out.println();
		}
	}
}
