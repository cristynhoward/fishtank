import java.awt.Color;
import java.util.ArrayList;

public class Bubble extends Item {

	/** The size of the bubble, from 0 through 4. */
	private int size = 0;

	/** Smallest bubble size, when size = 0. */
	private ArrayList<String> sizeA = new ArrayList<>();

	/** Second smallest bubble size, when size = 1. */
	private ArrayList<String> sizeB = new ArrayList<>();

	/** Second largest bubble size, when size = 2. */
	private ArrayList<String> sizeC = new ArrayList<>();

	/** Smallest bubble size, when size = 3. */
	private ArrayList<String> sizeD = new ArrayList<>();

	/** Smallest bubble size, when size = 4. */
	private ArrayList<String> sizeE = new ArrayList<>();


	Bubble(int col, int row) {
		super(col, row);
		colour = Color.gray;

		sizeA.add(".");
		sizeB.add("o");
		sizeC.add("O");
		sizeD.add("()");
		sizeE.add("( )");

		appearance = sizeA;
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
		if (size == 0 && Math.random() < 0.3) {
			size += 1; // size from 0 -> 1
			appearance = sizeB; // grow from . -> o

		} else if (size == 1 && Math.random() < 0.3) {
			size += 1; // size from 1 -> 2
			appearance = sizeC; // grow from o -> O

		} else if (size == 2 && Math.random() < 0.3) {
			size += 1; // size from 2 -> 3
			appearance = sizeD; // grow from O -> ()

		} else if (size == 3 && Math.random() < 0.3) {
			size += 1; // size from 3 -> 4
			appearance = sizeE; // grow from () -> ( )

		} else if (size == 4 && Math.random() < 0.3) {
			Tank.tankList.remove(this);	//	pop!
		}
	}

}
