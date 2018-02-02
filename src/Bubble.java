import java.awt.Color;
import java.util.ArrayList;

public class Bubble extends Item {

	/** The size of the bubble, from 0 through 4. */
	private int size = 0;

	Bubble(int col, int row) {
		super(col, row);
		ArrayList<String> sizeA = new ArrayList<>();
		sizeA.add(".");
		appearance = sizeA;
		colour = Color.gray;
	}

	/** Makes bubble float towards surface and grow in size. */
	@Override
	protected void move() {

		if (row < 0) {	//	If bubble is off screen, stop animation.
			Tank.tankList.remove(this);
			
		} else {

			row -= 3; // Bubble floats upwards.

			// Randomly move slightly left or slightly right.
			double dirChance = Math.random();
			if (dirChance < 0.33) {
				col -= 1; // move left
			} else if (dirChance < 0.66) {
				col += 1; // move right
			}

			grow();
		}
	}

	/**
	 * Causes bubbles to grow larger in size and appearance, until they
	 * pop and disappear!
	 */
	protected void grow() {
		if (size == 4 && Math.random() < 0.3) {
			Tank.tankList.remove(this);	//	pop!

		} else if (Math.random() < 0.3) {
			ArrayList<String> newApp = new ArrayList<>();
			size += 1;

			if (size == 1) {
				newApp.add("o");

			} else if (size == 2) {
				newApp.add("O");

			} else if (size == 3) {
				newApp.add("()");

			} else if (size == 4) {
				newApp.add("( )");
			}
			appearance = newApp;
		}
	}

}
