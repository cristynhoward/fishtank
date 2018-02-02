import java.awt.Color;

public class FishScaly extends Fish {

	FishScaly(int minX, int maxX, int minY, int maxY) {
		super(minX, maxX, minY, maxY);
		swimSpeed = 2;
		colour = Color.GREEN.darker().darker();
		bubbleProbability = 0.3;
		bodyLength = 23;

		shapeRight.clear();
		shapeRight.add("        }^^^^^^}");
		shapeRight.add("     ,oO))))))))Oo,");
		shapeRight.add("}\\ ,(((((((((((((((`,");
		shapeRight.add("}=((((((((((((((((  o`,");
		shapeRight.add("}=((((((((((((((((    <");
		shapeRight.add("}=(((((((({  {((((  ,~`");
		shapeRight.add("}/  `''*O(| ƒ(((O*~`");
		shapeRight.add("           ''  ''");

		shapeLeft.add("       {^^^^^^{");
		shapeLeft.add("    ,oO))))))))Oo,");
		shapeLeft.add("  ,'))))))))))))))), /{");
		shapeLeft.add(",'o  ))))))))))))))))={");
		shapeLeft.add(">    ))))))))))))))))={");
		shapeLeft.add("`~,  ))))}  }))))))))={");
		shapeLeft.add("   `~*O)))L |)O*''`  \\{");
		shapeLeft.add("       ``  ``");
	}

	/** Make fish swim, change direction, and blow bubbles. */
	protected void move() {

		// Chance of blowing a bubble.
		if (Math.random() < bubbleProbability) {
			Tank.tankList.add(new Bubble(col, row));
		}

		// Chance of bubble explosion.
		if (Math.random() < 0.4) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					Tank.tankList.add(new Bubble(col+j, row-i));
				}
			}
		}

		// If next move will take fish out of bounds, turn.
		int nextX = col + (horizMove * swimSpeed);
		if (nextX > (maxX - bodyLength)) { // next move to right of screen
			horizMove = -1; // go left
			setAppearanceForDirection();
		} else if (nextX < minX) { // next move to left of screen
			horizMove = 1; // go right
			setAppearanceForDirection();
		}
		int nextY = row + (vertMove * swimSpeed);
		if (nextY > (maxY - appearance.size())) {   //  next move below screen
			vertMove = -1;  //  go up
		} else if (nextY < minY) {  //  next move above screen
			vertMove = 1;   //  go down
		}

		//  Move horizontally & vertically.
		col += horizMove * swimSpeed;
		row += vertMove * swimSpeed;

		//  Possible reset of horizonal direction.
		if (Math.random() < dirChangeProb) {
			if (Math.random() < 0.5) {
				horizMove = -1; // left
			} else {
				horizMove = 1; // right
			}
			setAppearanceForDirection();
		}

		//  Possible reset of vertical direction.
		if (Math.random() < dirChangeProb * 0.5) {
			double newVertDir = Math.random();
			if (newVertDir < 0.2) { //  20% chance
				vertMove = -1; //
			} else if (newVertDir < 0.8) {  //  60% chance
				vertMove = 0;
			} else {    //  20% chance
				vertMove = 1;
			}
		}
	}
}